package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDao;
import user.UserVO;

//@WebServlet("/AddUser")
public class AddUser extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("EUC_KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();

		String name = req.getParameter("name");
		String sex = req.getParameter("sex");

		UserVO userVO = new UserVO();
		userVO.setName(name);
		userVO.setSex(sex);

		UserDao useDao = new UserDao();
		useDao.getUser(userVO);
		

		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");

		out.println("<h2>�����Է¿Ϸ�</h2>");

		if (userVO.isActive()) {
			out.println(userVO.getName() + "(" + userVO.getSex() + ")" + "���� ȯ���մϴ�");
			
			HttpSession session = req.getSession();	
			session.setAttribute("UserVO", userVO);
			
		} else {
			out.println("������ �ٽ� �Է����ּ���.");
		}

		out.println("<p><p><a href = '/homework02/servlet/findUser.html'/>������ã��</a>");
		out.println("<p><p><a href = '/homework02/FindUser'>�������ٷκ���</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
