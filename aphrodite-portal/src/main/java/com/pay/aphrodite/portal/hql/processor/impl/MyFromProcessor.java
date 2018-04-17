package com.pay.aphrodite.portal.hql.processor.impl;

import com.pay.aphrodite.portal.hql.processor.FromProcessor;
import com.pay.aphrodite.portal.hql.processor.SqlProcessContext;
import com.pay.aphrodite.portal.hql.processor.SqlProcessor;
import com.pay.aphrodite.portal.hql.processor.SqlProcessorAdaptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName:MyFromProcessor
 * @Author: yangyang.wang
 * @Date: 2018-04-16 18:06
 * @Version: 1.0
 * @Description: TODO
 **/
public class MyFromProcessor extends SqlProcessorAdaptor implements FromProcessor {

    private Logger log = LoggerFactory.getLogger(MyFromProcessor.class);

    public MyFromProcessor() {
    }

    public MyFromProcessor(SqlProcessor next) {
        super(next);
    }

    @Override
    public String execute(SqlProcessContext sqlContext) {
        return null;
    }

    @Override
    public boolean verify(SqlProcessContext sqlContext) {
        return true;
    }
}
