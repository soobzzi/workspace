
<%@ page contentType = "text/html;charset=euc-kr" %>

<%@ page import = "user.*" %>


	<%		request.setCharacterEncoding("EUC_KR");		
			response.setContentType("text/html;charset=EUC_KR");
			
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			
			
			UserVO userVO = null;
			System.out.println("session�� ����� UserVO ����Ȯ��: "+userVO);
			
			
			if(!(name == null || name.equals(""))) {
				userVO = new UserVO();
				userVO.setName(name);
				userVO.setSex(sex); //�����͸� ��ü�� �����ϱ����� set ���
				
				
				UserDao userData = new UserDao(); 				
				userVO = userData.findUser(name);
				
				System.out.println(userVO);
			
			}else if(name == null){
				
				System.out.println("ddd");
				session = request.getSession(true);
				userVO = (UserVO)session.getAttribute("UserVO");
				
				System.out.println(userVO);
				
				//UserDao userData = new UserDao();
				//userData.findUser(name);
				
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
			
			<p><p><a href = 'updateUserView.jsp'>�����������ϱ�</a>
			</body>
			</html>

		
		