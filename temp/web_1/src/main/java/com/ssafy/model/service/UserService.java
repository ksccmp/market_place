package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.User;

public interface UserService {
	public int join(User user);
	public User login(User user);
	public User detail(String userid);
	public List<User> all();
	public int change(User user);
	public int withdraw(User user);
	public int multiDel(List<String> list);
}
