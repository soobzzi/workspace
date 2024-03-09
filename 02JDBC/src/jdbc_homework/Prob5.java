package jdbc_homework;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;

import java.sql.*;

public class Prob5 {
	
	public static void main(String[] args) throws Exception {
		
		if(args.length != 1) {
			System.out.println("부서의 아이디를 입력하세요...");
			System.exit(1);
		}
		
		String dept_id = args[0];
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		
			con = DriverManager.getConnection(url, "hr","hr");
			
			String sql = "select \r\n"
					+ "e.employee_id, d.department_name , e.salary , vt.avg avg_salary\r\n"
					+ "from employees e, departments d, (select avg(salary) avg, department_id from employees group by department_id\r\n"
					+ ") vt\r\n"
					+ "where \r\n"
					+ "e.department_id = d.department_id \r\n"
					+ "and d.department_id = vt.department_id\r\n"
					+ "and e.department_id = '" +dept_id+ "' ";
			
			
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println(rsmd.getColumnName(1)+" "+rsmd.getColumnName(2)+" "+rsmd.getColumnName(3)+" "+rsmd.getColumnName(4));
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(stmt != null)
				stmt.close();
			if(con != null)
				con.close();
			if(rs != null)
				rs.close();
		}
	}
}
