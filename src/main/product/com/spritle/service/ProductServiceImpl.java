package com.spritle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spritle.dao.ProductDao;
import com.spritle.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Transactional
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.addProduct(product);
	}

	@Transactional
	public Product getProduct(int productid) {
		// TODO Auto-generated method stub
		return productDao.getProduct(productid);
	}

	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(product);
	}

	@Transactional
	public void deleteProduct(Integer productid) {
		// TODO Auto-generated method stub
		productDao.deleteProduct(productid);

	}

	@Transactional
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAllProducts();
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
}
