package com.pay.aphrodite.portal.hql.processor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.StringJoiner;

/**
 * @ClassName:HQLProcessorAdaptor
 * @Author: yangyang.wang
 * @Date: 2018-04-09 20:25
 * @Version: 1.0
 * @Description: SQL 处理 调度器
 **/
public abstract class SqlProcessorAdaptor implements SqlProcessor {

    private Logger log = LoggerFactory.getLogger(getClass());

    /* @Comment:  当前处理器链中的下一个处理器*/
    protected SqlProcessor next;

    public SqlProcessorAdaptor(){
        super();
    }

    public SqlProcessorAdaptor(final SqlProcessor next){
        super();
        if( next == null ) {
            throw new NullPointerException("next SqlProcessor should not be null");
        }
        this.next = next;
    }

    protected abstract String execute(final SqlProcessContext sqlContext);

    /**
     * @Author: yangyang.wang
     * @Date: 2018-04-09 20:49
     * @Param: [hqlContext] :
     * @Return: java.lang.Object :
     * @Description: 链式结构处理SQL 的解析处理
     * @Modifyby:yangyang.wang
     **/
    public String process(final SqlProcessContext sqlContext){
        StringJoiner sj = new StringJoiner(" ");

        if(this.verify(sqlContext)){
            String result = this.execute(sqlContext);
            if(StringUtils.isNotEmpty(result))
                sj.add(result);
        }

        if(next != null){
            sj.add(this.next.process(sqlContext));
        }

        return sj.toString();
    }
}
