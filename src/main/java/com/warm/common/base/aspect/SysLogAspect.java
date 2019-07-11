package com.warm.common.base.aspect;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.warm.common.base.annotation.SysLogger;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 系统日志 ， 切面处理类
 */
@Aspect
@Component
public class SysLogAspect {

    private Logger logger = LoggerFactory.getLogger(SysLogAspect.class);

//    @Autowired
//    private SysLogService sysLogService;

    @Pointcut("@annotation(com.warm.common.base.annotation.SysLogger)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //自定义保存日志
//        saveSysLog(point, beginTime, result);
        return result;
    }

//    private void saveSysLog(ProceedingJoinPoint joinPoint, long beginTime, Object result) {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//
//        com.hgzx.pub.admin.model.entity.SysLog sysLog = new com.hgzx.pub.admin.model.entity.SysLog();
//        SysLogger log = method.getAnnotation(SysLogger.class);
//        if (log != null) {
//            //注解上的描述
//            sysLog.setOperation(log.operation());
//
//        }
//
//        //请求的方法名
//        String className = joinPoint.getTarget().getClass().getName();
//        String methodName = signature.getName();
//        sysLog.setMethod(className + "." + methodName + "()");
//
//        //请求的参数
//        Object[] args = joinPoint.getArgs();
//        try {
//            if(log == null){
//                throw new NullPointerException();
//            }
//            if (log.param()) { //需要记录入参
//                String params = "";
//                for(Object obj: args){
//                    //处理MultipartHttpServletRequest类型参数
//                    if(obj instanceof MultipartHttpServletRequest){
//                        Map<String, Object> map = new HashMap<>();
//                        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)args[0];
//                        Map<String, String[]> paramMap = multiRequest.getParameterMap();
//                        map.putAll(paramMap);
////                        Map<String, MultipartFile> fileMap = multiRequest.getFileMap();
////                        for(MultipartFile file: fileMap.values()){
////                            String name = file.getName();
////                            String originalFilename = file.getOriginalFilename();
////                            map.put(name, originalFilename);
////                        }
//                        params += JSON.toJSONString(map, SerializerFeature.BrowserCompatible);
//                    }else{
//                        params += JSON.toJSONString(args, SerializerFeature.BrowserCompatible);
//                    }
//                }
//                sysLog.setParams(params);
//            }
//
//            if (log.result()) { //需要记录入参
//                String exeResult = JSON.toJSONString(result);
//                sysLog.setResult(exeResult);
//            }
//            sysLog.setModule(log.module().getName());
//            sysLog.setType(log.type().getName());
//
//        } catch (Throwable e) {
//            logger.error("系统日志保存失败：", e);
//        }
//
//        //获取request
//        HttpServletRequest request = HttpUtil.getHttpServletRequest();
//        //设置IP地址
//        sysLog.setIp(HttpUtil.getRemoteHost(request));
//
//        String loginName = "";
//        if (StringUtils.isNotEmpty(request.getParameter("username"))) {
//            loginName = request.getParameter("username");
//        } else {
//            if (SecurityUtils.getSubject().getPrincipal() != null) {
//                loginName = ((LoginInfo) SecurityUtils.getSubject().getPrincipal()).getLoginName();
//            } else {
//                loginName = "";
//            }
//        }
//
//        //用户名
//        sysLog.setOperator(loginName);
//        //执行时长(毫秒)
//        long time = System.currentTimeMillis() - beginTime;
//        sysLog.setDuration(time);
//        sysLog.setCreatedTime(new Date());
//        try{
//            //保存系统日志
//            sysLogService.saveSysLog(sysLog);
//        } catch (Exception e){
//            logger.error("系统日志保存失败：", e);
//        }
//    }

}
