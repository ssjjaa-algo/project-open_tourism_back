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
@MapperScan(value="com.ssafy.trip.dao.secure", sqlSessionFactoryRef="saltdbSqlSessionFactory")
@EnableTransactionManagement
public class SALTDB_Config {

    @Bean(name="saltdbDataSource")
    @ConfigurationProperties(prefix="spring.saltdb.datasource")
    public DataSource createSSAFYTEST_DataSource() {
        //application.properties에서 정의한 DB 연결 정보를 빌드
        return DataSourceBuilder.create().build();
    }


    @Bean(name="saltdbSqlSessionFactory")
    public SqlSessionFactory saltdbSqlSessionFactory(@Qualifier("saltdbDataSource") DataSource saltdbDataSource, ApplicationContext applicationContext) throws Exception{
        //세션 생성 시, 빌드된 DataSource를 세팅하고 SQL문을 관리할 mapper.xml의 경로를 알려준다.
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(saltdbDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/mappers/saltdb/*"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.ssafy.trip");
        return sqlSessionFactoryBean.getObject();
    }


    @Bean(name="saltdbSqlSessionTemplate")
    public SqlSessionTemplate saltdbSqlSessionTemplate(SqlSessionFactory saltdbSqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(saltdbSqlSessionFactory);
    }
    @Bean("saltTransactionManager")
    public DataSourceTransactionManager jesTransactionManager(@Qualifier("saltdbDataSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}