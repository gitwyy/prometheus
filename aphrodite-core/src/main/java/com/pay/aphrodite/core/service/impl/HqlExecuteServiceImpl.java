package com.pay.aphrodite.core.service.impl;

import com.pay.aphrodite.core.dao.hive.HqlExecuteDao;
import com.pay.aphrodite.core.service.HqlExecuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:HqlExecuteServiceImpl
 * @Author: yangyang.wang
 * @Date: 2018-04-21 15:48
 * @Version: 1.0
 * @Description: 执行HQL业务类 调用 hql 进行数据查询 和 下载数据到本地的操作
 **/
@Service
public class HqlExecuteServiceImpl implements HqlExecuteService {

    @Autowired
    private HqlExecuteDao hqlExecuteDao;

    @Override
    public List<Map<String, String>> select(String hql){
        return hqlExecuteDao.select(hql);
    }


    @Override
    public void download(String hql,String localPath){
        hqlExecuteDao.load(hql,localPath);
    }

}
