package com.sunbeam.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory factory;

	@Override
	public List<Product> getProductListByPrice(double minPrice, double maxPrice) {
    String jpql = "select p from Product p where p.price between :minP and :maxP";
	return factory.getCurrentSession()
			.createQuery(jpql,Product.class)
			.setParameter("minP",minPrice)
			.setParameter("maxP", maxPrice)
			.getResultList();
	}

}
