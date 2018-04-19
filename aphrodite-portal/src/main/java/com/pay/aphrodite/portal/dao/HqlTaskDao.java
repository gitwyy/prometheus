package com.pay.aphrodite.portal.dao;


import com.pay.aphrodite.model.entity.HqlTask;

public interface HqlTaskDao {
    int deleteByPrimaryKey(Integer id);

    int insert(HqlTask record);

    int insertSelective(HqlTask record);

    HqlTask selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HqlTask record);

    int updateByPrimaryKey(HqlTask record);
}