package com.itxxx.controller;



import com.itxxx.domain.SysLog;
import com.itxxx.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;


@Component
@Aspect
public class SysAop {
    /**
     * 要获取类SysLog的所有属性在前置通知和后置通知
     *
     visitTime      访问时间
     username       访问用户名
     ip             访问的ip地址
     url            访问的URL 例如/user/findAll.do
     executionTime  访问的总时长
     method;        访问的类名和方法名
     */
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SysLogService service;
    private Date visitTime; //访问时间
    private Class clazz;//访问的类
    private Method method;//访问的方法

    @Before("execution(* com.itxxx.controller.*.*(..))")

    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        /**
         * 在访问前可以获取的数据为访问时间，访问方法，访问用户名
         */
        visitTime = new Date();
       clazz = jp.getTarget().getClass();//获取访问的类
        String methodName = jp.getSignature().getName();//获取访问的方法名
        Object[] args = jp.getArgs();//获取访问的方法的参数
        //=======================================================
        //=======================================================
        if (args == null || args.length ==0){
            method = clazz.getMethod(methodName);
        }else {
            Class[] array = new Class[args.length];
            for (int i = 0; i < array.length; i++) {
                array[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName,array);
        }
    }
    //======================================================
    //======================================================
    @After("execution(* com.itxxx.controller.*.*(..))")
    /**
     * 后置通知主要获取ip,url,总时长,
     */
    public void doAfter(JoinPoint jp){
        //=============================================
        //=============================================
        if (clazz != SysLogController.class){
            RequestMapping annotationClazz = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (annotationClazz != null){
                RequestMapping annotationMethod = method.getAnnotation(RequestMapping.class);
                if (annotationMethod!=null){
                    //=====================================
                    //=====================================
                    String url = "";
                    url = annotationClazz.value()[0]+annotationMethod.value()[0];
                    SysLog sysLog = new SysLog();
                    Long executionTime = new Date().getTime() - visitTime.getTime();
                    sysLog.setExecutionTime(executionTime);
                    sysLog.setUrl(url);
                    sysLog.setMethod(method.getName());
                    sysLog.setIp(request.getRemoteAddr());
                    sysLog.setVisitTime(visitTime);
                    //===================================================
                    //===================================================
                    SecurityContext context = (SecurityContext) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();
                    //======================================
                    //======================================
                    sysLog.setUsername(username);
                    service.save(sysLog);
                }
            }
        }
    }
}
