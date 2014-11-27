package com.mta.javacourse;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Raam___checkServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		//EX 1
		resp.setContentType("text/html");
		int num1, num2, num3;
		
		num1= 3;
		num2= 4;
		num3= 7;
		
		int result = (num1+num2)*num3;
		
		String resultStr=new String("Result of " + "(" + num1 + "+" + num2 + ")"+"*"+num3 +"="+ result) ;
		
				
	
		
		//EX 2
		
		  //part1
		
        double circelArea;
        double radius;
        radius = 50;
        circelArea = Math.pow(radius, 2) * Math.PI;
        String circelAreaStr = new String("Area of circle with radius "+radius+" is "+circelArea);
       
        //part2
        
        double oppositeLength;
        double angleB= 30;
        int hypotenuse= 50;
        angleB= Math.toRadians(angleB);
        oppositeLength= Math.sin(angleB)*hypotenuse;
        String result3Str= new String("Length of opposite where angle B is "+ angleB + " degrees and Hypotenuse length is "+ hypotenuse+ " cm is: "+   oppositeLength+" cm");
       
        //part3
        int num4, num5;
        num4=20;
        num5=13;
        double powResult= Math.pow(num4, num5);
        String result4Str=new String("Power of "+ num4+ "with exp of " + num5+ " is: "+ (long) powResult );
       
        String FinalStr= new String(resultStr + "<br>" + circelAreaStr + "<br>" + result3Str + "<br>" + result4Str);
        resp.getWriter().println(FinalStr);
		
	}
	
		
	
}