package com.warm.system.service;

import com.warm.system.entity.Role;
import com.warm.common.base.service.ISuperService;
import com.warm.system.entity.RoleUser;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 陈鹏
 * @since 2019-07-02
 */
public interface IRoleService extends ISuperService<Role> {

    List<Role> getRolesByUser(long userId);
}
