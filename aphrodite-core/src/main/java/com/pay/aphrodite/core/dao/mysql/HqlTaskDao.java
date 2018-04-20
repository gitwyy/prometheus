package com.pay.aphrodite.core.dao.mysql;

import com.pay.aphrodite.model.entity.HqlTask;

public interface HqlTaskDao {

    int insert(HqlTask record);


    HqlTask selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HqlTask record);

}