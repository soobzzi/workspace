
<%@ page contentType = "text/html;charset=euc-kr" %>

<%@ page import = "user.*" %>


	<%		request.setCharacterEncoding("EUC_KR");		
			response.setContentType("text/html;charset=EUC_KR");
			
			String n = request.getParameter("name");
			String s = request.getParameter("sex");
			
			
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
				
				session =request.getSession(true);
				userVO = (UserVO)session.getAttribute("UserVO");
				
				UserDao userData = new UserDao();
				userData.getInfo(userVO);
				}
			
			%>	
				
			<html>
			<head></head>
			<body>
			<h2> �����ٷκ��� </h2>
			
			
			<% if( userVO != null ) { %>
				�̸� : <%=  userVO.getName() %>
				���� : <%=  userVO.getSex() %>
			<%}else{%>
				�Էµ� ������ �����ϴ�.
			<%}%>
			
			
			</body>
			</html>

		
		