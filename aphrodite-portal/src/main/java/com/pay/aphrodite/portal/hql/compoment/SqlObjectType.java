package com.pay.aphrodite.portal.hql.compoment;

/**
 * @ClassName:SqlObjectType
 * @Author: yangyang.wang
 * @Date: 2018-04-17 17:21
 * @Version: 1.0
 * @Description: sql object type 常量类
 **/
public enum  SqlObjectType {


    COLUMN_EXPR("COLUMN_EXPR","查询字段元素"),
    SUBQUERY("SUBQUERY","子查询类型"),EXPR_TABLE_SOURCE("EXPR_TABLE_SOURCE","表元素"),
    JOIN_TABLE_SOURCE("JOIN_TABLE_SOURCE","关联查询表元素"),CONDITON_EXPR("CONDITON_EXPR","约束表达式"),
    WHERE_EXPR("WHERE_EXPR","WHERE条件元素"),BINARY_CONDITION("BINARY_CONDITION","二元约束条件");
    /* @Comment: sql 类型 */
    private String type;

    /* @Comment:  sql 对象描述 */
    private String description;

    private SqlObjectType(String type,String description){
        this.type = type;
        this.description = description;
    }


}
