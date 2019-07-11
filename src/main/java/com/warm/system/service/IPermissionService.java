package com.warm.system.service;

import com.warm.system.entity.Permission;
import com.warm.common.base.service.ISuperService;
import com.warm.system.entity.Role;
import com.warm.system.entity.RolePermission;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 陈鹏
 * @since 2019-07-02
 */
public interface IPermissionService extends ISuperService<Permission> {

    List<Permission> getPermissionByRole(List<Role> roles);
}
