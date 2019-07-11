package com.warm.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.warm.common.base.entity.LoginInfo;
import com.warm.system.entity.User;
import com.warm.system.mapper.UserMapper;
import com.warm.system.service.IUserService;
import com.warm.common.base.service.impl.SuperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 陈鹏
 * @since 2019-07-02
 */
@Service
public class UserServiceImpl extends SuperServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByName(String username) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("username", username);
        return this.userMapper.selectOne(qw);
    }

    @Override
    public LoginInfo getUserLoginInfo(String username) {
        return userMapper.selectUserLoginInfo(username);
    }
}
