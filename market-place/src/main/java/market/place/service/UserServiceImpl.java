package market.place.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import market.place.dto.User;
import market.place.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository uRepo;
	
	@Override
	public int insert(User user) {
		return uRepo.insert(user);
	}
}
