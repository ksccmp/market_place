package market.place.repository;

import market.place.dto.User;

public interface UserRepository {
	
	public int insert(User user);
	
	public User selectByUserid(String userid);
}
