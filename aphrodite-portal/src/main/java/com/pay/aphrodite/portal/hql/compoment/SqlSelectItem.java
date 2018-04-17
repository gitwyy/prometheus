package com.pay.aphrodite.portal.hql.compoment;

import com.pay.aphrodite.portal.hql.visitor.SqlVisitor;

/**
 * @ClassName:SqlSelectItem
 * @Author: yangyang.wang
 * @Date: 2018-04-17 13:56
 * @Version: 1.0
 * @Description: select 节点元素
 **/
public class SqlSelectItem extends SqlObject{
    @Override
    public String accept(SqlVisitor sqlVisitor) {
        return sqlVisitor.visit(this);
    }
}
