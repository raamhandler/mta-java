package com.mta.javacourse.model;

import java.util.Date;

/**
 * Class :  Creating a stock & portfolio 
 * @author Raam Handler
 */
public class Portfolio {

	public final static int MAX_PORFOLIO_SIZE = 5;

	private String title;
	private int portfolioSize;
	private Stock[] stocks;
	private StockStatus[] stocksStatus;
	private static enum ALGO_RECOMMENDATION {DO_NOTHING, BUY, SELL};
	private float balance;
	private int stockStatusSize;
	
	/**
	 * The constructor is used to initialize members with the default values.
	 *portfolioSize - size of the portfolio.
	 *stockStatusSize - size of the stock Status array.
	 *title - the title for this  portfolio.
	 *balance= the amount of money in the balance account.
	 *stocks= an array of stocks in the size of MAX_PORTFOLIO_SIZE.
	 *stockStatus - an array of stockStatus in the size of MAX_PORTFOLIO_SIZE.
	 */



	public Portfolio()
	{
		portfolioSize =0;
		stockStatusSize = 0;
		title = "PortfolioDefault";
		balance=0;
		stocks= new Stock[MAX_PORFOLIO_SIZE];
		stocksStatus = new StockStatus[MAX_PORFOLIO_SIZE];
	}
	
	// cto'r which receives a title
	
	public Portfolio (String title)
	{
		this ();
		this.setTitle(title);
	}

		
	 // Copy C'tor for making instance copies for Portfolio object
	
	
	public Portfolio(Portfolio portoflio)
	{
		this();
		for (int i = 0; i < portoflio.portfolioSize; i++)
		{	
			stocks[i]=new Stock(portoflio.stocks[i]);
			stocksStatus[i]=new StockStatus(portoflio.stocksStatus[i]);
		}
		title=portoflio.title;
		portfolioSize=portoflio.portfolioSize;
		stockStatusSize=portoflio.stockStatusSize;
		balance=portoflio.balance;
	}
	
	/**
	 * print a stockStatus to the console.
	 * @param stockStatus
	 */
	
	public void printStockStatus (StockStatus stockStatus)
	{
		System.out.println("symbol: "+stockStatus.symbol+
				"\n"+"ask: "+stockStatus.currentAsk+
				"\n"+"bid: "+stockStatus.currentBid+
				"\n"+"date: "+stockStatus.date);
	}
	
	/**
	 * This function is adding money to the current balance
	 * @param amount
	 */
	
	public void updateBalance(float amount)
	{
		balance=balance+amount;
	}
	
	/**
	 * This function takes the stock's current bid and multiply it by the amount of stocks.
	 * @return the values off all stocks
	 */
	
	public float getStocksValue()
	{
		float stocksValue=0;
		int i=0;
		while(stocksStatus[i]!=null)
		{
			stocksValue+=stocksStatus[i].currentBid*stocksStatus[i].stockQuantity;
			i++;
		}
		return stocksValue;
		
	}
	
	
	/**
	 * 
	 * @return sum of the balance account + the assets' money value  
	 */
	
	public float getTotalValue()
	{
		return getBalance()+getStocksValue();
	}
	
	
	 /** function for adding new stock in the portfolio
	*/
	
	public void addStock(Stock stock)
	{
		int i=0;
		while(stocks[i]!=null)
		{
			if (stocks[i].getStockSymbol().equals(stock.getStockSymbol())) 
			{
				System.out.println("This stock "+stock.getStockSymbol()+" already exists in portfolio");
				return;
			}
			i++;
		}
		if(portfolioSize==MAX_PORFOLIO_SIZE)
		{
			System.out.println("Can’t add new stock,"+ " portfolio can only have " +MAX_PORFOLIO_SIZE +" stocks");
		}
		else
		{
			StockStatus stockStatus = new StockStatus();
			stockStatus.currentAsk=stock.getAskOfType();
			stockStatus.currentBid=stock.getBid();
			stockStatus.symbol=stock.getStockSymbol();
			stockStatus.stockQuantity=0;
			stockStatus.date=new Date(stock.getDate().getTime());
			stockStatus.recommendation=ALGO_RECOMMENDATION.DO_NOTHING;
			
			this.stocksStatus[stockStatusSize]=stockStatus;
			stocks[portfolioSize]=stock;
			stockStatusSize++;
			portfolioSize++;
		}
	}

	
	/** function for removing a specific stock -from portfolio (according to symbolStock)
	 * 
	 */
	
	public boolean removeStock(String stockSymbol)
	{

		int i=0;
		boolean isFound=false;
		boolean isSold=false;
		for (; i < portfolioSize; i++)
		{
			if (stocksStatus[i].symbol.equals(stockSymbol))
			{
				isSold=sellStock(stockSymbol, -1);
				isFound=true;
				break;
			}
		}
		if (isFound==false) {
			System.out.println("The stock that you want find: " + stockSymbol+" hasn't found");
			return false;
		}
		else{
			if(isSold==true){

				for (; i < portfolioSize; i++)
				{

					if (stocks[i+1]==null)
					{
						portfolioSize--;
						stockStatusSize--;
						break;
					}
					else
					{
						stocks[i]=stocks[i+1];
						stocksStatus[i]=stocksStatus[i+1];
					}
				}
			}
			else 
			{
				System.out.println("the"+ stockSymbol+" hasn't been sold");
				return false;
			}
		}
		return isFound;
	}
   
	/**
	 * buyStock is used to purchase stocks, it updates the balance of the balance account.
	 * The first loop is used to identify that the stock is actually in the stocks' array.
	 * "-1" for buying all stocks with the money on the balance account.
	 * @param symbol
	 * @param quantity
	 * @return
	 */
	
	public boolean buyStock (String symbol,int quantity)
	{

		boolean Symbolfound=false;
		int amount;
		int i = 0;
		
		for (; i < portfolioSize; i++) 
		{
			if (stocks[i].getStockSymbol().equals(symbol)) 
			{
				Symbolfound=true;
				break;
			}
		}
		if(Symbolfound==true)
		{
			if (quantity==-1) 
			{
				amount=(int) Math.floor((balance/stocksStatus[i].currentAsk));
				balance=balance - amount*stocksStatus[i].currentAsk;
				return true;
			}
			else
			{
				if(stocksStatus[i].currentAsk*quantity>balance)
				{
					System.out.println("Not enough balance to complete purchase");
					return false;
				}
				stocksStatus[i].stockQuantity=stocksStatus[i].stockQuantity+quantity;
				balance=balance - stocksStatus[i].currentAsk*quantity;
				return true;
			}
		}
		else
		{
			System.out.println(symbol+" purchase has failed");
			return false;
		}
	}
	
	/** 
	 * sellStock is similar to buyStock, it purpose is to sell stocks but not to remove them from the portfolio.
	 * The first loop is used to identify that the stock is actually in the stocks' array.
	 * "-1" to sell all stocks
	 * @param symbol
	 * @param quantity
	 * @return
	 */
	
	public boolean sellStock (String symbol, int quantity)
	{
		boolean Symbolfound=false;
		int i = 0;
		
		for (; i < portfolioSize; i++) 
		{
			if (stocks[i].getStockSymbol().equals(symbol)) 
			{
				Symbolfound=true;
				break;
			}
		}
		if(Symbolfound==true)
		{
			if (quantity==-1) 
			{
				balance=balance+stocksStatus[i].stockQuantity*stocksStatus[i].currentBid;
				stocksStatus[i].stockQuantity=0;
				return true;
			}
			if (quantity==MAX_PORFOLIO_SIZE||quantity>MAX_PORFOLIO_SIZE||quantity<0) 
			{
				System.out.println(symbol+" hasn't been sold - Not enough stocks to sell");
				return false;
			}
			else
			{
				stocksStatus[i].stockQuantity=stocksStatus[i].stockQuantity-quantity;
				balance=balance + stocksStatus[i].currentBid*quantity;
				return true;
			}
		}
		else
		{
			System.out.println(symbol+" hasn't been sold");
			return false;
		}
		
		
	}
    
    //Setters & Getters:

    
	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
 
    
	public Stock[] getStocks()
	{
		return stocks;
	}

	public StockStatus[] getStocksStatus() {
		return stocksStatus;
	}

	public void setStocksStatus(StockStatus[] stocksStatus) {
		this.stocksStatus = stocksStatus;
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

	
	/**
	 * This method returns a string composed of the stocks' details.
	 * At the end of the string the total sum of the portfolio/stocks/balance is presented.
	 * @param none
	 * @return A string with the information of all stocks.
	 */
	
	public String getHtmlString1()
	{
		String HtmlString= new String("<h1><u>"+title+"</u></h1>"); 
		for (int i = 0; i < portfolioSize; i++) 
		{ 

			HtmlString=HtmlString+(stocks[i].getHtmlDescription()+"<br>");
		}
		HtmlString+="<br>"+"Total Portfolio Value: "+getTotalValue()
				+"$, "+"<br>"+"Total Stocks value:" + getStocksValue()
				+"$, "+"<br>"+"Balance: "+getBalance()+"$"+"<br>";

		return HtmlString;
	}
	
	 /** an inner class for- storing stock status
	*/
	
	public class StockStatus {

		final static int DO_NOTHING = 0;
		final static int staticBUY = 1;
		final static int SELL = 2;

		private String symbol;
		private float currentBid, currentAsk;
		private Date date;
		private ALGO_RECOMMENDATION recommendation;
		private int stockQuantity;
		
		 
		 // c'tor for initializing- stock status
		
		
		public	StockStatus()
		{
			symbol = "empty";
			currentAsk = 0;
			currentBid = 0;
			date = new Date();
			recommendation=ALGO_RECOMMENDATION.DO_NOTHING;
			stockQuantity = 0;
		}
		
		 // copy c'tor - stock status
		
		public StockStatus (StockStatus stockStatus)
		{
		      this();
              setSymbol(stockStatus.symbol);
              setCurrentAsk(stockStatus.currentAsk);
              setCurrentBid(stockStatus.currentBid);
              setDate(stockStatus.date);
              setRecommendation(stockStatus.recommendation);
              setStockQuantity(stockStatus.stockQuantity);
		}
		
		// Setter & Getter:
		
		public String getSymbol() {
			return symbol;
		}
		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}
		public float getCurrentBid() {
			return currentBid;
		}
		public void setCurrentBid(float currentBid) {
			this.currentBid = currentBid;
		}
		public float getCurrentAsk() {
			return currentAsk;
		}
		public void setCurrentAsk(float currentAsk) {
			this.currentAsk = currentAsk;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
	
		public void setRecommendation(Enum<ALGO_RECOMMENDATION> recommendation2) {
			this.recommendation = recommendation2;
		}
		public int getStockQuantity() {
			return stockQuantity;
		}
		public void setStockQuantity(int stockQuantity) {
			this.stockQuantity = stockQuantity;
		}
	}

	
}