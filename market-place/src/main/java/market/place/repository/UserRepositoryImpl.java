package market.place.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import market.place.dto.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private String ns = "market.place.user.";
	
	@Autowired
	SqlSession session;
	
	@Override
	public int insert(User user) {
		return session.insert(ns + "insert", user); 
	}
}
