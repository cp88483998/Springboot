package com.warm.system.mapper;

import com.warm.system.entity.Role;
import com.warm.common.base.mapper.SuperMapper;
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
public interface RoleMapper extends SuperMapper<Role> {

    /**
     * 根据userid查询所有角色
     * @param userId
     * @return
     */
    List<Role> selectRolesByUserId(@Param("userId") long userId);
}
