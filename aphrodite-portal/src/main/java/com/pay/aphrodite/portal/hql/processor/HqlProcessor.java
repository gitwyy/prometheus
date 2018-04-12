package com.pay.aphrodite.portal.hql.processor;

/**
 * @ClassName: HqlProcessor
 * @Author: yangyang.wang
 * @Date: 2018-04-09 18:13:11
 * @Version: 1.0
 * @Description: HQL 解析处理器 顶层接口
 *
 **/
public interface HqlProcessor {

    Object execute(HqlContext hqlContext);

    Object process(HqlContext hqlContext);

    boolean verify();


}
