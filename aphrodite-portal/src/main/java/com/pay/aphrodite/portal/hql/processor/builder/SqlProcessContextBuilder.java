package com.pay.aphrodite.portal.hql.processor.builder;

import com.pay.aphrodite.portal.hql.processor.SqlProcessContext;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName:SqlProcessContextBuilder
 * @Author: yangyang.wang
 * @Date: 2018-04-16 19:56
 * @Version: 1.0
 * @Description: Sql ProcessContext 构建者
 **/
public class SqlProcessContextBuilder {

    public static SqlProcessContext builder(){
        SqlSelect select = new SqlSelect();
        SqlSelectItem selectItem = new SqlSelectItem();
        selectItem.setOwner("a").setColumnName("01").setColumnAlias("aaa");
        select.setSqlSelectItems(Stream.of(selectItem).collect(Collectors.toList()));
        SqlProcessContext context = new SqlProcessContext(select);
        return context;
    }
}
