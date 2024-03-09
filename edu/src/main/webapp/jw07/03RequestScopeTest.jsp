<%@ page language="java" contentType="text/html; charset=EUC-KR"%>

	<%

		Integer count = (Integer)request.getAttribute("count");
	
		 if(count == null){
			 
		 	out.println(":: 1 번째 Request ::");
		 	request.setAttribute("count",new Integer(1));
		 	
		 	}else{
		 	
		 	int changeCount = count.intValue() +1;
		 	out.println(":: +changeCount+ 번째 Request ::");
		 	
		 	request.setAttribute("count",new Integer(changeCount));
		 	
		 	}
	 	
	%>