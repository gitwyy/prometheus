package com.pay.aphrodite.portal.dao;

public interface SqlExpressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SqlExpress record);

    int insertSelective(SqlExpress record);

    SqlExpress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SqlExpress record);

    int updateByPrimaryKeyWithBLOBs(SqlExpress record);

    int updateByPrimaryKey(SqlExpress record);
}