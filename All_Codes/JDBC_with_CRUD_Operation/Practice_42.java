//42. Generate a teacher salary report using JDBC.

package program;

import java.sql.*;

public class Practice_42 {
	public static void main(String[] args) {
		try {
			String query = "select id,salary from teacher_new";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int id= rs.getInt("id");
				int salary = rs.getInt("salary");
				System.out.printf("\n\nID: %d\t Salary: %d\n",id,salary);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
