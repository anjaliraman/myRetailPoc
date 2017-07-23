package com.test.myRetail.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.myRetail.dao.MyRetailRepository;
import com.test.myRetail.model.Price;
import com.test.myRetail.model.Product;

@Service
public class MyRetailService {
	
	@Autowired 
	private MyRetailRepository myRetailRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	String responseUrl = "http://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
	
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
	}

	public String getProductName() {
		try {
			ResponseEntity<String> responseEntity = restTemplate.getForEntity(responseUrl,String.class);		
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(responseEntity.getBody());
			JsonNode name = root.path("product").path("item").path("product_description").path("title");
			String title = name.asText();
			return title;
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		return null;
	}

	public String getPricingInfo(long id, String name) {
		
		
		
		return null;
	}

	public Product updatePriceInfo(long id, Price price) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
