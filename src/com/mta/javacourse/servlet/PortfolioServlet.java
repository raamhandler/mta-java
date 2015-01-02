package com.mta.javacourse.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.service.PortfolioService;
 


import java.io.IOException;
 
	@SuppressWarnings("serial")
	public class PortfolioServlet extends HttpServlet 
	{

		public void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws IOException {

			PortfolioService portfolioService = new PortfolioService();
			Portfolio portfolio = portfolioService.getPortfolio();
			resp.setContentType("text/html");

			//printing portfolio
			String portfolioPage = portfolio.getHtmlString();
			resp.getWriter().println(portfolioPage);
		}
	}