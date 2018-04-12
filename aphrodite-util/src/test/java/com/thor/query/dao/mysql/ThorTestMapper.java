package com.thor.query.dao.mysql;

import com.thor.query.model.ThorTest;

public interface ThorTestMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ThorTest record);

    int insertSelective(ThorTest record);

    ThorTest selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ThorTest record);

    int updateByPrimaryKey(ThorTest record);
}