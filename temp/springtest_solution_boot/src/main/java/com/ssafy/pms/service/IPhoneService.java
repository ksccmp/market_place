package com.ssafy.pms.service;

import java.util.List;

import com.ssafy.pms.Phone;
import com.ssafy.pms.Userinfo;

public interface IPhoneService {
	public Userinfo selectUser(Userinfo user);
	public int insert(Phone phone);
	public List<Phone> select();
	public Phone select(Phone phone);
	public int delete(List<String> list);
	
	
	// rest api 추가
	public int restInsert(Phone phone);
	public Phone restSelect(String num);
	public List<Phone> restSelectAll();
	public int restDelete(String num);
	public int restUpdate(Phone phone);
}
