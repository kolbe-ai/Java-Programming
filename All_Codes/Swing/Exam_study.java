package program;

import java.awt.EventQueue;
import java.io.*;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class Exam_study extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ID;
	private JTextField Name;
	private JTextField Age;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exam_study frame = new Exam_study();
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
	public Exam_study() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(10, 49, 63, 12);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(10, 66, 63, 12);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setBounds(10, 83, 55, 12);
		contentPane.add(lblNewLabel_2);
		
		ID = new JTextField();
		ID.setBounds(75, 46, 96, 18);
		contentPane.add(ID);
		ID.setColumns(10);
		
		Name = new JTextField();
		Name.setBounds(75, 63, 96, 18);
		contentPane.add(Name);
		Name.setColumns(10);
		
		Age = new JTextField();
		Age.setBounds(75, 80, 96, 18);
		contentPane.add(Age);
		Age.setColumns(10);
		
		JRadioButton Grade_A = new JRadioButton("A");
		buttonGroup.add(Grade_A);
		Grade_A.setBounds(85, 104, 44, 18);
		contentPane.add(Grade_A);
		
		JRadioButton Grade_B = new JRadioButton("B");
		buttonGroup.add(Grade_B);
		Grade_B.setBounds(140, 104, 44, 20);
		contentPane.add(Grade_B);
		
		JLabel lblNewLabel_3 = new JLabel("Grade:");
		lblNewLabel_3.setBounds(10, 105, 44, 12);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = ID.getText();
				String name = Name.getText();
				String age = Age.getText();
				String grade = "";
				if (Grade_A.isSelected()) {
					grade = "A";
				}else {
					grade = "B";
				}
				try {
					Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
					String query = "insert into student values(?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setInt(1, Integer.parseInt(id));
					pst.setString(2,name);
					pst.setInt(3, Integer.parseInt(age));
					pst.setString(4,grade);
					int flag = pst.executeUpdate();
					if (flag < 0) {
						JOptionPane.showMessageDialog(null,"Invalid");
					}else {
						JOptionPane.showMessageDialog(null,"Inserted");
					}
					
				}catch(Exception e1) {
					System.out.println(e1);					
				}
			}
		});
		btnNewButton.setBounds(75, 129, 84, 20);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.setBounds(75, 152, 84, 20);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.setBounds(75, 177, 84, 20);
		contentPane.add(btnNewButton_2);

	}
}
