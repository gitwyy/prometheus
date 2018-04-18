package com.pay.aphrodite.portal.hql.visitor;

import com.pay.aphrodite.portal.hql.Condition;
import com.pay.aphrodite.portal.hql.SqlObject;
import com.pay.aphrodite.portal.hql.compoment.SqlFromItem;
import com.pay.aphrodite.portal.hql.compoment.SqlSelect;
import com.pay.aphrodite.portal.hql.compoment.SqlSelectItem;
import com.pay.aphrodite.portal.hql.compoment.SqlWhereItem;

/**
 * @ClassName:SqlVisitor
 * @Author: yangyang.wang
 * @Date:
 * @Version: 1.0
 * @Description: sql 访问者接口
 *
 **/
public interface SqlVisitor {

    String visit(SqlSelectItem sqlSelectItem);

    String visit(SqlFromItem SqlFromItem);

    String visit(SqlWhereItem sqlWhereItem);

    String visit(SqlSelect sqlSelect);

    String visit(Condition condition);

    String visit(SqlObject sqlObject);
}

