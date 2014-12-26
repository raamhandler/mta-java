package com.mta.javacourse.service;

import java.util.Calendar;
import java.util.Date;

import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;

 

public class PortfolioService {
 


        	public Portfolio getPortfolio() 
        	{

        		Portfolio myPortfolio= new Portfolio();
        		Stock stock1=new Stock();
        		Stock stock2=new Stock();
        		Stock stock3=new Stock();

        		stock1.setSymbol("PIH");
        		stock1.setAskOfType((float) 10);
        		stock1.setBid((float) 8.5);
        		stock1.setDate(new Date(114,11,15));
        		
        		
        		stock2.setSymbol("AAL");
        		stock2.setAskOfType((float) 30);
        		stock2.setBid((float) 25.5);
        		stock2.setDate(new Date(114,11,15));
        		
        		stock3.setSymbol("CAAS");
        		stock3.setAskOfType((float) 20);
        		stock3.setBid((float) 15.5);
        		stock3.setDate(new Date(114,11,15));
        		
        		myPortfolio.updateBalance(10000);
        		myPortfolio.addStock(stock1);
        		myPortfolio.addStock(stock2);
        		myPortfolio.addStock(stock3);

        		myPortfolio.title = "Exercise 7 portfolio";
        		myPortfolio.buyStock("PIH", 20);
        		myPortfolio.buyStock("AAL", 30);
        		myPortfolio.buyStock("CAAS", 40);
        		myPortfolio.sellStock("AAL", -1);
        		myPortfolio.removeStock("CAAS");

        		return myPortfolio;
        	}
        }
