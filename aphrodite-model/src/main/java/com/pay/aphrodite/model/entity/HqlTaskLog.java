package com.pay.aphrodite.model.entity;

import java.util.Date;

public class HqlTaskLog {
    private Integer id;

    private Date createTime;

    private Integer optimistic;

    private String operator;

    private String lfsPath;

    private String taskStatus;

    private String remark;

    private Integer step;

    private String taskNo;

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

    public String getLfsPath() {
        return lfsPath;
    }

    public void setLfsPath(String lfsPath) {
        this.lfsPath = lfsPath == null ? null : lfsPath.trim();
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus == null ? null : taskStatus.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
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
        sb.append(", createTime=").append(createTime);
        sb.append(", optimistic=").append(optimistic);
        sb.append(", operator=").append(operator);
        sb.append(", lfsPath=").append(lfsPath);
        sb.append(", taskStatus=").append(taskStatus);
        sb.append(", remark=").append(remark);
        sb.append(", step=").append(step);
        sb.append(", taskNo=").append(taskNo);
        sb.append("]");
        return sb.toString();
    }
}