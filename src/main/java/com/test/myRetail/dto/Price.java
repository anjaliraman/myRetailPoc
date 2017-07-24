package com.test.myRetail.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Price {
	
	@JsonProperty(value="value")
	private double value;
	

	@JsonProperty(value="currency_code")
	private String currencyCode;
	
	public Price(){
		
	}

	public Price(double value, String currencyCode) {
		super();
		this.value = value;
		this.currencyCode = currencyCode;
	
	}

	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
}
