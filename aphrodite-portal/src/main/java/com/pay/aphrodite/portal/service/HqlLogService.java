package com.pay.aphrodite.portal.service;

import com.pay.aphrodite.model.entity.HqlLog;

/**
 * @ClassName:HqlLogService$
 * @Author: yangyang.wang
 * @Date: 2018-03-30$ 22:54$
 * @Version: 1.0
 * @Description: 记录 hql执行记录的业务处理类
 **/
public interface HqlLogService {

    public int insert(HqlLog hqlLog);
}
