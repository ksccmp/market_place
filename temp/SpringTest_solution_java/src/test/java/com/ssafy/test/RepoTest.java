package com.ssafy.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.pms.Phone;
import com.ssafy.pms.Userinfo;
import com.ssafy.pms.repo.IPhoneDAO;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring/application-config.xml")
@Transactional
public class RepoTest {
	
	@Autowired
	IPhoneDAO repo;

	@Test
	public void test() {
		Userinfo user = new Userinfo();
		user.setId("ssafy");
		
		Userinfo selected = repo.selectUser(user);
		assertThat(selected.getPw(), is("ssafy"));
		
		user.setPw("ssafy");
		
		selected = repo.selectUser(user);
		assertThat(selected.getPw(), is("ssafy"));
	}
	
	@Test
	public void testSelect() {
		List<Phone> phones = repo.select();
		assertThat(phones.size(), is(4));
		
		System.out.println(repo.getClass().getName());
	}
}
