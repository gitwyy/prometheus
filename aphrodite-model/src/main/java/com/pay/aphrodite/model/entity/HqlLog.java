package com.pay.aphrodite.model.entity;

import java.util.Date;

public class HqlLog {
    private Integer id;

    private Date createTime;

    private Integer optimistic;

    private String logArgs;

    private String operator;

    private String remark;

    private String logMethod;

    public HqlLog() {
    }

    public HqlLog(String logArgs, String operator, String remark,String logMethod) {
        this.logArgs = logArgs;
        this.operator = operator;
        this.remark = remark;
        this.logMethod = logMethod;
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

    public String getLogArgs() {
        return logArgs;
    }

    public void setLogArgs(String logArgs) {
        this.logArgs = logArgs;
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

    public String getLogMethod() {
        return logMethod;
    }

    public void setLogMethod(String logMethod) {
        this.logMethod = logMethod;
    }

    @Override
    public String toString() {
        return "HqlLog{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", optimistic=" + optimistic +
                ", logArgs='" + logArgs + '\'' +
                ", operator='" + operator + '\'' +
                ", remark='" + remark + '\'' +
                ", logMethod='" + logMethod + '\'' +
                '}';
    }
}