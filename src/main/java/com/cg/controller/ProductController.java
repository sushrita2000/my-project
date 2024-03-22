package com.cg.controller;

import java.util.List;

import com.cg.model.Product;
import com.cg.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	@Autowired
	private IProductService productService;
	
	//http://localhost:8080/ProductApp/api/v1/products
	@PutMapping("/products")
	public ResponseEntity<List<Product>> updateProduct(
			@RequestBody Product product){
		System.out.println(product);
		List<Product> products= productService.updateProduct(product);
		if(products.isEmpty())
		{
			return new ResponseEntity("Sorry! Products not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	
	
	@PostMapping("/products")
	public ResponseEntity<List<Product>> insertProduct(
			@RequestBody Product product){
		List<Product> products= productService.saveProduct(product);
		if(products.isEmpty())
		{
			return new ResponseEntity("Sorry! Products not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	//Note:-use this method for saving
	@PostMapping("save/products")
	public ResponseEntity<Product> saveProduct(
			@RequestBody Product product){
		Product products= productService.saveProduct2(product);
		if(products==null)
		{
			return new ResponseEntity("Sorry! Products not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Product>(products, HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<List<Product>> deleteProduct(
			@PathVariable("productId")Integer productId){
		List<Product> products= productService.deleteProduct(productId);
		if(products.isEmpty() || products==null) {
			return new ResponseEntity("Sorry! ProductsId not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	
	@GetMapping("/products/{productId}")
	public ResponseEntity<Product> findProduct(
			@PathVariable("productId")Integer productId){
		Product product= productService.findProduct(productId);
		if(product==null) {
			return new ResponseEntity("Sorry! Products not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	
	//http://localhost:8080/ProductApp/api/v1/products
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products= productService.getAllProducts();
		if(products.isEmpty()) {
			return new ResponseEntity("Sorry! Products not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	////http://localhost:8081/ProductApp/api/v1/productsname/mouse
	@GetMapping("/productsname/{productName}")
	public ResponseEntity<List<Product>> getAllProductsByName(@PathVariable("productName")String productName){
		System.out.println("inside product");
	
		List<Product> products= productService.findByProductName(productName); //custom method
		if(products.isEmpty()) {
			return new ResponseEntity("Sorry! Products not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/products/price/{productPr}")
	public ResponseEntity<List<Product>> findProductAbovePrice(
			@PathVariable("productPr")Double productPr){
		System.out.println("value "+productPr);
		List<Product> products= productService.findProductAbovePrice(productPr);
		if(products.isEmpty()) {
			return new ResponseEntity("Sorry! Products not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
}
