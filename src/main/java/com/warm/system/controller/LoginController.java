package com.warm.system.controller;

import com.warm.common.base.annotation.SysLogger;
import com.warm.common.base.entity.LogType;
import com.warm.common.base.entity.LoginInfo;
import com.warm.common.base.entity.ModuleType;
import com.warm.common.shiro.EnceladusShiroRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warm.common.base.controller.BaseController;
import com.warm.common.base.entity.Result;
import com.warm.common.constant.SecurityConstants;
import com.warm.system.entity.User;
import com.warm.system.service.IUserService;



/**
 * @Discription:
 * @ClassName: HomeController
 * @Author: ChenPeng
 * @Date: Created in 14:52 2019/7/4
 * @Version: 1.0
 */
@Controller
public class LoginController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private IUserService userService;
    @Autowired
    private EnceladusShiroRealm shiroRealm;

    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        //如果已经认证通过，直接跳转到首页
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/index";
        }
        return "login";
    }

    /**
     * 登录验证
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login/load", method = RequestMethod.POST)
    @ResponseBody
    public Result load(String username, String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());
        try{
            //shiro帮我们匹配密码什么的，我们只需要把东西传给它，它会根据我们在EnceladusShiroRealm里认证方法设置的来验证
            subject.login(token);

            this.setLoginInfo(subject, username);
        } catch (ExcessiveAttemptsException ex) {
            logger.info("user: {}, login failure, cause by : {} !", username, SecurityConstants.EXCESSIVE_ATTEMPTS_EXCEPTION);
            return Result.failed(SecurityConstants.EXCESSIVE_ATTEMPTS_EXCEPTION);
        } catch (UnknownSessionException use) {
            subject = SecurityUtils.getSubject();
            subject.login(token);
            logger.info("user: {}, login failure, cause by : {} !", username, SecurityConstants.UNKNOWN_SESSION_EXCEPTION);
            return Result.failed(SecurityConstants.UNKNOWN_SESSION_EXCEPTION);
        } catch (UnknownAccountException ex) {
            logger.info("user: {}, login failure, cause by : {} !", username, SecurityConstants.UNKNOWN_ACCOUNT_EXCEPTION);
            return Result.failed(SecurityConstants.UNKNOWN_ACCOUNT_EXCEPTION);
        } catch (IncorrectCredentialsException ice) {
            logger.info("user: {}, login failure, cause by : {} !", username, SecurityConstants.INCORRECT_CREDENTIALS_EXCEPTION);
            return Result.failed(SecurityConstants.INCORRECT_CREDENTIALS_EXCEPTION);
        } catch (LockedAccountException lae) {
            logger.info("user: {}, login failure, cause by : {} !", username, SecurityConstants.LOCKED_ACCOUNT_EXCEPTION);
            return Result.failed(SecurityConstants.LOCKED_ACCOUNT_EXCEPTION);
        } catch (DisabledAccountException dae) {
            logger.info("user: {}, login failure, cause by : {} !", username, SecurityConstants.DISABLED_ACCOUNT_EXCEPTION);
            return Result.failed(SecurityConstants.DISABLED_ACCOUNT_EXCEPTION);
        }  catch (AuthenticationException ae) {
            logger.info("user: {}, login failure, cause by : {} !", username, SecurityConstants.AUTHENTICATION_EXCEPTION);
            return Result.failed(SecurityConstants.AUTHENTICATION_EXCEPTION);
        } catch (Exception e) {
            logger.error("user: {}, login failure, cause by : {} !", username, SecurityConstants.UNKNOWN_EXCEPTION);
            return Result.failed(SecurityConstants.UNKNOWN_EXCEPTION);
        }

        //登录失败5次,30分钟之后重新登录


        return Result.success("登录成功!");
    }

    /**
     * 登出
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @SysLogger(type = LogType.LOGOUT, module = ModuleType.USER, operation = "用户登出", result = true)
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        this.shiroRealm.cleanCachedAuthInfo(super.getLoginName());
        if (subject != null) {
            subject.logout();
        }
        return "redirect:/login";
    }


    /**
     * 设置登录信息
     *
     * @param subject
     * @param userName
     */
    private void setLoginInfo(Subject subject, String userName) {
        LoginInfo loginInfo = userService.getUserLoginInfo(userName);
//        userService.updateUserLoginInfo(loginInfo);

//        String sessionId = subject.getSession().getId().toString();
//        loginInfo.setSessionId(sessionId);

//        String host = subject.getSession().getHost();
//        host = host.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : host;
//        loginInfo.setIpAddress(host);

//        String curTime = DateUtils.formatDateTime(new Date());
//        loginInfo.setLoginTime(curTime);
        subject.getSession().setAttribute(SecurityConstants.LOGIN_USER, loginInfo);
    }

}
