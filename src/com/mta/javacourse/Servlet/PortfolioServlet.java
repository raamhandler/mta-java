package com.mta.javacourse.Servlet;
 
import java.io.IOException;
 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;
import com.mta.javacourse.service.PortfolioService;


	public class PortfolioServlet extends HttpServlet {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void doGet(HttpServletRequest req, HttpServletResponse resp)
                        throws IOException {
 
        PortfolioService portfolioService = new PortfolioService();
        Portfolio portfolio = portfolioService.getPortfolio();
        Stock[] stocks = portfolio.getStocks();
       
        resp.setContentType("text/html");
        resp.getWriter().println(portfolio.getHtmlString());
        }
}
	
	
}
