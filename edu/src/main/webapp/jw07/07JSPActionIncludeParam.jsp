<%@ page contentType="text/html;charset=euc-kr" %>

<br/><hr/>

	<h3>
	 ㅇ 07JSPActionInclude.jsp 시작<br/><br/>
	 
	 	request,session,application  Object Scope  Data 추출 <br/><br/>
	
		request ObjectScope 추출 Data : <%= request.getAttribute("aaa") %><br/>
		session ObjectScope 추출 Data : <%= session.getAttribute("bbb") %><br/>
		application ObjectScope 추출 Data : <%= application.getAttribute("ccc") %><br/><br/>
	
	 ㅇ 07JSPActionInclude.jsp 끝 <br/> 
	</h3>
	
	<!-- 아래을 주석 풀면 error 발생 이유 ? -->
	<%-- <jsp:param ~~/> 전달 Data 추출 API 확인 --%>
	parm으로 넘어온 str값 : <%= request.getParameter("str") %><br/><br/>
	
<hr/><br/>
	