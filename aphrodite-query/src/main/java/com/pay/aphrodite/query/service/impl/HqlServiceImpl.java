package com.pay.aphrodite.query.service.impl;

import com.pay.aphrodite.query.dao.hive.HqlDao;
import com.pay.aphrodite.query.service.HqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class HqlServiceImpl implements HqlService {

    @Autowired
    private HqlDao hqlDao;

    @Override
    public long insert(String hql) {

        return hqlDao.insert(hql);
    }

    @Override
    public List<Map<String, String>> select(String hql) {
        return hqlDao.select(hql);
    }

    @Override
    public List<Map<String, String>> load(String hql, String localPath) {
        return hqlDao.load(hql,localPath);
    }
}
