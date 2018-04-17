package com.pay.aphrodite.portal.hql.visitor.impl;

import com.pay.aphrodite.portal.hql.compoment.SqlFromItem;
import com.pay.aphrodite.portal.hql.compoment.SqlSelect;
import com.pay.aphrodite.portal.hql.compoment.SqlSelectItem;
import com.pay.aphrodite.portal.hql.compoment.SqlWhereItem;
import com.pay.aphrodite.portal.hql.visitor.SqlVisitor;

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
    @Override
    public String visit(SqlSelectItem sqlSelectItem) {
        return null;
    }

    @Override
    public String visit(SqlFromItem SqlFromItem) {
        return null;
    }

    @Override
    public String visit(SqlWhereItem sqlWhereItem) {
        return null;
    }

    @Override
    public String visit(SqlSelect sqlSelect) {
        String selectSql = sqlSelect.getSelectItemList().stream().map(select -> {
            return select.accept(this);
        }).reduce("SELECT ", (x, y) -> {
            return new StringJoiner(x).add(y).toString();
        });

        Stream<String> froms = sqlSelect.getFromItemList().stream().map(from -> {
            return from.accept(this);
        });


        Stream<String> wheres = sqlSelect.getWhereItemList().stream().map(where -> {
            return where.accept(this);
        });

        return selectSql;
    }
}
