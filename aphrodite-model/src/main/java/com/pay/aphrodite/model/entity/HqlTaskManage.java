package com.pay.aphrodite.model.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

public class HqlTaskManage extends BaseEntity<HqlTaskManage>{

    private String lfsPath;

    private String taskStatus;

    private String taskNo;

    private Integer downLoadCount;

    private Date completeTime;

    public String getLfsPath() {
        return lfsPath;
    }

    public HqlTaskManage setLfsPath(String lfsPath) {
        this.lfsPath = lfsPath;
        return this;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public HqlTaskManage setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
        return this;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public HqlTaskManage setTaskNo(String taskNo) {
        this.taskNo = taskNo;
        return this;
    }

    public Integer getDownLoadCount() {
        return downLoadCount;
    }

    public HqlTaskManage setDownLoadCount(Integer downLoadCount) {
        this.downLoadCount = downLoadCount;
        return this;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public HqlTaskManage setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HqlTaskManage{");
        sb.append("lfsPath='").append(lfsPath).append('\'');
        sb.append(", taskStatus='").append(taskStatus).append('\'');
        sb.append(", taskNo='").append(taskNo).append('\'');
        sb.append(", downLoadCount=").append(downLoadCount);
        sb.append(", completeTime=").append(completeTime);
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", optimistic='").append(optimistic).append('\'');
        sb.append(", remark='").append(remark).append('\'');
        sb.append(", operator='").append(operator).append('\'');
        sb.append('}');
        return sb.toString();
    }
}