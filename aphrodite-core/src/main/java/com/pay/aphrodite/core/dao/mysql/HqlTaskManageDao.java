package com.pay.aphrodite.core.dao.mysql;

import com.pay.aphrodite.model.entity.HqlTaskManage;

public interface HqlTaskManageDao {

    Long insert(HqlTaskManage record);

    HqlTaskManage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HqlTaskManage record);
}