package com.pay.aphrodite.portal.hql.compoment;

import com.pay.aphrodite.portal.hql.SqlObject;
import com.pay.aphrodite.portal.hql.visitor.SqlVisitor;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName:Select
 * @Author: yangyang.wang
 * @Date: 2018-04-10 13:47
 * @Version: 1.0
 * @Description:
 **/
public class SqlSelect extends SqlObject {

    private List<SqlSelectItem> selectItemList;

    private List<SqlFromItem> fromItemList;

    private List<SqlWhereItem> whereItemList;


    public SqlSelect() {
        super();
    }

    public SqlSelect(List<SqlSelectItem> selectItemList, List<SqlFromItem> fromItemList, List<SqlWhereItem> whereItemList) {
        super();
        this.selectItemList = selectItemList;
        this.fromItemList = fromItemList;
        this.whereItemList = whereItemList;
    }

    @Override
    public String accept(SqlVisitor sqlVisitor) {
        return sqlVisitor.visit(this);
    }


    public Optional<List<SqlSelectItem>> getSelectItemList() {
        return Optional.ofNullable(selectItemList);
    }

    public SqlSelect setSelectItemList(List<SqlSelectItem> selectItemList) {
        this.selectItemList = selectItemList;
        return this;
    }

    public Optional<List<SqlFromItem>> getFromItemList() {
        return Optional.ofNullable(fromItemList);
    }

    public SqlSelect setFromItemList(List<SqlFromItem> fromItemList) {
        this.fromItemList = fromItemList;
        return this;
    }

    public Optional<List<SqlWhereItem>> getWhereItemList() {
        return Optional.ofNullable(whereItemList);
    }

    public SqlSelect setWhereItemList(List<SqlWhereItem> whereItemList) {
        this.whereItemList = whereItemList;
        return this;
    }

    @Override
    public String toString() {
        return "SqlSelect{" +
                "selectItemList=" + selectItemList +
                ", fromItemList=" + fromItemList +
                ", whereItemList=" + whereItemList +
                '}';
    }
}
