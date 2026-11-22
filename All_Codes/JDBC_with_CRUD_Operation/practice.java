package program;
/*
Write a Java program where the user enters a minimum age, 
and your program loops through and prints out the details 
of every student who is that age or older.
 */

import java.sql.*;
import java.util.Scanner;

public class practice {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.printf("Enter the age: ");
			int age = sc.nextInt();
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
			String query = "select * from student where age>= ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,age);
			ResultSet rs = pst.executeQuery();
			int flag = 0;
			while(rs.next()) {
				flag++;
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age_s = rs.getInt("age");
				String grade = rs.getString("grade");
				System.out.println("__________________________________________________________________\n");
				System.out.printf("ID: %s	|	Name : %s 	| Age: %d	| Grade: %s\n",id,name,age_s,grade);
				System.out.println("__________________________________________________________________\n");
			}
			if(flag == 0) {
				System.out.println("No student found under this age");
			}			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
