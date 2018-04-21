package com.pay.aphrodite.model.entity;

public class HqlTaskLog extends BaseEntity<HqlTaskLog>{

    private String lfsPath;

    private String taskStep;

    private String taskNo;


    public String getLfsPath() {
        return lfsPath;
    }

    public HqlTaskLog setLfsPath(String lfsPath) {
        this.lfsPath = lfsPath;
        return this;
    }

    public String getTaskStep() {
        return taskStep;
    }

    public HqlTaskLog setTaskStep(String taskStep) {
        this.taskStep = taskStep;
        return this;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public HqlTaskLog setTaskNo(String taskNo) {
        this.taskNo = taskNo;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HqlTaskLog{");
        sb.append("lfsPath='").append(lfsPath).append('\'');
        sb.append(", taskStep='").append(taskStep).append('\'');
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