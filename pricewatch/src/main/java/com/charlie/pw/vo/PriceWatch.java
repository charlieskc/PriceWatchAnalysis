package com.charlie.pw.vo;

public class PriceWatch {
	
	private String marketName;
	private double price;
	private Product product;
	
	public PriceWatch(String marketName, double price){
		this.price = price;
		this.marketName = marketName;
	}
	
	public PriceWatch(){};
	
	public String getMarketName() {
		return marketName;
	}
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	


}
