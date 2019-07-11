package com.warm.common.base.entity;

/**
 * @Author: zhangbin
 */
public enum CodeEnum {
    SUCCESS(0,"成功"),
    ERROR(-1,"失败");

    private Integer code;
    private String msg;
    CodeEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }
    public String getMsg(){return this.msg;}
}
