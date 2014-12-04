
package com.mta.javacourse;
 
import java.io.IOException;
 


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.javacourse.model.Stock;
 
@SuppressWarnings("serial")
public class StockServlet extends HttpServlet {
        @SuppressWarnings("deprecation")
        public void doGet(HttpServletRequest req, HttpServletResponse resp)
                        throws IOException {

	                Stock s1 = new Stock();
	                Stock s2 = new Stock();
	                Stock s3 = new Stock();
	              
	                java.util.Date Date = new java.util.Date();
	 
	                Date.setDate(25);
	                Date.setMonth(11);
	                Date.setYear(2014);
	 
	                //PHI
	                
	                s1.setSymbol("PIH");
	                s1.setAsk(12.4f);
	                s1.setBid(13.1f);
	                s1.setDate(Date);
	 
	                //AAL
	                
	                s2.setSymbol("AAL");
	                s2.setAsk(5.5f);
	                s2.setBid(5.78f);
	                s2.setDate(Date);
	 
	                //CAAS
	                
	                s3.setSymbol("CAAS");
	                s3.setAsk(31.5f);
	                s3.setBid(31.2f);
	                s3.setDate(Date);
	 
	                resp.setContentType("text/html");
	 
	                resp.getWriter().println(s1.getHtmlDescription() + "<br>");
	                resp.getWriter().println(s2.getHtmlDescription() + "<br>");
	                resp.getWriter().println(s3.getHtmlDescription() + "<br>");
	 
	        }
	}


