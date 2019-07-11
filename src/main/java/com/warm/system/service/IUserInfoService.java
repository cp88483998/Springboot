package com.warm.system.service;


import com.warm.common.base.service.ISuperService;
import com.warm.system.entity.UserInfo;

import java.util.List;

/**
 * @Discription:
 * @ClassName: IUserInfoService
 * @Author: ChenPeng
 * @Date: Created in 10:41 2019/5/17
 * @Version: 1.0
 */
public interface IUserInfoService extends ISuperService<UserInfo>{

    List<UserInfo> getUserList();
}
