package com.pay.aphrodite.core.dao.hive;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * @ClassName:HqlDao
 * @Author: yangyang.wang
 * @Date: 2018-03-30 19:37
 * @Version: 1.0
 * @Description: HqlExecuteDao
 *
 **/
public interface HqlExecuteDao {

    public List<Map<String,String>> select(@Param("hql") String hql);

    public void load(@Param("hql")String hql,@Param("path") String path);
}