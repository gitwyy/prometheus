package com.pay.aphrodite.query.dao.mysql;


import com.pay.aphrodite.model.entity.HqlLog;


public interface HqlLogDao {
    int deleteByPrimaryKey(Integer id);

    int insert(HqlLog record);

    int insertSelective(HqlLog record);

    HqlLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HqlLog record);

    int updateByPrimaryKey(HqlLog record);
}