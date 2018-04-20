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

    private String taskName;

    private String taskType;

    private String remark;

    private String taskNo;

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

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo == null ? null : taskNo.trim();
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
        sb.append(", taskName=").append(taskName);
        sb.append(", taskType=").append(taskType);
        sb.append(", remark=").append(remark);
        sb.append(", taskNo=").append(taskNo);
        sb.append("]");
        return sb.toString();
    }
}