package com.pay.aphrodite.portal.dao;


public interface SqlFromMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SqlFrom record);

    int insertSelective(SqlFrom record);

    SqlFrom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SqlFrom record);

    int updateByPrimaryKey(SqlFrom record);
}