package com.pay.aphrodite.model.entity;

import java.util.Date;
import java.util.Objects;

/**
 * @ClassName:BaseEntity
 * @Author: yangyang.wang
 * @Date: 2018-04-21 15:11
 * @Version: 1.0
 * @Description: 基础实体类
 **/
public class BaseEntity <T>{
    protected Long id;

    protected Date createTime;

    protected String optimistic;

    protected String remark;

    protected String operator;

    public BaseEntity() {
        super();
    }

    public Long getId() {
        return id;
    }

    public T setId(Long id) {
        this.id = id;
        return (T) this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public T setCreateTime(Date createTime) {
        this.createTime = createTime;
        return (T) this;
    }

    public String getOptimistic() {
        return optimistic;
    }

    public T setOptimistic(String optimistic) {
        this.optimistic = optimistic;
        return (T) this;
    }

    public String getRemark() {
        return remark;
    }

    public T setRemark(String remark) {
        this.remark = remark;
        return (T) this;
    }

    public String getOperator() {
        return operator;
    }

    public T setOperator(String operator) {
        this.operator = operator;
        return (T) this;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", optimistic='" + optimistic + '\'' +
                ", remark='" + remark + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;
        BaseEntity<?> that = (BaseEntity<?>) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(optimistic, that.optimistic) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(operator, that.operator);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, createTime, optimistic, remark, operator);
    }
}