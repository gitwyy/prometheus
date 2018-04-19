package com.pay.aphrodite.model.entity;

import java.util.Date;

public class SqlWhere {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer optimistic;

    private String sqlObjectType;

    private Integer selectId;

    private String leftOwner;

    private String leftElement;

    private String rightOwner;

    private String rightElement;

    private String symbol;

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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getOptimistic() {
        return optimistic;
    }

    public void setOptimistic(Integer optimistic) {
        this.optimistic = optimistic;
    }

    public String getSqlObjectType() {
        return sqlObjectType;
    }

    public void setSqlObjectType(String sqlObjectType) {
        this.sqlObjectType = sqlObjectType == null ? null : sqlObjectType.trim();
    }

    public Integer getSelectId() {
        return selectId;
    }

    public void setSelectId(Integer selectId) {
        this.selectId = selectId;
    }

    public String getLeftOwner() {
        return leftOwner;
    }

    public void setLeftOwner(String leftOwner) {
        this.leftOwner = leftOwner == null ? null : leftOwner.trim();
    }

    public String getLeftElement() {
        return leftElement;
    }

    public void setLeftElement(String leftElement) {
        this.leftElement = leftElement == null ? null : leftElement.trim();
    }

    public String getRightOwner() {
        return rightOwner;
    }

    public void setRightOwner(String rightOwner) {
        this.rightOwner = rightOwner == null ? null : rightOwner.trim();
    }

    public String getRightElement() {
        return rightElement;
    }

    public void setRightElement(String rightElement) {
        this.rightElement = rightElement == null ? null : rightElement.trim();
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol == null ? null : symbol.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", optimistic=").append(optimistic);
        sb.append(", sqlObjectType=").append(sqlObjectType);
        sb.append(", selectId=").append(selectId);
        sb.append(", leftOwner=").append(leftOwner);
        sb.append(", leftElement=").append(leftElement);
        sb.append(", rightOwner=").append(rightOwner);
        sb.append(", rightElement=").append(rightElement);
        sb.append(", symbol=").append(symbol);
        sb.append("]");
        return sb.toString();
    }
}