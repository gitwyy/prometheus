package com.pay.aphrodite.portal.dao;


import com.pay.aphrodite.model.entity.SqlWhere;

public interface SqlWhereDao {
    
    int deleteByPrimaryKey(Integer id);

    int insert(SqlWhere record);

    int insertSelective(SqlWhere record);

    SqlWhere selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SqlWhere record);

    int updateByPrimaryKey(SqlWhere record);
}
