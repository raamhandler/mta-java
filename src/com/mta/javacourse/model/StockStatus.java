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
	 * @param date 
	 * @param g 
	 * @param f 
	 * @param string 
	 */
	public StockStatus(String string, float f, float g, Date date, int i, Enum<ALGO_RECOMMENDATION> doNothing) {
		stockSymbol = "None";
		ask = 0;
		bid = 0;
		recommendation = ALGO_RECOMMENDATION.DO_NOTHING;
		stockQuantity = 0;
	}

	/**
	 * copy c'tor for stock status
	 * 
	 * @param stockStatus
	 */
	public StockStatus(StockStatus stockStatus) {
		setSymbol(stockStatus.getStockSymbol());
		setAsk(stockStatus.getAsk());
		setBid(stockStatus.getBid());
		this.date = new Date(stockStatus.date.getTime());
		setRecommendation(stockStatus.recommendation);
		setStockQuantity(stockStatus.stockQuantity);
	}
	/**
	 * copy c'tor for filling stock status fields according to stock members
	 * 
	 * @param Symbol
	 * @param ask
	 * @param bid
	 * @param date
	 */
	public StockStatus(String Symbol, float ask, float bid, Date date) {
		this(null);
		setSymbol(Symbol);
		setAsk(ask);
		setBid(bid);
		setDate(new Date(date.getTime()));
	}

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