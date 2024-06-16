package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

import static com.sunbeam.utils.HibernateUtils.getFactory;

public class AddProductDetails {
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter product details- category,Product Name, price,quantity");
			
			Product newProduct = new Product(Category.valueOf(sc.next().toUpperCase()),sc.next(),sc.nextDouble(),sc.nextInt());
			System.out.println(dao.AddProduct(newProduct));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}