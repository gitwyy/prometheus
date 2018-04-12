package com.pay.aphrodite.portal.hql.processor;

/**
 * @ClassName:HQLProcessorAdaptor
 * @Author: yangyang.wang
 * @Date: 2018-04-09 20:25
 * @Version: 1.0
 * @Description: TODO
 **/
public abstract class HqlProcessorAdaptor implements HqlProcessor {

    /* @Comment:  当前处理器链中的下一个处理器*/
    protected HqlProcessor next;

    HqlProcessorAdaptor(){
        super();
        // TODO
    }

    HqlProcessorAdaptor(HqlProcessor next){
        super();
        if( next == null ) {
            throw new NullPointerException("next HqlProcessor should not be null");
        }
        this.next = next;
    }


    /**
     * @Author: yangyang.wang
     * @Date: 2018-04-09 20:49
     * @Param: [hqlContext] :
     * @Return: java.lang.Object :
     * @Description: 链式结构处理SQL 的解析处理
     * @Modifyby:yangyang.wang
     **/
    public Object process(HqlContext hqlContext){
        execute(hqlContext);
        return this.next.process(hqlContext);
    }
}
