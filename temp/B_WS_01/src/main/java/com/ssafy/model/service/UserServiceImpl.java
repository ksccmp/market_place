package com.ssafy.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dto.UserInfo;
import com.ssafy.model.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	private UserRepository userRepo;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@Override
	public int joinDayTime(UserInfo info) {
		logger.trace("joinDayTime: {}", info);
		return 0;
	}
	
	@Override
	public int leaveDayTime(String id) {
		logger.trace("leaveDayTime: {}", id);
		return 0;
	}
	
	@Override
	public UserInfo login(String id, String pass) {
		logger.trace("login: {}, {}", id, pass);
		return null;
	}
	
	@Override
	public UserInfo select(String id) {
		logger.trace("select: {}", id);
		return null;
	}
	
	@Override
	public List<UserInfo> selectAll() {
		logger.trace("selectAll:");
		return null;
	}
	
	@Override
	public int updateDayTime(UserInfo info) {
		logger.trace("updateDayTime: {}", info);
		return 0;
	}
	
	@Override
	public UserRepository getUserRepo() {
		logger.trace("getUserRepo:");
		return userRepo;
	}
}
