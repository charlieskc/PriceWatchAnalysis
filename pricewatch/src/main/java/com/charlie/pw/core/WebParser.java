package com.charlie.pw.core;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;


public class WebParser {
	
	static String url = "http://www3.consumer.org.hk/pricewatch/supermarket/index.php?view=0&filter1=&filter2=&filter3=";
	
	public static void parse() throws Exception {
		
	    WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38);
	   
	    HtmlPage page = (HtmlPage) webClient.getPage(url);
	    //get the form "itemlist"
	    HtmlForm form = (HtmlForm) page.getElementByName("itemlist");
	    //get the 2nd table which contains the price details
	    HtmlTable table = (HtmlTable)form.getElementsByTagName("table").item(2);

	    
	    for(HtmlTableRow row : table.getRows()){
	    	for(HtmlTableCell cell : row.getCells()){
	    		System.out.print(cell.asText());
		    	if(cell != row.getCells().get(row.getCells().size()-1))
		    		System.out.print(",");
		    	else
		    		System.out.println();
	    	}
	    }
	    //System.out.println(table.asXml());
	   
	}

	
	public static HtmlTable getTableFromDomElement(DomElement element) throws Exception{
		
		if(element instanceof com.gargoylesoftware.htmlunit.html.HtmlTable){
			System.out.println("----YES!!!!-----");
			HtmlTable table = (HtmlTable) element;
			return table;
		}
			
		for(DomElement e : element.getChildElements()){			
				getTableFromDomElement(e);
		    }

		throw new Exception("No HTML table found");
	}
}

