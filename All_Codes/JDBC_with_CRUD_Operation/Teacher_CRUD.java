//40. Perform CRUD operations on a Teacher table using JDBC.

package program;

import java.sql.*;

public class Teacher_CRUD {
	public static void main(String[] args) {
		try {
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
			
			//create
			/*String query = "insert into teacher_new values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst = con.prepareStatement(query);
			pst.setInt(1, 103);
			pst.setString(2, "Raju");
			pst.setInt(3, 67800);
			pst.executeUpdate();
			*/
			
			 
			//read
			String query = "select * from teacher_new";
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int sal = rs.getInt("salary");
				System.out.printf("\nID: %d\t Name: %s\t Salary: %d\n",id,name,sal);
			}
			
			//update
			query = "update teacher_new set salary = ? where id = ?";
			pst = con.prepareStatement(query);
			pst.setInt(1, 67800);
			pst.setInt(2, 101);
			int flag = pst.executeUpdate();
			if (flag != 0) {
				System.out.println("Updated!");
			}
			
			//delete
			query = "delete from teacher_new where id = ?";
			pst = con.prepareStatement(query);
			pst.setInt(1,103);
			flag = pst.executeUpdate();
			if (flag != 0) {
				System.out.println("Deleted");
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
