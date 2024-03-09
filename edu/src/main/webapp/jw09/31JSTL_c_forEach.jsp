<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <% 
    	java.util.Vector vector = new java.util.Vector();
    	vector.add("A");
    	vector.add("B");
    	vector.add("C");
    	vector.add("D");
    	
    	
    	for(Object obj : vector){
    		System.out.println((String)obj);
    		
    	}
    %>
    	
    	<c:forEach var = "i"  items = "<%= vector %>" begin = "0" step = "1" end= "10">
    		Vector 저장정보 추출 : ${i}<br/> 
    	</c:forEach>
    	
    	<c:forEach var = "i"  items = "<%= vector %>" begin = "1" step = "1" >
    		Vector 저장정보 추출 : ${i}<br/> 
    	</c:forEach>
    	
    	<c:forEach var = "i"  items = "<%= vector %>" begin = "0" step = "2" >
    		Vector 저장정보 추출 : ${i}<br/> 
    	</c:forEach>
    	
    	
    	<%
    	 java.util.HashMap hasMap = new java.util.HashMap();
    	 hasMap.put("a","A");
    	 hasMap.put("b","B");
    	 hasMap.put("c","C");
    	 hasMap.put("d","D");
    	 
    	%>
    	
    	<c:forEach var = "i" items = "<%= hasMap %>">
    		${i.key}= ${i.value}<br/>
    	</c:forEach>
    	
    	
    	
    	