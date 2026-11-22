/*
2. Write a Java Swing program with a form containing text fields for Student Number,
Name, and Course, and an Add button. On clicking Add, insert the entered details
into the Student table using JDBC and display a confirmation message.
*/

package program;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class student_swing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField s_id;
	private JTextField s_name;
	private JTextField s_course;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_swing frame = new student_swing();
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
	public student_swing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Registration");
		lblNewLabel.setBounds(156, 10, 118, 12);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID:");
		lblNewLabel_1.setBounds(47, 73, 74, 12);
		contentPane.add(lblNewLabel_1);
		
		s_id = new JTextField();
		s_id.setBounds(156, 70, 96, 18);
		contentPane.add(s_id);
		s_id.setColumns(10);
		
		s_name = new JTextField();
		s_name.setBounds(156, 98, 96, 18);
		contentPane.add(s_name);
		s_name.setColumns(10);
		
		s_course = new JTextField();
		s_course.setBounds(156, 126, 96, 18);
		contentPane.add(s_course);
		s_course.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Student Name: ");
		lblNewLabel_2.setBounds(47, 101, 74, 12);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Student Course: ");
		lblNewLabel_3.setBounds(47, 129, 81, 12);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = s_id.getText();
				String name = s_name.getText();
				String course = s_course.getText();
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
					String query = "insert into student_login1 values (?,?,?)";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setInt(1, Integer.parseInt(id));
					pst.setString(2, name);
					pst.setString(3, course);
					int flag = pst.executeUpdate();
					if (flag == 0) {
						JOptionPane.showMessageDialog(null,"Invalid input!");
					}else {
						JOptionPane.showMessageDialog(null, "Student added sucessfully!");
					}						
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setBounds(156, 154, 96, 20);
		contentPane.add(btnNewButton);

	}

}
