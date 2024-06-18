package com.sunbeam.dao;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;
import  static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

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

	@Override
	public List<Product> displayProdByCateNdPrice(double pMax, double pMin, Category prodCategory) {
		String jpql = "select p from Product p where p.price between :maxPrice and :minPrice and p.category= :c";
		List<Product> products = null;
		
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			products =  session.createQuery(jpql, Product.class)
					   .setParameter("maxPrice", pMax)
					   .setParameter("minPrice", pMin)
					   .setParameter("c", prodCategory).getResultList();
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				
				throw e;
			}
		}
		return products;
	}

	
	@Override
	public String applyDiscount(Category prodCategory, double discount) {
		String msg = "applying discount failed!!!";
		String jpql = "update Product p set p.price=p.price - :disc where p.category = :c";
		
		Session session  = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			int updaterow = session.createQuery(jpql).setParameter("disc", discount).setParameter("c", prodCategory)
					.executeUpdate();
			tx.commit();
			
			msg = "Applied discount on products -" +updaterow;
			
		}catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
		}
		
		return msg;
	}

	@Override
	public String purchaseProduct(Long productId, int qua) {
	    String msg = "";
	    
	    
		return null;
	}

	@Override
	public String delProdDetails(String productName) {
	    String msg = "Deletion failed";
	    String jpql = select u.productName from Product p 
	    
	    Session session = getFactory().getCurrentSession();
	    Transaction tx = session.beginTransaction();
	    try {
	    	
	    }catch(Exception e) {
	    	
	    }
		return msg;
	}

	
	
	
	
    
}
