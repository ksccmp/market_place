package springtest.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import springtest.config.ApplicationConfig;
import springtest.dto.Phone;
import springtest.repository.PhoneRepository;
import springtest.service.PhoneService;

@Transactional
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=ApplicationConfig.class)
@Slf4j
public class myTest {
	@Autowired
	PhoneRepository repo;
	
	@Autowired
	PhoneService service;
	
	@Test
	public void test() {
		List<Phone> phones = repo.selectAll();
		for(Phone phone : phones) {
			System.out.println(phone);
		}
		
		System.out.println();
		phones = service.selectAll();
		for(Phone phone : phones) {
			System.out.println(phone);
		}
	}
}
