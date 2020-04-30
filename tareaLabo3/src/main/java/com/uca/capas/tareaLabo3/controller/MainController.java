package com.uca.capas.tareaLabo3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.tareaLabo3.domain.Product;

@Controller
public class MainController {
	
	private List<Product> productos = new ArrayList<>();
	
	@GetMapping("/compraProducto")
	public ModelAndView compraProducto() {
		ModelAndView mav = new ModelAndView();
		
		productos.add(new Product(0, "wheat flour", 25));
		productos.add(new Product(1, "baking powder", 15));
		productos.add(new Product(2, "oil", 35));
		productos.add(new Product(3, "natural tomato sauce", 10));
		productos.add(new Product(4, "mushrooms", 25));
		productos.add(new Product(5, "mozzarella cheese", 50));
		productos.add(new Product(6, "pepperoni", 55));
		productos.add(new Product(7, "ham", 5));
		
		mav.setViewName("select");
		mav.addObject("product", new Product());
		mav.addObject("producto", productos);

		return mav;	
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product product) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("product", productos.get(product.getId()).getNombre());
		if(productos.get(product.getId()).getCantidad() >= product.getCantidad() && product.getCantidad() > 0) {
			mav.setViewName("compra");
		}else {
			mav.setViewName("error");
		}
		return mav;
	}
	

}
