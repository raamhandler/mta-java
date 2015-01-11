package com.mta.javacourse.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.javacourse.exception.BalanceException;
import com.mta.javacourse.exception.PortfolioFullException;
import com.mta.javacourse.exception.StockAlreadyExistsException;
import com.mta.javacourse.exception.StockNotExistException;
import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.service.PortfolioService;
 






import java.io.IOException;
 
	@SuppressWarnings("serial")
	public class PortfolioServlet extends HttpServlet {


		public void doGet(HttpServletRequest req, HttpServletResponse resp)
				
				throws IOException{
			
			resp.setContentType("text/html");
			PortfolioService portfolioService = new PortfolioService();
			Portfolio portfolio1;
			try{
				portfolio1 = portfolioService.getPortfolio();
				resp.getWriter().println(portfolio1.getHtmlString());	
			}
			catch (PortfolioFullException e) {
				resp.getWriter().println("Sorry, You had reached maximum portfolio size!!!");
			}
			catch(StockAlreadyExistsException ee) {
				resp.getWriter().println("Sorry, Stock already exists!!!");			
			}
			catch(BalanceException eee) {
				resp.getWriter().println("Sorry, You do not have enough balane to buy this stock!!!");			
			}
			
			catch(StockNotExistException eeeee) {
				resp.getWriter().println("Sorry, The stock does not exist!!!");			
			}
			
					

		}

	}