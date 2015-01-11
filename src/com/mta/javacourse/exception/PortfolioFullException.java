package com.mta.javacourse.exception;

public class PortfolioFullException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PortfolioFullException() {
		super("Sorry, You had reached maximum portfolio size!");
	}

}