package com.mta.javacourse.dto;

import java.util.List;

import com.mta.javacourse.model.StockStatus;

public class PortfolioEditDto {
	
	private String title;
	private List<StockStatus> stockStatusList;
	private float balance;
	
	public String getTitle() {
		return title;
	}
	public float getBalance() {
		return balance;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}	
	public List<StockStatus> getStockStatusList() {
		return stockStatusList;
	}
	public void setStockStatusList(List<StockStatus> stockStatusList) {
		this.stockStatusList = stockStatusList;
	}
}