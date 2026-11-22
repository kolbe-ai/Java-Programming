// Generate a marks report using JDBC.
package program;
import java.sql.*;
import java.util.Scanner;

public class L42 {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
			String query = "select * from student order by age desc";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			int flag = 0 ;
			while(rs.next()) {
				flag++;
				int id = rs.getInt("id");
				String name = rs.getString("Name");
				int age = rs.getInt("age");
				String grade = rs.getString("grade");
				System.out.println("__________________________________________________________________________________________");
				System.out.printf("\n|\tID:  %d\t | \tName:  %s\t | \tAge:  %d\t | \tGrade: %s \t|\n",id,name,age,grade);
				System.out.println("__________________________________________________________________________________________");
			}
			if (flag == 0) {
				System.out.println("\nNo data found");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
