package com.mta.javacourse.exception;

public class StockNotExistException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public StockNotExistException() {
		super("Sorry, The stock does not exist");
	}

}