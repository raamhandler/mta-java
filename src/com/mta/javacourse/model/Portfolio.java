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

	public Portfolio()
	{
		portfolioSize = 0;
		setTitle ("Portfolio  num # 001");
		stocks = new Stock[MAX_PORFOLIO_SIZE];
		stocksStatus = new StockStatus[MAX_PORFOLIO_SIZE];
	}
	
	// cto'r which receives a title
	
	public Portfolio (String title)
	{
		this ();
		this.setTitle(title);
	}


	 // Copy C'tor for making instance copies for Portfolio object
	
	public Portfolio(Portfolio portfolio)
	{
		this(portfolio.getTitle());
		setPortfolioSize(portfolio.getPortfolioSize());

	     for (int i = 0; i < portfolioSize; i++) 
             stocks[i] = new Stock(portfolio.getStocks()[i]);

	     for(int i = 0; i < portfolioSize; i++)
                 stocksStatus[i] = new StockStatus(portfolio.getStocksStatus()[i]);     
	}

	
	 // function for adding new stock in the portfolio
	
	public void addStock(Stock stock)
	{
		if (portfolioSize < MAX_PORFOLIO_SIZE)
		{
			stocks [portfolioSize] = stock;
			stocksStatus[portfolioSize] = new StockStatus();
			portfolioSize++;
		}
	}
	
	//  function for removing a specific stock -from portfolio (according to symbolStock)
	 
    public void removeStock(Stock stock)
    {
            for(int i = 0; i < portfolioSize; i++)
            {
                    if(this.stocks[i].getStockSymbol().equals(stock.getStockSymbol()))
                    {
                            if(i != portfolioSize-1 && portfolioSize > 1)
                                    for(int j = i; j < portfolioSize-1; j++)
                                    {
                                            this.stocks[j] = new Stock(this.stocks[j+1]);
                                    }
                    }
            }
            portfolioSize--;
    }
	
    //Setters & Getters:
    
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

	public String getHtmlString()
	{
		String res = "<h1>" + getTitle() + "</h1>";
		int i = 0;
		while (i < portfolioSize)
		{
			res+= stocks[i].getHtmlDescription() + "<br>";
			i++;
		}
		return res;
	}
	
	 // an inner class for- storing stock status
	
	public class StockStatus {

		final static int DO_NOTHING = 0;
		final static int staticBUY = 1;
		final static int SELL = 2;

		private String symbol;
		private float currentBid, currentAsk;
		private Date date;
		private int recommendation;
		private int stockQuantity;
		
		 
		 // c'tor for initializing- stock status
		
		
		public	StockStatus()
		{
			symbol = "empty";
			currentAsk = 0;
			currentBid = 0;
			date = new Date();
			recommendation = DO_NOTHING;
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
		public int getRecommendation() {
			return recommendation;
		}
		public void setRecommendation(int recommendation) {
			this.recommendation = recommendation;
		}
		public int getStockQuantity() {
			return stockQuantity;
		}
		public void setStockQuantity(int stockQuantity) {
			this.stockQuantity = stockQuantity;
		}
	}

}