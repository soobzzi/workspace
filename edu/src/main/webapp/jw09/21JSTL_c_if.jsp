<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% request.setCharacterEncoding("EUC_KR"); %>

	<c:if test = "true">
		 if�� 1
	 </c:if>
	 
	<c:if test = "false">
		if�� 2
	</c:if>
	
	
	<c:if test = "${param.name == 'ȫ�浿'}">
	 	3. ȫ�浿�� ȯ���մϴ�<br/>
	 </c:if>
	 
	<c:if test = "${!empty param.name}">
	 	4. ${param.name}�� ȯ���մϴ�.<br/>
	 </c:if>
	 
	 
	 <c:set var = "level" value = "����" scope = "session"/>
	 <c:if test = "${param.age<19}">
	 	<c:set var ="level" value = "û�ҳ�" />
	 </c:if>
	 5. ${param.name}���� ���� ${param.age}�� ${level}�Դϴ�.<br/>
	 
	 
	 <c:if test = "${!empty paramValues.sw[0]}">
	  6.�����Ͻ� SW : ${paramValues.sw[0]}<br/>
	  </c:if>
	  
	  <c:if test = "${!empty paramValues.sw[1]}">
	  6.�����Ͻ� SW : ${paramValues.sw[0]}<br/>
	  </c:if>
	  
	  <c:if test = "${!empty paramValues.sw[2]}">
	  6.�����Ͻ� SW : ${paramValues.sw[0]}<br/>
	  </c:if>
	  
	  
	  <c:choose>
	  	<c:when test = "${param.age>19}">
	  	7.${param.name}���� �������� ���� : ${param.age}<br/>
	  	</c:when>
	  	
	  	<c:when test = "${param.age<18}">
	  	7.${param.name}���� �������� ���� : ${param.age}<br/>
	  	</c:when>
	  	
	  	<c:otherwise>
	  	7.${param.name}���� ?? ���� : ${param.age}<br/>
	  	</c:otherwise>
	  	
	  	</c:choose>
	  	
	  	
 

