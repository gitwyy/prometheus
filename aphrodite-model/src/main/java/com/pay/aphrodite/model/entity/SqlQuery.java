package com.pay.aphrodite.model.entity;

import java.util.Date;

public class SqlQuery {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer optimistic;

    private String operator;

    private String columnName;

    private String alias;

    private Integer selectId;

    private String owner;

    private String sqlObjectType;

    private Integer subQueryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getOptimistic() {
        return optimistic;
    }

    public void setOptimistic(Integer optimistic) {
        this.optimistic = optimistic;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public Integer getSelectId() {
        return selectId;
    }

    public void setSelectId(Integer selectId) {
        this.selectId = selectId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getSqlObjectType() {
        return sqlObjectType;
    }

    public void setSqlObjectType(String sqlObjectType) {
        this.sqlObjectType = sqlObjectType == null ? null : sqlObjectType.trim();
    }

    public Integer getSubQueryId() {
        return subQueryId;
    }

    public void setSubQueryId(Integer subQueryId) {
        this.subQueryId = subQueryId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", optimistic=").append(optimistic);
        sb.append(", operator=").append(operator);
        sb.append(", columnName=").append(columnName);
        sb.append(", alias=").append(alias);
        sb.append(", selectId=").append(selectId);
        sb.append(", owner=").append(owner);
        sb.append(", sqlObjectType=").append(sqlObjectType);
        sb.append(", subQueryId=").append(subQueryId);
        sb.append("]");
        return sb.toString();
    }
}