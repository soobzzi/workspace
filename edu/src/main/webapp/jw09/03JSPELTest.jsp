<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3> EL ���尴ü�� ���</h3>

1. pageContext EL ���尴ü�� �̿��� requestURI : ${pageContext.request.requestURI}<br/>

2. pageContext EL ���尴ü�� �̿��� session�� id : ${pageContext.session.id}<br/>

3. Expression tag�� ��� : <%= pageContext.getSession().getId() %><br/>

4. �̸� : <%= request.getParameter("name") %>

5. �ּ� : ${param.addr}<br/>

<% String[] sw = request.getParameterValues("sw"); %>
6.������ ���������� : <%= sw[0] %><br/>
6.������ ���������� : ${paramValues.sw[1]}<br/>
6.������ ���������� : ${paramValues.sw[2]}<br/>

7.��Ű�� ����� JSESSIONID name : ${cookie.JSESSIONID.name}<br/>
7.��Ű�� ����� JSESSIONID value : ${cookie.JSESSIONID.value}
</body>
</html>