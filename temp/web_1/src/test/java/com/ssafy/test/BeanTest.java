package com.ssafy.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring/application-config.xml")
@Transactional
public class BeanTest {
	@Autowired
	DataSource ds;
	
	@Autowired
	SqlSession session;

	@Test
	public void test() {
		assertThat(ds, is(notNullValue()));
	}

	@Test
	public void testSession() {
		assertThat(session, is(notNullValue()));
	}
}
