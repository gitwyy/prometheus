package com.pay.aphrodite.portal.dao;


import com.pay.aphrodite.model.entity.SqlSelect;

public interface SqlSelectDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SqlSelect record);

    int insertSelective(SqlSelect record);

    SqlSelect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SqlSelect record);

    int updateByPrimaryKeyWithBLOBs(SqlSelect record);

    int updateByPrimaryKey(SqlSelect record);
}