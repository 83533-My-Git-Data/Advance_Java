package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Product;

public interface ProductDao {
List<Product> getProductListByPrice(double minPrice, double maxPrice);
}
