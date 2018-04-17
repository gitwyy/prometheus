package com.pay.aphrodite.portal.hql.visitor.impl;

import com.pay.aphrodite.portal.hql.compoment.*;
import com.pay.aphrodite.portal.hql.visitor.SqlVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.StringJoiner;
import java.util.stream.Stream;

/**
 * @ClassName:SqlVisitorImpl
 * @Author: yangyang.wang
 * @Date: 2018-04-17 15:31
 * @Version: 1.0
 * @Description: sql 访问者
 **/
public class SqlVisitorImpl implements SqlVisitor {
    private Logger log = LoggerFactory.getLogger(SqlVisitorImpl.class);
    @Override
    public String visit(final SqlSelectItem sqlSelectItem) {
        log.debug("visit SqlSelectItem [{}]",sqlSelectItem);
        StringBuilder sb = new StringBuilder();
        switch (sqlSelectItem.getSqlObjectType()){
            case EXPR:
                log.debug("visit SqlSelectItem case [{}]",SqlObjectType.EXPR);
                sb.append(sqlSelectItem.getOwner()).append(".").append(sqlSelectItem.getColumnName())
                        .append(" as ").append(sqlSelectItem.getColumnAlias());
                log.debug("visit SqlSelectItem case [{}] result [{}]",SqlObjectType.EXPR,sb.toString());
                break;
            case SELECT:
                log.debug("visit SqlSelectItem case [{}]",SqlObjectType.SELECT);
                sb.append("(").append(sqlSelectItem.getSqlObject().accept(this)).append(")")
                        .append(" as ").append(sqlSelectItem.getColumnAlias());
                log.debug("visit SqlSelectItem case [{}] result [{}]",SqlObjectType.SELECT,sb.toString());
                break;
            default:
                log.debug("visit SqlSelectItem case DEFAULT  no case matched !");
                break;
        }
        return sb.toString();
    }

    @Override
    public String visit(SqlFromItem sqlFromItem) {
        log.debug("visit SqlFromItem [{}]",sqlFromItem);
        StringBuilder sb = new StringBuilder();
        switch (sqlFromItem.getSqlObjectType()){
            case TABLE_SOURCE_EXPR:
                log.debug("visit SqlFromItem case [{}]",SqlObjectType.EXPR);
                sb.append(sqlFromItem.getTableName()).append(" as ").append(sqlFromItem.getTableAlias());
                log.debug("visit SqlFromItem case [{}] result [{}]",SqlObjectType.EXPR,sb.toString());
                break;
            case SELECT:
                log.debug("visit SqlFromItem case [{}]",SqlObjectType.SELECT);
                sb.append("(").append(sqlFromItem.getSqlObject().accept(this)).append(")")
                        .append(" as ").append(sqlFromItem.getTableAlias());
                log.debug("visit SqlFromItem case [{}] result [{}]",SqlObjectType.SELECT,sb.toString());
                break;
            default:
                log.debug("visit SqlSelectItem case DEFAULT  no case matched !");
                break;
        }
        return sb.toString();
    }

    @Override
    public String visit(SqlWhereItem sqlWhereItem) {
        return null;
    }

    @Override
    public String visit(SqlSelect sqlSelect) {

        String selectSql = sqlSelect.getSelectItemList().stream().map(select -> {
            return select.accept(this);
        }).reduce((x, y) -> {
            StringJoiner sj = new StringJoiner(", ");
            return sj.add(x).add(y).toString();
        }).get();

        sqlSelect.getFromItemList().stream().map(from -> {
            return from.accept(this);
        }).reduce((x,y) ->{
            StringJoiner sj = new StringJoiner(" ");
            return sj.add(x).add(y).toString();
        });


        Stream<String> wheres = sqlSelect.getWhereItemList().stream().sorted((x,y) ->{return 1;}).map(where -> {
            return where.accept(this);
        });

        return selectSql;
    }
}
