package com.pay.aphrodite.portal.hql.processor;

/**
 * @ClassName: SqlProcessor
 * @Author: yangyang.wang
 * @Date: 2018-04-09 18:13:11
 * @Version: 1.0
 * @Description: SQL 解析处理器 顶层接口
 *
 **/
public interface SqlProcessor {

//    String execute(SqlProcessContext sqlContext);

    String process(SqlProcessContext sqlContext);

    boolean verify(SqlProcessContext sqlContext);


}
