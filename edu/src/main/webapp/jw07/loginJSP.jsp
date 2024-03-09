<%@ page contentType = "text/html;charset=EUC-KR" %>

<%@ page import = "java.sql.*" %>


	<%
	
		request.setCharacterEncoding("EUC_KR");		
		//res.setContentType("text/html;charset=EUC_KR");
		//PrintWriter out = res.getWriter();
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			String fromDbld = null;
			String fromDbPwd = null;
		
		try {
		
			String dburl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbuser = "scott";
			String dbpwd = "tiger";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(dburl, dbuser, dbpwd);
			
			PreparedStatement pStmt = con.prepareStatement("SELECT id,pwd FROM users WHERE id = ?");
			pStmt.setString(1,id);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				fromDbld = rs.getString("id");
				fromDbPwd = rs.getString("pwd");
				
				System.out.println("db에서 확인 한 id,pwd ==> : " +fromDbld+ " : " +fromDbPwd);
			}else {
				System.out.println("db에 client에서 입력한 <"+id+"> 와 <"+pwd+"> 가 없습니다.");
						
			}
			
			rs.close();
			pStmt.close();
			con.close();
			
			}catch(Exception e) {
				System.out.println("==>JDBC관련 Exception 이 발생한 모양 <==");
				e.printStackTrace();
			}
		%>
		
		<html>
		<head></head>
		<body>
		<h2>Login 화면</h2>
		
			<%  if(fromDbld != null && fromDbPwd != null &&fromDbld.equals(id) && fromDbPwd.equals(pwd)) { %>
			
				<%= id %> 님 환영합니다.
				
			<%	}else { %>
					id,pwd를 확인하세요
			<%	}%>
			
			
		<p><p><a href = '/edu/jw07/loginJSP.html'>뒤로</a> 
		</body>
		</html>
	

	