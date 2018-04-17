package com.pay.aphrodite.portal.hql.processor;

/**
 * @ClassName:SqlExpressProcessor
 * @Author: yangyang.wang
 * @Date:  
 * @Version: 1.0
 * @Description: sql 表达式 处理器
 *
 **/
public interface SqlExpressProcessor extends SqlProcessor{


    default String execute(final SqlProcessContext sqlContext){
       return toSqlString(sqlContext);
    };

    default String process(final SqlProcessContext sqlContext){
        return null;
    };

    default boolean verify(final SqlProcessContext sqlContext){
        return true;
    };

    default String toSqlString(final SqlProcessContext sqlContext){
        return null;
    };
}