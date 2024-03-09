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

import jw04.UserDataSourceDao;
import jw04.UserVO;


/**
 * Servlet implementation class SessionUseCookieOne
 */
//@WebServlet("/SessionUseCookieTwo")
public class LoginBeanDataSourceSession extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
				
			req.setCharacterEncoding("EUC_KR");		
			res.setContentType("text/html;charset=EUC_KR");
			PrintWriter out = res.getWriter();
			
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			
			HttpSession session =req.getSession(true);
			
			UserVO userVO = (UserVO)session.getAttribute("userVO");
			System.out.println("session�� ����� UserVO ����Ȯ��: "+userVO);
			
			
			if(!(id ==null || id.equals(""))) {
				userVO = new UserVO();
				userVO.setId(id);
				userVO.setPwd(pwd);
				System.out.println(userVO);
				
				UserDataSourceDao userDataSourceDao = new UserDataSourceDao();
				userDataSourceDao.getUser(userVO);
			}
			
			out.println("<html>");
			out.println("<head></head>");
			out.println("<body>");
			out.println("<h2>Login ȭ�� </h2>");
			
			
			if(userVO != null && userVO.isActive()) {
				out.println(userVO.getId() + "���� ȯ���մϴ�");
				session.setAttribute("userVO", userVO);
			}else {
				out.println("Login ���� id.pwd�� Ȯ���ϼ���.");
			}
			
			out.println("<p><p><a hrdf = '/edu/jw04/loginBeanDataSourceSession.html'>�ڷ�</a>");
			out.println("</body>");
			out.println("</html>");
		}
		
		
	}
	