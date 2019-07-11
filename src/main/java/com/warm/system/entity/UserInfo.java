package com.warm.system.entity;


import com.warm.common.base.entity.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author dgd123
 * @since 2018-02-10
 */
@Data
public class UserInfo extends BaseEntity{

    private String username;
    private String password;
    private String email;
    private String telephone;
    private String enrolldate;

}
