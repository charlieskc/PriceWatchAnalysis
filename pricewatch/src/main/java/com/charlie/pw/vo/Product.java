package com.charlie.pw.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
	
	@Id
	private String id;
	private String name;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	 @Override
	    public String toString() {
	        return String.format(
	                "Product[id=%s, name='%s', category='%s']",
	                id, name, category);
	    }
	
	
	
}
