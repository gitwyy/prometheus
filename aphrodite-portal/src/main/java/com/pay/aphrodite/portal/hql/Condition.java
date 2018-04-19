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

    /* @Comment:  限制符 */
    private String symbol;

    /* @Comment:  被约束元素 */
    private String element;

    /* @Comment:  约束左边 */
    private Condition left;

    /* @Comment:  约束右边 */
    private Condition right;

    public Condition() {
    }

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

    public String getElement() {
        return element;
    }

    public Condition setElement(String element) {
        this.element = element;
        return this;
    }

    public Condition getLeft() {
        return left;
    }

    public Condition setLeft(Condition left) {
        this.left = left;
        return this;
    }

    public Condition getRight() {
        return right;
    }

    public Condition setRight(Condition right) {
        this.right = right;
        return this;
    }
}
