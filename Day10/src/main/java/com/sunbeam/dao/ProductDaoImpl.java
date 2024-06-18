package com.sunbeam.dao;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addProduct(Long categoryId, Product newProduct) {
		String msg = "adding product failed!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			// session.persist(newProduct);//exception -cause fk null
			Category category = session.get(Category.class, categoryId);
			if (category != null) {
				category.addProduct(newProduct);// state of (persistent)category is changed!
				// session.persist(newProduct);//not required

				msg = "added product successfully";
			}
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return msg;

	}

	@Override
	public Product getProductDetails(Long productId) {
		Product product = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			product = session.get(Product.class, productId);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return product;
	}

	@Override
	public String purchseProduct(Long productId, int qty) {
		String msg = "purchse product failed !";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Product product = session.get(Product.class, productId);
			if(product != null && product.getQuantity() >= qty) {
				product.setQuantity(product.getQuantity() - qty);
				msg = "product purchased!!";
			}
            tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
				throw e;
			}
		
		}
		return msg;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = null;
		
		String jpql = "select p from Product p";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			products = session.createQuery(jpql, Product.class).getResultList();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return products;
	}
}
