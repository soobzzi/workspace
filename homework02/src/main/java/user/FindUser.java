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
			System.out.println("session에 저장된 UserVO 유무확인: "+userVO);
			
			
			if(!(n == null || n.equals(""))) {
				userVO = new UserVO();
				userVO.setName(n);
				userVO.setSex(s); //데이터를 객체로 관리하기위해 set 사용
				
				
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
			out.println("<h2> 정보바로보기 </h2>");
			
			
			if( userVO != null ) {
				out.println( "이름 : "+ userVO.getName() +"    " + "성별 : " + userVO.getSex());
			}else {
				out.println("입력된 정보가 없습니다.");
			}
			
			
			out.println("</body>");
			out.println("</html>");
		}
}
		
		
	