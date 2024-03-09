package test;
import java.sql.*;
//import java.util.*;

//Oracle Driver ���
import oracle.jdbc.driver.*;

public class CreateJDBC{
   
	///Main Method
	public static void main(String[] args) throws Exception{

		//DB�� �α��� ��������
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
		System.out.println("2.connection �ν��Ͻ� ���� �Ϸ�");
			
		stmt = con.createStatement();
		System.out.println("3.statement ��ü ���� �Ϸ�");
		
		System.out.println("::QUERY ���۰�� : " + stmt.executeUpdate(createSql));
		System.out.println("4.query ���ۿϷ�");
		
		
		}catch(ClassNotFoundException e) {
			System.out.println("\n ==> Driver Loading �� Exception�߻�");
			e.printStackTrace();
		}	
				
		catch(SQLException e) {
			System.out.println("\n ==> JDBC ������ Exception �߻� : "+e.getErrorCode());
			e.printStackTrace();
		}
		
		
		finally {
			if(stmt != null)	stmt.close();
			if(con != null)		con.close();
		}

	}//end of main

}//end of class