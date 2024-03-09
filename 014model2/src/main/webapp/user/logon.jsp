<%@ page contentType="text/html;charset=euc-kr" %>

<%@ page import="spring.model2.service.user.vo.UserVO" %>

<!-- 
	1. 로그인 유무확인 :: Work Flow Control (방어적 코딩)  
		ㅇ 비 로그인 : 로그인 화면 display 
	   ㅇ 로  그  인 : 이미 로그인 한 회원임을 display
	2. 로그인 확인은...
		ㅇ 로그인한 회원은 session ObjectScope에 UserVO객체를 갖고, active 는 true
		ㅇ UserVO 객체의 유무 및 UserVO의 active 값 true/false  판단
-->

<%
	UserVO userVO = (UserVO)session.getAttribute("userVO");
%>

<html>
	<head></head>
	<body>

	<% // if(userVO == null ||  userVO.isActive() != true ) {%>
		
		<!--  <form id="login" method="post" action="/013model2/logonAction.do">-->
		<form id = "login" method = "post" action = "/014model2/logonAction.do">

			아 이 디  : <input id="userId" type="text" name="userId" value=""><br/><br/>
			패스워드 : <input id="userId" type="text" name="userPasswd" value=""><br/><br/>
			<input id="submit" type="submit" name="submit" value="Enter"/>

		</form>
		
	<%//}else{ %>
			<%-- <%= userVO.getUserId() %>님은 이미 로그인 하셨습니다. --%>
	<% //} %>
	
	<br/><br/>
	<hr/>
	:: info <%= request.getAttribute("info") %>
	<hr/>
	
	</body>
</html>