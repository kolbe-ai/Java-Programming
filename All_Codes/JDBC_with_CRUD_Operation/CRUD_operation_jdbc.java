//CRUD operation using JDBC
//create, read, update, delete

package program;

import java.sql.*;
import java.util.Scanner;
public class CRUD_operation_jdbc {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);	
			while(true) {
				int choice;
				System.out.print("Enter 1 for insert\nEnter 2 to read\nEnter 3 to update\nEnter 4 to delete\nEnter 0 to exit\n\nEnter your choice: ");
				choice = sc.nextInt();
				
				switch(choice) {
					case 1:
						System.out.printf("Enter the student ID: ");
						int id = sc.nextInt();
						sc.nextLine();
						System.out.printf("Enter the student name: ");
						String name = sc.nextLine();
						System.out.printf("Enter the student age : ");
						int age = sc.nextInt();
						System.out.printf("Enter the student grade: ");
						sc.nextLine();
						String grade = sc.nextLine();
						
						//inserting 
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
						String query = "insert into student values (?,?,?,?)";
						PreparedStatement pst = con.prepareStatement(query);
						pst.setInt(1, id);
						pst.setString(2,name);
						pst.setInt(3,age);
						pst.setString(4,grade);
						pst.executeUpdate();
						con.close();
						break;
					
					case 2:
						//read
						Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
						String query1 = "select * from student";
						PreparedStatement pst1 = con1.prepareStatement(query1);
						ResultSet rs = pst1.executeQuery();
						int flag = 0;
						while(rs.next()) {
							flag++;
							int id1 = rs.getInt("id");
							String name1 = rs.getString("name");
							int age1 = rs.getInt("age");
							String grade1 = rs.getString("grade");
							System.out.println("__________________________________________________________________________________________");
							System.out.printf("\n|\tID:  %d\t | \tName:  %s\t | \tAge:  %d\t | \tGrade: %s \t|\n",id1,name1,age1,grade1);
							System.out.println("__________________________________________________________________________________________\n");
						}
						con1.close();
						break;
					case 3:
						//update
						Connection con2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
						System.out.print("Enter the student ID to update: ");
						int id2 = sc.nextInt();
						System.out.print("Enter the new grade: ");
						sc.nextLine();
						String grade2 = sc.nextLine();
						String query2 = "update student set grade = ? where id = ?";
						PreparedStatement pst2 = con2.prepareStatement(query2);
						pst2.setString(1,grade2);
						pst2.setInt(2,id2);
						pst2.executeUpdate();
						System.out.println("\nStudent updated...!");
						con2.close();
						break;
					case 4:
						//delete
						Connection con3 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
						System.out.print("Enter the student ID to delete: ");
						int id3 = sc.nextInt();
						String query3 = "delete from student where id = ?";
						PreparedStatement pst3 = con3.prepareStatement(query3);
						pst3.setInt(1,id3);
						pst3.executeUpdate();
						System.out.println("\nStudent deleted...!");
						con3.close();
						break;
					case 0:
						return;
				}				
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
