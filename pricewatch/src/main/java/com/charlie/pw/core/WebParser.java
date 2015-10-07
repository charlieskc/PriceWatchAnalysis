package com.charlie.pw.core;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.charlie.pw.service.PriceWatchManager;
import com.charlie.pw.vo.PriceWatch;
import com.charlie.pw.vo.Product;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;


public class WebParser {
	
	private static String url = "http://www3.consumer.org.hk/pricewatch/supermarket/index.php?view=0&filter1=&filter2=&filter3=";
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	
	public List<Product> parse() throws Exception {
		
		List<Product> pList = new ArrayList<Product>();
		Product p;
		PriceWatch pw;
		
	    WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38);
	   
	    HtmlPage page = (HtmlPage) webClient.getPage(url);
	    
	    //get the form "itemlist"
	    HtmlForm form = (HtmlForm) page.getElementByName("itemlist");
	    //get the 2nd table which contains the price details
	    HtmlTable table = (HtmlTable)form.getElementsByTagName("table").item(2);

	    PriceWatchManager.exportCSV(table);
	    
	    
	    for(HtmlTableRow row : table.getRows()){
	    	p = new Product();
	    	//skip the header
	    	if(row == table.getRow(0)){
	    		continue;
	    	}
	    	
	    	String cat = row.getCell(1).asText();
	    	String brand = row.getCell(2).asText();
	    	String name = row.getCell(3).asText();
	    	double welcomePrice = toDouble(row.getCell(4).asText());
	    	double ParkNShopPrice = toDouble(row.getCell(5).asText());
	    	double marketPlacePrice = toDouble(row.getCell(6).asText());
	    	double wingWongPrice = toDouble(row.getCell(7).asText());
	    	double DaiChungPrice = toDouble(row.getCell(8).asText());
	    	Date date = sdf.parse(row.getCell(9).asText());
	    	
	    	p.setName(name);
	    	p.setBrand(brand);
	    	p.setCategory(cat);
	    	p.setLastUpdDate(date);
	    	p.addPriceWatch("Welcome", welcomePrice);
	    	p.addPriceWatch("ParkNShop", ParkNShopPrice);
	    	p.addPriceWatch("Market Place", marketPlacePrice);
	    	p.addPriceWatch("Wing Wong", wingWongPrice);
	    	p.addPriceWatch("DaiChung", DaiChungPrice);
	    	
	    	pList.add(p);
	    	
	  
	    	PriceWatchManager daoManager = new PriceWatchManager();
	    	daoManager.addPriceWatch(p);
	    	
	    	//pw.setPrice(Double.parseDouble(row.getCell(4).asText().replace('$', ' ').trim()));
	    
	    	for(HtmlTableCell cell : row.getCells()){
	    		System.out.print(cell.asText());
		    	if(cell != row.getCells().get(row.getCells().size()-1))
		    		System.out.print(",");
		    	else
		    		System.out.println();
	    	}
	    }
	    //System.out.println(table.asXml());
	    return pList;
	   
	}

	public double toDouble(String s){
		s = s.replace('$', ' ').trim();
		if (s.equals("--"))
			return -1;
		return Double.parseDouble(s);
	}

}

