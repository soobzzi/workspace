package spring.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import spring.service.domain.User;

public class LogonCheckInterceptor extends HandlerInterceptorAdapter{

	public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		
		HttpSession session = request.getSession(true);
		User sessionUser = null;
		if( (sessionUser = (User)session.getAttribute("sessionUser"))==null) {
			sessionUser = new User();
		}
		
		if(sessionUser.isActive()) {
			
			String uri = request.getRequestURI();
			if(uri.indexOf("logonAction") != -1 || uri.indexOf("logon") != -1) {
				
				request.getRequestDispatcher("/user002/home.jsp").forward(request, response);
				System.out.println("[�α��� ����.. �α��� �� ���ʿ� �� �䱸...]");
				System.out.println("[LogonCheckInterceptor end...]");
				
				return false;
			}
			
			System.out.println("[�α��� ����..]");
			System.out.println("[LogonCheckInterceptor end...]");
			
				return false;
		}else {
			
			String uri = request.getRequestURI();
			
			if(uri.indexOf("logonAction") != -1 || uri.indexOf("logon") != -1) {
				System.out.println("[�α��� �õ� ����...]");
				System.out.println("[LogonCheckInterceptor end...]");
				
				return true;
			}
			
				request.getRequestDispatcher("/user002/home.jsp").forward(request, response);
				System.out.println("[�α��� ����..]");
				System.out.println("[LogonCheckInterceptor end...]");
			
				return false; 
		}
	}
}
