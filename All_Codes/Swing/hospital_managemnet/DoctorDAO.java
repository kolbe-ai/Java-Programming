import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public void addDoctor(String name, String specialization, String phone, int deptId) {
        String sql = "INSERT INTO Doctors (doctor_name, specialization, phone, dept_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, specialization);
            ps.setString(3, phone);
            ps.setInt(4, deptId);

            int rows = ps.executeUpdate();
            System.out.println(rows + " doctor(s) added.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllDoctors() {
        List<String> doctors = new ArrayList<>();
        // JOIN with Departments to show department name instead of just ID
        String sql = "SELECT d.doctor_id, d.doctor_name, d.specialization, d.phone, dept.dept_name " +
                     "FROM Doctors d LEFT JOIN Departments dept ON d.dept_id = dept.dept_id";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String record = "ID: " + rs.getInt("doctor_id") +
                        ", Name: " + rs.getString("doctor_name") +
                        ", Specialization: " + rs.getString("specialization") +
                        ", Phone: " + rs.getString("phone") +
                        ", Department: " + rs.getString("dept_name");
                doctors.add(record);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    public void deleteDoctor(int doctorId) {
        String sql = "DELETE FROM Doctors WHERE doctor_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, doctorId);
            int rows = ps.executeUpdate();
            System.out.println(rows + " doctor(s) deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
