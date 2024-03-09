<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3> EL 내장객체를 사용</h3>

1. pageContext EL 내장객체를 이용한 requestURI : ${pageContext.request.requestURI}<br/>

2. pageContext EL 내장객체를 이용한 session의 id : ${pageContext.session.id}<br/>

3. Expression tag를 사용 : <%= pageContext.getSession().getId() %><br/>

4. 이름 : <%= request.getParameter("name") %>

5. 주소 : ${param.addr}<br/>

<% String[] sw = request.getParameterValues("sw"); %>
6.선택한 소프르웨어 : <%= sw[0] %><br/>
6.선택한 소프르웨어 : ${paramValues.sw[1]}<br/>
6.선택한 소프르웨어 : ${paramValues.sw[2]}<br/>

7.쿠키에 저장된 JSESSIONID name : ${cookie.JSESSIONID.name}<br/>
7.쿠키에 저장된 JSESSIONID value : ${cookie.JSESSIONID.value}
</body>
</html>