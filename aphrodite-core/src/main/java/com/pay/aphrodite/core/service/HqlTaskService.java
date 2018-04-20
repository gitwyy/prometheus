package com.pay.aphrodite.core.service;

import com.pay.aphrodite.model.entity.HqlTask;

/**
 * @ClassName:HqlTaskService
 * @Author: yangyang.wang
 * @Date: 2018-04-20
 * @Version: 1.0
 * @Description: 处理HQL任务的业务类
 * 主要用于 HQL 任务的管理于调度
 **/
public interface HqlTaskService {

    // 创建一条 hql 任务
    void insert(HqlTask hqlTask);

    // 查询一条任务
    HqlTask selectById(Integer id);

    void update(HqlTask hqlTask);

    void delete(Integer id);
}