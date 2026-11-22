import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    // CREATE
    public void addPatient(String name, int age, String gender, String phone, String address) {
        String sql = "INSERT INTO Patients (patient_name, age, gender, phone, address) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, gender);
            ps.setString(4, phone);
            ps.setString(5, address);

            int rows = ps.executeUpdate();
            System.out.println(rows + " patient(s) added.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ ALL
    public List<String> getAllPatients() {
        List<String> patients = new ArrayList<>();
        String sql = "SELECT * FROM Patients";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String record = "ID: " + rs.getInt("patient_id") +
                        ", Name: " + rs.getString("patient_name") +
                        ", Age: " + rs.getInt("age") +
                        ", Gender: " + rs.getString("gender") +
                        ", Phone: " + rs.getString("phone") +
                        ", Address: " + rs.getString("address");
                patients.add(record);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    // UPDATE
    public void updatePatientPhone(int patientId, String newPhone) {
        String sql = "UPDATE Patients SET phone = ? WHERE patient_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newPhone);
            ps.setInt(2, patientId);

            int rows = ps.executeUpdate();
            System.out.println(rows + " patient(s) updated.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deletePatient(int patientId) {
        String sql = "DELETE FROM Patients WHERE patient_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, patientId);
            int rows = ps.executeUpdate();
            System.out.println(rows + " patient(s) deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
