package com.mta.javacourse.model;

import java.util.Date;
import java.util.logging.Logger;

import com.mta.javacourse.exception.BalanceException;
import com.mta.javacourse.exception.PortfolioFullException;
import com.mta.javacourse.exception.StockAlreadyExistsException;
import com.mta.javacourse.exception.StockNotExistException;

/**
 * Class :  Creating a stock & portfolio 
 * @author Raam Handler
 */
public class Portfolio {
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(Portfolio.class.getSimpleName());
	public final static int MAX_PORFOLIO_SIZE = 5;
	private static final int MAX_PROTFOLIO_SIZE = 0;
	public enum ALGO_RECOMMENDATION {DO_NOTHING, BUY, SELL};

	private String title;
	private int portfolioSize;
	private float balance;
	private StockStatus[] stockStatus;

	/**
	 * c'tor for initializing portfolio members
	 */
	public Portfolio() {
		portfolioSize = 0;
		balance = 0;
		setTitle("");
		stockStatus = new StockStatus[MAX_PORFOLIO_SIZE];
	}

	/**
	 * cto'r which receives a title and calls 1st cto'r for setting it
	 * 
	 * @param title
	 */
	public Portfolio(String title) {
		this();
		this.setTitle(title);
	}

	/**
	 * copy c'tor for making instance copies of Portfolio object
	 * 
	 * @param portfolio
	 */
	public Portfolio(Portfolio portfolio) {
		this.setTitle(portfolio.getTitle());
		this.setPortfolioSize(portfolio.getPortfolioSize());
		this.setBalance(portfolio.getBalance());

		for (int i = 0; i < portfolioSize; i++)
			stockStatus[i] = new StockStatus(portfolio.getStocksStatus()[i]);
	}

	/**
	 * function for adding new stock to portfolio within portfolio size limits
	 * 
	 * @param stock
	 */
	public void addStock(Stock stock) throws StockAlreadyExistsException, PortfolioFullException{
		if(this.portfolioSize<MAX_PROTFOLIO_SIZE){
			for(int i=0; i<=portfolioSize-1; i++){
				if(stock.getStockSymbol().equals(this.stockStatus[i].getStockSymbol())){
					log.warning("Sorry, Stock " + stock.getStockSymbol() + " already exists");
					throw new StockAlreadyExistsException(stock.getStockSymbol());
				}
			}
			stockStatus[portfolioSize] = new StockStatus(stock.getStockSymbol(), stock.getAsk(), stock.getBid(), stock.getDate(),0 ,ALGO_RECOMMENDATION.DO_NOTHING);
			portfolioSize++;
		}
		else{
			log.warning("Sorry, You had reached maximum portfolio size [" + MAX_PROTFOLIO_SIZE + "]");
			throw new PortfolioFullException();
		}
	}
	
	

	/**
	 * function for removing a specific stock from portfolio (according to its symbol)
	 * 
	 * @param stock
	 */
	public void removeStock(String symbol) throws StockNotExistException{
		for(int i = 0; i<=portfolioSize-1; i++){
			if(symbol.equals(this.stockStatus[i].getStockSymbol())){
				this.sellStock(symbol,-1);
				this.portfolioSize--;
				for(int j=i; j<=portfolioSize-1; j++){
					this.stockStatus[j] = this.stockStatus[j+1];
					
				}
			
			}
					
		}
		log.warning("Sorry, The stock isnt exist");
		throw new StockNotExistException();
	}
		
		
		/**
	 * function for selling stocks and updating portfolio balance
	 * 
	 * @param symbol
	 * @param quantity
	 * @return
	 */
	public void sellStock(String symbol, int qu) throws StockNotExistException,StockNotExistException{
		for(int i=0; i<=portfolioSize-1 ; i++ ){
			if(symbol.equals(this.stockStatus[i].getStockSymbol()) && qu == -1 ||symbol.equals(this.stockStatus[i].getStockSymbol()) && this.stockStatus[i].getQuantity() == qu){
				this.updateBalance(this.stockStatus[i].bid*this.stockStatus[i].getQuantity());
				this.stockStatus[i].setQuantity(0);
				}
			else if(symbol.equals(this.stockStatus[i].getStockSymbol()) && this.stockStatus[i].getQuantity()>qu){
				this.updateBalance(this.stockStatus[i].bid*qu);
				this.stockStatus[i].setQuantity(-qu);
			}
			else if(symbol.equals(this.stockStatus[i].getStockSymbol()) && this.stockStatus[i].getQuantity()<qu){
				log.warning("Sorry, You do not have enough from this stock");
				throw new StockNotExistException();
			}
		}
		log.warning("Sorry, The stock does not exist");
		throw new StockNotExistException();
	}
	
	/**
	 * function for buying stocks and updating portfolio balance
	 * 
	 * @param symbol
	 * @param quantity
	 * @return
	 */
		public void buyStock(String symbol, int qu) throws BalanceException, StockNotExistException{
			for(int i=0; i<=portfolioSize-1; i++ ){
			
				if(symbol.equals(this.stockStatus[i].getStockSymbol()) && qu == -1){
					this.stockStatus[i].setStockQuantity((int)(this.balance/this.stockStatus[i].ask));
					this.updateBalance(-1*this.stockStatus[i].ask*this.stockStatus[i].getStockQuantity());
				}
				
				else if(symbol.equals(this.stockStatus[i].getStockSymbol()) && this.balance>this.stockStatus[i].ask*qu){
					this.stockStatus[i].setStockQuantity(qu);
					this.updateBalance(this.stockStatus[i].ask*qu*-1);
				}
			
				else if (symbol.equals(this.stockStatus[i].getStockSymbol()) && this.balance<this.stockStatus[i].ask*qu){
					log.warning("Sorry, You do not have enough balane to buy this stock");
					throw new BalanceException();
				}
			}
			log.warning("Sorry, The stock does not exist");
			throw new StockNotExistException();
		}
	/**
	 * function for updating balance when buying/selling stocks
	 * 
	 * @param amount
	 */
	public void updateBalance(float amount) {
		balance += amount;
	}

	/**
	 * function for returning total value of all stocks
	 * @return
	 */
	public float getStocksValue()
	{
		float res = 0;
		for (int i = 0; i < portfolioSize; i++)
			res+=stockStatus[i].getStockQuantity() * stockStatus[i].getBid();
		return res;
	}
	/**
	 * function for returning total portfolio value (balance+stocks value)
	 * 
	 * @return
	 */
	public float getTotalValue()
	{
		return (getBalance() + getStocksValue());
	}

	/**
	 * creates html-string from all stocks in portfolio
	 * 
	 * @return
	 */
	public String getHtmlString() {
		String res = "<h1><center>" + getTitle() + "</center></h1>" + "<br>";
		res+="<b> Total Portfolio Value: </b>" + getTotalValue() + "$ <b>Total Stocks Value: </b>" + getStocksValue() + "$" + " <b>Balance:</b> " + getBalance() +"$" + "<br>" + "<br>" + "<b>Portfolio Stocks:</b>" + "<br>";

		int i = 0;
		while (i < portfolioSize) {
			res += stockStatus[i].getHtmlDescription() + "<br>";
			i++;
		}
		return res;
	}

	// Setters & Getters-->
	
	public StockStatus[] getStock(){
		return stockStatus;
	}

	public StockStatus[] getStocksStatus() {
		return stockStatus;
	}

	public void setStockStatus(StockStatus[] stockStatus) {
		this.stockStatus = stockStatus;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPortfolioSize() {
		return portfolioSize;
	}

	public void setPortfolioSize(int portfolioSize) {
		this.portfolioSize = portfolioSize;
	}

	public float getBalance()
	{
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
}