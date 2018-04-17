package com.pay.aphrodite.portal.dao;


public interface SqlTableSourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SqlTableSource record);

    int insertSelective(SqlTableSource record);

    SqlTableSource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SqlTableSource record);

    int updateByPrimaryKey(SqlTableSource record);
}