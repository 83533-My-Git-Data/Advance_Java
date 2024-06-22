package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	public ProductController() {
		System.out.println("in ctor" +getClass());
	
	}
	@GetMapping("/view")
	public String getProductList(@RequestParam double minPrice , double maxPrice,Model model)
	{
		model.addAttribute("product_list", productService.getProductsByPrice(minPrice, maxPrice));
		return "products/view";
		
	}
	
}
