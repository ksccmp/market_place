package springtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import springtest.dto.Phone;
import springtest.repository.PhoneRepository;

@Service
@Slf4j
public class PhoneService {
	
	@Autowired
	PhoneRepository repo;
	
	@Transactional
	public int insert(Phone phone) {
		log.trace("service: insert", phone);
		return repo.insert(phone);
	}
	
	@Transactional
	public int delete(String num) {
		log.trace("service: delete", num);
		return repo.delete(num);
	}
	
	@Transactional
	public int update(Phone phone) {
		log.trace("service: update", phone);
		return repo.update(phone);
	}
	
	public Phone select(String num) {
		log.trace("service: select", num);
		return repo.select(num);
	}
	
	public List<Phone> selectAll() {
		log.trace("service: selectAll");
		return repo.selectAll();
	}
}
