package com.pay.aphrodite.portal.hql.compoment;

import com.pay.aphrodite.portal.hql.visitor.SqlVisitor;

import java.util.List;

/**
 * @ClassName:Select
 * @Author: yangyang.wang
 * @Date: 2018-04-10 13:47
 * @Version: 1.0
 * @Description:
 **/
public class SqlSelect extends SqlObject{

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


    public List<SqlSelectItem> getSelectItemList() {
        return selectItemList;
    }

    public SqlSelect setSelectItemList(List<SqlSelectItem> selectItemList) {
        this.selectItemList = selectItemList;
        return this;
    }

    public List<SqlFromItem> getFromItemList() {
        return fromItemList;
    }

    public SqlSelect setFromItemList(List<SqlFromItem> fromItemList) {
        this.fromItemList = fromItemList;
        return this;
    }

    public List<SqlWhereItem> getWhereItemList() {
        return whereItemList;
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
