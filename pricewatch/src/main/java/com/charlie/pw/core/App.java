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
        WebParser parser = new WebParser();
        parser.parse();
        
    }
}
