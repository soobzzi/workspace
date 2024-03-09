package spring.base.navigation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spring.service.domain.User;


//@WebServlet("/ServletForward")
public class ServletSendRedirect extends HttpServlet {
	
	public void service(HttpServletRequest request , HttpServletResponse response)
						throws ServletException,IOException{
		
		System.out.println("[ ServletSendRedirect.service() start...]");
		
		request.setAttribute("user01", new User("홍길동","1111"));
		
		HttpSession session = request.getSession(true);
		session.setAttribute("user02", new User("이순신","2222"));
		
		ServletContext application = this.getServletContext();
		application.setAttribute("user03", new User("장보고","3333"));
		
		ServletContext sc = this.getServletContext();
		
		RequestDispatcher rd = sc.getRequestDispatcher("/003edu/02Navigation/view.jsp");
		rd.forward(request, response);
		
		System.out.println("[ServletSendRedirect.service() start...]");
	}
}
