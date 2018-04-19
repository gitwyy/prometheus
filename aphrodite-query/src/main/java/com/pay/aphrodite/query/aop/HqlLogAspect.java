package com.pay.aphrodite.query.aop;

import com.pay.aphrodite.model.entity.HqlLog;
import com.pay.aphrodite.query.service.HqlLogService;
import com.pay.aphrodite.query.service.HqlService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * @ClassName:HqlLogAspect
 * @Author: yangyang.wang
 * @Date: 2018-03-30$ 22:20$
 * @Version: 1.0
 * @Description: 用于记录HQL执行记录的 AOP 切面类
 **/
@Aspect
@Component
public class HqlLogAspect {
    private final Logger log = LoggerFactory.getLogger(HqlLogAspect.class);

    @Autowired
    private HqlLogService hqlLogService;

    @Around(value = "execution(public * com.pay.aphrodite.query.controller.HiveController.*(..))")
    public void aroundHql(ProceedingJoinPoint pjp){
        String typeName = pjp.getSignature().getDeclaringTypeName();
        log.debug("typeName >>> [{}]",typeName);
        try {
            String args = Arrays.stream(pjp.getArgs()).map(arg -> arg.toString()).reduce((x, y) -> {
                StringJoiner sj = new StringJoiner(";", "[", "]");
                return sj.add(x).add(y).toString();
            }).get();
            Object proceed = pjp.proceed();
            hqlLogService.insert(new HqlLog(args,typeName,proceed.toString()));
            log.debug("after ",proceed);
        } catch (Throwable throwable) {
            log.error(" error ",throwable);
        }
        HqlLog log = new HqlLog();
        hqlLogService.insert(log);
    }

}
