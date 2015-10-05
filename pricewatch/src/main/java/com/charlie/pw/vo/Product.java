package com.charlie.pw.vo;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Product {
	
	private String name;
	private String sku;
	private String category;
	private String brand;
	private List <PriceWatch> priceList = new ArrayList<PriceWatch>();
	private Date lastUpdDate;
	
	public void addPriceWatch(String marketName, double price){
		priceList.add(new PriceWatch(marketName, price));
	}
	
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Date getLastUpdDate() {
		return lastUpdDate;
	}

	public void setLastUpdDate(Date lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}
	
	
	
	
}
