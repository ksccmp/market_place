package com.ssafy.pms.repo;

import java.util.List;

import com.ssafy.pms.Phone;
import com.ssafy.pms.Userinfo;

public interface IPhoneDAO {
	Userinfo selectUser(Userinfo user);
	int insert(Phone phone);
	List<Phone> select();
	Phone select(Phone phone);
	int delete(List<String> list);
	
	
	// rest api 추가
	int restInsert(Phone phone);
	Phone restSelect(String num);
	List<Phone> restSelectAll();
	int restDelete(String num);
	int restUpdate(Phone phone);
}
