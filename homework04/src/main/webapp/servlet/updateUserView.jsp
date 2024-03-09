<%@ page contentType = "text/html;charset=euc-kr" %>
<%@ page import = "user.*" %>

<head>
<title>Insert title here</title>
</head>

<body>

	<%  
	
		//String name = request.getParameter("name");
		UserVO userVO = null;
		session = request.getSession();
		userVO = (UserVO)session.getAttribute("UserVO");
		
		System.out.println(userVO);
		
		/*
		if(name == null){
			userVO =  ((UserVO)session.getAttribute("userVO"));
			
		}else{
			UserDao userDao = new UserDao();			
			userVO = userDao.findUser(name);
		}
		*/
		
	%>	
	
	<form method = "post" action = "updateUser.jsp">
	<table  border = "1" width = "700" height = "300" align = "center">
		<tread>
			<tr>
				<th>개인정보</th>
				<th colspan ="3"></th>
				
			</tr>
			.
		</tread>
			<tr>
				<td>* 이름(한글실명)</td>
				<td colspan ="3">
					<input type = "text" name = "name" value = <%= userVO.getName()%>></td>		
			</tr>
			
			<tr>
				<td>* 성별</td>
				<td colspan ="3">
					<% if(userVO.getSex().equals("male")){ %>
					<input type = "radio" name = "sex" value = "male" checked >남
					<input type = "radio" name = "sex" value = "female" >여
					<%}else{ %>
					<input type = "radio" name = "sex" value = "male" >남
					<input type = "radio" name = "sex" value = "female" checked>여	
					<% }%>				
				</td>
			</tr>
			<tr>
				<td>* 생년월일</td>
				<td colspan ="3"><input type = "text" name = "year">년 
					<select><optgroup = "month">
							<option value = "0">선택</option>
							<option value = "1">1</option>
							<option value = "2">2</option>
							<option value = "3">3</option>
							<option value = "4">4</option>
							<option value = "5">5</option>
							<option value = "6">6</option>
							<option value = "7">7</option>
							<option value = "8">8</option>
							<option value = "9">9</option>
							<option value = "10">10</option>
							<option value = "11">11</option>
							<option value = "12">12</option>
					</select>월
		
					<select><optgroup = "date">
							<option value = "0">선택</option>
							<option value = "1">1</option>
							<option value = "2">2</option>
							<option value = "3">3</option>
							<option value = "4">4</option>
							<option value = "5">5</option>
							<option value = "6">6</option>
							<option value = "7">7</option>
							<option value = "8">8</option>
							<option value = "9">9</option>
							<option value = "10">10</option>
							<option value = "11">11</option>
							<option value = "12">12</option>
							<option value = "13">13</option>
							<option value = "14">14</option>
							<option value = "15">15</option>
							<option value = "16">16</option>
							<option value = "17">17</option>
							<option value = "18">18</option>
							</optgroup>
					</select>일
					<input type = "radio" name = "sun">양력
					<input type = "radio" name = "moon">음력
					(<input type = "radio" name = "ddmoon">윤달)
				</td>
			</tr>
			<tr>
				<td>* 최종학력</td>
					<td colspan = "3">
					<select><optgroup label="edulevel">
							<option value = "1">선택하세요</option>
							<option value = "1">초</option>
							<option value = "2">중</option>
							<option value = "3">고</option>
							<option value = "4">대</option>
							</optgroup>
					</select>
					</td>
			</tr>
			<tr>
				<td>* 직업</td>
				<td>
					<select><optgroup label="job">
							<option value = "0">선택하세요</option>
							<option value = "1">회사원</option>
							<option value = "2">자영업</option>
							<option value = "3">무직</option>
							</optgroup>
					</select>
				</td>	
				<td>소속</td>
					<td>
						<input type = "text" name = "ththr">
					</td>		
			</tr>
			<tr>
				<td>* 결혼여부</td>
				<td>
					<input type = "radio" name = "">미혼
					<input type = "radio" name = "">기혼	
				</td>	
				<td>자녀수</td>
				<td>
					<select>
						<optgroup label="">
							<option value = "">선택</option>
							<option value = "">1</option>
							<option value = "">2</option>
						</optgroup>
					</select>
				</td>
				
			</tr>
			<tr>
				<td>* 연락처</td>
				<td colspan ="3">
					<input type = "text" name = "name">
				</td>
			</tr>
			<tr>
				<td>* 거주지주소</td>
				<td colspan ="3">
					<input type = "text" name = "name">
				</td>
			</tr>
		
		</table>
			<center><input type="submit" value=" 수정완료"/></center>
		
	</form>
</body>
</html>