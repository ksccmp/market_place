package com.ssafy.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.pms.Phone;
import com.ssafy.pms.Userinfo;
import com.ssafy.pms.repo.IPhoneDAO;

@Service
public class IPhoneServiceImpl implements IPhoneService {
	@Autowired
	IPhoneDAO repo;
	
	@Override
	public Userinfo selectUser(Userinfo user) {
		return repo.selectUser(user);
	}
	
	@Override
	@Transactional
	public int insert(Phone phone) {
		return repo.insert(phone);
	}
	
	@Override
	public List<Phone> select() {
		return repo.select();
	}
	
	@Override
	public Phone select(Phone phone) {
		return repo.select(phone);
	}
	
	@Override
	@Transactional
	public int delete(List<String> list) {
		return repo.delete(list);
	}
	
	@Override
	@Transactional
	public int restInsert(Phone phone) {
		return repo.restInsert(phone);
	}
	
	@Override
	@Transactional
	public int restDelete(String num) {
		return repo.restDelete(num);
	}
	
	@Override
	public Phone restSelect(String num) {
		return repo.restSelect(num);
	}
	
	@Override
	public List<Phone> restSelectAll() {
		return repo.restSelectAll();
	}
	
	@Override
	@Transactional
	public int restUpdate(Phone phone) {
		return repo.restUpdate(phone);
	}
}
