package com.warm.system.service.impl;

import com.warm.common.base.service.impl.SuperServiceImpl;
import com.warm.system.entity.UserInfo;
import com.warm.system.mapper.UserInfoMapper;
import com.warm.system.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Discription:
 * @ClassName: UserInfoServiceImpl
 * @Author: ChenPeng
 * @Date: Created in 14:33 2019/7/2
 * @Version: 1.0
 */
@Service
public class UserInfoServiceImpl extends SuperServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public List<UserInfo> getUserList() {
        UserInfo u = new UserInfo();
        return this.userInfoMapper.selectAllUserInfo();
    }

}
