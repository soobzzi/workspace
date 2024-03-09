package user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jw.OracleConnectionPool;

//@WebServlet("/UserPoolDao")
public class UserDao {

	public UserDao() {
	}

	public void getUser(UserVO userVO) {

		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;

		try {

			con = OracleConnectionPool.getInstance().getConnection();

			pStmt = con.prepareStatement("insert into user00\r\n" + "(name, sex) values (?,?)");
			pStmt.setString(1, userVO.getName());
			pStmt.setString(2, userVO.getSex());

			rs = pStmt.executeQuery();

			if (rs.next()) {
				System.out.println("db���� Ȯ�� �� �̸��� ���� ==> : " + userVO.getName() + " : " + userVO.getSex());
				userVO.setActive(true);
			} else {
				System.out.println("db����  <" + userVO.getName() + ">�� �ش��ϴ� �ڷᰡ �����ϴ�.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e1) {
				}
			}

			if (con != null) {
				try {
					pStmt.close();
				} catch (Exception e2) {
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (Exception e3) {
				}
			}
		}
	}

	public UserVO findUser(String name) {

		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;

		try {
			con = OracleConnectionPool.getInstance().getConnection();
			pStmt = con.prepareStatement("SELECT * FROM user00 where name = ?");
			pStmt.setString(1, name);
			UserVO userVO = new UserVO();
			

			rs = pStmt.executeQuery();

			while (rs.next()) {
			
				userVO.setName(rs.getString("name"));
				userVO.setSex(rs.getString("sex"));

				System.out.println("ȸ������ =>" + "�̸� :" + userVO.getName()+ "���� : "	+ userVO.getSex());
				userVO.setActive(true);
				
				return userVO;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}finally {
			if(rs != null){
				try{	
					rs.close();	
				}catch(Exception e1){  }
			}
			if(pStmt != null){
				try{	
					pStmt.close();	
				}catch(Exception e2){  }
			}
			if(con != null){
				try{	
					con.close();	
				}catch(Exception e3){  }
			}
		}
		return null;
		
	}


		public void updateUser(UserVO userVO) {
			
			Connection con = null;
			PreparedStatement pStmt = null;
			ResultSet rs = null;
			
			try {
				            
					con = OracleConnectionPool.getInstance().getConnection();
				    pStmt = con.prepareStatement("update user00 set sex = ? where name = ?");
				    pStmt.setString(1, userVO.getSex());
				    pStmt.setString(2, userVO.getName());
				              
				    System.out.println("����� ������ �̸� " + userVO.getSex() + userVO.getName());
				
				    int i = pStmt.executeUpdate();
				
				if(i>0) {
					userVO.setActive(true);
					System.out.println("db���� Ȯ���� �̸��� ���� => :" + userVO.getName() + userVO.getSex());
				}else{
					System.out.println("����� ������ �����ϴ�.");
				}
				
				}catch(Exception e){
					e.printStackTrace();
					
				}finally {
					if (rs != null) {
						try {
							rs.close();
						} catch (Exception e1) {
						}
					}

					if (con != null) {
						try {
							pStmt.close();
						} catch (Exception e2) {
						}
					}

					if (con != null) {
						try {
							con.close();
						} catch (Exception e3) {
						}
					}
				}
		}
}
