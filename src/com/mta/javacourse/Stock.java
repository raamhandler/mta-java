package com.mta.javacourse;


public class Stock {
	
    private String stockSymbol;
	private float askOfType;
	private float Bid;
	private java.util.Date Date;
	
	// stockSymbol get & set
	
	 public String stockSymbol() {
         return stockSymbol;
 }
	 public void setSymbol(String symbol) {
		 stockSymbol = symbol;
 }

	 // askOfType get & set
	 
 	public float askOfType() {
         return askOfType;
 }
 	public void setAsk(float ask) {
	 askOfType = ask;
 }

 	//BID get & set
 	
 	public float Bid() {
         return Bid;
 }
 	public void setBid(float bid) {
         Bid = bid;
 }

 	//DATE
 	
 	public java.util.Date getDate() {
         return Date;
 }
 	public void setDate(java.util.Date date) {
         Date = date;
 }

 	
 	public String getHtmlDescription()
 { 		
         String stockHtmlDetailsString = "<b>Stock symbol</b>: " +stockSymbol() + "<b> Stock Ask</b>: " +askOfType() + "<b> Bid</b>: " +Bid() + "<b> Stock Date</b>: " +getDate();
         return stockHtmlDetailsString;
 }

}
	
	


