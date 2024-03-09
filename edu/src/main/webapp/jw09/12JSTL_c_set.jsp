<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var = "client" value = "<%= new jw09.Client() %>" scope="session" />

<c:set var = "test" value = "${client}" scope = "session"/>

1. client °´Ã¼ÀÇ name : ${client.name}<br/>
1. test °´Ã¼ÀÇ name : ${test.name}<br/><hr/>

<c:set target = "${test}" property = "name" value= "ÀÌ¼ø½Å"/>

2. client °´Ã¼ÀÇ name : ${client.name}<br/>
2. test °´Ã¼ÀÇ name : ${test.name}<br/><hr/>

<c:remove var = "client" scope = "session" />
3. remove ÈÄ client °´Ã¼ ${empty client}</br>
3. remove ÈÄ test °´Ã¼ ${empty test}