package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public interface ProductDao {
    String AddProduct(Product product);
    Product getProductDetailsById(Long productId);
    List<Product> displayProdByCateNdPrice (double pMax, double pMin, Category prodCategory);
    String applyDiscount(Category prodCategory, double discount);
    String purchaseProduct(Long productId, int qua);
    String delProdDetails(String productName);
}
