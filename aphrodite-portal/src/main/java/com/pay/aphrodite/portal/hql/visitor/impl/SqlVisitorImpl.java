package com.pay.aphrodite.portal.hql.visitor.impl;

import com.pay.aphrodite.portal.hql.Condition;
import com.pay.aphrodite.portal.hql.SqlObject;
import com.pay.aphrodite.portal.hql.compoment.*;
import com.pay.aphrodite.portal.hql.exception.SqlFromItemException;
import com.pay.aphrodite.portal.hql.exception.SqlSelectItemException;
import com.pay.aphrodite.portal.hql.exception.SqlWhereItemException;
import com.pay.aphrodite.portal.hql.visitor.SqlVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.StringJoiner;

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
        log.debug("visit SqlSelectItem [{}]", sqlSelectItem);
        StringBuilder sb = new StringBuilder();
        switch (sqlSelectItem.getSqlObjectType()) {
            case COLUMN_EXPR:
                log.debug("visit SqlSelectItem case [{}]", SqlObjectType.COLUMN_EXPR);
                sb.append(sqlSelectItem.getOwner()).append(".").append(sqlSelectItem.getColumnName())
                        .append(" as ").append(sqlSelectItem.getAlias());
                log.debug("visit SqlSelectItem case [{}] result [{}]", SqlObjectType.COLUMN_EXPR, sb.toString());
                break;
            case SUBQUERY:
                log.debug("visit SqlSelectItem case [{}]", SqlObjectType.SUBQUERY);
                sb.append("(").append(sqlSelectItem.getSqlObject().accept(this)).append(")")
                        .append(" as ").append(sqlSelectItem.getAlias());
                log.debug("visit SqlSelectItem case [{}] result [{}]", SqlObjectType.SUBQUERY, sb.toString());
                break;
            default:
                sb.append(sqlSelectItem.getSqlExpr());
                log.debug("visit SqlSelectItem case DEFAULT  no case matched !");
                break;
        }
        return sb.toString();
    }

    @Override
    public String visit(SqlFromItem sqlFromItem) {
        log.debug("visit SqlFromItem [{}]", sqlFromItem);
        StringJoiner sj = new StringJoiner(" ");

        switch (sqlFromItem.getSqlObjectType()) {
            case EXPR_TABLE_SOURCE:
                log.debug("visit SqlFromItem case [{}]", SqlObjectType.EXPR_TABLE_SOURCE);
                sj.add(sqlFromItem.getTableName()).add("as").add(sqlFromItem.getAlias());
                sj = sqlFromItem.getJoinType() == null? sj :sj.add(sqlFromItem.getJoinType());
                log.debug("visit SqlFromItem case [{}] result [{}]", SqlObjectType.EXPR_TABLE_SOURCE, sj.toString());
                break;
            case JOIN_TABLE_SOURCE:
                log.debug("visit SqlFromItem case [{}]", SqlObjectType.JOIN_TABLE_SOURCE);
                sj.add(sqlFromItem.getTableName()).add("as").add(sqlFromItem.getAlias()).add(KeyConstant.ON)
                        .add(sqlFromItem.getFromCondition().accept(this));
                sj = sqlFromItem.getJoinType() == null? sj :sj.add(sqlFromItem.getJoinType());
                log.debug("visit SqlFromItem case [{}] result [{}]", SqlObjectType.JOIN_TABLE_SOURCE, sj.toString());
                break;
            case SUBQUERY:
                log.debug("visit SqlFromItem case [{}]", SqlObjectType.SUBQUERY);
                sj.add("(").add(sqlFromItem.getSqlObject().accept(this)).add(")")
                        .add("as").add(sqlFromItem.getAlias())
                        .add(sqlFromItem.getFromCondition().accept(this));
                sj = sqlFromItem.getJoinType() == null? sj :sj.add(sqlFromItem.getJoinType());
                log.debug("visit SqlFromItem case [{}] result [{}]", SqlObjectType.SUBQUERY, sj.toString());
                break;
            default:
                sj.add(sqlFromItem.getSqlExpr());
                log.debug("visit SqlSelectItem case DEFAULT  no case matched !");
                break;
        }

        return sj.toString();
    }

    @Override
    public String visit(SqlWhereItem sqlWhereItem) {
        log.debug("visit SqlFromItem [{}]", sqlWhereItem);
        StringBuilder sb = new StringBuilder();

        switch (sqlWhereItem.getSqlObjectType()) {
            case WHERE_EXPR:
                log.debug("visit SqlWhereItem case [{}]", SqlObjectType.WHERE_EXPR);
                sb.append(sqlWhereItem.getWhereCondition().accept(this));
                log.debug("visit SqlWhereItem case [{}] result [{}]", SqlObjectType.WHERE_EXPR, sb.toString());
                break;
            case SUBQUERY:
                log.debug("visit SqlWhereItem case [{}]", SqlObjectType.SUBQUERY);
                sb.append("(").append(sqlWhereItem.getSqlObject().accept(this)).append(")");
                log.debug("visit SqlWhereItem case [{}] result [{}]", SqlObjectType.SUBQUERY, sb.toString());
                break;
            default:
                sb.append(sqlWhereItem.getSqlExpr());
                log.debug("visit SqlSelectItem case DEFAULT  no case matched !");
                break;
        }

        return sb.toString();
    }

    @Override
    public String visit(SqlSelect sqlSelect) {
        StringJoiner sql = new StringJoiner(" ");
        String selectSql = sqlSelect.getSelectItemList()
                .orElseThrow(() -> new SqlSelectItemException(String.format("[%s].getSelectItemList() is null", sqlSelect)))
                .stream().map(select -> select.accept(this))
                .reduce((x, y) -> {
                    StringJoiner sj = new StringJoiner(", ");
                    return sj.add(x).add(y).toString();
                }).get();
        System.out.println(selectSql);

        String fromSql = sqlSelect.getFromItemList()
                .orElseThrow(() -> new SqlFromItemException(String.format("[%s].getFromItemList() is null", sqlSelect)))
                .stream().map(from -> from.accept(this))
                .reduce(new StringJoiner(" "),(x, y) -> x.add(y),(p, q) -> p.add(q.toString())).toString();
        System.out.println(fromSql);


        String whereSql = sqlSelect.getWhereItemList().
                orElseThrow(() -> new SqlWhereItemException(String.format("[%s].getWhereItemList() is null", sqlSelect)))
                .stream().map(where -> where.accept(this))
                .reduce(new StringJoiner(" AND "),(x, y) -> x.add(y),(p, q)->p.add(q.toString())).toString();
        System.out.println(whereSql);

        return sql.add(KeyConstant.SELECT).add(selectSql).add(KeyConstant.FROM).add(fromSql).add(KeyConstant.WHERE).add(whereSql).toString();
    }


    @Override
    public String visit(Condition condition) {
        StringBuilder sb = new StringBuilder();
        switch (condition.getSqlObjectType()){
            case BINARY_CONDITION:
                sb.append(condition.getLeft().getOwner()).append(".")
                        .append(condition.getLeft().getElement())
                        .append(condition.getSymbol())
                        .append(condition.getRight().getOwner()).append(".")
                        .append(condition.getElement());
                break;
            case CONDITON_EXPR:
                sb.append(condition.getSqlExpr());
                break;
        }

        return sb.toString();
    }

    @Override
    public String visit(SqlObject sqlObject){
        return sqlObject.getSqlExpr();
    }
}
