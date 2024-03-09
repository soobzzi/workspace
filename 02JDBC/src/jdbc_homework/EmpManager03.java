package jdbc_homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpManager03 {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws SQLException{
		new EmpManager03().printEmployee("South San Francisco",7000,10000);
	}
	
	public void printEmployee(String city, int lo, int hi) throws SQLException{
		
		String dburl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection con = DriverManager.getConnection(dburl,"hr" ,"hr");
		
		String sql = "select\r\n"
				+ "last_name, department_name\r\n"
				+ "from employees e , departments d , locations l\r\n"
				+ "where e.department_id = d.department_id\r\n"
				+ "and d.location_id = l.location_id\r\n"
				+ "and l.city = ?\r\n"
				+ "and salary between ? and ?";
		
		PreparedStatement pStmt = con.prepareStatement(sql);
		
		pStmt.setString(1,city);
		pStmt.setInt(2,lo);
		pStmt.setInt(3,hi);
		
		ResultSet rs = pStmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2));
		}
		
		rs.close();
		pStmt.close();
		con.close();
	}
	

		
	
}

	
