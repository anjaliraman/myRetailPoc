package com.test.myRetail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.myRetail.model.Product;
import com.test.myRetail.service.MyRetailService;

@RestController
public class MyRetailController {
	
	@Autowired
	private MyRetailService myRetailService;
	
	@RequestMapping(value="/products", method=RequestMethod.GET) 
	public List<Product> getProducts(){
		return myRetailService.getAllProducts();
	}
	
	@RequestMapping(value="/products/{id}", method=RequestMethod.GET) 
	public Product getProductById(@PathVariable long id){
		return myRetailService.getProductById(id);
	}
	
	
	@RequestMapping(value="/products", method=RequestMethod.POST) 
	public void addProduct(@RequestBody Product product){
		myRetailService.addProduct(product);
	}
	

}
