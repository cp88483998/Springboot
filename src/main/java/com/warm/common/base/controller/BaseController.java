package com.warm.common.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.warm.common.base.entity.LoginInfo;
import com.warm.common.constant.SecurityConstants;
import com.warm.system.entity.User;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 控制器基础类
 * @author zhangbin
 */
public class BaseController {
    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    /**
     * 获取存放在HttpSession中的当前登录用户信息对象
     *
     * @return User
     */
    protected LoginInfo getCurrentUser() {
        LoginInfo currentUser = (LoginInfo) request.getSession().getAttribute(SecurityConstants.LOGIN_USER);
        return currentUser;
    }

    /**
     * 获取当前用户-登录名
     * @return
     */
    public String getLoginName() {
        LoginInfo loginInfo = this.getCurrentUser();
        String loginName = loginInfo != null ? loginInfo.getLoginName() : "";
        return loginName;
    }
}
