package jw04;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DbBean{

	private String dburl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private	String dbuser = "scott";
	private	String dbpwd = "tiger";
	private String id;
	private String pwd;
	
	public DbBean() {
	}
	
	
	public void setId(String id) {
		this.id = id;		
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean getUser() {
		
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(dburl, dbuser, dbpwd);
			
			pStmt = con.prepareStatement("SELECT id,pwd FROM users WHERE id = ?");
			pStmt.setString(1,id);
			
			rs = pStmt.executeQuery();
			String str = null;
			
			if(rs.next()) {	
				str = rs.getString("pwd");
				System.out.println("db���� Ȯ�� �� id,pwd ==> : " +id+ " : " +str);
			}else {
				System.out.println("db�� <" +id+ ">�� �ش��ϴ� �ڷᰡ �����ϴ�.");
			}
			
			if(str != null && str.equals(pwd)) {
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(Exception e1) {}
			}
			
			if(con != null) {
				try {
					pStmt.close();
				}catch(Exception e2) {}
			}
			
			if(con != null) {
				try {
					con.close();
				}catch(Exception e3) {}
			}
		}
	}
	}



	
