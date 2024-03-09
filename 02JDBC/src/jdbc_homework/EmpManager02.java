package jdbc_homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpManager02 {

	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			}
		}
	
		public static void main(String[] args) throws SQLException{
			
			String[] jobs = {"Accountant","Stock Clerk"};
	
				new EmpManager02().printEmployee(jobs);
			
			
		}
		
		public void printEmployee(String jobs[]) throws SQLException{
			
			String dburl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			Connection conn = DriverManager.getConnection(dburl, "hr","hr");
			
			String sql02 = "select\n"
					+"e.employee_id, e.first_name, e.salary\n"
					+"from employees e, jobs j\n"
					+"where e.job_id = j.job_id\n"
					+"and j.job_title IN(?,?)";
			
				PreparedStatement pStmt = conn.prepareStatement(sql02);
						
						pStmt.setString(1,"Accountant");
						pStmt.setString(2,"Stock Clerk");
						
						
						ResultSet res = pStmt.executeQuery();
						
						while(res.next()) {
						System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getInt(3));
						}
						
						res.close();
						pStmt.close();
						conn.close();
		}	
		
		
}


