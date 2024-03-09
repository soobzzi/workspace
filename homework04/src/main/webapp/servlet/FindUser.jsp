
<%@ page contentType = "text/html;charset=euc-kr" %>

<%@ page import = "user.*" %>


	<%		request.setCharacterEncoding("EUC_KR");		
			response.setContentType("text/html;charset=EUC_KR");
			
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			
			
			UserVO userVO = null;
			System.out.println("session에 저장된 UserVO 유무확인: "+userVO);
			
			
			if(!(name == null || name.equals(""))) {
				userVO = new UserVO();
				userVO.setName(name);
				userVO.setSex(sex); //데이터를 객체로 관리하기위해 set 사용
				
				
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
			<h2> 정보바로보기 </h2>
			
			
			<% if( userVO != null ) { %>
				이름 : <%=  userVO.getName() %>
				성별 : <%=  userVO.getSex() %>
			<%}else{%>
				입력된 정보가 없습니다.
			<%}%>
			
			<p><p><a href = 'updateUserView.jsp'>내정보수정하기</a>
			</body>
			</html>

		
		