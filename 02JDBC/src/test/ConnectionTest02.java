package test;
import java.sql.*;
//import java.util.*;

//Oracle Driver 사용
import oracle.jdbc.driver.*;

/*
*	FileName : ConnectionTest01.java
*
*	1. JDBC Programming  절차 이해
 *   ==>DBMS 접근(login과정)			: Connection 객체로 Object Modeling
 *   ==>SQL Prompt  & SQL전송		: Statement  객체로 Object Modeling
 *   ==>SQL문의 결과						: ResultSet 객체로 Object Modeling
*/
public class ConnectionTest02{
   
	///Main Method
	public static void main(String[] args) throws Exception{

		//DB에 로그인 접속정보
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user ="scott";
		String pwd = "tiger";

/*		//1.단계  connection :: login 과정
		//1.1 OracleDriver  instance 생성
		OracleDriver od = new OracleDriver();

		//1.2 oracle에 접속 정보를 갖는  properties instance 생성 
		Properties info = new Properties();
		info.put("user",user);
		info.put("password",pwd);

		//1.3OracleDriver intance를 사용  Connection instance 생성
		Connection con = od.connect(url,info);
*/
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,user,pwd);
		//로그인했당

		//2단계 QUERY (SELECT * FROM product) 전송단계 
		Statement stmt = con.createStatement();
		//sql프롬프트잡음
		ResultSet rs = stmt.executeQuery("SELECT * FROM product"); 
		//쿼리는 String sql

		//3단계 결과 확인
		while(rs.next()) {
		
		//while(rs.next())
		//while(null != readLine());
		//true - 다음행 

		String productName = rs.getString("p_name");
		//String productName = rs.getString(1);
		//하이딩된 정보 접속 get
		int productPrice = rs.getInt("p_price");
		//int productPrice = rs.getInt(2);

		System.out.println("상품명 : "+productName);
		System.out.println("가   격 : "+productPrice);
		}

		//각각의 객체를 close한다.
		rs.close();
		stmt.close();
		con.close();
		
		//외부자원 연결할시 close 

	}//end of main

}//end of class