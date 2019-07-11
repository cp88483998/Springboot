package com.warm.system.entity;

import java.time.LocalDate;

import com.warm.common.base.entity.BaseEntity;

import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author 陈鹏
 * @since 2019-07-02
 */
@Data
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String role;

}
