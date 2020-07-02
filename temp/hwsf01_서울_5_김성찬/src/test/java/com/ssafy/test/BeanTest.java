package com.ssafy.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssafy.model.repository.ProductRepo;
import com.ssafy.model.service.ProductService;

@RunWith(SpringRunner.class)
@ContextConfiguration("/application.xml")
public class BeanTest {
	@Autowired
	ProductService service;
	
	@Autowired
	ProductRepo repo;
	
	@Test
	public void test() {
		assertThat(service, is(notNullValue()));
		assertThat(repo, is(service.getRepo()));
		service.select("hong");
	}
}
