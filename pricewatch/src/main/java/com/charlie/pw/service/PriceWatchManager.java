package com.charlie.pw.service;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
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

	public static void exportCSV(HtmlTable table) throws Exception{
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String filename = "./price-data/" + formatter.format(date)+ ".csv";


		File file = new File(filename);

		// if file does not exists, then create it
		if (!file.exists()) 
			file.createNewFile();
		else 
			throw new Exception("File already exists - " + filename);


		try ( Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF8")))
		{

			for(HtmlTableRow row : table.getRows()){
				for(int i=1; i<row.getCells().size();i++) //skip the first cell value as it is checkbox
				{		
					HtmlTableCell cell = row.getCell(i);
					writer.write(removeSpecialChars(cell.asText()));
					if(cell != row.getCells().get(row.getCells().size()-1))
						writer.write(",");
					else
						writer.write("\n");
				}
			}

			writer.close();
		}

	}
	
	private static String removeSpecialChars(String s){
		return s.replace("\r\n", " ").replace(",", "-");
	}
}