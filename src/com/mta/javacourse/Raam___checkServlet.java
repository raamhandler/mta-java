package com.mta.javacourse;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Raam___checkServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		resp.setContentType("text/html");
		int num1, num2, num3;
		
		num1= 3;
		num2= 4;
		num3= 7;
		
		int result = (num1+num2)*num3;
		
		String resultStr=new String("Result of " + "(" + num1 + "+" + num2 + ")"+"*"+num3 +"="+ result) ;
		
				
		resp.getWriter().println(resultStr);
	}
}