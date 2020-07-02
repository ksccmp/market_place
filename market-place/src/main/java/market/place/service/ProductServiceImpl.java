package market.place.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import market.place.dto.Product;
import market.place.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository pRepo;
	
	@Override
	public List<Product> selectAll() {
		return pRepo.selectAll();
	}
	
	@Override
	public Product selectById(int id) {
		return pRepo.selectById(id);
	}
	
	@Override
	@Transactional
	public int insert(Product product) {
		return pRepo.insert(product);
	}
	
	@Override
	@Transactional
	public int delete(Product product) {
		return pRepo.delete(product);
	}
	
	@Override
	@Transactional
	public int updateByCount(Product product) {
		return pRepo.updateByCount(product);
	}
}
