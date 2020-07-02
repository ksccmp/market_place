package market.place.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import market.place.dto.Purchase;

@Repository
public class PurchaseRepositoryImpl implements PurchaseRepository {
	private String ns = "market.place.purchase.";
	
	@Autowired
	SqlSession session;
	
	@Override
	public int insert(Purchase purchase) {
		return session.insert(ns + "insert", purchase);
	}
}
