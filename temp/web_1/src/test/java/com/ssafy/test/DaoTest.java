package com.ssafy.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.model.dto.User;
import com.ssafy.model.repository.UserRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring/application-config.xml")
@Transactional // 테스트 메서드 동작 후 rollback 처리
public class DaoTest {
	
	@Autowired
	UserRepository uRepo;

	@Test
	public void test() {
		User user = new User(System.currentTimeMillis()+"", "테스트", "1234", 100);
		int result = uRepo.insert(user);
		assertThat(result, is(1));
	}
	
	@Test
	public void selectTest() {
		User user = new User("영심이", null, null, 0);
		
		user = uRepo.select(user);
		assertThat(user.getName(), is("테스트"));
	}
	
	@Test
	public void multiDelTest() {
		List<String> list = Arrays.asList("헤", "헬로", "호");
		uRepo.multiDel(list);
	}
}
