package jw.common.util;


import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


public class DBUtil {
	
	public DBUtil() {
	}
	
	public static Connection getConnection(String drierClssName,
											String url,
											String id,
											String passwd) {
		
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, id, passwd);	
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("db 접속시 오류 발생 : " + e);
		}
		return con;
	}

	
		public static Connection getConnection() {
			Connection con = null;
			
			try {
				InitialContext ic = new InitialContext();
				DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/ora");
				con = ds.getConnection();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if( con == null)
					con = getConnection("oracle.jdbc.driver.OracleDriver",
										"jdbc : oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
												
			}
			return con;
		}
	}
	