package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/FindUser")
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

import user.UserDao;
import user.UserVO;

//@WebServlet("/SessionUseCookieTwo")
public class FindUser extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
				
			req.setCharacterEncoding("EUC_KR");		
			res.setContentType("text/html;charset=EUC_KR");
			PrintWriter out = res.getWriter();
			
			String n = req.getParameter("name");
			String s = req.getParameter("sex");
			
			
			UserVO userVO = null;
			System.out.println("session�� ����� UserVO ����Ȯ��: "+userVO);
			
			
			if(!(n == null || n.equals(""))) {
				userVO = new UserVO();
				userVO.setName(n);
				userVO.setSex(s); //�����͸� ��ü�� �����ϱ����� set ���
				
				
				UserDao userData = new UserDao(); 
				userData.getInfo(userVO);
				
				
				System.out.println(userVO);
			
			}else if(n == null){
				
				HttpSession session =req.getSession(true);
				userVO = (UserVO)session.getAttribute("UserVO");
				
				UserDao userData = new UserDao();
				userData.getInfo(userVO);
				}
			
				
				
			out.println("<html>");
			out.println("<head></head>");
			out.println("<body>");
			out.println("<h2> �����ٷκ��� </h2>");
			
			
			if( userVO != null ) {
				out.println( "�̸� : "+ userVO.getName() +"    " + "���� : " + userVO.getSex());
			}else {
				out.println("�Էµ� ������ �����ϴ�.");
			}
			
			
			out.println("</body>");
			out.println("</html>");
		}
}
		
		
	