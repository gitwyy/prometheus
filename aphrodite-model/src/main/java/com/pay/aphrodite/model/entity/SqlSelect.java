package com.pay.aphrodite.model.entity;

import java.util.Date;

public class SqlSelect extends BaseEntity<SqlSelect>{
    private Date updateTime;

    private String sqlExpress;

    public Date getUpdateTime() {
        return updateTime;
    }

    public SqlSelect setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getSqlExpress() {
        return sqlExpress;
    }

    public SqlSelect setSqlExpress(String sqlExpress) {
        this.sqlExpress = sqlExpress;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SqlSelect{");
        sb.append("updateTime=").append(updateTime);
        sb.append(", sqlExpress='").append(sqlExpress).append('\'');
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", optimistic='").append(optimistic).append('\'');
        sb.append(", remark='").append(remark).append('\'');
        sb.append(", operator='").append(operator).append('\'');
        sb.append('}');
        return sb.toString();
    }
}