package com.sunbeam.entities;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product extends BaseEntity{

	@Column(name = "product_name",length=20, unique = true)
	private String productName;
	@Column(name = "price")
	private double price;
	@Column(name = "quantity", length = 10)
	private int quantity;
	
	//product*-->1Category(many  to one)
	
    @ManyToOne //mandatory, otherwise mappingException
    //optional but recommended , to specify name of a FK column n adding not null constraints
    @JoinColumn(name="category_id",nullable = false)
	private Category productCategory;

	public Product() {

	}

	public Product(String productName, double price, int quantity) {
		super();
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	
	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", price=" + price + ", quantity=" + quantity + "]";
	}
  
	
	
}
