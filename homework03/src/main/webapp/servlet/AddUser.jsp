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

		<h2>정보입력완료</h2>

		<% if(userVO.isActive()) {%>
			이름 : <%= userVO.getName() %>
			성별 : <%= userVO.getSex() %>
			님을 환영합니다.
			
		<% session = request.getSession();%>
			<%session.setAttribute("UserVO", userVO);%>
			
		<%} else {%>
			정보를 다시 입력해주세요.
		<%}%>

		<p><p><a href = 'findUser.html'/>내정보찾기</a>
		<p><p><a href = 'FindUser.jsp'>내정보바로보기</a>
		</body>
		</html>


		