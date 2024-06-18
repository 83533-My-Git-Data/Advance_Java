package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Product;

public class ProductBean {
//Map /bind request parameters to java beans props
	
	private String name;
	private double price;
	private int quantity;
	private long categoryId;
	private long productId;
	
	//dependency - dao layer inteface
	
	private ProductDao productDao;
	public ProductBean() {
		//create Dao instance
		
		productDao = new ProductDaoImpl();
		System.out.println("product bean added");
	}
	public ProductBean(String name, double price, int quantity, long categoryId) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
	//add business logic method to add a new product
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String addNewProduct() {
		System.out.println("in add product" +categoryId);
		//1.create product instance
		Product product = new Product(name,price,quantity);
		//invoke daos method for saving products details in db
		return productDao.addProduct(categoryId, product);
		
	}
	public List<Product> getAllProducts(){
		return productDao.getAllProducts();
	}
	
	public String purchaseProduct() {
		System.out.println("in purchase" + quantity + " " + productId);
		return productDao.purchseProduct(productId, quantity);
		
	}
	
}
