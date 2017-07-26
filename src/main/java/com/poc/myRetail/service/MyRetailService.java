package com.poc.myRetail.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DBObject;
import com.poc.myRetail.dao.MyRetailRepository;
import com.poc.myRetail.dto.Price;
import com.poc.myRetail.dto.Product;
import com.poc.myRetail.model.ProductPriceDao;

@Service
public class MyRetailService {
	
	@Autowired 
	private MyRetailRepository myRetailRepository;
	
	@Autowired
	RestTemplate restTemplate;

	
	private static String responseUrl = "http://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
	
	public Product getProductDetailsById(long id) {
		String productName = getProductName();
		//get price details from DB
		ProductPriceDao productDao = myRetailRepository.findOne(id);		
		Product p = new Product(id, productName, new Price(productDao.getPrice(),productDao.getCurrencyCode()));
		return p;
		
	}

	public String getProductName() {
		try {
		
			HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	        
	        ResponseEntity<String> responseEntity = restTemplate.exchange(responseUrl, HttpMethod.GET, entity, String.class);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(responseEntity.getBody());
			JsonNode name = root.path("product").path("item").path("product_description").path("title");
			String title = name.asText();
			return title;
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		return "Not Found";
	}

	public String updatePriceInfo(long id, Product p) {
		double priceValue = p.getPrice().getValue();
		String currencyCode = p.getPrice().getCurrencyCode();
		
		ProductPriceDao prodPriceDao = myRetailRepository.findOne(id);
		prodPriceDao.setPrice(priceValue);
		prodPriceDao.setCurrencyCode(currencyCode);
		
		myRetailRepository.save(prodPriceDao);
		return "Done";
	}
}
