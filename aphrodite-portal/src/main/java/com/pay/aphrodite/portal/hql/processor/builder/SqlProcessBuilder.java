package com.pay.aphrodite.portal.hql.processor.builder;

import com.pay.aphrodite.portal.hql.processor.SqlProcessor;
import com.pay.aphrodite.portal.hql.processor.impl.MyFromProcessor;
import com.pay.aphrodite.portal.hql.processor.impl.MySelectProcessor;
import com.pay.aphrodite.portal.hql.processor.impl.MyWhereProcessor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName:SqlProcessBuilder
 * @Author: yangyang.wang
 * @Date: 2018-04-17 8:53
 * @Version: 1.0
 * @Description: 解析器构建
 **/
public class SqlProcessBuilder {

    public static final String SELECT = "select";

    public static final Map<String, MySelectProcessor> processorPool = new HashMap<>();

    public static SqlProcessor builder(String process){

        if(!processorPool.containsKey(process)){
            synchronized (SqlProcessBuilder.class){
                if(!processorPool.containsKey(process)){
                    // 构建解析器
                    processorPool.put(process, new MySelectProcessor(new MyFromProcessor(new MyWhereProcessor())));
                }
            }
        }
        return processorPool.get(process);
    }
}
