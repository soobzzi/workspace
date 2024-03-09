package jdbc_homework;

import java.sql.*;

public class EmpStatistics {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			}
		}
	
	public static void main(String[] args) throws SQLException{
		
		int maxSalary = 10000;
		new EmpStatistics().printStatistics(maxSalary);
		
		maxSalary = 15000;
		new EmpStatistics().printStatistics(maxSalary);
	}
	
	public void printStatistics(int maxSalary) throws SQLException{
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user ="hr";
		String pwd = "hr";
		
		Connection con = DriverManager.getConnection(url,user,pwd);
		
		String sql = "select\r\n"
				+ "j.job_title, avg(e.salary)\n"
				+ "from Employees e, jobs j\r\n"
				+ "where e.job_id= j.job_id\r\n"
				+ "and e.salary >= ?\r\n"
				+ "group by job_title\r\n"
				+ "order by avg(e.salary) desc\r\n";
		
		PreparedStatement pStmt = con.prepareStatement(sql);
		
		pStmt.setInt(1, maxSalary);
		
		ResultSet res = pStmt.executeQuery();
		
		System.out.println("======================");
		System.out.println("Max Salary :"+maxSalary);
		System.out.println("======================");
		
		while(res.next()) {
			System.out.println(res.getString(1)+" "+res.getInt(2));
		}
		
		res.close();
		pStmt.close();
		con.close();
		
	}

}
