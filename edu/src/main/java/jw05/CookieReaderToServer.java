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


/**
 * Servlet implementation class CookieReaderToServer
 */
@WebServlet("/CookieReaderToServer")
public class CookieReaderToServer extends HttpServlet {
       

	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		req.setCharacterEncoding("EUC_KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		
		Cookie[] cookies = req.getCookies();
		String userName = null;
		
		if(cookies != null) {
			
			out.println("Client에서 전송된 Cookie 있습니다.<br/>");
			
			for (int i = 0; i < cookies.length; i++) {
				
				String name = cookies[i].getName();
				String value = URLDecoder.decode(cookies[i].getValue());
				System.out.println("client로 부터 전송된 cookie : "+name+"="+value);
				
				if(name.equals("name")) {
					userName = value;
				}
			}
		}else {
			out.print("Client에서 전송된 cookie가 없습니다.<br/>");
		}
		
		out.println("<html><body>");
		
		if(userName == null) {
			out.print("처음입니다.");
		}else {
			out.print(userName+"님 환영");
		}
		out.print("</body></html>");
		}
		
	}

