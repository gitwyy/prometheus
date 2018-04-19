package com.pay.aphrodite.query.service.impl;

import com.pay.aphrodite.model.entity.HqlLog;
import com.pay.aphrodite.query.dao.mysql.HqlLogDao;
import com.pay.aphrodite.query.service.HqlLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jdo.annotations.Transactional;

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
    @Autowired
    private HqlLogDao hqlLogDao;

    @Override
    @Transactional
    public int insert(HqlLog hqlLog) {
        return hqlLogDao.insert(hqlLog);
    }
}