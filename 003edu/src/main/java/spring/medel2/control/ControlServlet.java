package spring.medel2.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ControlServlet
 */
@WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet {
	
	public void init(ServletConfig sc) throws ServletException{
		super.init(sc);
		
		System.out.println("\n\n =============");
		System.out.println("ControlServlet의 init() Method");
		System.out.println("=================");
	
	}

	
	public void service(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException{
		
		System.out.println("\n [ControlServlet.servic() start ...");
		
		String actionPage = this.getURI(req.getRequestURI());
		System.out.println("::URI? => "+req.getRequestURI());
		System.out.println("::client의 요구사항은 ? => :"+actionPage);
		
		req.setCharacterEncoding("euc-kr");
		HttpSession session = req.getSession(true);
		
		
		String requestPage = "/user/logon.jsp";
		
		if(session.isNew() || session.getAttribute("userVO")== null) {
			session.setAttribute("userVO", new UserVO());
		}
		
		UserVO userVO =(UserVO)session.getAttribute("userVO");
		
		if(userVO != null && userVO.isActive()) {
			requestPage = "/user/home.jsp";
		}else if(actionPage.equals("logon")) {
		
		}else if(actionPage.equals("logonAction"))
}
