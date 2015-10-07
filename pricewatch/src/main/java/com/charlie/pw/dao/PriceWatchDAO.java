package com.charlie.pw.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.charlie.pw.vo.PriceWatch;
import com.charlie.pw.vo.Product;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

public class PriceWatchDAO extends BaseDAO{

	public PriceWatchDAO() throws UnknownHostException {
		super();
		
	}

	public void addPriceWatch(Product p){
		
		BasicDBObject document = new BasicDBObject();
		List <BasicDBObject> priceDetailList = new ArrayList <BasicDBObject>();
		
		document.put("productId", p.getId());
		document.put("productName", p.getName());
		document.put("category", p.getCategory());
		document.put("brand", p.getBrand());
		document.put("LastUpdDate", p.getLastUpdDate());
				 
		for(PriceWatch pw : p.getPriceList()){
			BasicDBObject priceDetail = new BasicDBObject();
			priceDetail.put("supermarket", pw.getMarketName());
			priceDetail.put("price", pw.getPrice());
			priceDetailList.add(priceDetail);			
			document.put("price", priceDetailList);
		}
		
		DBCollection coll = getDBCollection("price-watch-collection");	
		 
		coll.insert(document);
	
	}
	
	public void dropCollection(String collection){
		DBCollection coll = getDBCollection(collection);	
		coll.drop();
	}
	
}
