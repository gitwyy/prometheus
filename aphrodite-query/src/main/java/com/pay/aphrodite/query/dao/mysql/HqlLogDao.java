package com.pay.aphrodite.query.dao.mysql;


import com.pay.aphrodite.model.entity.HqlLog;

/**
 * @ClassName:HqlLogDao
 * @Author: yangyang.wang
 * @Date: 2018-03-30 19:38
 * @Version: 1.0
 * @Description: Hql操作记录Dao
 *
 **/
public interface HqlLogDao {
    int insert(HqlLog hqlLog);


}
