package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Product;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class DeleteProduct {
public static void main(String[] args) {
	try(SessionFactory sf = getFactory();Scanner sc = new Scanner(System.in)){
		
		Product dao = new ProductDaoImpl();
		System.out.println("Enter product name for deleting the product details");
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
