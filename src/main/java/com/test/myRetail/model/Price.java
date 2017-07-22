package com.test.myRetail.model;

public class Price {
	double value;
	String currencyCode;
	public double getValue() {
		return value;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
}
