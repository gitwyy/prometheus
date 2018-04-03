package com.pay.aphrodite.query.aop;

import com.pay.aphrodite.model.entity.HqlLog;
import com.pay.aphrodite.query.service.HqlLogService;
import com.pay.aphrodite.query.service.HqlService;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @Around(value = "")
    public void aroundHql(){
        HqlLog log = new HqlLog();
        hqlLogService.insert(log);
    }

}
