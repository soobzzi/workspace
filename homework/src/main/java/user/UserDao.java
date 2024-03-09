package user;

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

import jw.OracleConnectionPool;

//@WebServlet("/UserPoolDao")
	public class UserDao  {

		public UserDao() {
		}
		
		public void getUser(UserVO userVO) {
		
			Connection con = null;
			PreparedStatement pStmt = null;
			ResultSet rs = null;
		
			try {
				
				con = OracleConnectionPool.getInstance().getConnection();
				
				pStmt = con.prepareStatement("insert into user00\r\n"
						+ "(name, sex) values (?,?)");
				pStmt.setString(1,userVO.getName());
				pStmt.setString(2,userVO.getSex());
				
				rs = pStmt.executeQuery();
				
				if(rs.next()) {	
					System.out.println("db에서 확인 한 id,pwd ==> : " +userVO.getName()+ " : " +userVO.getSex());
					userVO.setActive(true);
				}else {
					System.out.println("db에 <" +userVO.getName()+ ">에 해당하는 자료가 없습니다.");
				}
				
			}catch(Exception e) {
				e.printStackTrace();
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

