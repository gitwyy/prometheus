package com.pay.aphrodite.core.service.impl;

import com.pay.aphrodite.core.dao.mysql.HqlLogDao;
import com.pay.aphrodite.core.service.HqlLogService;
import com.pay.aphrodite.model.entity.HqlLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @ClassName:HqlLogServiceImpl
 * @Author: yangyang.wang
 * @Date: 2018-04-02 0:40
 * @Version: 1.0
 * @Description: 记录HQL操作记录
 *
 **/
@Service
public class HqlLogServiceImpl implements HqlLogService {
    @Autowired
    private HqlLogDao hqlLogDao;

    @Override
    @Transactional
    public int insert(HqlLog hqlLog) {
        return hqlLogDao.insert(hqlLog);
    }
}