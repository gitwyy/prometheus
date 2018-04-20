package com.pay.aphrodite.core.dao.mysql;

import com.pay.aphrodite.model.entity.HqlTaskLog;

public interface HqlTaskLogDao {

    int insert(HqlTaskLog record);

    HqlTaskLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HqlTaskLog record);
}