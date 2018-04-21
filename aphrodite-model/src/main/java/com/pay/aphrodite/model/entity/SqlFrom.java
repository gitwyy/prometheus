package com.pay.aphrodite.model.entity;

import java.util.Date;

public class SqlFrom extends BaseEntity<SqlFrom>{

    private Date updateTime;

    private String tableName;

    private String alias;

    private Integer selectId;

    private String sqlObjectType;

    private String owner;

    private String joinType;

    private Integer nextId;

    private Integer subQueryId;

    private String leftOwner;

    private String rightOwner;

    private String leftElement;

    private String rightElement;

    private String symbol;

    public Date getUpdateTime() {
        return updateTime;
    }

    public SqlFrom setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getTableName() {
        return tableName;
    }

    public SqlFrom setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public String getAlias() {
        return alias;
    }

    public SqlFrom setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public Integer getSelectId() {
        return selectId;
    }

    public SqlFrom setSelectId(Integer selectId) {
        this.selectId = selectId;
        return this;
    }

    public String getSqlObjectType() {
        return sqlObjectType;
    }

    public SqlFrom setSqlObjectType(String sqlObjectType) {
        this.sqlObjectType = sqlObjectType;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public SqlFrom setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getJoinType() {
        return joinType;
    }

    public SqlFrom setJoinType(String joinType) {
        this.joinType = joinType;
        return this;
    }

    public Integer getNextId() {
        return nextId;
    }

    public SqlFrom setNextId(Integer nextId) {
        this.nextId = nextId;
        return this;
    }

    public Integer getSubQueryId() {
        return subQueryId;
    }

    public SqlFrom setSubQueryId(Integer subQueryId) {
        this.subQueryId = subQueryId;
        return this;
    }

    public String getLeftOwner() {
        return leftOwner;
    }

    public SqlFrom setLeftOwner(String leftOwner) {
        this.leftOwner = leftOwner;
        return this;
    }

    public String getRightOwner() {
        return rightOwner;
    }

    public SqlFrom setRightOwner(String rightOwner) {
        this.rightOwner = rightOwner;
        return this;
    }

    public String getLeftElement() {
        return leftElement;
    }

    public SqlFrom setLeftElement(String leftElement) {
        this.leftElement = leftElement;
        return this;
    }

    public String getRightElement() {
        return rightElement;
    }

    public SqlFrom setRightElement(String rightElement) {
        this.rightElement = rightElement;
        return this;
    }

    public String getSymbol() {
        return symbol;
    }

    public SqlFrom setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SqlFrom{");
        sb.append("updateTime=").append(updateTime);
        sb.append(", tableName='").append(tableName).append('\'');
        sb.append(", alias='").append(alias).append('\'');
        sb.append(", selectId=").append(selectId);
        sb.append(", sqlObjectType='").append(sqlObjectType).append('\'');
        sb.append(", owner='").append(owner).append('\'');
        sb.append(", joinType='").append(joinType).append('\'');
        sb.append(", nextId=").append(nextId);
        sb.append(", subQueryId=").append(subQueryId);
        sb.append(", leftOwner='").append(leftOwner).append('\'');
        sb.append(", rightOwner='").append(rightOwner).append('\'');
        sb.append(", leftElement='").append(leftElement).append('\'');
        sb.append(", rightElement='").append(rightElement).append('\'');
        sb.append(", symbol='").append(symbol).append('\'');
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", optimistic='").append(optimistic).append('\'');
        sb.append(", remark='").append(remark).append('\'');
        sb.append(", operator='").append(operator).append('\'');
        sb.append('}');
        return sb.toString();
    }
}