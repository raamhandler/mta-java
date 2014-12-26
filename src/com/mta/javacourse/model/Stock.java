package com.mta.javacourse.model;

import java.util.Date;


public class Stock {
	
    private String stockSymbol;
	private float askOfType;
	private float bid;
	private java.util.Date date;
	private float quantity;
	
	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public Stock()
	{
		stockSymbol = " ";
		askOfType = 0;
		bid = 0;
		date = new Date();
	}

	// copy c`tor:
	
	public Stock (String symbol, float ask, float bid, Date date)
	{
		this();
		setSymbol(symbol);
		setAskOfType(ask);
		setBid(bid);
		setDate(date);
	}
	
	public Stock (Stock stock)
	{
		this (stock.getStockSymbol(), stock.getAskOfType(), stock.getBid(), stock.getDate());
	}
	
	
	//  Getter & Setter:
	
	public String stockSymbol() {
         return stockSymbol;
	}
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public float getAskOfType() {
		return askOfType;
	}
	public void setAskOfType(float askOfType) {
		this.askOfType = askOfType;
	}
	public float getBid() {
		return bid;
	}
	public void setSymbol(String symbol) {
		 stockSymbol = symbol;
	} 
	 public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public void setBid(float bid) {
		this.bid = bid;
	} 
 	
 	public String getHtmlDescription()
 	{ 		
         String stockHtmlDetailsString =
        		 "<b>Stock symbol</b>: "+getStockSymbol()
        		 + "<b> Stock Ask</b>: " +getAskOfType()
        		 + "<b> Bid</b>: " +getBid()
        		 + "<b> Stock Date</b>: " +getDate();
         return stockHtmlDetailsString;
 	}

}
	
	


