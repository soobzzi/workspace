<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	// 1. page ObjectScope ����
	pageContext.setAttribute("abc",new String("page ObjectScope ����� ���ڿ�"));
	
	// 2. request ObjectScope ����
	request.setAttribute("abc",new String("request ObjectScope ����� ���ڿ�"));
	
	//3.1 session ObjectScope  (size() ==0��)  ArrayList ����
	session.setAttribute("abc",new ArrayList());
	
	// 3.2 session ObjectScope ���� ���� ArrayList ����
	ArrayList arrayList =new ArrayList();
	arrayList.add( new String("ArrayList  ����� ���ڿ�") );
	session.setAttribute("def",arrayList);
	
	// 4. Application ObjectScope ���� ���� HashMap ����
	HashMap hashMap = new HashMap();
	hashMap.put("zzz",new String("HashMap ����� ���ڿ�"));
	application.setAttribute("abc",hashMap);
%>

<h5>1.page ObjectScope ����</h5>
	${pageScope.abc} = ${pageScope["abc"]}
	
<h5>2.request ObjectScope ����</h5>
	${requestScope.abc} = ${requestScope["abc"]}
	
<h5>3.session ObjectScope ����</h5>
	${empty sessionScope.abc} = ${empty sessionScope["abc"]}

<h5>4.session n ObjectScope ����</h5>
	${empty sessionScope.def} = ${empty sessionScope["def"]}
	
<h5>5.session n ObjectScope ����</h5>
	${sessionScope.def[0]} = ${sessionScope["def"][0]}
	
<h5>5.application ObjectScope ����</h5>
	${empty applicationScope.def[0]} = ${empty applicationnScope["def"][0]}

<h5>5.session n ObjectScope ����</h5>
	${applicationScope.abc.zzz} = ${applicationScope["abc"].zzz}<br/><hr/><br/>
	
<h3>Object Scope ������ �������� �ʰ� EL�� ��� </h3>
	� ObjectScope�� �����ΰ� : ${abc}</h3>
	
	
	
		
</body>
</html>