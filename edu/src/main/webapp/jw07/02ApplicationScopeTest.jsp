<%@ page language="java" contentType="text/html; charset=EUC-KR"%>

	<%

		Integer count = (Integer)application.getAttribute("count");
	
		 if(count == null){
			 
		 	out.println(":: �ش� ������ 1��° ��� ::");
		 	application.setAttribute("count",new Integer(1));
		 	
		 	}else{
		 	
		 	int changeCount = count.intValue() +1;
		 	out.println(":: �ش� ������ " + changeCount+" ��° ��� ::");
		 	
		 	application.setAttribute("count",new Integer(changeCount));
		 	
		 	}
	 	
	%>