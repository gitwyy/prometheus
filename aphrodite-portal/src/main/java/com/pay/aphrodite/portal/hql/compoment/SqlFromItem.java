package com.pay.aphrodite.portal.hql.compoment;

import com.pay.aphrodite.portal.hql.Condition;
import com.pay.aphrodite.portal.hql.SqlObject;
import com.pay.aphrodite.portal.hql.visitor.SqlVisitor;

/**
 * @ClassName:SqlFromItem
 * @Author: yangyang.wang
 * @Date: 2018-04-17 13:56
 * @Version: 1.0
 * @Description: from 节点元素
 **/
public class SqlFromItem extends SqlObject {

    /* @Comment: from 约束条件 */
    private Condition fromCondition;

    /* @Comment: 关联类型 */
    private String JoinType;

    /* @Comment:  表名 */
    private String tableName;

    private SqlFromItem next;

    @Override
    public String accept(SqlVisitor sqlVisitor) {
        return sqlVisitor.visit(this);
    }

    public Condition getFromCondition() {
        return fromCondition;
    }

    public SqlFromItem setFromCondition(Condition fromCondition) {
        this.fromCondition = fromCondition;
        return this;
    }

    public String getJoinType() {
        return JoinType;
    }

    public SqlFromItem setJoinType(String joinType) {
        JoinType = joinType;
        return this;
    }


    public String getTableName() {
        return tableName;
    }

    public SqlFromItem setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }


    @Override
    public SqlFromItem setSqlObjectType(SqlObjectType sqlObjectType) {
        super.setSqlObjectType(sqlObjectType);
        return this;
    }

    @Override
    public SqlFromItem setSqlObject(SqlObject sqlObject) {
        super.setSqlObject(sqlObject);
        return this;
    }

    @Override
    public SqlFromItem setAlias(String alias) {
        super.setAlias(alias);
        return this;
    }

}
