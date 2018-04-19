package com.pay.aphrodite.portal.service;

import com.pay.aphrodite.portal.hql.compoment.SqlFromItem;
import com.pay.aphrodite.portal.hql.compoment.SqlSelect;
import com.pay.aphrodite.portal.hql.compoment.SqlSelectItem;
import com.pay.aphrodite.portal.hql.compoment.SqlWhereItem;

/**
 * @ClassName:SqlBuildService
 * @Author: yangyang.wang
 * @Date: 2018-04-19 11:14
 * @Version: 1.0
 * @Description: 构建SQL 组件的 service 类
 **/
public interface SqlBuildService {

    /**
     * @Author: yangyang.wang
     * @Date: 2018-04-19 11:19
     * @Param: [] :
     * @Return: com.pay.aphrodite.portal.hql.compoment.SqlSelect :
     * @Description: 构建 sql 语句
     **/
    SqlSelect buildSql();


    /**
     * @Author: yangyang.wang
     * @Date: 2018-04-19 11:19
     * @Param: [] :
     * @Return: com.pay.aphrodite.portal.hql.compoment.SqlSelectItem :
     * @Description: 构建 SELECT 语句块
     **/
    SqlSelectItem buildSelectItem();


    /**
     * @Author: yangyang.wang
     * @Date: 2018-04-19 11:20
     * @Param: [] :
     * @Return: com.pay.aphrodite.portal.hql.compoment.SqlFromItem :
     * @Description: 构建 FROM 语句块
     **/
    SqlFromItem buildFromItem();

    /**
     * @Author: yangyang.wang
     * @Date: 2018-04-19 11:20
     * @Param: [] :
     * @Return: com.pay.aphrodite.portal.hql.compoment.SqlWhereItem :
     * @Description: 构建 Where 语句块
     **/
    SqlWhereItem buildWhereItem();
}
