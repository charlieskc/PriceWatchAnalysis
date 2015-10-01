package com.charlie.pw.vo;

import java.util.List;

public class Product {
	
	private String name;
	private String sku;
	private List <PriceWatch> priceList;
	
	
	public List<PriceWatch> getPriceList() {
		return priceList;
	}
	public void setPriceList(List<PriceWatch> priceList) {
		this.priceList = priceList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	
	
	
}
