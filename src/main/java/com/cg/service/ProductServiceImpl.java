
package com.cg.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.ProductJPARepository;
import com.cg.model.Product;
@Service
public class ProductServiceImpl implements IProductService
{
	@Autowired
	private ProductJPARepository productRepo;
	//

	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}
	public Product findProduct(Integer productId) {
		Optional<Product>prod=productRepo.findById(productId); //predefined method
		return prod.get();
	}
	public List<Product> deleteProduct(Integer productId) {
		productRepo.deleteById(productId);
		return  productRepo.findAll();
	}
	public List<Product> saveProduct(Product product) {
		productRepo.saveAndFlush(product);
		return  productRepo.findAll();
	}
	
	
	public Product saveProduct2(Product product) {
	System.out.println("inside save2");
		return productRepo.save(product);
	}

	public List<Product> updateProduct(Product product) {
		productRepo.saveAndFlush(product);
		return  productRepo.findAll();
	}

	public List<Product> saveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByProductName(String prName) {
		List<Product> prd=productRepo.findByProductName(prName);//custom methods of repository
		return prd;
	}
	
	@Override
	public List<Product> findProductAbovePrice(Double price) {
		List<Product> prd=productRepo.getByPrice(price); //user defined custom method
		return prd;
	}
}
