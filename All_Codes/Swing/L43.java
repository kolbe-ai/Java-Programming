//43. Design a Student Registration Form using Swing.package program;

package program;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class L43 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1_1;
	private JTextField textField_2_1;
	private JTextField textField_3_1;
	private JTextField textField_4_1;
	private JLabel lblNewLabel_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					L43 frame = new L43();
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
	public L43() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_1_1 = new JTextField();
		textField_1_1.setBounds(178, 89, 96, 18);
		contentPane.add(textField_1_1);
		textField_1_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Student Name: ");
		lblNewLabel.setBounds(72, 92, 96, 12);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Address:");
		lblNewLabel_1.setBounds(72, 120, 96, 12);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gender: ");
		lblNewLabel_2.setBounds(72, 148, 78, 12);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblPhone = new JLabel("Course:");
		lblPhone.setBounds(72, 178, 78, 12);
		contentPane.add(lblPhone);
		
		textField_2_1 = new JTextField();
		textField_2_1.setBounds(178, 117, 96, 18);
		contentPane.add(textField_2_1);
		textField_2_1.setColumns(10);
		
		textField_3_1 = new JTextField();
		textField_3_1.setBounds(178, 145, 96, 18);
		contentPane.add(textField_3_1);
		textField_3_1.setColumns(10);
		
		textField_4_1 = new JTextField();
		textField_4_1.setBounds(178, 175, 96, 18);
		contentPane.add(textField_4_1);
		textField_4_1.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Phone:");
		lblNewLabel_3.setBounds(72, 206, 96, 12);
		contentPane.add(lblNewLabel_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(178, 203, 96, 18);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(178, 61, 96, 18);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Student ID:");
		lblNewLabel_4.setBounds(72, 64, 66, 12);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Student Registration");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(126, 10, 181, 41);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s_id = textField_6.getText();
				String s_name = textField_1_1.getText();
				String s_address = textField_4_1.getText();
				String s_gender = textField_3_1.getText();
				String s_course = textField_2_1.getText();
				String s_num = textField_5.getText();
		
				try{ 
					//step1 load the driver class 	
					Class.forName("oracle.jdbc.driver.OracleDriver"); 					 
	
					//step2 create  the connection object 	
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");					 
	
					//step3 create the statement object  	
					//Statement stmt=con.createStatement(); 
	
					//step4 execute query 
					
					/*String query = "insert into student_reg values("+ s_id + " ' "+s_name+ " ' "+  "'"+s_name+ " ' "+  " ' "+s_address+ " ' "+ 
					" ' "+s_gender+ " ' "+ s_num + " ' "+s_course+ "'"; 
					*/
					String query = "insert into student_reg values (?,?,?,?,?,?)" ;
					

					PreparedStatement pstmt = con.prepareStatement(query);

					pstmt.setInt(1, Integer.parseInt(s_id));
					pstmt.setString(2,s_name);
					pstmt.setString(3, s_address);
					pstmt.setString(4,s_gender);
					pstmt.setInt(5,Integer.parseInt(s_num));
					pstmt.setString(6, s_course);
					
					int rows = pstmt.executeUpdate();			//not executeQuery because to insert we use executeUpdate
					//ResultSet rs=stmt.executeQuery(query); 
					//System.out.println("\n\n\n"+query+"\n\n\n");     //checking the query
					
					//check if the enter user is correct
					if(rows>0){
						JOptionPane.showMessageDialog(null,"Registered Successfully");
					}else {
						JOptionPane.showMessageDialog(null,"Cannot registered, try again!");
					}
	
					//step5 close the connection object 	
					con.close(); 
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null,ex.getMessage());
				} 
			}
		});
		btnNewButton.setBounds(178, 231, 96, 20);
		contentPane.add(btnNewButton);

	}
}
