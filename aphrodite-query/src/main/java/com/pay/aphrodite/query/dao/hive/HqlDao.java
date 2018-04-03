package com.pay.aphrodite.query.dao.hive;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * @ClassName:HqlDao
 * @Author: yangyang.wang
 * @Date: 2018-03-30 19:37
 * @Version: 1.0
 * @Description: HqlDao
 *
 **/
public interface HqlDao {

    public long insert(@Param("hql") String hql);

    public List<Map<String,String>> select(@Param("hql") String hql);

    public List<Map<String,String>> load(@Param("hql")String hql,@Param("path") String path);
}