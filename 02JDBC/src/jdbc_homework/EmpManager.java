package jdbc_homework;

import java.sql.*;

public class EmpManager {
	
		
		static {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
				}
			}
		
		public static void main(String[] args) throws SQLException{
			
			new EmpManager().printEmployee("al",4000);
			
		}
		
		public void printEmployee(String name,int salary) throws SQLException{
			
			String dburl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			Connection conn = DriverManager.getConnection(dburl, "hr","hr");
			
			String sql01 = "select\r\n"
					+ "employee_id , first_name, salary\r\n"
					+ "from employees\r\n"
					+ "where instr(lower(first_name), lower(?)) > 0 and salary > ? ";
			
			PreparedStatement pStmt = conn.prepareStatement(sql01);
			
			pStmt.setString(1,"al");
			pStmt.setInt(2, 4000);
			
			
			ResultSet res = pStmt.executeQuery();
			
			while(res.next()) {
				System.out.println(res.getString(1)+" "+ res.getString(2)+" "+res.getInt(3));
				
				
				
			}
				res.close();
				pStmt.close();
				conn.close();
				
		}
		
	}


