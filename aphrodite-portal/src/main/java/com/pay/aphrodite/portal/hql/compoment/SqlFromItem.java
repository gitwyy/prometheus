package com.pay.aphrodite.portal.hql.compoment;

import com.pay.aphrodite.portal.hql.visitor.SqlVisitor;

/**
 * @ClassName:SqlFromItem
 * @Author: yangyang.wang
 * @Date: 2018-04-17 13:56
 * @Version: 1.0
 * @Description: from 节点元素
 **/
public class SqlFromItem extends SqlObject{
    @Override
    public String accept(SqlVisitor sqlVisitor) {
        return sqlVisitor.visit(this);
    }
}
