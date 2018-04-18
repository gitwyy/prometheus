import com.pay.aphrodite.portal.hql.Condition;
import com.pay.aphrodite.portal.hql.compoment.*;
import com.pay.aphrodite.portal.hql.visitor.SqlVisitor;
import com.pay.aphrodite.portal.hql.visitor.impl.SqlVisitorImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName:TestMySelectProcessor
 * @Author: yangyang.wang
 * @Date: 2018-04-16 19:47
 * @Version: 1.0
 * @Description: 测试MySelectProcessor
 **/
public class TestMySelectProcessor {

    @Test
    public void testMySelectProcessor() {
        SqlSelect sqlSelect = new SqlSelect();


        List<SqlSelectItem> selectItem = new ArrayList<SqlSelectItem>();

        selectItem.add(new SqlSelectItem().setOwner("own_a").setColumnName("col_a").setAlias("alias_a").setSqlObjectType(SqlObjectType.COLUMN_EXPR));
        selectItem.add(new SqlSelectItem().setOwner("own_b").setColumnName("col_b").setAlias("alias_b").setSqlObjectType(SqlObjectType.COLUMN_EXPR));


        SqlSelect subSelecct = new SqlSelect();
        List<SqlSelectItem> subSelectItem = new ArrayList<SqlSelectItem>();
        subSelectItem.add(new SqlSelectItem().setOwner("own_a_2").setColumnName("col_a_2").setAlias("alias_a_2").setSqlObjectType(SqlObjectType.COLUMN_EXPR));
        subSelectItem.add(new SqlSelectItem().setOwner("own_b_2").setColumnName("col_b_2").setAlias("alias_b_2").setSqlObjectType(SqlObjectType.COLUMN_EXPR));
        subSelecct.setSelectItemList(subSelectItem);

        //selectItem.add(new SqlSelectItem().setColumnAlias("alias_c").setSqlObjectType(SqlObjectType.SELECT).setSqlObject(subSelecct));
        // 构建 from 语句块


        List<SqlFromItem> fromItems = new ArrayList<>();

        fromItems.add(new SqlFromItem().setSqlObjectType(SqlObjectType.EXPR_TABLE_SOURCE).setTableName("table_a").setAlias("tab_alias_a").setJoinType(KeyConstant.LEFT_JOIN));
        fromItems.add(new SqlFromItem().setSqlObjectType(SqlObjectType.EXPR_TABLE_SOURCE).setTableName("table_b").setAlias("tab_alias_b").setFromCondition(new Condition()));

        // 构建 where 语句块

        List<SqlWhereItem> whereItems = new ArrayList<>();

        whereItems.add(new SqlWhereItem().setSqlObjectType(SqlObjectType.WHERE_EXPR).setOwner("tab_alias_a").setWhereCondition(new Condition().setSqlExpr("a=b")));
        whereItems.add(new SqlWhereItem().setSqlObjectType(SqlObjectType.WHERE_EXPR).setOwner("tab_alias_b").setWhereCondition(new Condition().setSqlExpr("c=d")));

        sqlSelect.setSelectItemList(selectItem).setFromItemList(fromItems).setWhereItemList(whereItems);

        SqlVisitor visitor = new SqlVisitorImpl();

        String accept = sqlSelect.accept(visitor);

        System.out.println(accept);


    }


    @Test
    public void testSqlSelect() {
        System.out.println(String.format("[%s]", new SqlFromItem()));
    }

    @Test
    public void testReduceDemo() {


        List<Integer> list2 = Arrays.asList(2, 3, 4);
        //Here result will be 2*2*3 + 2*4 that is 18.
        int res = list2.parallelStream().reduce(2, (s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
            System.out.println("----------------------");
            return s1 * s2;
        }, (p, q) -> {
            System.out.println(p);
            System.out.println(q);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
            return p * q;
        });
        // Here result will be 2*2 * 2*3 * 2*4 is 192
        int res2 = list2.stream().reduce(2, (s1, s2) -> s1 * s2, (p, q) -> p * q);

        int res3 = list2.stream().reduce((s1, s2) -> s1 * s2).get();
        System.out.println(res);
        System.out.println("res2 >>>>>>" +res2);
        System.out.println("res3 >>>>>>" +res3);

        List<String> list1 = Arrays.asList("Mohan", "Sohan", "Ramesh");
        // Here result whill be (-+Mohan) + :: +(-+Sohna) + :: +(-+Ramesh)
        String result = list1.stream().reduce("-",
                (s1, s2) -> {
                    System.out.println(s1);
                    System.out.println(s2);
                    System.out.println("-----------------");
                    return s1 + s2;
                }, (p, q) -> {
                    System.out.println(p);
                    System.out.println(q);
                    System.out.println("====================");
                    return p + "::" + q;
                });

        System.out.println(result);

        //Here result = ??.append Mohan append Sohna append Ramesh
        StringBuilder sb = new StringBuilder("??");
        StringBuilder reduce = list1.stream().reduce(sb, (x, y) -> {
            System.out.print("sb" + sb.hashCode());
            System.out.println(sb.toString());
            System.out.print("x" + x.hashCode());
            System.out.println(x.toString());
            System.out.println("y" + y.hashCode());
            return x.append(y);
        }, (p, q) -> {
            System.out.println("<<<<<<<<<<<<<<<" + sb.hashCode());
            return p.append("<<<<<<<<<<<");
        });

        System.out.println(" >>>>>>>>>>>>" + reduce.toString());
    }

}
