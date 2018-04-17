package com.pay.aphrodite.portal.hql.compoment;

import com.pay.aphrodite.portal.hql.visitor.SqlVisitor;

/**
 * @ClassName:SqlObject
 * @Author: yangyang.wang
 * @Date: 2018-04-17 13:59
 * @Version: 1.0
 * @Description: sql 元素父节点
 **/
public abstract class SqlObject {

    /**
     * @Author: yangyang.wang
     * @Date: 2018-04-17 14:22
     * @Param: [sqlVisitor] : sql元素访问者
     * @Return: java.lang.String :
     * @Description: 访问当前元素
     * @Modifyby:yangyang.wang
     **/
    public abstract String accept(SqlVisitor sqlVisitor);

}
