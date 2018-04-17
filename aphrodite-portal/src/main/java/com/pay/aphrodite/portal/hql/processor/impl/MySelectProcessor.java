package com.pay.aphrodite.portal.hql.processor.impl;

import com.pay.aphrodite.portal.hql.processor.SelectProcessor;
import com.pay.aphrodite.portal.hql.processor.SqlProcessContext;
import com.pay.aphrodite.portal.hql.processor.SqlProcessor;
import com.pay.aphrodite.portal.hql.processor.SqlProcessorAdaptor;

import java.util.StringJoiner;

/**
 * @ClassName:MySelectProcessor
 * @Author: yangyang.wang
 * @Date: 2018-04-16 17:59
 * @Version: 1.0
 * @Description: Select 查询列表 处理器
 **/
public class MySelectProcessor extends SqlProcessorAdaptor implements SelectProcessor {

    public MySelectProcessor() {
        super();
    }

    public MySelectProcessor(SqlProcessor next) {
        super(next);
    }

    @Override
    protected String execute(SqlProcessContext sqlContext) {
        StringJoiner sj = new StringJoiner(",","select ","");

        sqlContext.getSqlSelect().getSqlSelectItems().forEach(
                sqlSelectItem -> {sj.add(sqlSelectItem.toSqlString());}
        );
        return sj.toString();
    }

    @Override
    public boolean verify(SqlProcessContext hqlContext) {
        return true;
    }
}
