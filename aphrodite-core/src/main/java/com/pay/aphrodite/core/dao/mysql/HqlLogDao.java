package com.pay.aphrodite.core.dao.mysql;


import com.pay.aphrodite.model.entity.HqlLog;


public interface HqlLogDao {

    int insert(HqlLog record);

    HqlLog selectByPrimaryKey(Integer id);
}