package com.pay.aphrodite.query.config.ds;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = HiveDataSource.PACKAGE,basePackages = HiveDataSource.PACKAGE, sqlSessionFactoryRef = "hiveSqlSessionFactory")
public class HiveDataSource {

    public static final String MAPPER_LOCATION = "classpath:com/pay/aphrodite/query/dao/hive/*.xml";
    public static final String PACKAGE = "com.pay.aphrodite.query.dao.hive";

    @Value("${hive.url}")
    private String hiveUrl;
    @Value("${hive.driverClassName}")
    private String hiveDriverClassName;
    @Value("${hive.username}")
    private String hiveUsername;
    @Value("${hive.password}")
    private String hivePassword;

    @Bean(name = "hiveJdbcDataSource")
    @Primary
    public DataSource hiveDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(hiveUrl);
        dataSource.setDriverClassName(hiveDriverClassName);
        dataSource.setUsername(hiveUsername);
        dataSource.setPassword(hivePassword);
        return dataSource;
    }


    @Bean(name = "hiveTransactionManager")
    @Primary
    public DataSourceTransactionManager hiveTransactionManager(@Qualifier("hiveJdbcDataSource")DataSource hiveDataSource) {
        return new DataSourceTransactionManager(hiveDataSource);
    }

    @Bean(name = "hiveSqlSessionFactory")
    @Primary
    public SqlSessionFactory hiveSqlSessionFactory(@Qualifier("hiveJdbcDataSource") DataSource hiveDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(hiveDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

}