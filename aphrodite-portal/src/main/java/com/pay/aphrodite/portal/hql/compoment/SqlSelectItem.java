package com.pay.aphrodite.portal.hql.compoment;

import com.pay.aphrodite.portal.hql.SqlObject;
import com.pay.aphrodite.portal.hql.visitor.SqlVisitor;

/**
 * @ClassName:SqlSelectItem
 * @Author: yangyang.wang
 * @Date: 2018-04-17 13:56
 * @Version: 1.0
 * @Description: select 节点元素
 **/
public class SqlSelectItem extends SqlObject {

    /* @Comment:  列名*/
    private String columnName;

    @Override
    public String accept(SqlVisitor sqlVisitor) {
        return sqlVisitor.visit(this);
    }


    public String getColumnName() {
        return columnName;
    }

    public SqlSelectItem setColumnName(String columnName) {
        this.columnName = columnName;
        return this;
    }

    @Override
    public SqlSelectItem setAlias(String alias) {
        super.setAlias(alias);
        return this;
    }

    @Override
    public SqlSelectItem setSqlObject(SqlObject sqlObject) {
        super.setSqlObject(sqlObject);
        return this;
    }

    @Override
    public SqlSelectItem setSqlObjectType(SqlObjectType sqlObjectType) {
        super.setSqlObjectType(sqlObjectType);
        return this;
    }

    @Override
    public SqlSelectItem setOwner(String owner) {
        super.setOwner(owner);
        return this;
    }
}
