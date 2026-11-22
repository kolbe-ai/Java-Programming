//41. Search teacher details by Teacher ID using JDBC.

package program;

import java.sql.*;
import java.util.Scanner;

public class Practice_41 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");	
			System.out.print("Enter ID to search: ");
			int id1 = sc.nextInt();
			
			String query = "select * from teacher_new where id = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id1);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int sal = rs.getInt("salary");
				System.out.printf("\n\nID: %d\t Name: %s \tSalary: %d",id,name,sal);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
