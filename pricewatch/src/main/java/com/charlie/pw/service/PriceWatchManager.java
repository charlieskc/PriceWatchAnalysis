package com.charlie.pw.service;


import java.io.FileWriter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import com.charlie.pw.dao.PriceWatchDAO;
import com.charlie.pw.vo.Product;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

public class PriceWatchManager {
	private PriceWatchDAO dao;

	public PriceWatchManager() throws UnknownHostException{
		dao = new PriceWatchDAO();
	}

	public void addPriceWatch(Product p){
		dao.addPriceWatch(p);
	}

	public void exportCSV(List <Product> plist) throws IOException{

		String priceWatchDate = plist.get(0).getLastUpdDate().toString();

		try (FileWriter writer = new FileWriter(priceWatchDate + ".csv")){
			for(Product p:plist){


			}
			writer.write("hello");
			writer.close();
		}


	}

	public static void exportCSV(HtmlTable table) throws IOException{
		try (FileWriter writer = new FileWriter((new Date()).toString() + ".csv")){
			for(HtmlTableRow row : table.getRows()){
				for(HtmlTableCell cell : row.getCells()){
					writer.write((cell.asText()));
					if(cell != row.getCells().get(row.getCells().size()-1))
						writer.write(",");
					else
						writer.write("\n");
				}
			}
			writer.flush();
			writer.close();
		}
	}
}