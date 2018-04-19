package com.pay.aphrodite.portal.dao;

import com.pay.aphrodite.model.entity.SqlFrom;

public interface SqlFromDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SqlFrom record);

    int insertSelective(SqlFrom record);

    SqlFrom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SqlFrom record);

    int updateByPrimaryKey(SqlFrom record);
}