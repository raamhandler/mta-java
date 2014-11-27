package com.mta.javacourse;

import java.util.Calendar;
import java.util.Date;

public class EX4 {

	private String stockName;
	
	private String stockdatails;
	
	
	float askOfType;
	
	float bid;
	
	Date d = new Date ();
	
	Calendar c = Calendar.getInstance();
	

	
	public EX4( ) {
	
		
		stockName = "Unknown";

	}
	
	public void setstockName(String name,) { //"set"+(member name in 
		
		
		stockName = name;
		askOfType = Type;
		bid = bid;
		
	
	}
	
	
	public String getstockName( ) { //"get"+(member name in camelCase)
		return stockName;
		String stockDatails = new String ( stockName + "<br>" +  askOfType + "<br>" + bid + "<br>" + d.getDate())
		
		resp.getWriter().println(stockDatails);
	}
}
