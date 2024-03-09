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

		<h2>정보수정완료</h2>

		<% if(userVO.isActive()) {%>
			이름 : <%= userVO.getName() %>
			성별 : <%= userVO.getSex() %>
			님을 환영합니다.
			
		<% session = request.getSession();%>
			<%session.setAttribute("UserVO", userVO);%>
			
		<%} else {%>
			정보를 다시 입력해주세요.
		<%}%>

		</body>
		</html>