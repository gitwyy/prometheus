package com.pay.aphrodite.portal.dao;

public interface SqlSelectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SqlSelect record);

    int insertSelective(SqlSelect record);

    SqlSelect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SqlSelect record);

    int updateByPrimaryKey(SqlSelect record);
}