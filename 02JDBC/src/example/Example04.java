package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Example04 {

	public static void main(String[] args)throws Exception{
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, "scott", "tiger");		
	
		Statement stmt = con.createStatement();
//		int no = Integer.parseInt(args[0]);
//		String id = args[1];
//		String pwd = args[2];
	
	//	System.out.println("회원정보 =>"+"번호 :" +no+ "id:" +id+ "pwd:" +pwd);
	
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM member"); 
		
		while(rs.next()) {
			
			int no = rs.getInt("1");
			String id = rs.getString("angle");
			String pwd = rs.getString("1004");
					
			System.out.println("회원정보 =>"+"번호 :" +no+ "id:" +id+ "pwd:" +pwd);
			
		}
		
	}

}
