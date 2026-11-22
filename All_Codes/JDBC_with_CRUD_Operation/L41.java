//41. Search student details by Roll Number using JDBC.
package program;

import java.sql.*;
import java.util.Scanner;

public class L41 {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
			Scanner sc = new Scanner(System.in);
			System.out.printf("Enter the student id: ");
			int id = sc.nextInt();
			String query = "select * from student where id = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				String name1 = rs.getString("name");
				System.out.printf("Name: %s",name1 );
			}else {
				System.out.println("No student found!");
			}
		}catch (SQLException e){
			System.out.println(e);
		}
	}

}
