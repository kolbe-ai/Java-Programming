//43. Design a Teacher Registration Form using Swing.



package program;

import java.awt.EventQueue;

import java.sql.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class Practice_43 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Practice_43 frame = new Practice_43();
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
	public Practice_43() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Teacher ID: ");
		lblNewLabel.setBounds(60, 50, 87, 12);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Teacher Name: ");
		lblNewLabel_1.setBounds(60, 72, 104, 12);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTeacherLogin = new JLabel("Teacher Registration");
		lblTeacherLogin.setBounds(160, 10, 127, 12);
		contentPane.add(lblTeacherLogin);
		
		JLabel lblNewLabel_2 = new JLabel("Teacher Salary: ");
		lblNewLabel_2.setBounds(60, 94, 117, 12);
		contentPane.add(lblNewLabel_2);
		
		TextField tid = new TextField();
		tid.setBounds(183, 50, 104, 12);
		contentPane.add(tid);
		
		TextField tname = new TextField();
		tname.setBounds(183, 72, 104, 12);
		contentPane.add(tname);
		
		TextField tsalary = new TextField();
		tsalary.setBounds(183, 94, 104, 12);
		contentPane.add(tsalary);
		
		Button button = new Button("ADD");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(tid.getText());
					String name = tname.getText();
					int salary = Integer.parseInt(tsalary.getText());
					
					Class.forName("oracle.jdbc.driver.OracleDriver");	
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
					String query = "insert into teacher_new values(?,?,?)";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setInt(1, id);
					pst.setString(2, name);
					pst.setInt(3, salary);
					
					int flag = pst.executeUpdate();
					if(flag > 0) {
						JOptionPane.showMessageDialog(null,"ADDED SUCESSFULLY");
					}else {
						JOptionPane.showMessageDialog(null,"Cannot ADD");
					}
					
					
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		button.setBounds(161, 129, 65, 20);
		contentPane.add(button);

	}
}
