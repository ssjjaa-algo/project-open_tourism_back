package com.ssafy.trip.config;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(value="com.ssafy.trip.dao.trip", sqlSessionFactoryRef="jesdbSqlSessionFactory")
@EnableTransactionManagement
public class JESDB_Config {

    @Bean(name="jesdbDataSource")
    @ConfigurationProperties(prefix="spring.jesdb.datasource")
    public DataSource createJESDB_DataSource() {
        //application.properties에서 정의한 DB 연결 정보를 빌드
        return DataSourceBuilder.create().build();
    }


    @Primary
    @Bean(name="jesdbSqlSessionFactory")
    public SqlSessionFactory jesdbSqlSessionFactory(@Qualifier("jesdbDataSource") DataSource jesdbDataSource, ApplicationContext applicationContext) throws Exception{
        //세션 생성 시, 빌드된 DataSource를 세팅하고 SQL문을 관리할 mapper.xml의 경로를 알려준다.
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(jesdbDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/mappers/jesdb/*.xml"));
          sqlSessionFactoryBean.setTypeAliasesPackage("com.ssafy.trip");
        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name="jesdbSqlSessionTemplate")
    public SqlSessionTemplate jesdbSqlSessionTemplate(SqlSessionFactory jesdbSqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(jesdbSqlSessionFactory);
    }

    // DataSource 에서 Transaction 관리를 위한 Manager 클래스 등록
    @Primary
    @Bean
    public DataSourceTransactionManager jesTransactionManager(@Qualifier("jesdbDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}