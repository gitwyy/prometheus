package com.pay.aphrodite.portal.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName:DebugLoggerAop
 * @Author: yangyang.wang
 * @Date: 2018-04-16 19:05
 * @Version: 1.0
 * @Description: debug 调试日志 aop
 **/
@Aspect
@Component
public class DebugLoggerAop {
    private Logger log = LoggerFactory.getLogger("debug-info");

    @Around("execution(public * com.pay.aphrodite.portal.*.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        Object proceed = null;
        String declaringTypeName = signature.getDeclaringTypeName();

        log.debug("[{}] START >>>>> [{}]",declaringTypeName,pjp.getArgs());
        try {
            proceed = pjp.proceed();
        } catch (Exception e) {
            log.error("[{}] ERROR XXXXX ",declaringTypeName, e);
            throw e;
        }
        log.debug("[{}] END <<<<< [{}]",declaringTypeName,proceed);
        return proceed;
    }
}
