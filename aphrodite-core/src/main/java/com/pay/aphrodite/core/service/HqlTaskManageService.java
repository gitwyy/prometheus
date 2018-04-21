package com.pay.aphrodite.core.service;

import com.pay.aphrodite.model.entity.HqlTask;
import com.pay.aphrodite.model.entity.HqlTaskManage;

import java.util.List;
import java.util.Map;

public interface HqlTaskManageService {

    List<Map<String,String>> startSelectTask(HqlTask hqlTask);


    void startDownLoadTask(HqlTask hqlTask);


    Long insert(HqlTaskManage hqlTaskManage);

    void update(HqlTaskManage hqlTaskManage);
}