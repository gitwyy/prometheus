package com.pay.aphrodite.model.entity;

import java.util.Date;

public class SqlQuery extends BaseEntity<SqlQuery>{
    private Date updateTime;

    private String columnName;

    private String alias;

    private Integer selectId;

    private String owner;

    private String sqlObjectType;

    private Integer subQueryId;

    public Date getUpdateTime() {
        return updateTime;
    }

    public SqlQuery setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getColumnName() {
        return columnName;
    }

    public SqlQuery setColumnName(String columnName) {
        this.columnName = columnName;
        return this;
    }

    public String getAlias() {
        return alias;
    }

    public SqlQuery setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public Integer getSelectId() {
        return selectId;
    }

    public SqlQuery setSelectId(Integer selectId) {
        this.selectId = selectId;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public SqlQuery setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getSqlObjectType() {
        return sqlObjectType;
    }

    public SqlQuery setSqlObjectType(String sqlObjectType) {
        this.sqlObjectType = sqlObjectType;
        return this;
    }

    public Integer getSubQueryId() {
        return subQueryId;
    }

    public SqlQuery setSubQueryId(Integer subQueryId) {
        this.subQueryId = subQueryId;
        return this;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SqlQuery{");
        sb.append("updateTime=").append(updateTime);
        sb.append(", columnName='").append(columnName).append('\'');
        sb.append(", alias='").append(alias).append('\'');
        sb.append(", selectId=").append(selectId);
        sb.append(", owner='").append(owner).append('\'');
        sb.append(", sqlObjectType='").append(sqlObjectType).append('\'');
        sb.append(", subQueryId=").append(subQueryId);
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", optimistic='").append(optimistic).append('\'');
        sb.append(", remark='").append(remark).append('\'');
        sb.append(", operator='").append(operator).append('\'');
        sb.append('}');
        return sb.toString();
    }
}