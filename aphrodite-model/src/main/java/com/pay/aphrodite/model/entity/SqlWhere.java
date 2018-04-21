package com.pay.aphrodite.model.entity;

import java.util.Date;

public class SqlWhere extends BaseEntity<SqlWhere>{

    private Date updateTime;

    private String sqlObjectType;

    private Integer selectId;

    private String leftOwner;

    private String leftElement;

    private String rightOwner;

    private String rightElement;

    private String symbol;

    public Date getUpdateTime() {
        return updateTime;
    }

    public SqlWhere setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getSqlObjectType() {
        return sqlObjectType;
    }

    public SqlWhere setSqlObjectType(String sqlObjectType) {
        this.sqlObjectType = sqlObjectType;
        return this;
    }

    public Integer getSelectId() {
        return selectId;
    }

    public SqlWhere setSelectId(Integer selectId) {
        this.selectId = selectId;
        return this;
    }

    public String getLeftOwner() {
        return leftOwner;
    }

    public SqlWhere setLeftOwner(String leftOwner) {
        this.leftOwner = leftOwner;
        return this;
    }

    public String getLeftElement() {
        return leftElement;
    }

    public SqlWhere setLeftElement(String leftElement) {
        this.leftElement = leftElement;
        return this;
    }

    public String getRightOwner() {
        return rightOwner;
    }

    public SqlWhere setRightOwner(String rightOwner) {
        this.rightOwner = rightOwner;
        return this;
    }

    public String getRightElement() {
        return rightElement;
    }

    public SqlWhere setRightElement(String rightElement) {
        this.rightElement = rightElement;
        return this;
    }

    public String getSymbol() {
        return symbol;
    }

    public SqlWhere setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SqlWhere{");
        sb.append("updateTime=").append(updateTime);
        sb.append(", sqlObjectType='").append(sqlObjectType).append('\'');
        sb.append(", selectId=").append(selectId);
        sb.append(", leftOwner='").append(leftOwner).append('\'');
        sb.append(", leftElement='").append(leftElement).append('\'');
        sb.append(", rightOwner='").append(rightOwner).append('\'');
        sb.append(", rightElement='").append(rightElement).append('\'');
        sb.append(", symbol='").append(symbol).append('\'');
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", optimistic='").append(optimistic).append('\'');
        sb.append(", remark='").append(remark).append('\'');
        sb.append(", operator='").append(operator).append('\'');
        sb.append('}');
        return sb.toString();
    }
}