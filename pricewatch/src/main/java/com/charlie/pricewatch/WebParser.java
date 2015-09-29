package com.charlie.pricewatch;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;



public class WebParser {
	
	String url = "http://www3.consumer.org.hk/pricewatch/supermarket/index.php?view=0&filter1=001&filter2=001&filter3=001";
	
	public static void parse() throws Exception {
		
	    WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38);
	   
	    HtmlPage page = (HtmlPage) webClient.getPage(url);
	    System.out.println(page.asText());
	   
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

