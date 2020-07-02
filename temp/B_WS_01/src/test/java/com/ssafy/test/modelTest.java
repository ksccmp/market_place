package com.ssafy.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssafy.model.repository.UserRepository;
import com.ssafy.model.service.UserService;

@RunWith(SpringRunner.class)
@ContextConfiguration("/Application.xml")
public class modelTest {
	@Autowired
	UserService service;
	
	@Autowired
	UserRepository repo;
	
	@Test
	public void test() {
		assertThat(service, is(notNullValue()));
		assertThat(repo, is(service.getUserRepo()));
		service.login("hong", "1234");
	}
}
