package jw02;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class GetDataKrATagServletMapping extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws
		ServletException,IOException{

		
		req.setCharacterEncoding("EUC_KR");

		
		res.setContentType("text/html;charset = EUC_KR");
		PrintWriter out = res.getWriter();

		String clientName = req.getParameter("name");
		String clientAddr = req.getParameter("addr");
	

		System.out.println(clientName+" : "+clientAddr);


		out.println("<html>");
		out.println("<head><title>GetDataKrATag.java</title></head>");
		out.println("<body>");
	

		out.println("<h2>Get Test </h2>");
		out.println("<li> 이름 : " +clientName);
		out.println("<li> 주소 : " +clientAddr);

		out.println("<p><p><a href ='./jw02/getDataKrATagServletMapping.html'>뒤로</a>");

		out.println("<p><a href='GetDataKrATagServletMapping?name=홍길동&addr=서울'>"+"자기자신</a>");


		out.println("</body>");
		out.println("</html>");


		
	}

}