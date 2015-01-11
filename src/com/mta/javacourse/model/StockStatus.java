package com.mta.javacourse.model;

import java.util.Date;

import com.mta.javacourse.model.Portfolio.ALGO_RECOMMENDATION;
/**
 * Class for storing stock status values
 * Inherits members from stock class
 * 
 * @author Raam Handler
 *
 */
public class StockStatus extends Stock  {

	private ALGO_RECOMMENDATION recommendation;
	private int stockQuantity;

	/**
	 * 
	 * c'tor for initializing stock status fields (based on inherited stock members)
	 * @param doNothing 
	 * @param i 
	 * @param date2 
	 * @param date 
	 * @param g 
	 * @param f 
	 * @param string 
	 */
	public StockStatus(String string, float Ask, float Bid, Date date1,int newStockQuntity, ALGO_RECOMMENDATION recom) {
		super(string, Ask, Bid, date1);
		// TODO Auto-generated constructor stub
		stockQuantity = newStockQuntity;
		recommendation = recom;
	}

	/**
	 * copy c'tor for stock status
	 * 
	 * @param stockStatus
	 */
	
	
	public ALGO_RECOMMENDATION getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
		this.recommendation = recommendation;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	
}