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
				<th>��������</th>
				<th colspan ="3"></th>
				
			</tr>
			.
		</tread>
			<tr>
				<td>* �̸�(�ѱ۽Ǹ�)</td>
				<td colspan ="3">
					<input type = "text" name = "name" value = <%= userVO.getName()%>></td>		
			</tr>
			
			<tr>
				<td>* ����</td>
				<td colspan ="3">
					<% if(userVO.getSex().equals("male")){ %>
					<input type = "radio" name = "sex" value = "male" checked >��
					<input type = "radio" name = "sex" value = "female" >��
					<%}else{ %>
					<input type = "radio" name = "sex" value = "male" >��
					<input type = "radio" name = "sex" value = "female" checked>��	
					<% }%>				
				</td>
			</tr>
			<tr>
				<td>* �������</td>
				<td colspan ="3"><input type = "text" name = "year">�� 
					<select><optgroup = "month">
							<option value = "0">����</option>
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
					</select>��
		
					<select><optgroup = "date">
							<option value = "0">����</option>
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
					</select>��
					<input type = "radio" name = "sun">���
					<input type = "radio" name = "moon">����
					(<input type = "radio" name = "ddmoon">����)
				</td>
			</tr>
			<tr>
				<td>* �����з�</td>
					<td colspan = "3">
					<select><optgroup label="edulevel">
							<option value = "1">�����ϼ���</option>
							<option value = "1">��</option>
							<option value = "2">��</option>
							<option value = "3">��</option>
							<option value = "4">��</option>
							</optgroup>
					</select>
					</td>
			</tr>
			<tr>
				<td>* ����</td>
				<td>
					<select><optgroup label="job">
							<option value = "0">�����ϼ���</option>
							<option value = "1">ȸ���</option>
							<option value = "2">�ڿ���</option>
							<option value = "3">����</option>
							</optgroup>
					</select>
				</td>	
				<td>�Ҽ�</td>
					<td>
						<input type = "text" name = "ththr">
					</td>		
			</tr>
			<tr>
				<td>* ��ȥ����</td>
				<td>
					<input type = "radio" name = "">��ȥ
					<input type = "radio" name = "">��ȥ	
				</td>	
				<td>�ڳ��</td>
				<td>
					<select>
						<optgroup label="">
							<option value = "">����</option>
							<option value = "">1</option>
							<option value = "">2</option>
						</optgroup>
					</select>
				</td>
				
			</tr>
			<tr>
				<td>* ����ó</td>
				<td colspan ="3">
					<input type = "text" name = "name">
				</td>
			</tr>
			<tr>
				<td>* �������ּ�</td>
				<td colspan ="3">
					<input type = "text" name = "name">
				</td>
			</tr>
		
		</table>
			<center><input type="submit" value=" �����Ϸ�"/></center>
		
	</form>
</body>
</html>