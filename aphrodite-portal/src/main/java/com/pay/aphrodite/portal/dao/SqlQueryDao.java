package com.pay.aphrodite.portal.dao;


import com.pay.aphrodite.model.entity.SqlQuery;

public interface SqlQueryDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SqlQuery record);

    int insertSelective(SqlQuery record);

    SqlQuery selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SqlQuery record);

    int updateByPrimaryKey(SqlQuery record);
}