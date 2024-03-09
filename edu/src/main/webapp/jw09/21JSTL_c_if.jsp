<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% request.setCharacterEncoding("EUC_KR"); %>

	<c:if test = "true">
		 if문 1
	 </c:if>
	 
	<c:if test = "false">
		if문 2
	</c:if>
	
	
	<c:if test = "${param.name == '홍길동'}">
	 	3. 홍길동님 환영합니다<br/>
	 </c:if>
	 
	<c:if test = "${!empty param.name}">
	 	4. ${param.name}님 환영합니다.<br/>
	 </c:if>
	 
	 
	 <c:set var = "level" value = "성인" scope = "session"/>
	 <c:if test = "${param.age<19}">
	 	<c:set var ="level" value = "청소년" />
	 </c:if>
	 5. ${param.name}님은 나이 ${param.age}로 ${level}입니다.<br/>
	 
	 
	 <c:if test = "${!empty paramValues.sw[0]}">
	  6.선택하신 SW : ${paramValues.sw[0]}<br/>
	  </c:if>
	  
	  <c:if test = "${!empty paramValues.sw[1]}">
	  6.선택하신 SW : ${paramValues.sw[0]}<br/>
	  </c:if>
	  
	  <c:if test = "${!empty paramValues.sw[2]}">
	  6.선택하신 SW : ${paramValues.sw[0]}<br/>
	  </c:if>
	  
	  
	  <c:choose>
	  	<c:when test = "${param.age>19}">
	  	7.${param.name}님은 성인으로 나이 : ${param.age}<br/>
	  	</c:when>
	  	
	  	<c:when test = "${param.age<18}">
	  	7.${param.name}님은 성인으로 나이 : ${param.age}<br/>
	  	</c:when>
	  	
	  	<c:otherwise>
	  	7.${param.name}님은 ?? 나이 : ${param.age}<br/>
	  	</c:otherwise>
	  	
	  	</c:choose>
	  	
	  	
 

