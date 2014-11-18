package com.mta.javacourse;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Raam___checkServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//exp 1
		resp.setContentType("text/html");
		int num1, num2, num3;
		
		num1= 3;
		num2= 4;
		num3= 7;
		
		int result = (num1+num2)*num3;
		
		String resultStr=new String("Result of " + "(" + num1 + "+" + num2 + ")"+"*"+num3 +"="+ result) ;
		
				
		resp.getWriter().println(resultStr);
		//testing git
		
		//ex 2
		
		  //part1
		
        double circelArea;
        double radius;
        radius = 50;
        circelArea = Math.pow(radius, 2) * Math.PI;
        String circelAreaStr = new String("Area of circle with radius"+radius+"is"+circelArea+" square CM");
       
        //part2
        
        double oppositeLength;
        double angleB= 30;
        int hypotenuse= 50;
        angleB= Math.toRadians(angleB);
        oppositeLength= Math.sin(angleB)*hypotenuse;
        String result3Str= new String("Length of opposite where angle B is 30 degrees and Hypotenuse length is 50 cm is: "+oppositeLength+" cm");
       
        //part3
        double powerResult= Math.pow(20, 13);
        String result4Str=new String("Power of 20 with exp of 13 is: "+powerResult );
       
        String FinalStr= new String(resultStr + "<br>" + circelAreaStr + "<br>" + result3Str + "<br>" + result4Str);
        resp.getWriter().println(FinalStr);
		
	}
}