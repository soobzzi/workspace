<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page pageEncoding="EUC-KR"%>

<html>
<head>
	<title>Insert title here</title>
</head>
<body>
	<%--///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	<%
		String value01 = (String)request.getAttribute("request");
		String value02 = (String)session.getAttribute("session");
		String value03 = (String)application.getAttribute("application");
	%> 
	<%= value01 %><br/>
	<%= value02 %><br/>
	<%= value03 %><br/>
	JSP2.0�� �߰��� ����� EL(Expression Language)�� ����ϸ�..
	���� ����  <%%><%=%> �� �Ʒ��� ���� �ܼ��ϰ� ���/����� �� �ִ�.	
	 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////--%>
	�� Model/View ���� : Object Scope ���<br/> <br/>
	requestScope.request : ${ requestScope.request } <br/>
	sessionScope.session : ${ sessionScope.session } <br/>
	applicationScope.application : ${ applicationScope.application } <br/>

	<br/><br/><hr size="5" /><br/>	
	
	�� ModelAndView ��ü�� �־���(?) Model Data �� : request Object Scope ���<br/><br/>
	message : ${ message }<br/>
	reqeustScope.message : ${ requestScope.message }<br/>
	sessionScope.message :${ sessionScope.message }<br/>
	applicationScope.message : ${ applicationScope.message }<br/>
	
	<br/><br/><hr size="5" /><br/>
	
	<%=  request.getRequestURI() %><br/>
	<%=  request.getRequestURL() %>
	
</body>
</html>