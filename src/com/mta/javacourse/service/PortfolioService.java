package com.mta.javacourse.service;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.mta.javacourse.exception.BalanceException;
import com.mta.javacourse.exception.PortfolioFullException;
import com.mta.javacourse.exception.StockAlreadyExistsException;
import com.mta.javacourse.exception.StockNotExistException;
import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Portfolio.ALGO_RECOMMENDATION;
import com.mta.javacourse.model.Stock;
import com.mta.javacourse.model.StockStatus;

/**
 * Class for adding values into stock fields
 * 
 */
	public class PortfolioService {
	private final static int MAX_PROTFOLIO_SIZE = 5;
	Portfolio myPortfolio;
	

	/**
	 * function to create new portfolio
	 * and returns it
	 * 
	 * @return
	 */
	public Portfolio getPortfolio() throws StockAlreadyExistsException, PortfolioFullException, BalanceException, StockNotExistException,StockNotEnoughException{
		
		myPortfolio = new Portfolio ( new StockStatus[MAX_PROTFOLIO_SIZE], 0, "UNKNOWE",0);
		StockStatus stock1,stock2, stock3;
		
		Date date = new Date();
		
		stock1 = new StockStatus("PIH",(float)10,(float)8.5,date,0,ALGO_RECOMMENDATION.DO_NOTHING);
		myPortfolio.addStock(stock1);
		
		stock2 = new StockStatus("AAL",(float)30,(float)25.5,date,0,ALGO_RECOMMENDATION.DO_NOTHING);
		myPortfolio.addStock(stock2);
		
		stock3 = new StockStatus("CAAS",(float)20,(float)15.5,date,0,ALGO_RECOMMENDATION.DO_NOTHING);
		myPortfolio.addStock(stock3);
		myPortfolio.addStock(stock3);
		
		myPortfolio.setTitle("Potfolio #1");
		myPortfolio.setBalance(10000);
		myPortfolio.buyStock("PIH", 20);
		myPortfolio.buyStock("AAL", 30);
		myPortfolio.buyStock("CAAS", 40);
		myPortfolio.sellStock("AAL", -1);
		myPortfolio.removeStock("CAAS");
		
		return myPortfolio;
	}
}
 


