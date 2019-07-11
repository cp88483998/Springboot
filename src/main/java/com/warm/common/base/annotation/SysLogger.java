package com.warm.common.base.annotation;

import com.warm.common.base.entity.LogType;
import com.warm.common.base.entity.ModuleType;

import java.lang.annotation.*;


/**
 * 系统日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLogger {

	LogType type() default LogType.OPERTION;//分为登录，登出，操作三种类型

	String operation() default "";//操作说明，例如删除用户，新增用户

	ModuleType module() default ModuleType.EMPTY;//模块名称

	boolean param() default true;//是否记录参数

	boolean result() default false;//是否记录结果

}
