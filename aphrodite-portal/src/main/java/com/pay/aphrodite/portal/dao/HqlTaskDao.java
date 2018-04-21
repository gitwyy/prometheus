package com.pay.aphrodite.portal.dao;

import com.pay.aphrodite.model.entity.HqlTask;

public interface HqlTaskDao {

    int insert(HqlTask record);


    HqlTask selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HqlTask record);

}