package com.charlie.pw.service;

import java.net.UnknownHostException;

import com.charlie.pw.dao.PriceWatchDAO;
import com.charlie.pw.vo.Product;

public class PriceWatchDaoManager {
	private PriceWatchDAO dao;
	
	public PriceWatchDaoManager() throws UnknownHostException{
		dao = new PriceWatchDAO();
	}
	
	public void addPriceWatch(Product p){
		dao.addPriceWatch(p);
	}
}
