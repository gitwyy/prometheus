package com.pay.aphrodite.model.entity;

import java.util.Date;

public class HqlLog {
    private Integer id;

    private Date createTime;

    private Integer optimistic;

    private String logContent;

    private String operator;

    private String remark;

    public HqlLog() {
    }

    public HqlLog(String logContent, String operator, String remark) {
        this.logContent = logContent;
        this.operator = operator;
        this.remark = remark;
    }

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

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "HqlLog{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", optimistic=" + optimistic +
                ", logContent='" + logContent + '\'' +
                ", operator='" + operator + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}