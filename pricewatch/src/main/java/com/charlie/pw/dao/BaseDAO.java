package com.charlie.pw.dao;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public abstract class BaseDAO implements AutoCloseable{
	
	private MongoClient mongoClient;
	private DB db;
	
	public BaseDAO() throws UnknownHostException{
		if(db == null){
			connectDB();
		}
	}
	

	public void close() throws Exception{
		mongoClient.close();
	}

	private void connectDB() throws UnknownHostException{
		mongoClient = new MongoClient("192.168.99.101", 32771);
		db = mongoClient.getDB("pricewatch");
		
	}
	
	public DBCollection getDBCollection(String collection){
		return db.getCollection("priceCollection");
	}

	
	
}