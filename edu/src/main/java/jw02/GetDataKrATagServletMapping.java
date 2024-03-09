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
		out.println("<li> �̸� : " +clientName);
		out.println("<li> �ּ� : " +clientAddr);

		out.println("<p><p><a href ='./jw02/getDataKrATagServletMapping.html'>�ڷ�</a>");

		out.println("<p><a href='GetDataKrATagServletMapping?name=ȫ�浿&addr=����'>"+"�ڱ��ڽ�</a>");


		out.println("</body>");
		out.println("</html>");


		
	}

}