package market.place.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import market.place.dto.MyProduct;
import market.place.dto.Purchase;
import market.place.repository.PurchaseRepository;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	
	@Autowired
	PurchaseRepository pRepo;
	
	@Override
	public List<MyProduct> selectByUserid(String userid) {
		return pRepo.selectByUserid(userid);
	}
	
	@Override
	@Transactional
	public int insert(Purchase purchase) {
		return pRepo.insert(purchase);
	}
}
