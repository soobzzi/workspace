package spring.base.objectscope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

//@WebServlet("/SessionScopeTest")
public class RequestScopeTest extends HttpServlet {
		
		public void service(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException{
			
			res.setContentType("text/html ; charset = EUC-kr");
			PrintWriter out = res.getWriter();
			
			HttpSession session = req.getSession(true);
			
			Integer count = (Integer)session.getAttribute("count");
			
			if(count == null) {
				out.print(":: 1번째 Request ::");
				session.setAttribute("count",new Integer(1));
			}else {
				int changeCount = count.intValue()+1;
				out.print("::"+changeCount+ "번째 Request::");
				 
				
				session.setAttribute("count", new Integer(changeCount));
				
			}	
		}
	}