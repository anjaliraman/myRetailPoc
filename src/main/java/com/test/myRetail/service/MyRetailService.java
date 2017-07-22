package com.test.myRetail.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.myRetail.dao.MyRetailRepository;
import com.test.myRetail.model.Product;

@Service
public class MyRetailService {
	
	@Autowired 
	private MyRetailRepository myRetailRepository;
	
//	private List<Product> products = new ArrayList<>(Arrays.asList(
//			new Product("Head First Java", new Long(123456), 10.00f),
//			new Product("Java Persisitence API", new Long(445566), 45.00f)
//			));
	
	public List<Product> getAllProducts() {
		List products = new ArrayList<>();
		myRetailRepository.findAll().forEach(products::add);
		return products;
	}
	
	public Product getProductById(long id) {
		return myRetailRepository.findOne(id);
	}
	
	public void addProduct(Product product){
		myRetailRepository.save(product);
		//products.add(product);
	}
	

}
