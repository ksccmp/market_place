package com.ssafy.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssafy.model.dto.User;
import com.ssafy.model.service.UserService;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring/application-config.xml")
public class ServiceTest {
	@Autowired
	UserService service;
	
	@Test
	public void test() {
		User user = new User("일심이", "테스트", "1234", 100);
		int result = service.join(user);
		assertThat(result, is(1));
	}
}
