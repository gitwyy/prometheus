package com.pay.aphrodite.core.service;

import com.pay.aphrodite.model.entity.HqlTaskLog;

/**
 * @ClassName: HqlTaskLogService
 * @Author: yangyang.wang
 * @Date:  
 * @Version: 1.0
 * @Description: 任务管理 日志
 *
 **/
public interface HqlTaskLogService {

    Long insert(HqlTaskLog hqlTaskLog);
}
