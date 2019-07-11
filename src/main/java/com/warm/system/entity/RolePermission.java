package com.warm.system.entity;

import com.warm.common.base.entity.BaseEntity;
import lombok.Data;

import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author 陈鹏
 * @since 2019-07-02
 */
@Data
public class RolePermission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Integer roleId;

    private Integer permissionId;

}
