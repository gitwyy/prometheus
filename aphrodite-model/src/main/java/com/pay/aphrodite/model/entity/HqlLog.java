package com.pay.aphrodite.model.entity;

public class HqlLog extends BaseEntity<HqlLog>{

    private String logArgs;

    private String logMethod;

    public HqlLog() {
        super();
    }

    public String getLogArgs() {
        return logArgs;
    }

    public HqlLog setLogArgs(String logArgs) {
        this.logArgs = logArgs;
        return this;
    }

    public String getLogMethod() {
        return logMethod;
    }

    public HqlLog setLogMethod(String logMethod) {
        this.logMethod = logMethod;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HqlLog{");
        sb.append("logArgs='").append(logArgs).append('\'');
        sb.append(", logMethod='").append(logMethod).append('\'');
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", optimistic='").append(optimistic).append('\'');
        sb.append(", remark='").append(remark).append('\'');
        sb.append(", operator='").append(operator).append('\'');
        sb.append('}');
        return sb.toString();
    }
}