package com.poc.myRetail.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProductPriceDao {
	
	@Id
	private long id;
	
	private double price;
	
	private String currencyCode;
	
	public ProductPriceDao(){
		
	}

	public ProductPriceDao(long productId, double price, String currencyCode) {
		super();
		this.id = productId;
		this.price = price;
		this.currencyCode = currencyCode;
	}

	public long getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setId(long productId) {
		this.id = productId;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	
	
}
