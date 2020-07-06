package market.place.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import market.place.dto.MyProduct;
import market.place.dto.Purchase;

@Repository
public class PurchaseRepositoryImpl implements PurchaseRepository {
	private String ns = "market.place.purchase.";
	
	@Autowired
	SqlSession session;
	
	@Override
	public List<MyProduct> selectByUserid(String userid) {
		return session.selectList(ns + "selectByUserid", userid);
	}
	
	@Override
	public int insert(Purchase purchase) {
		return session.insert(ns + "insert", purchase);
	}
}
