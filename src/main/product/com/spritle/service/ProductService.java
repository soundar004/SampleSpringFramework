package com.spritle.service;

import java.util.List;

import com.spritle.model.Product;

public interface ProductService {

public void addProduct(Product product);
	
	public Product getProduct(int productid);
	
	public Product updateProduct(Product product);
	
	public void deleteProduct(Integer productid);
	
	public List<Product> getAllProducts();
}
