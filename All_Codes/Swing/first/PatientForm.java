package first;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PatientForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLayeredPane contentPane;

	// ---- Patients ----
	private JTextField textField;      // Patient Name
	private JTextField textField_1;    // Age
	private JTextField textField_3;    // Phone no
	private JTextField textField_4;    // Address
	private JTable table_2;            // Patients table
	private JComboBox comboBox;        // Gender

	// ---- Doctors ----
	private JTextField textField_5;    // Dept ID
	private JTextField textField_6;    // Phone
	private JTextField textField_8;    // Specialization
	private JTextField textField_9;    // Doctor Name
	private JTable table;              // Doctors table

	// ---- Appointments ----
	private JTextField textField_7;    // Patient ID
	private JTextField textField_10;   // Doctor ID
	private JTextField textField_12;   // Room ID
	private JTextField textField_11;   // Appointment Date
	private JTextField textField_13;   // Appointment Time
	private JComboBox comboBox_1;      // Status
	private JTable table_1;            // Appointments table

	// ---- Rooms (new) ----
	private JTextField txtRoomNumber;
	private JComboBox comboRoomType;
	private JTextField txtRoomDeptId;
	private JTable tableRooms;

	// ---- Billing (new) ----
	private JTextField txtApptId;
	private JTextField txtConsultFee;
	private JTextField txtRoomCharge;
	private JTextField txtOtherCharges;
	private JTable tableBills;

	private JButton btnNewButton_4;
	private JButton btnNewButton_5;

	// ---- Update/Delete ID fields ----
	private JTextField txtPatientUpdateId;
	private JTextField txtDoctorUpdateId;
	private JTextField txtApptUpdateId;
	private JTextField txtRoomUpdateId;
	private JTextField txtBillUpdateId;
	private JTextField txtDeptUpdateId;

	// ---- Departments (new) ----
	private JTextField txtDeptName;
	private JTextField txtDeptLocation;
	private JTable tableDepts;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientForm frame = new PatientForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PatientForm() {
		setBackground(new Color(0, 255, 64));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);

		contentPane = new JLayeredPane();
		contentPane.setBackground(new Color(0, 255, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(10, 20, 1166, 740);
		contentPane.add(tabbedPane);

		JPanel patientPanel = new JPanel();
		patientPanel.setBackground(new Color(174, 231, 137));
		patientPanel.setLayout(null);
		tabbedPane.addTab("Patients", patientPanel);

		JPanel doctorPanel = new JPanel();
		doctorPanel.setBackground(new Color(174, 231, 137));
		doctorPanel.setLayout(null);
		tabbedPane.addTab("Doctors", doctorPanel);

		JPanel appointmentPanel = new JPanel();
		appointmentPanel.setBackground(new Color(174, 231, 137));
		appointmentPanel.setLayout(null);
		tabbedPane.addTab("Appointments", appointmentPanel);

		JPanel roomPanel = new JPanel();
		roomPanel.setBackground(new Color(174, 231, 137));
		roomPanel.setLayout(null);
		tabbedPane.addTab("Rooms", roomPanel);

		JPanel billingPanel = new JPanel();
		billingPanel.setBackground(new Color(174, 231, 137));
		billingPanel.setLayout(null);
		tabbedPane.addTab("Billing", billingPanel);

		JPanel deptPanel = new JPanel();
		deptPanel.setBackground(new Color(174, 231, 137));
		deptPanel.setLayout(null);
		tabbedPane.addTab("Departments", deptPanel);

		// =======================================================
		// PATIENTS TAB
		// =======================================================
		JLabel lblP0 = new JLabel("ENTER DETAILS");
		lblP0.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblP0.setBounds(74, 20, 150, 26);
		patientPanel.add(lblP0);

		JLabel lblP1 = new JLabel("PATIENT DETAILS");
		lblP1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblP1.setBounds(561, 20, 150, 26);
		patientPanel.add(lblP1);

		JLabel lblNewLabel_1 = new JLabel("Patient Name:");
		lblNewLabel_1.setBounds(34, 86, 79, 13);
		patientPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Age:");
		lblNewLabel_2.setBounds(34, 105, 61, 13);
		patientPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Gender:");
		lblNewLabel_3.setBounds(33, 124, 80, 13);
		patientPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Address:");
		lblNewLabel_4.setBounds(34, 143, 79, 13);
		patientPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Phone no:");
		lblNewLabel_5.setBounds(34, 162, 79, 13);
		patientPanel.add(lblNewLabel_5);

		textField = new JTextField();
		textField.setBounds(130, 83, 103, 19);
		patientPanel.add(textField);

		textField_1 = new JTextField();
		textField_1.setBounds(130, 102, 103, 19);
		patientPanel.add(textField_1);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Male", "Female"}));
		comboBox.setBounds(130, 121, 103, 20);
		patientPanel.add(comboBox);

		textField_4 = new JTextField();
		textField_4.setBounds(130, 140, 103, 19);
		patientPanel.add(textField_4);

		textField_3 = new JTextField();
		textField_3.setBounds(130, 159, 103, 19);
		patientPanel.add(textField_3);

		JButton btnNewButton = new JButton("ADD PATIENT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String ageText = textField_1.getText();
				String gender = (String) comboBox.getSelectedItem();
				String phone = textField_3.getText();
				String address = textField_4.getText();

				if (name.isEmpty() || ageText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Name and Age are required.");
					return;
				}

				int age;
				try {
					age = Integer.parseInt(ageText);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Age must be a number.");
					return;
				}

				String sql = "INSERT INTO Patients (patient_name, age, gender, phone, address) VALUES (?, ?, ?, ?, ?)";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql)) {

					ps.setString(1, name);
					ps.setInt(2, age);
					ps.setString(3, gender);
					ps.setString(4, phone);
					ps.setString(5, address);

					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Patient added successfully!");

					textField.setText("");
					textField_1.setText("");
					comboBox.setSelectedIndex(0);
					textField_3.setText("");
					textField_4.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnNewButton.setBounds(118, 185, 118, 19);
		patientPanel.add(btnNewButton);

		JLabel lblPatientUpdateId = new JLabel("Patient ID:");
		lblPatientUpdateId.setBounds(34, 220, 79, 13);
		patientPanel.add(lblPatientUpdateId);

		txtPatientUpdateId = new JTextField();
		txtPatientUpdateId.setBounds(130, 217, 103, 19);
		patientPanel.add(txtPatientUpdateId);

		JButton btnUpdatePatient = new JButton("UPDATE");
		btnUpdatePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText = txtPatientUpdateId.getText();
				String ageText = textField_1.getText();

				if (idText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Patient ID to update.");
					return;
				}
				if (textField.getText().isEmpty() || ageText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Fill in Name and Age before updating.");
					return;
				}

				int patientId, age;
				try {
					patientId = Integer.parseInt(idText);
					age = Integer.parseInt(ageText);
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Patient ID and Age must be numbers.");
					return;
				}

				String sql = "UPDATE Patients SET patient_name=?, age=?, gender=?, phone=?, address=? WHERE patient_id=?";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql)) {

					ps.setString(1, textField.getText());
					ps.setInt(2, age);
					ps.setString(3, (String) comboBox.getSelectedItem());
					ps.setString(4, textField_3.getText());
					ps.setString(5, textField_4.getText());
					ps.setInt(6, patientId);

					int rows = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, rows > 0 ? "Patient updated!" : "No patient with that ID.");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnUpdatePatient.setBounds(118, 245, 100, 19);
		patientPanel.add(btnUpdatePatient);

		JButton btnDeletePatient = new JButton("DELETE");
		btnDeletePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText = txtPatientUpdateId.getText();
				if (idText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Patient ID to delete.");
					return;
				}

				String sql = "DELETE FROM Patients WHERE patient_id=?";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql)) {

					ps.setInt(1, Integer.parseInt(idText));
					int rows = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, rows > 0 ? "Patient deleted!" : "No patient with that ID.");
					txtPatientUpdateId.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnDeletePatient.setBounds(226, 245, 100, 19);
		patientPanel.add(btnDeletePatient);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(392, 60, 700, 200);
		patientPanel.add(scrollPane_1);

		table_2 = new JTable();
		scrollPane_1.setViewportView(table_2);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] { "Patient ID", "Patient Name", "Age", "Gender", "Phone no", "Address" }
		));

		JButton btnNewButton_1 = new JButton("SHOW PATIENTS");
		btnNewButton_1.setBounds(554, 275, 148, 20);
		patientPanel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Patient ID");
				model.addColumn("Patient Name");
				model.addColumn("Age");
				model.addColumn("Gender");
				model.addColumn("Phone no");
				model.addColumn("Address");

				String sql = "SELECT patient_id, patient_name, age, gender, phone, address FROM Patients";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql);
				     ResultSet rs = ps.executeQuery()) {

					while (rs.next()) {
						Object[] row = {
							rs.getInt("patient_id"), rs.getString("patient_name"), rs.getInt("age"),
							rs.getString("gender"), rs.getString("phone"), rs.getString("address")
						};
						model.addRow(row);
					}
					table_2.setModel(model);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});

		// =======================================================
		// DOCTORS TAB
		// =======================================================
		JLabel lblD0 = new JLabel("ENTER DETAILS");
		lblD0.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblD0.setBounds(74, 20, 150, 26);
		doctorPanel.add(lblD0);

		JLabel lblD1 = new JLabel("DOCTOR DETAILS");
		lblD1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblD1.setBounds(561, 20, 150, 20);
		doctorPanel.add(lblD1);

		JLabel lblNewLabel_8 = new JLabel("Doctor Name:");
		lblNewLabel_8.setBounds(24, 86, 91, 13);
		doctorPanel.add(lblNewLabel_8);

		JLabel lblNewLabel_7 = new JLabel("Specialization:");
		lblNewLabel_7.setBounds(21, 105, 97, 13);
		doctorPanel.add(lblNewLabel_7);

		JLabel lblNewLabel_9 = new JLabel("Department ID:");
		lblNewLabel_9.setBounds(24, 124, 91, 13);
		doctorPanel.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Phone no:");
		lblNewLabel_10.setBounds(24, 143, 65, 13);
		doctorPanel.add(lblNewLabel_10);

		textField_9 = new JTextField();
		textField_9.setBounds(128, 83, 103, 19);
		doctorPanel.add(textField_9);

		textField_8 = new JTextField();
		textField_8.setBounds(128, 102, 103, 19);
		doctorPanel.add(textField_8);

		textField_5 = new JTextField();
		textField_5.setBounds(128, 121, 103, 19);
		doctorPanel.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setBounds(128, 140, 103, 19);
		doctorPanel.add(textField_6);

		JButton btnNewButton_2 = new JButton("ADD DOCTOR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String doctorName = textField_9.getText();
				String specialization = textField_8.getText();
				String departmentText = textField_5.getText();
				String phoneNo = textField_6.getText();

				if (doctorName.isEmpty() || specialization.isEmpty() || departmentText.isEmpty() || phoneNo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter all doctor details.");
					return;
				}

				int departmentId;
				try {
					departmentId = Integer.parseInt(departmentText);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Department ID must be a number.");
					return;
				}

				String sql = "INSERT INTO doctors (doctor_name, phone, specialization, dept_id) VALUES (?, ?, ?, ?)";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql)) {

					ps.setString(1, doctorName);
					ps.setString(2, phoneNo);
					ps.setString(3, specialization);
					ps.setInt(4, departmentId);

					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Doctor added successfully!");

					textField_9.setText("");
					textField_8.setText("");
					textField_5.setText("");
					textField_6.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(120, 185, 127, 20);
		doctorPanel.add(btnNewButton_2);

		JLabel lblDoctorUpdateId = new JLabel("Doctor ID:");
		lblDoctorUpdateId.setBounds(24, 220, 91, 13);
		doctorPanel.add(lblDoctorUpdateId);

		txtDoctorUpdateId = new JTextField();
		txtDoctorUpdateId.setBounds(128, 217, 103, 19);
		doctorPanel.add(txtDoctorUpdateId);

		JButton btnUpdateDoctor = new JButton("UPDATE");
		btnUpdateDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText = txtDoctorUpdateId.getText();
				if (idText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Doctor ID to update.");
					return;
				}

				String sql = "UPDATE Doctors SET doctor_name=?, specialization=?, phone=?, dept_id=? WHERE doctor_id=?";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql)) {

					ps.setString(1, textField_9.getText());
					ps.setString(2, textField_8.getText());
					ps.setString(3, textField_6.getText());
					ps.setInt(4, Integer.parseInt(textField_5.getText()));
					ps.setInt(5, Integer.parseInt(idText));

					int rows = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, rows > 0 ? "Doctor updated!" : "No doctor with that ID.");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnUpdateDoctor.setBounds(120, 245, 100, 19);
		doctorPanel.add(btnUpdateDoctor);

		JButton btnDeleteDoctor = new JButton("DELETE");
		btnDeleteDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText = txtDoctorUpdateId.getText();
				if (idText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Doctor ID to delete.");
					return;
				}

				String sql = "DELETE FROM Doctors WHERE doctor_id=?";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql)) {

					ps.setInt(1, Integer.parseInt(idText));
					int rows = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, rows > 0 ? "Doctor deleted!" : "No doctor with that ID.");
					txtDoctorUpdateId.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnDeleteDoctor.setBounds(228, 245, 100, 19);
		doctorPanel.add(btnDeleteDoctor);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(386, 60, 700, 200);
		doctorPanel.add(scrollPane_2);

		table = new JTable();
		scrollPane_2.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] { "Doctor ID", "Doctor Name", "Phone no", "Specialization", "Department ID" }
		));

		JButton btnNewButton_3 = new JButton("SHOW DOCTORS");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Doctor ID");
				model.addColumn("Doctor Name");
				model.addColumn("Phone no");
				model.addColumn("Specialization");
				model.addColumn("Department ID");

				String sql = "SELECT doctor_id, doctor_name, phone, specialization, dept_id FROM doctors";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql);
				     ResultSet rs = ps.executeQuery()) {

					while (rs.next()) {
						Object[] row = {
							rs.getInt("doctor_id"), rs.getString("doctor_name"), rs.getString("phone"),
							rs.getString("specialization"), rs.getString("dept_id")
						};
						model.addRow(row);
					}
					table.setModel(model);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnNewButton_3.setBounds(558, 275, 144, 20);
		doctorPanel.add(btnNewButton_3);

		// =======================================================
		// APPOINTMENTS TAB
		// =======================================================
		JLabel lblA0 = new JLabel("ENTER DETAILS");
		lblA0.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblA0.setBounds(74, 20, 150, 26);
		appointmentPanel.add(lblA0);

		JLabel lblA1 = new JLabel("APPOINTMENT DETAILS");
		lblA1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblA1.setBounds(561, 20, 200, 20);
		appointmentPanel.add(lblA1);

		JLabel lblNewLabel_15 = new JLabel("Patient ID:");
		lblNewLabel_15.setBounds(21, 86, 91, 13);
		appointmentPanel.add(lblNewLabel_15);

		JLabel lblNewLabel_16 = new JLabel("Doctor ID:");
		lblNewLabel_16.setBounds(21, 105, 91, 13);
		appointmentPanel.add(lblNewLabel_16);

		JLabel lblNewLabel_17 = new JLabel("Room ID:");
		lblNewLabel_17.setBounds(21, 124, 94, 13);
		appointmentPanel.add(lblNewLabel_17);

		JLabel lblNewLabel_18 = new JLabel("Appointment Date:");
		lblNewLabel_18.setBounds(21, 143, 108, 13);
		appointmentPanel.add(lblNewLabel_18);

		JLabel lblNewLabel_19 = new JLabel("Appointment Time:");
		lblNewLabel_19.setBounds(21, 162, 108, 13);
		appointmentPanel.add(lblNewLabel_19);

		JLabel lblNewLabel_20 = new JLabel("Status:");
		lblNewLabel_20.setBounds(21, 181, 91, 13);
		appointmentPanel.add(lblNewLabel_20);

		textField_7 = new JTextField();
		textField_7.setBounds(140, 83, 103, 19);
		appointmentPanel.add(textField_7);

		textField_10 = new JTextField();
		textField_10.setBounds(140, 102, 103, 19);
		appointmentPanel.add(textField_10);

		textField_12 = new JTextField();
		textField_12.setBounds(140, 121, 103, 19);
		appointmentPanel.add(textField_12);

		textField_11 = new JTextField();
		textField_11.setBounds(140, 140, 103, 19);
		appointmentPanel.add(textField_11);

		textField_13 = new JTextField();
		textField_13.setBounds(140, 159, 103, 19);
		appointmentPanel.add(textField_13);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "Scheduled", "Not scheduled"}));
		comboBox_1.setBounds(140, 178, 103, 20);
		appointmentPanel.add(comboBox_1);

		btnNewButton_4 = new JButton("ADD APPOINTMENT");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patientIdText = textField_7.getText();
				String doctorIdText = textField_10.getText();
				String roomIdText = textField_12.getText();
				String date = textField_11.getText();      // expects: 2026-09-05
				String time = textField_13.getText();       // expects: 10:30:00
				String status = (String) comboBox_1.getSelectedItem();

				if (patientIdText.isEmpty() || doctorIdText.isEmpty() || date.isEmpty() || time.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Patient ID, Doctor ID, Date and Time are required.");
					return;
				}

				String sql = "INSERT INTO Appointments (patient_id, doctor_id, room_id, appointment_date, appointment_time, status) " +
				             "VALUES (?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?)";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql)) {

					ps.setInt(1, Integer.parseInt(patientIdText));
					ps.setInt(2, Integer.parseInt(doctorIdText));

					if (roomIdText.isEmpty()) {
						ps.setNull(3, java.sql.Types.NUMERIC);
					} else {
						ps.setInt(3, Integer.parseInt(roomIdText));
					}

					ps.setString(4, date);
					ps.setString(5, time);
					ps.setString(6, (status == null || status.isEmpty()) ? "Scheduled" : status);

					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Appointment added successfully!");

					textField_7.setText("");
					textField_10.setText("");
					textField_12.setText("");
					textField_11.setText("");
					textField_13.setText("");
					comboBox_1.setSelectedIndex(0);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnNewButton_4.setBounds(108, 220, 150, 20);
		appointmentPanel.add(btnNewButton_4);

		JLabel lblApptUpdateId = new JLabel("Appointment ID:");
		lblApptUpdateId.setBounds(21, 255, 108, 13);
		appointmentPanel.add(lblApptUpdateId);

		txtApptUpdateId = new JTextField();
		txtApptUpdateId.setBounds(140, 252, 103, 19);
		appointmentPanel.add(txtApptUpdateId);

		JButton btnUpdateAppt = new JButton("UPDATE");
		btnUpdateAppt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText = txtApptUpdateId.getText();
				if (idText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Appointment ID to update.");
					return;
				}

				String sql = "UPDATE Appointments SET patient_id=?, doctor_id=?, room_id=?, " +
				             "appointment_date=TO_DATE(?, 'YYYY-MM-DD'), appointment_time=?, status=? WHERE appointment_id=?";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql)) {

					ps.setInt(1, Integer.parseInt(textField_7.getText()));
					ps.setInt(2, Integer.parseInt(textField_10.getText()));

					String roomIdText = textField_12.getText();
					if (roomIdText.isEmpty()) {
						ps.setNull(3, java.sql.Types.NUMERIC);
					} else {
						ps.setInt(3, Integer.parseInt(roomIdText));
					}

					ps.setString(4, textField_11.getText());
					ps.setString(5, textField_13.getText());
					String status = (String) comboBox_1.getSelectedItem();
					ps.setString(6, (status == null || status.isEmpty()) ? "Scheduled" : status);
					ps.setInt(7, Integer.parseInt(idText));

					int rows = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, rows > 0 ? "Appointment updated!" : "No appointment with that ID.");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnUpdateAppt.setBounds(108, 280, 100, 19);
		appointmentPanel.add(btnUpdateAppt);

		JButton btnDeleteAppt = new JButton("DELETE");
		btnDeleteAppt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText = txtApptUpdateId.getText();
				if (idText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Appointment ID to delete.");
					return;
				}

				String sql = "DELETE FROM Appointments WHERE appointment_id=?";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql)) {

					ps.setInt(1, Integer.parseInt(idText));
					int rows = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, rows > 0 ? "Appointment deleted!" : "No appointment with that ID.");
					txtApptUpdateId.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnDeleteAppt.setBounds(216, 280, 100, 19);
		appointmentPanel.add(btnDeleteAppt);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(348, 60, 750, 200);
		appointmentPanel.add(scrollPane_3);

		table_1 = new JTable();
		scrollPane_3.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] { "Appointment ID", "Patient ID", "Doctor ID", "Room ID", "Appointment Date", "Appointment Time", "Status" }
		));

		btnNewButton_5 = new JButton("SHOW APPOINTMENTS");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Appointment ID");
				model.addColumn("Patient ID");
				model.addColumn("Doctor ID");
				model.addColumn("Room ID");
				model.addColumn("Appointment Date");
				model.addColumn("Appointment Time");
				model.addColumn("Status");

				String sql = "SELECT appointment_id, patient_id, doctor_id, room_id, appointment_date, appointment_time, status " +
				             "FROM Appointments ORDER BY appointment_date";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql);
				     ResultSet rs = ps.executeQuery()) {

					while (rs.next()) {
						Object[] row = {
							rs.getInt("appointment_id"), rs.getInt("patient_id"), rs.getInt("doctor_id"),
							rs.getObject("room_id"), rs.getDate("appointment_date"),
							rs.getString("appointment_time"), rs.getString("status")
						};
						model.addRow(row);
					}
					table_1.setModel(model);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnNewButton_5.setBounds(606, 275, 175, 20);
		appointmentPanel.add(btnNewButton_5);

		// =======================================================
		// ROOMS TAB (new)
		// =======================================================
		JLabel lblR0 = new JLabel("ENTER DETAILS");
		lblR0.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblR0.setBounds(74, 20, 150, 26);
		roomPanel.add(lblR0);

		JLabel lblR1 = new JLabel("ROOM DETAILS");
		lblR1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblR1.setBounds(561, 20, 150, 20);
		roomPanel.add(lblR1);

		JLabel lblRoomNumber = new JLabel("Room Number:");
		lblRoomNumber.setBounds(24, 86, 91, 13);
		roomPanel.add(lblRoomNumber);

		JLabel lblRoomType = new JLabel("Room Type:");
		lblRoomType.setBounds(24, 105, 91, 13);
		roomPanel.add(lblRoomType);

		JLabel lblRoomDept = new JLabel("Department ID:");
		lblRoomDept.setBounds(24, 124, 91, 13);
		roomPanel.add(lblRoomDept);

		txtRoomNumber = new JTextField();
		txtRoomNumber.setBounds(140, 83, 103, 19);
		roomPanel.add(txtRoomNumber);

		comboRoomType = new JComboBox();
		comboRoomType.setModel(new DefaultComboBoxModel(new String[] {"", "General", "Private", "ICU"}));
		comboRoomType.setBounds(140, 102, 103, 20);
		roomPanel.add(comboRoomType);

		txtRoomDeptId = new JTextField();
		txtRoomDeptId.setBounds(140, 121, 103, 19);
		roomPanel.add(txtRoomDeptId);

		JButton btnAddRoom = new JButton("ADD ROOM");
		btnAddRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String roomNumber = txtRoomNumber.getText();
				String roomType = (String) comboRoomType.getSelectedItem();
				String deptIdText = txtRoomDeptId.getText();

				if (roomNumber.isEmpty() || deptIdText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Room Number and Dept ID are required.");
					return;
				}

				String sql = "INSERT INTO Rooms (room_number, room_type, is_occupied, dept_id) VALUES (?, ?, 0, ?)";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql)) {

					ps.setString(1, roomNumber);
					ps.setString(2, (roomType == null || roomType.isEmpty()) ? "General" : roomType);
					ps.setInt(3, Integer.parseInt(deptIdText));

					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Room added successfully!");

					txtRoomNumber.setText("");
					comboRoomType.setSelectedIndex(0);
					txtRoomDeptId.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnAddRoom.setBounds(120, 165, 127, 20);
		roomPanel.add(btnAddRoom);

		JLabel lblRoomUpdateId = new JLabel("Room ID:");
		lblRoomUpdateId.setBounds(24, 200, 91, 13);
		roomPanel.add(lblRoomUpdateId);

		txtRoomUpdateId = new JTextField();
		txtRoomUpdateId.setBounds(140, 197, 103, 19);
		roomPanel.add(txtRoomUpdateId);

		JButton btnUpdateRoom = new JButton("UPDATE");
		btnUpdateRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText = txtRoomUpdateId.getText();
				if (idText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Room ID to update.");
					return;
				}

				String sql = "UPDATE Rooms SET room_number=?, room_type=?, dept_id=? WHERE room_id=?";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql)) {

					ps.setString(1, txtRoomNumber.getText());
					String roomType = (String) comboRoomType.getSelectedItem();
					ps.setString(2, (roomType == null || roomType.isEmpty()) ? "General" : roomType);
					ps.setInt(3, Integer.parseInt(txtRoomDeptId.getText()));
					ps.setInt(4, Integer.parseInt(idText));

					int rows = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, rows > 0 ? "Room updated!" : "No room with that ID.");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnUpdateRoom.setBounds(120, 225, 100, 19);
		roomPanel.add(btnUpdateRoom);

		JButton btnDeleteRoom = new JButton("DELETE");
		btnDeleteRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText = txtRoomUpdateId.getText();
				if (idText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Room ID to delete.");
					return;
				}

				String sql = "DELETE FROM Rooms WHERE room_id=?";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql)) {

					ps.setInt(1, Integer.parseInt(idText));
					int rows = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, rows > 0 ? "Room deleted!" : "No room with that ID.");
					txtRoomUpdateId.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnDeleteRoom.setBounds(228, 225, 100, 19);
		roomPanel.add(btnDeleteRoom);

		JScrollPane scrollPaneRooms = new JScrollPane();
		scrollPaneRooms.setBounds(386, 60, 700, 200);
		roomPanel.add(scrollPaneRooms);

		tableRooms = new JTable();
		scrollPaneRooms.setViewportView(tableRooms);
		tableRooms.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] { "Room ID", "Room Number", "Room Type", "Occupied", "Department" }
		));

		JButton btnShowRooms = new JButton("SHOW ROOMS");
		btnShowRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Room ID");
				model.addColumn("Room Number");
				model.addColumn("Room Type");
				model.addColumn("Occupied");
				model.addColumn("Department");

				String sql = "SELECT r.room_id, r.room_number, r.room_type, r.is_occupied, dept.dept_name " +
				             "FROM Rooms r LEFT JOIN Departments dept ON r.dept_id = dept.dept_id";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql);
				     ResultSet rs = ps.executeQuery()) {

					while (rs.next()) {
						Object[] row = {
							rs.getInt("room_id"), rs.getString("room_number"), rs.getString("room_type"),
							rs.getInt("is_occupied") == 1 ? "Yes" : "No", rs.getString("dept_name")
						};
						model.addRow(row);
					}
					tableRooms.setModel(model);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnShowRooms.setBounds(558, 275, 144, 20);
		roomPanel.add(btnShowRooms);

		// =======================================================
		// BILLING TAB (new)
		// =======================================================
		JLabel lblB0 = new JLabel("ENTER DETAILS");
		lblB0.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblB0.setBounds(74, 20, 150, 26);
		billingPanel.add(lblB0);

		JLabel lblB1 = new JLabel("BILLING DETAILS");
		lblB1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblB1.setBounds(561, 20, 150, 20);
		billingPanel.add(lblB1);

		JLabel lblApptId = new JLabel("Appointment ID:");
		lblApptId.setBounds(24, 86, 91, 13);
		billingPanel.add(lblApptId);

		JLabel lblConsultFee = new JLabel("Consultation Fee:");
		lblConsultFee.setBounds(24, 105, 100, 13);
		billingPanel.add(lblConsultFee);

		JLabel lblRoomCharge = new JLabel("Room Charge:");
		lblRoomCharge.setBounds(24, 124, 91, 13);
		billingPanel.add(lblRoomCharge);

		JLabel lblOtherCharges = new JLabel("Other Charges:");
		lblOtherCharges.setBounds(24, 143, 91, 13);
		billingPanel.add(lblOtherCharges);

		txtApptId = new JTextField();
		txtApptId.setBounds(150, 83, 103, 19);
		billingPanel.add(txtApptId);

		txtConsultFee = new JTextField();
		txtConsultFee.setBounds(150, 102, 103, 19);
		billingPanel.add(txtConsultFee);

		txtRoomCharge = new JTextField();
		txtRoomCharge.setBounds(150, 121, 103, 19);
		billingPanel.add(txtRoomCharge);

		txtOtherCharges = new JTextField();
		txtOtherCharges.setBounds(150, 140, 103, 19);
		billingPanel.add(txtOtherCharges);

		JButton btnAddBill = new JButton("GENERATE BILL");
		btnAddBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String apptIdText = txtApptId.getText();
				String consultText = txtConsultFee.getText();
				String roomChargeText = txtRoomCharge.getText();
				String otherText = txtOtherCharges.getText();

				if (apptIdText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Appointment ID is required.");
					return;
				}

				String sql = "INSERT INTO Billing (appointment_id, consultation_fee, room_charge, other_charges, payment_status) " +
				             "VALUES (?, ?, ?, ?, 'Unpaid')";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql)) {

					ps.setInt(1, Integer.parseInt(apptIdText));
					ps.setDouble(2, consultText.isEmpty() ? 0.0 : Double.parseDouble(consultText));
					ps.setDouble(3, roomChargeText.isEmpty() ? 0.0 : Double.parseDouble(roomChargeText));
					ps.setDouble(4, otherText.isEmpty() ? 0.0 : Double.parseDouble(otherText));

					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Bill generated successfully!");

					txtApptId.setText("");
					txtConsultFee.setText("");
					txtRoomCharge.setText("");
					txtOtherCharges.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnAddBill.setBounds(130, 185, 130, 20);
		billingPanel.add(btnAddBill);

		JLabel lblBillUpdateId = new JLabel("Bill ID:");
		lblBillUpdateId.setBounds(24, 220, 91, 13);
		billingPanel.add(lblBillUpdateId);

		txtBillUpdateId = new JTextField();
		txtBillUpdateId.setBounds(150, 217, 103, 19);
		billingPanel.add(txtBillUpdateId);

		JButton btnMarkPaid = new JButton("MARK PAID");
		btnMarkPaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText = txtBillUpdateId.getText();
				if (idText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Bill ID to update.");
					return;
				}

				String sql = "UPDATE Billing SET payment_status='Paid' WHERE bill_id=?";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql)) {

					ps.setInt(1, Integer.parseInt(idText));
					int rows = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, rows > 0 ? "Bill marked as Paid!" : "No bill with that ID.");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnMarkPaid.setBounds(130, 245, 110, 19);
		billingPanel.add(btnMarkPaid);

		JButton btnDeleteBill = new JButton("DELETE");
		btnDeleteBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText = txtBillUpdateId.getText();
				if (idText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Bill ID to delete.");
					return;
				}

				String sql = "DELETE FROM Billing WHERE bill_id=?";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql)) {

					ps.setInt(1, Integer.parseInt(idText));
					int rows = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, rows > 0 ? "Bill deleted!" : "No bill with that ID.");
					txtBillUpdateId.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnDeleteBill.setBounds(250, 245, 100, 19);
		billingPanel.add(btnDeleteBill);

		JScrollPane scrollPaneBills = new JScrollPane();
		scrollPaneBills.setBounds(386, 60, 700, 200);
		billingPanel.add(scrollPaneBills);

		tableBills = new JTable();
		scrollPaneBills.setViewportView(tableBills);
		tableBills.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] { "Bill ID", "Patient Name", "Total Amount", "Payment Status" }
		));

		JButton btnShowBills = new JButton("SHOW BILLS");
		btnShowBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Bill ID");
				model.addColumn("Patient Name");
				model.addColumn("Total Amount");
				model.addColumn("Payment Status");

				String sql = "SELECT b.bill_id, p.patient_name, b.total_amount, b.payment_status " +
				             "FROM Billing b JOIN Appointments a ON b.appointment_id = a.appointment_id " +
				             "JOIN Patients p ON a.patient_id = p.patient_id";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql);
				     ResultSet rs = ps.executeQuery()) {

					while (rs.next()) {
						Object[] row = {
							rs.getInt("bill_id"), rs.getString("patient_name"),
							rs.getDouble("total_amount"), rs.getString("payment_status")
						};
						model.addRow(row);
					}
					tableBills.setModel(model);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnShowBills.setBounds(558, 275, 144, 20);
		billingPanel.add(btnShowBills);

		// =======================================================
		// DEPARTMENTS TAB (new)
		// =======================================================
		JLabel lblDe0 = new JLabel("ENTER DETAILS");
		lblDe0.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDe0.setBounds(74, 20, 150, 26);
		deptPanel.add(lblDe0);

		JLabel lblDe1 = new JLabel("DEPARTMENT DETAILS");
		lblDe1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDe1.setBounds(561, 20, 200, 20);
		deptPanel.add(lblDe1);

		JLabel lblDeptName = new JLabel("Dept Name:");
		lblDeptName.setBounds(24, 86, 91, 13);
		deptPanel.add(lblDeptName);

		JLabel lblDeptLocation = new JLabel("Location:");
		lblDeptLocation.setBounds(24, 105, 91, 13);
		deptPanel.add(lblDeptLocation);

		txtDeptName = new JTextField();
		txtDeptName.setBounds(140, 83, 103, 19);
		deptPanel.add(txtDeptName);

		txtDeptLocation = new JTextField();
		txtDeptLocation.setBounds(140, 102, 103, 19);
		deptPanel.add(txtDeptLocation);

		JButton btnAddDept = new JButton("ADD DEPARTMENT");
		btnAddDept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deptName = txtDeptName.getText();
				String location = txtDeptLocation.getText();

				if (deptName.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Department Name is required.");
					return;
				}

				String sql = "INSERT INTO Departments (dept_name, location) VALUES (?, ?)";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql)) {

					ps.setString(1, deptName);
					ps.setString(2, location);

					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Department added successfully!");

					txtDeptName.setText("");
					txtDeptLocation.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnAddDept.setBounds(120, 145, 150, 20);
		deptPanel.add(btnAddDept);

		JLabel lblDeptUpdateId = new JLabel("Dept ID:");
		lblDeptUpdateId.setBounds(24, 180, 91, 13);
		deptPanel.add(lblDeptUpdateId);

		txtDeptUpdateId = new JTextField();
		txtDeptUpdateId.setBounds(140, 177, 103, 19);
		deptPanel.add(txtDeptUpdateId);

		JButton btnUpdateDept = new JButton("UPDATE");
		btnUpdateDept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText = txtDeptUpdateId.getText();
				if (idText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Dept ID to update.");
					return;
				}

				String sql = "UPDATE Departments SET dept_name=?, location=? WHERE dept_id=?";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql)) {

					ps.setString(1, txtDeptName.getText());
					ps.setString(2, txtDeptLocation.getText());
					ps.setInt(3, Integer.parseInt(idText));

					int rows = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, rows > 0 ? "Department updated!" : "No department with that ID.");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnUpdateDept.setBounds(120, 205, 100, 19);
		deptPanel.add(btnUpdateDept);

		JButton btnDeleteDept = new JButton("DELETE");
		btnDeleteDept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText = txtDeptUpdateId.getText();
				if (idText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Dept ID to delete.");
					return;
				}

				String sql = "DELETE FROM Departments WHERE dept_id=?";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql)) {

					ps.setInt(1, Integer.parseInt(idText));
					int rows = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, rows > 0 ? "Department deleted!" : "No department with that ID.");
					txtDeptUpdateId.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnDeleteDept.setBounds(228, 205, 100, 19);
		deptPanel.add(btnDeleteDept);

		JScrollPane scrollPaneDepts = new JScrollPane();
		scrollPaneDepts.setBounds(386, 60, 700, 200);
		deptPanel.add(scrollPaneDepts);

		tableDepts = new JTable();
		scrollPaneDepts.setViewportView(tableDepts);
		tableDepts.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] { "Dept ID", "Dept Name", "Location" }
		));

		JButton btnShowDepts = new JButton("SHOW DEPARTMENTS");
		btnShowDepts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Dept ID");
				model.addColumn("Dept Name");
				model.addColumn("Location");

				String sql = "SELECT dept_id, dept_name, location FROM Departments";

				try (Connection conn = DBConnection.getConnection();
				     PreparedStatement ps = conn.prepareStatement(sql);
				     ResultSet rs = ps.executeQuery()) {

					while (rs.next()) {
						Object[] row = {
							rs.getInt("dept_id"), rs.getString("dept_name"), rs.getString("location")
						};
						model.addRow(row);
					}
					tableDepts.setModel(model);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});
		btnShowDepts.setBounds(558, 275, 170, 20);
		deptPanel.add(btnShowDepts);
	}
}