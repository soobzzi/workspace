package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Example01 {

	public static void main(String[] args)throws Exception{
		
		Connection con = null;
		Statement stmt = null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		String createsql =
			"CREATE TABLE member("+
			"no		NUMBER," +
			"id		VARCHAR2(10),"+
			"Pwd	VARCHAR2(10))";
		
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,"scott","tiger");	
			stmt = con.createStatement();
			int i = stmt.executeUpdate(createsql);
			

			
			}catch(ClassNotFoundException e) {
				System.out.println("\n ==> Driver Loading 시 Exception발생");
				e.printStackTrace();
			}	
					
			catch(SQLException e) {
				System.out.println("\n ==> JDBC 절차중 Exception 발생 : "+e.getErrorCode());
				e.printStackTrace();
			}
			
			
			finally {
				if(stmt != null)	stmt.close();
				if(con != null)		con.close();
			}

		}//end of main

	}//end of class
	


