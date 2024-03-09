<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import = "user.*" %>

<%

	request.setCharacterEncoding("EUC-KR");
	
	String name = request.getParameter("name");
	String sex = request.getParameter("sex");
	
	UserVO userVO = null;
	
	if(! ( name == null || name.equals("") )) {
		System.out.println("no use session");
		userVO = new UserVO();
		userVO.setName(name);
		userVO.setSex(sex);
		
		UserDao userData = new UserDao();
		userData.updateUser(userVO);
		
	}else if( name == null){
	
		session =request.getSession(true);
		userVO = (UserVO)session.getAttribute("UserVO");
				
		UserDao userData = new UserDao();
		userData.updateUser(userVO);
	}
	%>
	
	<html>
		<head></head>
		<body>

		<h2>���������Ϸ�</h2>

		<% if(userVO.isActive()) {%>
			�̸� : <%= userVO.getName() %>
			���� : <%= userVO.getSex() %>
			���� ȯ���մϴ�.
			
		<% session = request.getSession();%>
			<%session.setAttribute("UserVO", userVO);%>
			
		<%} else {%>
			������ �ٽ� �Է����ּ���.
		<%}%>

		</body>
		</html>