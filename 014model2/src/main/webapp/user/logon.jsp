<%@ page contentType="text/html;charset=euc-kr" %>

<%@ page import="spring.model2.service.user.vo.UserVO" %>

<!-- 
	1. �α��� ����Ȯ�� :: Work Flow Control (����� �ڵ�)  
		�� �� �α��� : �α��� ȭ�� display 
	   �� ��  ��  �� : �̹� �α��� �� ȸ������ display
	2. �α��� Ȯ����...
		�� �α����� ȸ���� session ObjectScope�� UserVO��ü�� ����, active �� true
		�� UserVO ��ü�� ���� �� UserVO�� active �� true/false  �Ǵ�
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

			�� �� ��  : <input id="userId" type="text" name="userId" value=""><br/><br/>
			�н����� : <input id="userId" type="text" name="userPasswd" value=""><br/><br/>
			<input id="submit" type="submit" name="submit" value="Enter"/>

		</form>
		
	<%//}else{ %>
			<%-- <%= userVO.getUserId() %>���� �̹� �α��� �ϼ̽��ϴ�. --%>
	<% //} %>
	
	<br/><br/>
	<hr/>
	:: info <%= request.getAttribute("info") %>
	<hr/>
	
	</body>
</html>