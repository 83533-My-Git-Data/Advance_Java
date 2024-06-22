package com.sunbeam.service;

import java.util.List;

import com.sunbeam.entities.Product;

public interface ProductService {
	List<Product> getProductsByPrice(double minP, double maxP);
}
