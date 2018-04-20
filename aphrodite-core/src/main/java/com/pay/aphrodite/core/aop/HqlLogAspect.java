package com.pay.aphrodite.core.aop;

import com.pay.aphrodite.core.service.HqlLogService;
import com.pay.aphrodite.model.entity.HqlLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;
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

    @Around(value = "execution(public * com.pay.aphrodite.core.service.impl.HqlServiceImpl.*(..))")
    public Object aroundHql(ProceedingJoinPoint pjp) throws Throwable {
        Object proceed = null;
        String declaringTypeName = pjp.getSignature().getDeclaringTypeName();
        try {
            log.debug("before proceed [{}]", declaringTypeName);
            proceed = pjp.proceed();
            log.debug("after proceed [{}]", declaringTypeName);
            return proceed;
        } catch (Throwable throwable) {
            log.error("error proceed [{}] ", declaringTypeName, throwable);
            proceed = String.format("[%s] proceed error msg is - [%s]",declaringTypeName,throwable.getMessage());
            throw throwable;
        } finally {
            // 成功失败都写日志
            insertLog(pjp, proceed);
        }
    }

    private void insertLog(ProceedingJoinPoint pjp, Object result) {
        try {
            Signature signature = pjp.getSignature();
            String method = String.format("%s-%s", signature.getDeclaringTypeName(), signature.getName());
            String args = Arrays.stream(pjp.getArgs())
                    .filter(Objects::nonNull).map(arg -> arg.toString()).reduce((x, y) -> {
                        StringJoiner sj = new StringJoiner("];[", "{[", "]}");
                        return sj.add(x).add(y).toString();
                    }).get();
            hqlLogService.insert(new HqlLog(args, "SYSTEM", result.toString(),method));
        } catch (Throwable throwable) {
            log.error("insert log error ", throwable);
        }
    }

}
