package com.pay.aphrodite.portal.hql.processor.impl;

import com.pay.aphrodite.portal.hql.processor.SqlProcessContext;
import com.pay.aphrodite.portal.hql.processor.SqlProcessor;
import com.pay.aphrodite.portal.hql.processor.SqlProcessorAdaptor;
import com.pay.aphrodite.portal.hql.processor.WhereProcessor;

/**
 * @ClassName:MyWhereProcessor
 * @Author: yangyang.wang
 * @Date: 2018-04-16 18:07
 * @Version: 1.0
 * @Description: TODO
 **/
public class MyWhereProcessor extends SqlProcessorAdaptor implements WhereProcessor {

    public MyWhereProcessor() {
    }

    public MyWhereProcessor(SqlProcessor next) {
        super(next);
    }

    @Override
    protected String execute(SqlProcessContext sqlContext) {
        return null;
    }


    @Override
    public boolean verify(SqlProcessContext sqlContext) {
        return true;
    }

}
