<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var = "client" value = "<%= new jw09.Client() %>" scope="session" />

<c:set var = "test" value = "${client}" scope = "session"/>

1. client ��ü�� name : ${client.name}<br/>
1. test ��ü�� name : ${test.name}<br/><hr/>

<c:set target = "${test}" property = "name" value= "�̼���"/>

2. client ��ü�� name : ${client.name}<br/>
2. test ��ü�� name : ${test.name}<br/><hr/>

<c:remove var = "client" scope = "session" />
3. remove �� client ��ü ${empty client}</br>
3. remove �� test ��ü ${empty test}