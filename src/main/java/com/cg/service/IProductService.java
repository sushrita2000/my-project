package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.model.Product;
@Service
public interface IProductService {

	public List<Product> getAllProducts();

	public Product findProduct(Integer productId);

	public List<Product> deleteProduct(Integer productId);

	public List<Product> saveProduct(Product product);
	
	public Product saveProduct2(Product product);

	public List<Product> updateProduct(Product product);
	public List<Product> saveAll();
	
	public List<Product> findByProductName(String prName);
	
	public List<Product> findProductAbovePrice(Double price);
	
}
