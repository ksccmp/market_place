package market.place.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import market.place.dto.User;
import market.place.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository uRepo;
	
	@Override
	@Transactional
	public int insert(User user) {
		return uRepo.insert(user);
	}
	
	@Override
	public User selectByUserid(String userid) {
		return uRepo.selectByUserid(userid);
	}
}
