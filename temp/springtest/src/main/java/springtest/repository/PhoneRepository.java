package springtest.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import springtest.dto.Phone;

@Repository
@Slf4j
public class PhoneRepository {
	private String ns = "springtest.phonemapper.";
	
	@Autowired
	SqlSession session;
	
	public int insert(Phone phone) {
		log.trace("repo: insert", phone);
		return session.insert(ns+"insert", phone);
	}
	
	public int delete(String num) {
		log.trace("repo: delet", num);
		return session.delete(ns+"delete", num);
	}
	
	public int update(Phone phone) {
		log.trace("repo: update", phone);
		return session.update(ns+"update", phone);
	}
	
	public Phone select(String num) {
		log.trace("repo: select", num);
		return session.selectOne(ns+"select", num);
	}
	
	public List<Phone> selectAll() {
		log.trace("repo: selectAll");
		return session.selectList(ns+"select");
	}
}
