package com.pay.aphrodite.portal.hql.compoment;

import com.pay.aphrodite.portal.hql.visitor.SqlVisitor;

/**
 * @ClassName:SqlWhereItem
 * @Author: yangyang.wang
 * @Date: 2018-04-17 13:57
 * @Version: 1.0
 * @Description: where 节点元素
 **/
public class SqlWhereItem extends SqlObject{

    @Override
    public String accept(SqlVisitor sqlVisitor) {
        return sqlVisitor.visit(this);
    }
}
