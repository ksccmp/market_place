package com.ssafy.model.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.UserInfo;

@Repository
public class UserRepositoryJDBCImpl implements UserRepository {
	private static Logger logger = LoggerFactory.getLogger(UserRepositoryJDBCImpl.class);
	
	@Override
	public int delete(String userId) {
		logger.trace("delete: {}", userId);
		return 0;
	}
	
	@Override
	public int insert(UserInfo info) {
		logger.trace("insert: {}", info);
		return 0;
	}
	
	@Override
	public UserInfo select(String id) {
		logger.trace("select: {}", id);
		return null;
	}
	
	@Override
	public List<UserInfo> selectAllUsers() {
		logger.trace("selectAllUsers");
		return null;
	}
	
	@Override
	public int update(UserInfo info) {
		logger.trace("update: {}", info);
		return 0;
	}
}
