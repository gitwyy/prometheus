package com.pay.aphrodite.query.service;

import java.util.List;
import java.util.Map;


/**
 * @ClassName:HqlService
 * @Author: yangyang.wang
 * @Date: 2018-03-30 19:39
 * @Version: 1.0
 * @Description: Hql 业务操作封装接口 操作hive都需要通过该接口来操作（日志aop 也会配置在该接口）
 *
 **/
public interface HqlService {
    /**
     * @Author: yangyang.wang
     * @Date: 2018-03-30 19:43
     * @Param: [hql] :
     * @Return: long :
     * @Description: 数据插入操作
     * @Modifyby: yangyang.wang
     **/
    public long insert(String hql);


    /**
     * @Author: yangyang.wang
     * @Date: 2018-03-30 19:43
     * @Param: [hql] : 执行查询的hql
     * @Return: java.util.List<java.util.Map<java.lang.String,java.lang.String>> :
     * @Description: 数据查询
     * @Modifyby: yangyang.wang
     **/
    public List<Map<String,String>> select(String hql);


    /**
     * @Author: yangyang.wang
     * @Date: 2018-03-30 19:41
     * @Param: [hql, localPath] : 需要导出数据的sql, 导出数据的路径
     * @Return: java.util.List<java.util.Map<java.lang.String,java.lang.String>> :
     * @Description: 进行数据下载操作
     * @Modifyby: yangyang.wang
     **/
    public List<Map<String, String>> load(String hql, String localPath);
}
