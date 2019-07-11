package com.warm.common.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.warm.common.constant.CommonConstant;
import com.warm.common.constant.SecurityConstants;
import com.warm.system.entity.Permission;
import com.warm.system.entity.Role;
import com.warm.system.entity.User;
import com.warm.system.service.IPermissionService;
import com.warm.system.service.IRoleService;
import com.warm.system.service.IUserService;

/**
 * @Discription: 帮助Shiro能够正确为当前登陆用户做认证和授权,
 * 				 实现doGetAuthenticationInfo和doGetAuthorizationInfo，
 *               这两个方法前者负责登陆认证后者负责提供一个权限信息
 * @ClassName: EnceladusShiroRealm
 * @Author: ChenPeng
 * @Date: Created in 17:24 2019/7/2
 * @Version: 1.0
 */
public class EnceladusShiroRealm extends AuthorizingRealm {

	private static final Logger logger = LoggerFactory.getLogger(EnceladusShiroRealm.class);

	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IPermissionService permissionService;

	/**
	 * 验证密码
	 * new SimpleAuthenticationInfo会调用ShiroConfig类中的hashedCredentialsMatcher方法验证密码
	 * @param authcToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
		throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User sysUser = userService.findUserByName(token.getUsername());
		if (sysUser == null) {
			throw new UnknownAccountException();// 未知账户异常
		} else {
			return new SimpleAuthenticationInfo(sysUser, sysUser.getPassword(),
				ByteSource.Util.bytes(SecurityConstants.SALT), this.getName());
		}
	}

	/**
	 * 获取授权信息
	 * principals对应的是doGetAuthenticationInfo方法中SimpleAuthenticationInfo的第一个参数sysUser
	 * @param principals
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User sysUser = (User) principals.getPrimaryPrincipal();
		return this.generateAuthorizationInfo(sysUser);
	}

	/**
	 * 获取用户授权编码列表
	 * @param sysUser
	 * @return
	 */
	private SimpleAuthorizationInfo generateAuthorizationInfo(User sysUser) {
		Set<String> hasRoleStrList = new HashSet<String>();
		Set<String> hasPermissionStrList = new HashSet<String>();

		//判断是否为超级管理员
		if(SecurityConstants.ROOT_USER_ID.equals(sysUser.getId().toString())){
			hasRoleStrList.add("superManager");
			hasPermissionStrList.add("*");
			if (logger.isInfoEnabled()) {
				logger.info("使用了{}的超级管理员权限", sysUser.getUsername());
				logger.info("{}拥有的角色:{}", sysUser.getUsername(), hasRoleStrList);
				logger.info("{}拥有的权限:{}", sysUser.getUsername(), hasPermissionStrList);
			}
		}else{
			logger.info("非超级管理员进入");
			// 根据user查询所有角色
			List<Role> roles = this.roleService.getRolesByUser(sysUser.getId());
			for (Role role : roles) {
				hasRoleStrList.add(role.getRole());
			}
			// 根据role查询所有权限
			List<Permission> perms = this.permissionService.getPermissionByRole(roles);
			for (Permission perm : perms) {
				if(!StringUtils.isBlank(perm.getCode())){
					hasPermissionStrList.add(perm.getCode());
				}
			}
		}

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setRoles(hasRoleStrList);
		info.setStringPermissions(hasPermissionStrList);
		return info;
	}

	/**
	 * 清空用户鉴权和授权信息缓存（包括登录信息和授权信息，即AuthenticationInfo和AuthorizationInfo），当用户被删除时调用该方法，从而确保数据安全性
	 * @author 柏耀明
	 * @since 2017年12月22日
	 * @param principal 用户身份标识，本系统中可以传入用户名
	 */
	public void cleanCachedAuthInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		logger.debug("清空用户{}的授权信息！", principal);
		clearCachedAuthorizationInfo(principals);
		logger.debug("清空用户{}的身份信息！", principal);
		clearCachedAuthenticationInfo(principals);
	}
}
