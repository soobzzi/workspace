package jw05;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionUseCookieOne
 */
//@WebServlet("/SessionUseCookieTwo")
public class SessionUseCookieTwo extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
	
		
		req.setCharacterEncoding("EUC_KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		
		Cookie[] cookies = req.getCookies();
		
		if(cookies != null) {			
			for (int i = 0; i < cookies.length; i++) {
				
				System.out.println("\nCookie에 저장된 정보: ");
				System.out.println("cookie[i].getName(): "+cookies[i].getValue());
				System.out.println("\n");
			}
		}
				
		HttpSession session = req.getSession(false);
		
			
			out.println("<html><head></head>");
			out.println("<body>");
			out.println("<center><h2>SessionUseCookieTwo</h2></center>");
			
			System.out.println("\nUNIQUE 한 JSESSIONID는 : "+session.getId());
		
		if(session != null) {
			out.print("<hr> JSESSIONID = "+ session.getId()+"<hr>");
			String name = (String)session.getAttribute("name");
			out.println("이름 : "+name);
		}else {
			out.print("처음이십니다");
		}
	
		out.print("</body></html>");
		
		
	}
}