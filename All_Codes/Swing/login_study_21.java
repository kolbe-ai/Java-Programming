/*
21. Write a Java Swing program for a login form with a text field for Username, a
password field for Password, and a Login button. On clicking Login, check whether
the username is "123456" and the password is "admin123", and display "Login
Successful" or "Invalid Username or Password" in a label.
 */

package program;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class login_study_21 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user_name;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_study_21 frame = new login_study_21();
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
	public login_study_21() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(177, 10, 44, 12);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username: ");
		lblNewLabel_1.setBounds(101, 65, 81, 12);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password: ");
		lblNewLabel_2.setBounds(101, 87, 69, 12);
		contentPane.add(lblNewLabel_2);
		
		user_name = new JTextField();
		user_name.setBounds(178, 62, 96, 18);
		contentPane.add(user_name);
		user_name.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(177, 87, 97, 18);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = user_name.getText();
				String pass = new String(password.getPassword());
				
				try {
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
					String query = "select * from student_login where st_id = ? and password = ?";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setInt(1, Integer.parseInt(user));
					pst.setString(2, pass);
					ResultSet rs = pst.executeQuery();
					int flag = 0;
					while(rs.next()) {
						flag++;
						JOptionPane.showMessageDialog(null, "Successfull login!");
					}
					if (flag == 0) {
						JOptionPane.showMessageDialog(null,"incorrect user or password");
					}
					
				}catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setBounds(177, 122, 97, 20);
		contentPane.add(btnNewButton);

	}
}
