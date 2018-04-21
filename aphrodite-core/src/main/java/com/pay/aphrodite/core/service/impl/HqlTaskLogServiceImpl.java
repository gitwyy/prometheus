package com.pay.aphrodite.core.service.impl;

import com.pay.aphrodite.core.dao.mysql.HqlTaskLogDao;
import com.pay.aphrodite.core.service.HqlTaskLogService;
import com.pay.aphrodite.model.entity.HqlTaskLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName:HqlTaskLogServiceImpl
 * @Author: yangyang.wang
 * @Date: 2018-04-21 16:28
 * @Version: 1.0
 **/
@Service
public class HqlTaskLogServiceImpl implements HqlTaskLogService {

    @Autowired
    private HqlTaskLogDao hqlTaskLogDao;

    @Override
    public Long insert(HqlTaskLog hqlTaskLog){
        return hqlTaskLogDao.insert(hqlTaskLog);
    }
}
