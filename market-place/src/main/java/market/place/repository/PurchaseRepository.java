package market.place.repository;

import java.util.List;

import market.place.dto.MyProduct;
import market.place.dto.Purchase;

public interface PurchaseRepository {
	public List<MyProduct> selectByUserid(String userid);
	
	public int insert(Purchase purchase);
}
