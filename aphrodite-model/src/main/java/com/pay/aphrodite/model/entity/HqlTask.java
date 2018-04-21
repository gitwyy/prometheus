package com.pay.aphrodite.model.entity;

import java.util.Date;

public class HqlTask extends BaseEntity<HqlTask>{

    private Date updateTime;

    private String hqlParam;

    private String finalHql;

    private String taskName;

    private String taskType;

    private String taskNo;


    public Date getUpdateTime() {
        return updateTime;
    }

    public HqlTask setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getHqlParam() {
        return hqlParam;
    }

    public HqlTask setHqlParam(String hqlParam) {
        this.hqlParam = hqlParam;
        return this;
    }

    public String getFinalHql() {
        return finalHql;
    }

    public HqlTask setFinalHql(String finalHql) {
        this.finalHql = finalHql;
        return this;
    }

    public String getTaskName() {
        return taskName;
    }

    public HqlTask setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    public String getTaskType() {
        return taskType;
    }

    public HqlTask setTaskType(String taskType) {
        this.taskType = taskType;
        return this;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public HqlTask setTaskNo(String taskNo) {
        this.taskNo = taskNo;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HqlTask{");
        sb.append("updateTime=").append(updateTime);
        sb.append(", hqlParam='").append(hqlParam).append('\'');
        sb.append(", finalHql='").append(finalHql).append('\'');
        sb.append(", taskName='").append(taskName).append('\'');
        sb.append(", taskType='").append(taskType).append('\'');
        sb.append(", taskNo='").append(taskNo).append('\'');
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", optimistic='").append(optimistic).append('\'');
        sb.append(", remark='").append(remark).append('\'');
        sb.append(", operator='").append(operator).append('\'');
        sb.append('}');
        return sb.toString();
    }
}