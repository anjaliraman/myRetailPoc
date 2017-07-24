package com.test.myRetail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.myRetail.dto.Product;
import com.test.myRetail.service.MyRetailService;

@RestController
public class MyRetailController {
	
	@Autowired
	private MyRetailService myRetailService;
	

	@RequestMapping(value="/products/{id}", method=RequestMethod.GET) 
	public @ResponseBody Product getProductDetailsById(@PathVariable long id){
		return myRetailService.getProductDetailsById(id);
	}

	@RequestMapping(value="/products/{id}", method=RequestMethod.PUT) 
	public void updatePricingInfo(@PathVariable long id,@RequestBody Product body){
		myRetailService.updatePriceInfo(id, body);
	}
	
}
