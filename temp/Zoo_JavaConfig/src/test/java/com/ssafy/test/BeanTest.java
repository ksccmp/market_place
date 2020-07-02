package com.ssafy.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssafy.config.ApplicationConfig;
import com.ssafy.zoo.Tiger;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=ApplicationConfig.class)
public class BeanTest {
	
	@Autowired
	Tiger tiger;

	@Autowired
	ApplicationConfig config;
	
	@Test
	public void test() {
		assertThat(tiger, is(notNullValue()));
		System.out.println(tiger.getClass().getName());
		
		assertThat(config, is(notNullValue()));
		System.out.println(config.getClass().getName());
	}
	
	@Test
	public void testAOP() {
		tiger.setName("호돌이");
		assertThat(tiger.getName(), is("호돌이"));
		
		tiger.setAge(100);
		assertThat(tiger.getAge(), is(100));
	}
}
