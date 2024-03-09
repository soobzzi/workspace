
 <%@ page  contentType="text/html; charset=EUC-KR" %>

<%@ page import = "java.util.ArrayList" %>    
<%@ page import = "jw.service.user.vo.UserVO" %>
<%@ page import = "jw.service.user.dao.UserDao" %>

	<%
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		if(userVO == null){
			userVO = new UserVO();
			}
	%>
	
	
	<% if( ! userVO.isActive()){ %>
	
		<jsp:include page = "../jw07/login.html"/>
		<br/><br/>
			
		<a href = "/edu/jw07/addUser.html">회원가입</a>
		
	<% }else{ %>
		<center><h1>회원가입한 전체 목록...</h1></center>
			<center>
				<table border = '1'>
					<tr>
					<% UserDao userDao = new UserDao(); %>
					<% ArrayList<UserVO> arrayList = userDao.getUserList(); %>
					<% for(int i = 0 ; i<arrayList.size() ; i++){ %>
						<% UserVO user = arrayList.get(i); %>
						<tr>
							<td><%=user.getNo() %></td>
							<td><%=user.getId() %></td>
							<td><%=user.getPwd() %></td>
						</tr>
					<%}%>
					
				</table>
			</center>
		<%}%>		
					
			