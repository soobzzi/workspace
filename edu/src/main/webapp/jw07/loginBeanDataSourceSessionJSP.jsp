	
<%@ page contentType = "text/html;charset=euc-kr" %>

<%@ page import = "jw04.*" %>

				<% 
				request.setCharacterEncoding("EUC_KR");		
				//response.setContentType("text/html;charset=EUC_KR");
				//PrintWriter out = res.getWriter();
				
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				
				//HttpSession session =req.getSession(true);
				
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
				%>
				
				<html>
				<head></head>
				<body>
				<h2>Login ȭ��</h2>
				
				
					<% if(userVO != null && userVO.isActive()) {%>
						<% userVO.getId(); %> ���� ȯ���մϴ�.
						<% session.setAttribute("userVO", userVO);%>
					<% }else {%>
						Login ���� id.pwd�� Ȯ���ϼ���.
					<% } %>
				 
				<p><p><a href ='/edu/jw07/loginBeanDataSourceSession.html'>�ڷ�</a>
				</body>
				</html>
	
		
		