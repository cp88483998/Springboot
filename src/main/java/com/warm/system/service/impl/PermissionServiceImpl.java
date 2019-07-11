package com.warm.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.warm.system.entity.Permission;
import com.warm.system.entity.Role;
import com.warm.system.entity.RolePermission;
import com.warm.system.mapper.PermissionMapper;
import com.warm.system.mapper.RolePermissionMapper;
import com.warm.system.service.IPermissionService;
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
public class PermissionServiceImpl extends SuperServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getPermissionByRole(List<Role> roles) {
        return this.permissionMapper.selectPermListByRole(roles);
    }
}
