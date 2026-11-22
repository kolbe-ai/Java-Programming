import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    // Book a new appointment
    public void bookAppointment(int patientId, int doctorId, int roomId, String date, String time) {
        String sql = "INSERT INTO Appointments (patient_id, doctor_id, room_id, appointment_date, appointment_time, status) " +
                     "VALUES (?, ?, ?, ?, ?, 'Scheduled')";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, patientId);
            ps.setInt(2, doctorId);
            ps.setInt(3, roomId);
            ps.setDate(4, Date.valueOf(date));       // format: yyyy-MM-dd
            ps.setTime(5, Time.valueOf(time + ":00")); // format: HH:mm

            int rows = ps.executeUpdate();
            System.out.println(rows + " appointment(s) booked.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View all appointments with patient & doctor names (JOIN across 3 tables)
    public List<String> getAllAppointments() {
        List<String> appointments = new ArrayList<>();
        String sql = "SELECT a.appointment_id, p.patient_name, d.doctor_name, " +
                     "a.appointment_date, a.appointment_time, a.status " +
                     "FROM Appointments a " +
                     "JOIN Patients p ON a.patient_id = p.patient_id " +
                     "JOIN Doctors d ON a.doctor_id = d.doctor_id " +
                     "ORDER BY a.appointment_date, a.appointment_time";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String record = "Appt ID: " + rs.getInt("appointment_id") +
                        ", Patient: " + rs.getString("patient_name") +
                        ", Doctor: " + rs.getString("doctor_name") +
                        ", Date: " + rs.getDate("appointment_date") +
                        ", Time: " + rs.getTime("appointment_time") +
                        ", Status: " + rs.getString("status");
                appointments.add(record);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    // Cancel / update appointment status
    public void updateStatus(int appointmentId, String newStatus) {
        String sql = "UPDATE Appointments SET status = ? WHERE appointment_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newStatus);
            ps.setInt(2, appointmentId);

            int rows = ps.executeUpdate();
            System.out.println(rows + " appointment(s) updated to '" + newStatus + "'.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAppointment(int appointmentId) {
        String sql = "DELETE FROM Appointments WHERE appointment_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, appointmentId);
            int rows = ps.executeUpdate();
            System.out.println(rows + " appointment(s) deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
