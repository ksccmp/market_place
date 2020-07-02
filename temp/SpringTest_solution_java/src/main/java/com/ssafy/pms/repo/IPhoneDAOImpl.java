package com.ssafy.pms.repo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.pms.Phone;
import com.ssafy.pms.Userinfo;

@Repository
public class IPhoneDAOImpl implements IPhoneDAO {
	private String ns = "sql.pms.";
	
	@Autowired
	SqlSession session;
	
	@Override
	public Userinfo selectUser(Userinfo user) {
		return session.selectOne(ns + "selectUser", user);
	}
	
	@Override
	public int insert(Phone phone) {
		return session.insert(ns+"insert", phone);
	}
	
	@Override
	public List<Phone> select() {
		return session.selectList(ns+"select", null);
	}
	
	@Override
	public Phone select(Phone phone) {
		return session.selectOne(ns+"select", phone);
	}
	
	@Override
	public int delete(List<String> list) {
		return session.delete(ns+"delete", list);
	}
	
	@Override
	public int restInsert(Phone phone) {
		return session.insert(ns+"restInsert", phone);
	}
	
	@Override
	public int restDelete(String num) {
		return session.delete(ns+"restDelete", num);
	}
	
	@Override
	public Phone restSelect(String num) {
		return session.selectOne(ns+"restSelect", num);
	}
	
	@Override
	public List<Phone> restSelectAll() {
		return session.selectList(ns+"restSelectAll");
	}
	
	@Override
	public int restUpdate(Phone phone) {
		return session.update(ns+"restUpdate", phone);
	}
}
