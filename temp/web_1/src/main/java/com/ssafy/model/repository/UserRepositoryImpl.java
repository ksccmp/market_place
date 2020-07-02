package com.ssafy.model.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	private static Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);
	private String ns = "com.ssafy.model.UserMapper.";
	
	@Autowired
	SqlSession session;
	
	@Override
	public int insert(User user) {
		logger.trace("insert: {}", user);
		return session.insert(ns+"insert", user);
	}
	
	@Override
	public User select(User user) {
		logger.trace("select: {}", user);
		return session.selectOne(ns+"select", user);
	}
	
	@Override
	public List<User> selectAll() {
		logger.trace("selectAll");
		return session.selectList(ns+"selectAll");
	}
	
	@Override
	public User select(String userid) {
		logger.trace("selectById: {}", userid);
		return session.selectOne(ns+"selectById", userid);
	}
	
	@Override
	public int update(User user) {
		logger.trace("update: {}", user);
		return session.update(ns+"update", user);
	}
	
	@Override
	public int delete(User user) {
		logger.trace("delete: {}", user);
		return session.delete(ns+"delete", user);
	}
	
	@Override
	public int multiDel(List<String> list) {
		logger.trace("multiDel: {}", list);
		return session.delete(ns+"multiDel", list);
	}
}
