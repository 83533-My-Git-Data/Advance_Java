package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;

import static com.sunbeam.utils.HibernateUtils.getFactory;

public class DisplayProductByCategoryNPrice {
public static void main(String[] args) {
	try(SessionFactory sf = getFactory();
			Scanner sc = new Scanner(System.in)){
		
		ProductDao dao = new ProductDaoImpl();
		System.out.println
		("Enter max price and min price and category of product:");
		
//		System.out.println(dao.displayProdByCateNdPrice(sc.nextDouble(), sc.nextDouble(), Category.valueOf(sc.next().toUpperCase()))
//);
		dao.displayProdByCateNdPrice(sc.nextDouble(), sc.nextDouble(), Category.valueOf(sc.next().toUpperCase()))
				.forEach(System.out::println);
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
