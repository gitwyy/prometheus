package com.pay.aphrodite.portal.dao;

public interface SqlSelectItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SqlSelectItem record);

    int insertSelective(SqlSelectItem record);

    SqlSelectItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SqlSelectItem record);

    int updateByPrimaryKey(SqlSelectItem record);
}