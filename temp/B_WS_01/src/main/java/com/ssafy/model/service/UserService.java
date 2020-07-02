package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.UserInfo;
import com.ssafy.model.repository.UserRepository;

public interface UserService {
	public UserRepository getUserRepo();
	public UserInfo login(String id, String pass);
	public UserInfo select(String id);
	public List<UserInfo> selectAll();
	public int joinDayTime(UserInfo info);
	public int updateDayTime(UserInfo info);
	public int leaveDayTime(String id);
}
