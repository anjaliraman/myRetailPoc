package com.test.myRetail.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class Price {
	
	@JsonProperty
	@Column(name = "VALUE", nullable = false)
	float value;
	
	
	@JsonProperty(value="currency_code")
	@Column(name = "CURRENCYCODE", nullable = false)
	String currencyCode;
	
	@OneToOne(optional=false)
    @JoinColumn(name = "PRODUCT_ID") 
	Product product;
	
	public Price(){
		
	}

	public Price(float value, String currencyCode) {
		super();
		this.value = value;
		this.currencyCode = currencyCode;
	}

	public float getValue() {
		return value;
	}
	
	public void setValue(float value) {
		this.value = value;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	
	
}
