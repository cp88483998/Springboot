package com.warm.common.base.entity;

import java.io.Serializable;

/**
 * 用户视图类
 *
 * @author 柏耀明
 * @since 2017年12月18日
 */
public class LoginInfo implements Serializable {

    private static final long serialVersionUID = -4910314259323535915L;

    private String sessionId;

    /**
     * PK
     */
    private String userId;

    /**
     * 系统登录用户名
     */
    private String loginName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 隶属组织机构ID，FK
     */
    private String orgId;

    /**
     * 隶属组织机构名称
     */
    private String orgName;

    /**
     * 最近一次登录日期，格式：yyyy-MM-dd HH:mm:ss
     */
    private String latestLoginTime;

    /**
     * 登录时间
     */
    private String loginTime;

    /**
     * lastAccessTime
     */
    private String lastAccessTime;

    /**
     * 失败登录次数
     */
    private int loginFailureTimes;

    /**
     * 用户状态
     */
    private String userStatus;

    /**
     * 当前登录IP
     */
    private String ipAddress;

    /**
     * 是否当前用户
     */
    private boolean currentUser;

    /**
     * 用户类型 0：平台用户 1：系统用户
     */
    private String userType;

    /**
     * 手机已校验（0未校验1已校验）
     */
    private String telephoneChecked;

    /**
     * 邮箱已校验（0未校验 1已校验）
     */
    private String emailChecked;

    /**
     * 电话号码
     */
    private String mobilePhone;

    /**
     * 电子邮件
     */
    private String email;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getLatestLoginTime() {
        return latestLoginTime;
    }

    public void setLatestLoginTime(String latestLoginTime) {
        this.latestLoginTime = latestLoginTime;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public int getLoginFailureTimes() {
        return loginFailureTimes;
    }

    public void setLoginFailureTimes(int loginFailureTimes) {
        this.loginFailureTimes = loginFailureTimes;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(String lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public boolean isCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(boolean currentUser) {
        this.currentUser = currentUser;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getTelephoneChecked() {
        return telephoneChecked;
    }

    public void setTelephoneChecked(String telephoneChecked) {
        this.telephoneChecked = telephoneChecked;
    }

    public String getEmailChecked() {
        return emailChecked;
    }

    public void setEmailChecked(String emailChecked) {
        this.emailChecked = emailChecked;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
