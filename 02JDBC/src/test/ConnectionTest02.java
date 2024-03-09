package test;
import java.sql.*;
//import java.util.*;

//Oracle Driver ���
import oracle.jdbc.driver.*;

/*
*	FileName : ConnectionTest01.java
*
*	1. JDBC Programming  ���� ����
 *   ==>DBMS ����(login����)			: Connection ��ü�� Object Modeling
 *   ==>SQL Prompt  & SQL����		: Statement  ��ü�� Object Modeling
 *   ==>SQL���� ���						: ResultSet ��ü�� Object Modeling
*/
public class ConnectionTest02{
   
	///Main Method
	public static void main(String[] args) throws Exception{

		//DB�� �α��� ��������
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user ="scott";
		String pwd = "tiger";

/*		//1.�ܰ�  connection :: login ����
		//1.1 OracleDriver  instance ����
		OracleDriver od = new OracleDriver();

		//1.2 oracle�� ���� ������ ����  properties instance ���� 
		Properties info = new Properties();
		info.put("user",user);
		info.put("password",pwd);

		//1.3OracleDriver intance�� ���  Connection instance ����
		Connection con = od.connect(url,info);
*/
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,user,pwd);
		//�α����ߴ�

		//2�ܰ� QUERY (SELECT * FROM product) ���۴ܰ� 
		Statement stmt = con.createStatement();
		//sql������Ʈ����
		ResultSet rs = stmt.executeQuery("SELECT * FROM product"); 
		//������ String sql

		//3�ܰ� ��� Ȯ��
		while(rs.next()) {
		
		//while(rs.next())
		//while(null != readLine());
		//true - ������ 

		String productName = rs.getString("p_name");
		//String productName = rs.getString(1);
		//���̵��� ���� ���� get
		int productPrice = rs.getInt("p_price");
		//int productPrice = rs.getInt(2);

		System.out.println("��ǰ�� : "+productName);
		System.out.println("��   �� : "+productPrice);
		}

		//������ ��ü�� close�Ѵ�.
		rs.close();
		stmt.close();
		con.close();
		
		//�ܺ��ڿ� �����ҽ� close 

	}//end of main

}//end of class