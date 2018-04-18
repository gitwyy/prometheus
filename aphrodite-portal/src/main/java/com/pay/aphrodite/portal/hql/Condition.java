package com.pay.aphrodite.portal.hql;

import com.pay.aphrodite.portal.hql.compoment.SqlObjectType;
import com.pay.aphrodite.portal.hql.visitor.SqlVisitor;

/**
 * @ClassName:Condition
 * @Author: yangyang.wang
 * @Date: 2018-04-18 17:05
 * @Version: 1.0
 * @Description: 约束类
 **/
public class Condition extends SqlObject{

    private String symbol;

    @Override
    public String accept(SqlVisitor sqlVisitor) {
        return sqlVisitor.visit(this);
    }

    public String getSymbol() {
        return symbol;
    }

    public Condition setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    @Override
    public Condition setSqlObjectType(SqlObjectType sqlObjectType) {
        super.setSqlObjectType(sqlObjectType);
        return this;
    }

    @Override
    public Condition setSqlObject(SqlObject sqlObject) {
        super.setSqlObject(sqlObject);
        return this;
    }

    @Override
    public Condition setAlias(String alias) {
        super.setAlias(alias);
        return this;
    }

    @Override
    public Condition setOwner(String owner) {
        super.setOwner(owner);
        return this;
    }

    @Override
    public Condition setSqlExpr(String sqlExpr) {
        super.setSqlExpr(sqlExpr);
        return this;
    }
}
