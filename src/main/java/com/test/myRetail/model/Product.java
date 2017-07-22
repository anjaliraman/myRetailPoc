package com.test.myRetail.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	Long id;
	
	@JsonProperty
	String name;
	
	@JsonProperty
	float price;
	//Price price;
	
	public Product(){
		
	}
	
	public Product(String name, Long id, float price) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
		//this.price = price;;
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

//	public Price getPrice() {
//		return price;
//	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

//	public void setPrice(Price price) {
//		this.price = price;
//	}
	
	
	
}
