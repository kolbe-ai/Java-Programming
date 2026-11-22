//45. Design a Login Form with validation.

package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class L44 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					L44 frame = new L44();
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
	public L44() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentRollno = new JLabel("Student ID: ");
		lblStudentRollno.setBounds(75, 111, 116, 12);
		contentPane.add(lblStudentRollno);
		
		textField = new JTextField();
		textField.setBounds(220, 108, 96, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(220, 136, 96, 18);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Student password:");
		lblNewLabel.setBounds(75, 139, 116, 12);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
					String studentID = textField.getText();
					String password = new String(passwordField.getPassword());

					try{ 
						//step1 load the driver class 	
						Class.forName("oracle.jdbc.driver.OracleDriver"); 					 
		
						//step2 create  the connection object 	
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");					 
		
						//step3 create the statement object  	
						Statement stmt=con.createStatement(); 
		
						//step4 execute query 
						
						String query = "select * from student_login"+ " where st_id = "+studentID+ " and password = '"+password+"'";
		
						ResultSet rs=stmt.executeQuery(query); 
						
						//check if the enter user is correct
						if(rs.next()){
							JOptionPane.showMessageDialog(null,"Login Sucessul!");
						}else {
							JOptionPane.showMessageDialog(null,"Invalid Student ID or Password!");
						}
		
						//step5 close the connection object 	
						con.close(); 
					}catch(Exception ex){
						JOptionPane.showMessageDialog(null,ex.getMessage());
					} 
			}
		});
		btnNewButton.setBounds(165, 177, 84, 20);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Student Login");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(86, 32, 209, 35);
		contentPane.add(lblNewLabel_1);

	}
}
