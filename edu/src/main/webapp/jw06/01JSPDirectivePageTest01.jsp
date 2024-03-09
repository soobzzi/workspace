<!-- JSP page directive Element 연습 -->

<%@ page contentType="text/html;charset=euc-kr"%>
<%@ page import="java.util.*"%>

<%@ page language="java"%>
<%@ page info = "처음 작성하는 JSP"%>

<%@ page session ="false"%>
<%@ page isThreadSafe="false"%>

<%--
	JSP 주석 : Container 가 java File 변환 시 주석인식
	<%@ page extends = "java.util.Vector" %>
--%>

<%
	String value = " 지역변수";
	System.out.println("::" + value );

	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
	System.out.println(":: "+ year + "년");


	String info = getServletInfo();
	System.out.println(":: information :" + info);

%>

<html>
<head></head>
	<body>
	안녕하세요 html 시작<br/>
	<hr/>
	<%= "::"+value %><br/>
	<%="::"+year + "년"%><br/>
	<%=":: information : "+ info %><br/>
	<hr/>
	안녕하세요 html 끝<br/>
	</body>
</html>
