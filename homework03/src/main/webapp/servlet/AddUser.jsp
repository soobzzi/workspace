<%@ page contentType="text/html; charset=EUC-KR"%>
    
<%@ page import = "user.*" %>

<% 
		request.setCharacterEncoding("EUC_KR");
		//response.setContentType("text/html;charset=EUC_KR");
		//PrintWriter out = respons.getWriter();

		String name = request.getParameter("name");
		String sex = request.getParameter("sex");

		UserVO userVO = new UserVO();
		userVO.setName(name);
		userVO.setSex(sex);

		UserDao useDao = new UserDao();
		useDao.getUser(userVO);
		
%>
		<html>
		<head></head>
		<body>

		<h2>�����Է¿Ϸ�</h2>

		<% if(userVO.isActive()) {%>
			�̸� : <%= userVO.getName() %>
			���� : <%= userVO.getSex() %>
			���� ȯ���մϴ�.
			
		<% session = request.getSession();%>
			<%session.setAttribute("UserVO", userVO);%>
			
		<%} else {%>
			������ �ٽ� �Է����ּ���.
		<%}%>

		<p><p><a href = 'findUser.html'/>������ã��</a>
		<p><p><a href = 'FindUser.jsp'>�������ٷκ���</a>
		</body>
		</html>


		