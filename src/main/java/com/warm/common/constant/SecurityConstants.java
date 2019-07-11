package com.warm.common.constant;

/**
 * 系统常量，通常用于配置系统中的通用常量、参数等
 *
 * @author vincent
 * @version 1.0
 * @description: 常量
 * @createDate
 */
public interface SecurityConstants {

    /**
     * 加密盐
     */
    public final static String SALT = "hgzx@2018";

    /**
     * 登录用户
     */
    public final static String LOGIN_USER = "login_user";

    /**
     * 系统默认用户登录密码
     */
    public final static String DEFAULT_PASSWORD = "123456";

    /**
     * 验证码
     */
    public final static String CAPTCHA_KEY = "captcha_key";

    /**
     * 超级管理员 ID
     */
    public final static String ROOT_USER_ID = "1";

    public static final String USERNAME_IS_NULL = "用户名或密码为空!";

    public static final String SESSION_EXPIRED = "当前会话已经失效，请重新登录！";

    public static final String LOGIN_IS_EXIST = "该用户已登录!";

    public static final String UNKNOWN_SESSION_EXCEPTION = "异常会话!";

    public static final String UNKNOWN_ACCOUNT_EXCEPTION = "您输入的用户名或密码错误！";

    public static final String EXCESSIVE_ATTEMPTS_EXCEPTION = "多次登录失败，账户被锁定!";

    public static final String INCORRECT_CREDENTIALS_EXCEPTION = "您输入的用户名或密码错误！";

    public static final String LOCKED_ACCOUNT_EXCEPTION = "账号已被锁定，请与系统管理员联系!";

    public static final String DISABLED_ACCOUNT_EXCEPTION = "账号被冻结，请与系统管理员联系!";

    public static final String INCORRECT_CAPTCHA_EXCEPTION = "验证码错误!";

    public static final String REPEAT_LOGIN_EXCEPTION = "重复登录!";

    public static final String AUTHENTICATION_EXCEPTION = "未知账号，没有被授权或账户授权信息失效!";

    public static final String UNKNOWN_EXCEPTION = "出现未知异常,请与系统管理员联系!";

    public static final String TEXT_TYPE_PLAIN = "text/plain";

    public static final String TEXT_TYPE_HTML = "text/html";

    public static final String SESSION_FORCE_LOGOUT_KEY = "session.force.logout";

    public static final String LOGIN_FAIL_COUNT = "登录失败超过5次,请30分钟之后重新登录";
}
