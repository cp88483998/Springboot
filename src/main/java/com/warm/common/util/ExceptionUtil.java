package com.warm.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 关于异常的工具类
 * 
 * @author 柏耀明
 * @since 2017年12月22日
 */
public class ExceptionUtil {

    /**
     * 将CheckedException转换为UncheckedException
     * 
     * @author 柏耀明
     * @since 2017年12月22日
     */
    public static RuntimeException unchecked(Exception e) {
        if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        } else {
            return new RuntimeException(e);
        }
    }

    /**
     * 将ErrorStack转化为String
     * 
     * @author 柏耀明
     * @since 2017年12月22日
     */
    public static String getStackTraceAsString(Exception e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /**
     * 判断异常是否由某些底层的异常引起
     * 
     * @author 柏耀明
     * @since 2017年12月22日
     */
    @SuppressWarnings("unchecked")
    public static boolean isCausedBy(Exception ex, Class<? extends Exception>... causeExceptionClasses) {
        Throwable cause = ex;
        while (cause != null) {
            for (Class<? extends Exception> causeClass : causeExceptionClasses) {
                if (causeClass.isInstance(cause)) {
                    return true;
                }
            }
            cause = cause.getCause();
        }
        return false;
    }
}
