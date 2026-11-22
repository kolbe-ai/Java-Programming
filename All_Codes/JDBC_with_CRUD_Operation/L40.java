//40. Perform CRUD operations on Student table using JDBC.

package program;

import java.sql.*;
public class L40 {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
			System.out.println("Connected to the database sucessfully!\n");
			
			//1. create (inerting a new student)
			createStudent(con,1,"Alice Smith",20,"A");
			
			//2. read (display the students)
			readStudent(con);
			
			//3. update
			updateStudent(con,1,"A++");
			
			//4. delete
			//deleteStudent(con,1);
			con.close();			
		}catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public static void createStudent(Connection con, int id, String name, int age, String grade) throws SQLException{
		String query = "insert into student values(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1,id);
		pstmt.setString(2,name);
		pstmt.setInt(3,age);
		pstmt.setString(4,grade);
		
		pstmt.executeUpdate();
		System.out.printf("-> Record created: %s",name);
		pstmt.close();
	}
	
	public static void readStudent(Connection con) throws SQLException{
		String query = "select * from students";
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		
		System.out.println("\n Student Record\n");
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String grade = rs.getString("grade");
			System.out.printf("ID: %d | Name: %s | Age: %d | Grade : %s ",id,name,age,grade);
			System.out.println("______________________________________________");
		}
		rs.close();
		pst.close();
	}
	
	public static void updateStudent(Connection con, int id, String grade) throws SQLException{
		String query = "update student set grade = ? where id = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1,grade);
		pst.setInt(2,id);
		pst.executeUpdate();
		System.out.printf("-> Record Updated for ID: %d", id);
	}
	
	public static void deleteStudent(Connection con, int id) throws SQLException {
		String query = "delete from student where id = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		pst.executeUpdate();
	}

}
