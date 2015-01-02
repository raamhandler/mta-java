package com.mta.javacourse.model;

import java.util.Date;


import sun.util.resources.CalendarData;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class Stock {
	
	protected String stockSymbol;
    protected float ask;
	protected float bid;
	public float getAsk() {
		return ask;
	}

	public void setAsk(float ask) {
		this.ask = ask;
	}

	protected  java.util.Date date;
	protected  float quantity;
	
	protected Calendar cal = Calendar.getInstance();
	protected java.util.Date date = cal.getTime(); 

	DateFormat dateFt = new SimpleDateFormat("dd/MM/yy");

	
	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public Stock() {
		this.stockSymbol = "";
		this.ask = 0;
		this.bid = 0;
	}



	// copy c`tor:
	
	public Stock (String symbol, float ask, float bid, Date date)
	{
		this();
		setSymbol(symbol);
		setAsk(ask);
		setBid(bid);
		setDate(date);
	}
	
	public Stock (Stock stock)
	{
		this (stock.getStockSymbol(), stock.getAsk(), stock.getBid(), stock.getDate());
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
        		 + "<b> Stock Ask</b>: " +getAsk()
        		 + "<b> Bid</b>: " +getBid()
        		 + "<b> Stock Date</b>: " +getDate();
         return stockHtmlDetailsString;
 	}

}
	
	


