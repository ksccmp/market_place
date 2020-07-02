package com.ssafy.pms.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration // 자바 환경 설정
@ComponentScan({"com.ssafy.pms.repo, com.ssafy.pms.service"})
@EnableTransactionManagement
public class ApplicationConfig {
	
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC");
		ds.setUsername("ssafy");
		ds.setPassword("ssafy");
		ds.setMaxActive(20);
		return ds;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
		SqlSessionFactoryBean sbean = new SqlSessionFactoryBean();
		//sbean.setDataSource(dataSource());
		sbean.setDataSource(dataSource);
		String path = "classpath:spring/SqlMapConfig.xml";
		sbean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(path));
		return sbean;
	}
	
	@Bean
	public SqlSession sqlSession(SqlSessionFactoryBean sbean) throws Exception {
		SqlSessionTemplate temp = new SqlSessionTemplate(sbean.getObject());
		return temp;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(DataSource ds) {
		DataSourceTransactionManager pm = new DataSourceTransactionManager();
		pm.setDataSource(ds);
		return pm;
	}
}