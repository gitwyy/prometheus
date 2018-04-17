package com.pay.aphrodite.portal.hql.processor;

/**
 * @ClassName:SqlProcessContext
 * @Author: yangyang.wang
 * @Date: 2018-04-09 19:36
 * @Version: 1.0
 * @Description: SQL 解析处理上下文。
 **/
public class SqlProcessContext {

    /* @Comment: sqlSelect 根元素  */
    private SqlSelect sqlSelect ;

    /* @Comment:  sql 解析器*/
    private SqlProcessor sqlProcessor;

    private StringBuilder sqlString;

    public SqlProcessContext(SqlSelect sqlSelect) {
        this(sqlSelect,new StringBuilder());
    }

    public SqlProcessContext(SqlSelect sqlSelect, StringBuilder sqlString) {
        super();
        this.sqlSelect = sqlSelect;
        this.sqlString = sqlString;
    }

    public SqlSelect getSqlSelect() {
        return sqlSelect;
    }

    public void setSqlSelect(SqlSelect sqlSelect) {
        this.sqlSelect = sqlSelect;
    }

    public StringBuilder getSqlString() {
        return sqlString;
    }

    public void setSqlString(StringBuilder sqlString) {
        this.sqlString = sqlString;
    }


    public SqlProcessor getSqlProcessor() {
        return sqlProcessor;
    }

    public void setSqlProcessor(SqlProcessor sqlProcessor) {
        this.sqlProcessor = sqlProcessor;
    }
}