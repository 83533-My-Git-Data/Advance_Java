package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="categories")
public class Category extends BaseEntity{
	@Column(name="name", length = 30, unique = true)
	private String categoryName;
	private String description;
	
	
	
	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL)
	//Category 1 --->*product(one to many)
	private List<Product> products = new ArrayList<>();
	
	
	public Category() {
		
	}
	
	

	public Category(String categoryName, String description) {
		super();
		this.categoryName = categoryName;
		this.description = description;
	}



	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public List<Product> getProducts() {
		return products;
	}



	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
	
	//add helper method to establish bi dir association between category and product
	public void addProduct(Product product) {
		//parent(category) --> child (product)
		//child --> parent
		this.products.add(product);
		product.setProductCategory(this);
	}


	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + ", description=" + description + "]";
	}
	
	

}
