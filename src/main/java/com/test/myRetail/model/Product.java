package com.test.myRetail.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Product {
	
	@Id
	@Column(name = "PRODUCT_ID", nullable = false)
	Long id;
	
	@JsonProperty(value="name")
	@Column(name = "NAME", nullable = false)
	String name;
	
	@Embedded
	@Column(name = "CURRENT_PRICE", nullable = false)
	@JsonProperty(value="current_price")
	Price price;
		
	public Product(){
		
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
