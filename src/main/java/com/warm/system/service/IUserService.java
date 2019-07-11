package com.warm.system.service;

import com.warm.common.base.entity.LoginInfo;
import com.warm.system.entity.User;
import com.warm.common.base.service.ISuperService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 陈鹏
 * @since 2019-07-02
 */
public interface IUserService extends ISuperService<User> {

    User findUserByName(String username);

    LoginInfo getUserLoginInfo(String username);
}
