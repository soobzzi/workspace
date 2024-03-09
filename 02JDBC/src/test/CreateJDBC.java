package test;
import java.sql.*;
//import java.util.*;

//Oracle Driver 사용
import oracle.jdbc.driver.*;

public class CreateJDBC{
   
	///Main Method
	public static void main(String[] args) throws Exception{

		//DB에 로그인 접속정보
		Connection con = null;
		Statement stmt = null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		
		String createSql =
				"CREATE TABLE firstJDBC"+
				"no		NUMBER(3),"+
				"name		VARCHAR2(20),"+
				"email		VARCHAR2(20),"+
				"address	VARCHAR2(50)";
		
		try {
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("1.driver loaing OK");
		
		con = DriverManager.getConnection(url,"scott","tiger");
		System.out.println("2.connection 인스턴스 생성 완료");
			
		stmt = con.createStatement();
		System.out.println("3.statement 객체 생성 완료");
		
		System.out.println("::QUERY 전송결과 : " + stmt.executeUpdate(createSql));
		System.out.println("4.query 전송완료");
		
		
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