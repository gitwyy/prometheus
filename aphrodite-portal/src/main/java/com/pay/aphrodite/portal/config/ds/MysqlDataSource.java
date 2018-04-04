package com.pay.aphrodite.portal.config.ds;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


/**
 * @ClassName:MysqlDataSource
 * @Author: yangyang.wang
 * @Date: 2018-03-30 19:36
 * @Version: 1.0
 * @Description: mysql 数据源配置类（双数据源 mysql 配置为副数据源 ,集成了mybatis）
 *
 **/
@SuppressWarnings("ALL")
@Configuration
@MapperScan(value = MysqlDataSource.PACKAGE,basePackages = MysqlDataSource.PACKAGE, sqlSessionFactoryRef = "mysqlSqlSessionFactory")
public class MysqlDataSource {
    private static final Logger logger = LoggerFactory.getLogger(MysqlDataSource.class);

    public static final String MAPPER_LOCATION = "classpath:com/pay/aphrodite/query/mapper/mysql/*.xml";
    public static final String PACKAGE = "com.pay.aphrodite.query.mapper.mysql";

    @Value("${mysql.url}")
    private String mysqlUrl;
    @Value("${mysql.driverClassName}")
    private String mysqlDriverClassName;
    @Value("${mysql.username}")
    private String mysqlUsername;
    @Value("${mysql.password}")
    private String mysqlPassword;




    @Bean(name = "mysqlJdbcDataSource")
    public DataSource mysqlDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(mysqlDriverClassName);
        dataSource.setUrl(mysqlUrl);
        dataSource.setUsername(mysqlUsername);
        dataSource.setPassword(mysqlPassword);
        return dataSource;
    }

    @Bean(name = "mysqlTransactionManager")
    public DataSourceTransactionManager mysqlTransactionManager(@Qualifier("mysqlJdbcDataSource") DataSource mysqlDataSource) {
        return new DataSourceTransactionManager(mysqlDataSource);
    }

    @Bean(name = "mysqlSqlSessionFactory")
    public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("mysqlJdbcDataSource") DataSource mysqlDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(mysqlDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

}