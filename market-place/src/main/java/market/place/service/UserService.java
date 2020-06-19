package market.place.service;

import market.place.dto.User;

public interface UserService {
	
	public int insert(User user);
	
	public User selectByUserid(String userid);
}
