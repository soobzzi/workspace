<%@ page contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>개인정보검색</title>
	</head>
	<body>
		 <form method = "post" action = "FindUser.jsp">
				<table border = "1" align = "center">
					<tr> 
						<td align = "center">이름으로 검색하기</td>
					</tr>	
						<td><input type = "text" name = "name"></td>
					
				</table>
			<center><input type="submit" value="내정보보기"/></center>
			
		</form>
	</body>
</html>