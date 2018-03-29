package com.pay.aphrodite.query.dao.hive;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HqlDao {

    public long insert(@Param("hql") String hql);

    public List<Map<String,String>> get(@Param("hql") String hql);

    public List<Map<String,String>> load(@Param("hql")String hql);
}