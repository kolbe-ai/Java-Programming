import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillingDAO {

    // Generate a bill for an appointment
    public void addBill(int appointmentId, double consultationFee, double roomCharge, double otherCharges) {
        String sql = "INSERT INTO Billing (appointment_id, consultation_fee, room_charge, other_charges, payment_status) " +
                     "VALUES (?, ?, ?, ?, 'Unpaid')";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, appointmentId);
            ps.setDouble(2, consultationFee);
            ps.setDouble(3, roomCharge);
            ps.setDouble(4, otherCharges);

            int rows = ps.executeUpdate();
            System.out.println(rows + " bill(s) generated.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View all bills with patient names (JOIN across tables)
    public List<String> getAllBills() {
        List<String> bills = new ArrayList<>();
        String sql = "SELECT b.bill_id, p.patient_name, b.total_amount, b.payment_status " +
                     "FROM Billing b " +
                     "JOIN Appointments a ON b.appointment_id = a.appointment_id " +
                     "JOIN Patients p ON a.patient_id = p.patient_id";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String record = "Bill ID: " + rs.getInt("bill_id") +
                        ", Patient: " + rs.getString("patient_name") +
                        ", Total: Rs. " + rs.getDouble("total_amount") +
                        ", Status: " + rs.getString("payment_status");
                bills.add(record);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bills;
    }

    // Mark a bill as paid
    public void markAsPaid(int billId) {
        String sql = "UPDATE Billing SET payment_status = 'Paid' WHERE bill_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, billId);
            int rows = ps.executeUpdate();
            System.out.println(rows + " bill(s) marked as paid.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
