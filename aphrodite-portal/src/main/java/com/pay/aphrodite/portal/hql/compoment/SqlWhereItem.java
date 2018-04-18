package com.pay.aphrodite.portal.hql.compoment;

import com.pay.aphrodite.portal.hql.Condition;
import com.pay.aphrodite.portal.hql.SqlObject;
import com.pay.aphrodite.portal.hql.visitor.SqlVisitor;

/**
 * @ClassName:SqlWhereItem
 * @Author: yangyang.wang
 * @Date: 2018-04-17 13:57
 * @Version: 1.0
 * @Description: where 节点元素
 **/
public class SqlWhereItem extends SqlObject {


    /* @Comment:  约束条件 */
    private Condition whereCondition;


    @Override
    public String accept(SqlVisitor sqlVisitor) {
        return sqlVisitor.visit(this);
    }

    public Condition getWhereCondition() {
        return whereCondition;
    }

    public SqlWhereItem setWhereCondition(Condition whereCondition) {
        this.whereCondition = whereCondition;
        return this;
    }

    @Override
    public SqlWhereItem setSqlObjectType(SqlObjectType sqlObjectType) {
        super.setSqlObjectType(sqlObjectType);
        return this;
    }

    @Override
    public SqlWhereItem setSqlObject(SqlObject sqlObject) {
        super.setSqlObject(sqlObject);
        return this;
    }

    @Override
    public SqlWhereItem setAlias(String alias) {
        super.setAlias(alias);
        return this;
    }

    @Override
    public SqlWhereItem setOwner(String owner) {
        super.setOwner(owner);
        return this;
    }

}
