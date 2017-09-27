package com.spritle.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spritle.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(product);

	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub

		return sessionFactory.getCurrentSession()
				.createQuery("from Product").list();

	}

	public Product getProduct(int productid) {
		// TODO Auto-generated method stub
		return (Product) sessionFactory.getCurrentSession().get(Product.class,
				productid);

	}

	public Product updateProduct(Product product) {
		sessionFactory.getCurrentSession().update(product);
		return product;
		// TODO Auto-generated method stub

	}

	public void deleteProduct(Integer productid) {
		// TODO Auto-generated method stub

		Product product = (Product) sessionFactory.getCurrentSession().load(
				Product.class, productid);
		if (product != null) {
			this.sessionFactory.getCurrentSession().delete(product);
		}
	}

}
