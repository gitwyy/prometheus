package com.pay.aphrodite.core.service.impl;

import com.pay.aphrodite.core.dao.mysql.HqlTaskDao;
import com.pay.aphrodite.core.service.HqlTaskService;
import com.pay.aphrodite.model.entity.HqlTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName:HqlTaskServiceImpl
 * @Author: yangyang.wang
 * @Date: 2018-04-20 11:07
 * @Version: 1.0
 * @Description: 处理HQL任务的业务处理类
 **/
@Service
public class HqlTaskServiceImpl implements HqlTaskService {

    @Autowired
    private HqlTaskDao hqlTaskDao;


    @Override
    @Transactional
    public void insert(HqlTask hqlTask){
        hqlTaskDao.insert(hqlTask);
    }

    @Override
    public HqlTask selectById(Integer id){
        return hqlTaskDao.selectByPrimaryKey(id);
    }

    @Override
    public void update(HqlTask hqlTask) {
        hqlTaskDao.updateByPrimaryKeySelective(hqlTask);
    }

    @Override
    public void delete(Integer id) {
        // TODO
    }

}
