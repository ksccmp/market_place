package com.ssafy.model.repository;

import java.util.List;

import com.ssafy.model.dto.User;

public interface UserRepository {
	public int insert(User user);
	public User select(User user);
	public User select(String userid);
	public List<User> selectAll();
	public int update(User user);
	public int delete(User user);
	public int multiDel(List<String> list);
}
