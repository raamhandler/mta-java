package com.mta.javacourse.service;

import java.util.Calendar;
import java.util.Date;

import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;

 

public class PortfolioService {
 
        Stock s1 = new Stock();
        Stock s2 = new Stock();
        Stock s3 = new Stock();
  
        public Portfolio getPortfolio ()
        {
                Portfolio myPortfolio = new Portfolio();
                Calendar c = Calendar.getInstance();
                c.set (2014, 12,11, 0, 0, 0);
                Date date = c.getTime();
               
                s1.setSymbol("PIH");
                s1.setAskOfType(10f);
                s1.setBid(8.5f);
                s1.setDate(date);
                s1.setQuantity(20);
                
                s2.setSymbol("AAL");
                s2.setAskOfType(30f);
                s2.setBid(25.5f);
                s2.setDate(date);
                s2.setQuantity(30);
                
                
                s3.setSymbol("CAAS");
                s3.setAskOfType(20f);
                s3.setBid(15.5f);
                s3.setDate(date);
                s3.setQuantity(40);
                
                myPortfolio.addStock(s1);
                myPortfolio.addStock(s2);
                myPortfolio.addStock(s3);
               
                return myPortfolio;
        }
}