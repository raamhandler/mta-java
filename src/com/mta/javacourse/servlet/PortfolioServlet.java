package com.mta.javacourse.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;
import com.mta.javacourse.service.PortfolioService;
 

import java.io.IOException;
 
	@SuppressWarnings("serial")
	public class PortfolioServlet extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws IOException {

			PortfolioService portfolioService = new PortfolioService();
			Portfolio portfolio = portfolioService.getPortfolio();
			@SuppressWarnings("unused")
			Stock[] stocks = portfolio.getStocks();
			resp.setContentType("text/html");
			
			//create a copy of the first portfolio.
			
			Portfolio portfolio1 = new Portfolio(portfolio);
			
			//set new title for new portfolio.
			
			portfolio1.setTitle("Portfolio num # 002");

			//printing 1st portfolio
			
			resp.getWriter().println(portfolio.getHtmlString());
			resp.getWriter().println("</br>");
			
			//printing 2nd portfolio
			
			resp.getWriter().println(portfolio1.getHtmlString());
			resp.getWriter().println("</br>");
			
			//remove 1st stock from 1st portfolio
			
			portfolio.removeStock(portfolio.getStocks()[0]);
			
			//printing the two portfolios (after remove)
			
			resp.getWriter().println("after portfolio1 1st stock remove--->" + "</br>");
			resp.getWriter().println(portfolio.getHtmlString() + "</br>");
			resp.getWriter().println(portfolio1.getHtmlString() + "</br>");

			//changing bid value of last stock in portfolio2
			
			portfolio1.getStocks()[2].setBid(55.55f);
			
			//printing the two portfolios  again
			
			resp.getWriter().println("after changing bid value of portfolio1 last stock is:" + "</br>");
			resp.getWriter().println(portfolio.getHtmlString() + "</br>");
			resp.getWriter().println();
			resp.getWriter().println(portfolio1.getHtmlString());
		}
	}
