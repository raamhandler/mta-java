package com.mta.javacourse.Servlet;
 
import java.io.IOException;
 


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 


import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;
import com.mta.javacourse.service.PortfolioService;


	@SuppressWarnings("serial")
	public class PortfolioServlet extends HttpServlet {
       
	

		public void doGet(HttpServletRequest req, HttpServletResponse resp)
                        throws IOException {
 
        PortfolioService portfolioService = new PortfolioService();
        Portfolio portfolio = portfolioService.getPortfolio();
        @SuppressWarnings("unused")
		Stock[] stocks = portfolio.getStocks();
       
        resp.setContentType("text/html");
        resp.getWriter().println(portfolio.getHtmlString());
        }
}
	
	
	

