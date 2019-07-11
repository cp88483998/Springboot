package com.warm.common.base.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: chenpeng
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private T datas;
    private Integer resp_code;
    private String resp_msg;

    public static <T> Result<T> success(String msg) {
        return successWith(null, CodeEnum.SUCCESS.getCode(), msg);
    }

    public static <T> Result<T> success(T model, String msg) {
        return successWith(model, CodeEnum.SUCCESS.getCode(), msg);
    }

    public static <T> Result<T> success(T model) {
        return successWith(model, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }

    public static <T> Result<T> successWith(T datas, Integer code, String msg) {
        return new Result<>(datas, code, msg);
    }

    public static <T> Result<T> failed(String msg) {
        return failedWith(null, CodeEnum.ERROR.getCode(), msg);
    }

    public static <T> Result<T> failed(T model) {
        return failedWith(model, CodeEnum.ERROR.getCode(), CodeEnum.ERROR.getMsg());
    }

    public static <T> Result<T> failed(T model, String msg) {
        return failedWith(model, CodeEnum.ERROR.getCode(), msg);
    }

    public static <T> Result<T> failedWith(T datas, Integer code, String msg) {
        return new Result<>(datas, code, msg);
    }

}
