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
	public class StockStatus extends Stock {

	private ALGO_RECOMMENDATION recommendation;
	protected int stockQuantity;
	
	/**
	 * This constructor is used to initialize members in StockStatus
	 */
	public StockStatus (){
		
		super();
		recommendation=ALGO_RECOMMENDATION.DO_NOTHING;
		stockQuantity=0;
	}
	/**
	 * The copy constructor is used to duplicate an instance with all of his members.
	 * @param stockStatus
	 */
	public StockStatus (StockStatus stockStatus){
		
		super(stockStatus);
		recommendation=stockStatus.getRecommendation();
		stockQuantity=stockStatus.getStockQuantity();
	}
	
	public StockStatus(Stock stock) {
		super(stock);
	}
	public ALGO_RECOMMENDATION getRecommendation() {
		return recommendation;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
		this.recommendation = recommendation;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}	
	
}