package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;

import static com.sunbeam.utils.HibernateUtils.getFactory;

public class ApplyDiscount {
	public static void main(String[] args) {
		try(SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)){
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter category and discount amount -");
			System.out.println(dao.applyDiscount(Category.valueOf(sc.next().toUpperCase()), sc.nextDouble()));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
