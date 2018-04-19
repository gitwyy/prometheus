package com.pay.aphrodite.model.entity;

import java.util.Date;

public class SqlSelect {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer optimistic;

    private String operator;

    private String sqlExpress;

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

    public String getSqlExpress() {
        return sqlExpress;
    }

    public void setSqlExpress(String sqlExpress) {
        this.sqlExpress = sqlExpress == null ? null : sqlExpress.trim();
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
        sb.append(", sqlExpress=").append(sqlExpress);
        sb.append("]");
        return sb.toString();
    }
}