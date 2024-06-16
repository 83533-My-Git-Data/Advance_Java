package com.sunbeam.dao;

import com.sunbeam.entities.Product;
import  static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;

import org.hibernate.*;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String AddProduct(Product product) {
		String msg = "product added successfully";
		Session session  =getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Serializable productId = session.save(product);
			tx.commit();
			msg = "product added successfully, with ID"+productId;
		}catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		return msg;
	}

	@Override
	public Product getProductDetailsById(Long productId) {
		Product product = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			product = session.get(Product.class,productId);
			tx.commit();
			
		}catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return product;
	}
	
	

}
