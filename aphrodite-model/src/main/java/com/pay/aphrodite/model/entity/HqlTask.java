package com.pay.aphrodite.model.entity;

import java.util.Date;

public class HqlTask {
    private Integer id;

    private Integer optimistic;

    private Date createTime;

    private Date updateTime;

    private String hqlParam;

    private String finalHql;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOptimistic() {
        return optimistic;
    }

    public void setOptimistic(Integer optimistic) {
        this.optimistic = optimistic;
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

    public String getHqlParam() {
        return hqlParam;
    }

    public void setHqlParam(String hqlParam) {
        this.hqlParam = hqlParam == null ? null : hqlParam.trim();
    }

    public String getFinalHql() {
        return finalHql;
    }

    public void setFinalHql(String finalHql) {
        this.finalHql = finalHql == null ? null : finalHql.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", optimistic=").append(optimistic);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", hqlParam=").append(hqlParam);
        sb.append(", finalHql=").append(finalHql);
        sb.append(", operator=").append(operator);
        sb.append("]");
        return sb.toString();
    }
}