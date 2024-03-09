package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertJDBC {

	public static void main(String[] args) throws Exception{
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		
		Statement stmt = con.createStatement();
		
		String sql1 = "INSERT INTO fistJDBC VALUES(1,'ȫ�浿','a@lycos.co.kr','�Ѿ�')";
		String sql2 = "INSERT INTO fistJDBC VALUES(2,'ȫ���','b@lycos.co.kr','�Ѿ�')";
		String sql3 = "INSERT INTO fistJDBC VALUES(3,'�̼���','c@lycos.co.kr','�Ѿ�')";
		
		
		int i = stmt.executeUpdate(sql1);
		System.out.println("1�� insert ���� :"+i+"���� ���� ����������ϴ�.");
		
		i = stmt.executeUpdate(sql2);
		System.out.println("2�� insert ���� :"+i+"���� ���� ����������ϴ�.");
		
		i = stmt.executeUpdate(sql3);
		System.out.println("3�� insert ���� :"+i+"���� ���� ����������ϴ�.");
	
		if(stmt != null)
			stmt.close();
		if(con != null)
			con.close();
		
		
		
	}
	
	

}
