package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Product;

public interface ProductDao {
	String addProduct(Long categoryId, Product newProduct);
	//categoryid for association
	
	List<Product>getAllProducts();
	Product getProductDetails(Long productId);
	
	String purchseProduct(Long productId, int qty);
	
	
}
