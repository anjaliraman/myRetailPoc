package com.poc.myRetail.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Product {
	
	@JsonProperty(value="id")
	private Long id;
	
	@JsonProperty(value="name")
	private String name;
	
	@JsonProperty(value="current_price")
	private Price price;
		
	public Product() {
		
	}
	
	public Product(Long id, String name, Price price) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
	}


	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}
	
	

}
