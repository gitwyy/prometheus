package com.pay.aphrodite.portal.hql;

import com.pay.aphrodite.portal.hql.compoment.SqlObjectType;
import com.pay.aphrodite.portal.hql.visitor.SqlVisitor;

/**
 * @ClassName:SqlObject
 * @Author: yangyang.wang
 * @Date: 2018-04-17 13:59
 * @Version: 1.0
 * @Description: sql 元素父节点
 **/
public abstract class SqlObject {

    /* @Comment: sql 元素类型 */
    private SqlObjectType sqlObjectType;

    /* @Comment:  sql 元素*/
    private SqlObject sqlObject;

    /* @Comment:  别名 */
    private String alias;

    /* @Comment:  所属者*/
    private String owner;

    /* @Comment:  sql 语句块 */
    private String sqlExpr;

    /**
     * @Author: yangyang.wang
     * @Date: 2018-04-17 14:22
     * @Param: [sqlVisitor] : sql元素访问者
     * @Return: java.lang.String :
     * @Description: 访问当前元素
     * @Modifyby:yangyang.wang
     **/
    public abstract String accept(SqlVisitor sqlVisitor);


    public SqlObjectType getSqlObjectType() {
        return sqlObjectType;
    }

    public SqlObject setSqlObjectType(SqlObjectType sqlObjectType) {
        this.sqlObjectType = sqlObjectType;
        return this;
    }

    public SqlObject getSqlObject() {
        return sqlObject;
    }

    public SqlObject setSqlObject(SqlObject sqlObject) {
        this.sqlObject = sqlObject;
        return this;
    }

    public String getAlias() {
        return alias;
    }

    public SqlObject setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public SqlObject setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getSqlExpr() {
        return sqlExpr;
    }

    public SqlObject setSqlExpr(String sqlExpr) {
        this.sqlExpr = sqlExpr;
        return this;
    }

    @Override
    public String toString() {
        return "SqlObject{" +
                "sqlObjectType=" + sqlObjectType +
                ", sqlObject=" + sqlObject +
                ", alias='" + alias + '\'' +
                ", owner='" + owner + '\'' +
                ", sqlExpr='" + sqlExpr + '\'' +
                '}';
    }
}
