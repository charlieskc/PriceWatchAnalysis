package com.charlie.pw.core;

import java.util.ArrayList;
import java.util.List;

import com.charlie.pw.dao.PriceWatchDAO;
import com.charlie.pw.vo.PriceWatch;
import com.charlie.pw.vo.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        WebParser.parse();
        Product p = new Product();
        p.setName("Charlie");
        p.setSku("97259741");
        PriceWatch pw = new PriceWatch();
        pw.setPrice(12.5);
        pw.setMarketName("ParkNShop");
        List<PriceWatch> pwList = new ArrayList<PriceWatch>();
	    pwList.add(pw);
        p.setPriceList(pwList);
        
        PriceWatchDAO pwDao = new PriceWatchDAO();
        pwDao.addPriceWatch(p);
    }
}
