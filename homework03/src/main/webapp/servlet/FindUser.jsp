
<%@ page contentType = "text/html;charset=euc-kr" %>

<%@ page import = "user.*" %>


	<%		request.setCharacterEncoding("EUC_KR");		
			response.setContentType("text/html;charset=EUC_KR");
			
			String n = request.getParameter("name");
			String s = request.getParameter("sex");
			
			
			UserVO userVO = null;
			System.out.println("session에 저장된 UserVO 유무확인: "+userVO);
			
			
			if(!(n == null || n.equals(""))) {
				userVO = new UserVO();
				userVO.setName(n);
				userVO.setSex(s); //데이터를 객체로 관리하기위해 set 사용
				
				
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
			<h2> 정보바로보기 </h2>
			
			
			<% if( userVO != null ) { %>
				이름 : <%=  userVO.getName() %>
				성별 : <%=  userVO.getSex() %>
			<%}else{%>
				입력된 정보가 없습니다.
			<%}%>
			
			
			</body>
			</html>

		
		