package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Example02 {

	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		
		
		int no = Integer.parseInt(args[0]);
		String id = args[1];
		String pwd = args[2];
						
	
		String sql = "INSERT INTO member VALUES('"+no+"','"+id+"','"+pwd+"')";
		Statement stmt = con.createStatement();	
		
		int i = stmt.executeUpdate(sql);
		System.out.println("number TABLE member DATA INSERT ¿Ï·á");
		
		if(stmt != null)
			stmt.close();
		if(con != null)
			con.close();
		
	
/*
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO MEMBER VALUE(?,?,?)");
		
		pstmt.setInt(1,no);
		pstmt.setString(2, id);
		pstmt.setString(3, pwd);
		int confirm = pstmt.executeUpdate();
*/
		
	}

}
