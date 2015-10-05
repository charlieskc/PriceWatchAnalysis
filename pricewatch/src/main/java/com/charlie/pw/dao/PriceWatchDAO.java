package com.charlie.pw.dao;

import java.net.UnknownHostException;

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
		
		document.put("productId", p.getSku());
		document.put("productName", p.getName());
		document.put("category", p.getCategory());
		document.put("brand", p.getBrand());
		document.put("LastUpdDate", p.getLastUpdDate());
				 
		for(PriceWatch pw : p.getPriceList()){
			BasicDBObject priceDetail = new BasicDBObject();
			priceDetail.put("supermarket", pw.getMarketName());
			priceDetail.put("price", pw.getPrice());
			document.put("price", priceDetail);
		}
		
		DBCollection coll = getDBCollection("pricewatch");	
		 
		coll.insert(document);
	
	}
	
	
}
