package jw05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionUseCookieOne
 */
//@WebServlet("/SessionUseCookieOne")
public class SessionUseCookieOne extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
	
		HttpSession session = req.getSession(true);
		
		if(session.isNew()) {
			session.setAttribute("name",new String("ȫ�浿"));
		}
		
		req.setCharacterEncoding("EUC_KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("<center><h2>SessionUseCookieOne</h2></center>");
		
		System.out.println("\nUNIQUE �� JSESSIONID�� : "+session.getId());
		
		if(session.isNew()) {
			out.print("������ ���� ������<br>");
		}else {
			out.print("\n UNIQUE�� JSESSIONID�� : "+session.getId()+"�����");
		}
		
		out.print("<hr>");
		out.print("<a href = '/edu/SessionUseCookieTwo'>��ũ</a>");
		out.print("</body></html>");
		
		
	}
}