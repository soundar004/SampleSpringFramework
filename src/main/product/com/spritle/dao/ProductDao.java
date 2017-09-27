package com.spritle.dao;

import java.util.List;

import com.spritle.model.Product;

public interface ProductDao {

	public void addProduct(Product product);

	public Product getProduct(int productid);

	public Product updateProduct(Product product);

	public void deleteProduct(Integer productid);

	public List<Product> getAllProducts();

}
