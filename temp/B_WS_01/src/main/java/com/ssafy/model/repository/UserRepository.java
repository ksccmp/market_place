package com.ssafy.model.repository;

import java.util.List;

import com.ssafy.model.dto.UserInfo;

public interface UserRepository {
	public List<UserInfo> selectAllUsers();
	public UserInfo select(String id);
	public int insert(UserInfo info);
	public int update(UserInfo info);
	public int delete(String userId);
}
