package com.warm.system.service.impl;

import com.warm.system.entity.Role;
import com.warm.system.entity.RoleUser;
import com.warm.system.mapper.RoleMapper;
import com.warm.system.mapper.RoleUserMapper;
import com.warm.system.service.IRoleService;
import com.warm.common.base.service.impl.SuperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 陈鹏
 * @since 2019-07-02
 */
@Service
public class RoleServiceImpl extends SuperServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getRolesByUser(long userId) {
        return this.roleMapper.selectRolesByUserId(userId);
    }
}
