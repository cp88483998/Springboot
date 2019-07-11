package com.warm.system.mapper;

import com.warm.system.entity.Permission;
import com.warm.common.base.mapper.SuperMapper;
import com.warm.system.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 陈鹏
 * @since 2019-07-02
 */
public interface PermissionMapper extends SuperMapper<Permission> {

    List<Permission> selectPermListByRole(@Param("roles") List<Role> roles);
}
