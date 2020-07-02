package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.model.dto.User;
import com.ssafy.model.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService { // service의 역할: transaction 처리 & 예외 처리
	@Autowired
	UserRepository uRepo;
	
	@Override
	@Transactional // AOP기반으로 동작
	// commit? 별일 없었다면..
	// rollback? 별일이 발생했다면..
	// 예외처리는 controller에게 위임
	public int join(User user) {
		int result = uRepo.insert(user);
		return result;
	}
	
	@Override
	public User login(User user) {
		return uRepo.select(user);
	}
	
	@Override
	public List<User> all() {
		return uRepo.selectAll();
	}
	
	@Override
	public User detail(String userid) {
		return uRepo.select(userid);
	}
	
	@Transactional
	@Override
	public int change(User user) {
		return uRepo.update(user);
	}
	
	@Transactional
	@Override
	public int withdraw(User user) {
		return uRepo.delete(user);
	}
	
	@Transactional
	@Override
	public int multiDel(List<String> list) {
		return uRepo.multiDel(list);
	}
}
