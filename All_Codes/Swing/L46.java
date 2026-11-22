//47. Develop a Student Attendance Management System.
package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class L46 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField s_id;
	private JTextField s_name;
	private JLabel lblNewLabel_2;
	private JTextField s_date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					L46 frame = new L46();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public L46() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student ID: \r\n");
		lblNewLabel.setBounds(57, 76, 76, 12);
		contentPane.add(lblNewLabel);
		
		s_id = new JTextField();
		s_id.setBounds(156, 73, 96, 18);
		contentPane.add(s_id);
		s_id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Student name: ");
		lblNewLabel_1.setBounds(57, 102, 89, 12);
		contentPane.add(lblNewLabel_1);
		
		s_name = new JTextField();
		s_name.setBounds(156, 101, 96, 18);
		contentPane.add(s_name);
		s_name.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Attendance: ");
		lblNewLabel_2.setBounds(57, 133, 76, 12);
		contentPane.add(lblNewLabel_2);
		
		JComboBox attendance_combo = new JComboBox();
		attendance_combo.setModel(new DefaultComboBoxModel(new String[] {"", "Present", "Absent"}));
		attendance_combo.setBounds(156, 129, 96, 20);
		contentPane.add(attendance_combo);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = s_id.getText();
				String name = s_name.getText();
				String attendance = attendance_combo.getSelectedItem().toString();
				String date = s_date.getText();
				try {
					//step 1 load driver
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					//step 2 create connection
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
					
					//step 3 create statement object
					String query = "insert into attendance values(?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setInt(1,Integer.parseInt(id));
					pst.setString(2,name);
					pst.setString(3,date);
					pst.setString(4, attendance);
					int rows = pst.executeUpdate();
					if(rows>0) {
						JOptionPane.showMessageDialog(null,"Marked sucessfully");
					}else {
						JOptionPane.showMessageDialog(null,"Marking unsucessfull\nTry again!");
					}		
					//pst.close();
					//con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					
				}
			}
		});
		btnNewButton.setBounds(156, 198, 84, 20);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Attendance Report");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(133, 25, 154, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date:");
		lblNewLabel_4.setBounds(57, 171, 44, 12);
		contentPane.add(lblNewLabel_4);
		
		s_date = new JTextField();
		s_date.setBounds(156, 168, 96, 18);
		contentPane.add(s_date);
		s_date.setColumns(10);

	}
}
