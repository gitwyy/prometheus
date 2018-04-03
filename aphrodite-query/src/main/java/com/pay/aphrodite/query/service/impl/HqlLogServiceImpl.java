package com.pay.aphrodite.query.service.impl;

import com.pay.aphrodite.model.entity.HqlLog;
import com.pay.aphrodite.query.service.HqlLogService;
import org.springframework.stereotype.Service;

/**
 * @ClassName:HqlLogServiceImpl
 * @Author: yangyang.wang
 * @Date: 2018-04-02 0:40
 * @Version: 1.0
 * @Description: 记录HQL操作记录
 *
 **/
@Service
public class HqlLogServiceImpl implements HqlLogService{

    @Override
    public int insert(HqlLog hqlLog) {
        return 0;
    }
}
