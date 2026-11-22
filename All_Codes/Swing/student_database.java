/*
Write a Java Swing program to maintain a Student Database. Design a form to add, edit, and delete student records 
(Name, Roll No, Course, Semester) and display all records in a JTable. 
Clicking a row in the JTable should populate the form for editing.
 */
package program;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JOptionPane;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class student_database extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField st_id;
	private JTextField st_name;
	private JTextField st_age;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JTextField st_grade;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_database frame = new student_database();
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
	public student_database() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Details");
		lblNewLabel.setBounds(189, 10, 90, 12);
		contentPane.add(lblNewLabel);
		
		st_id = new JTextField();
		st_id.setBounds(86, 72, 96, 18);
		contentPane.add(st_id);
		st_id.setColumns(10);
		
		st_name = new JTextField();
		st_name.setBounds(86, 104, 96, 18);
		contentPane.add(st_name);
		st_name.setColumns(10);
		
		st_age = new JTextField();
		st_age.setBounds(86, 139, 96, 18);
		contentPane.add(st_age);
		st_age.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID:");
		lblNewLabel_1.setBounds(10, 75, 78, 12);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Student name:");
		lblNewLabel_2.setBounds(10, 107, 96, 12);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age: ");
		lblNewLabel_3.setBounds(10, 142, 66, 12);
		contentPane.add(lblNewLabel_3);
		
		btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String s_id = st_id.getText();
					String s_name = st_name.getText();
					String s_age = st_age.getText();
					String s_grade = st_grade.getText();
					
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
					String query = "insert into student values (?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setInt(1, Integer.parseInt(s_id));
					pst.setString(2, s_name);
					pst.setInt(3, Integer.parseInt(s_age));
					pst.setString(4, s_grade);
					
					int flag = pst.executeUpdate();
					if(	flag!= 0) {
						JOptionPane.showMessageDialog(null,"Sucessfull login!");
					}else{
						JOptionPane.showMessageDialog(null, "Unsuccessfull login");
					}
					
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setBounds(86, 193, 84, 20);
		contentPane.add(btnNewButton);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(261, 72, 165, 129);
		contentPane.add(scrollPane_1);
		
		scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				if(selectedRow != -1) {
					String id = table.getValueAt(selectedRow, 0 ).toString();
					String name = table.getValueAt(selectedRow, 1).toString();
					String age = table.getValueAt(selectedRow, 2).toString();
					String grade = table.getValueAt(selectedRow, 3).toString();
					
					st_id.setText(id);
					st_name.setText(name);
					st_age.setText(age);
					st_grade.setText(grade);
				}else {
					JOptionPane.showMessageDialog(null,"No data selected");
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Age", "Grade"
			}
		));
		scrollPane.setViewportView(table);
		
		st_grade = new JTextField();
		st_grade.setBounds(86, 165, 96, 18);
		contentPane.add(st_grade);
		st_grade.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Grade");
		lblNewLabel_4.setBounds(10, 168, 66, 12);
		contentPane.add(lblNewLabel_4);
		
		btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String s_id = st_id.getText();
					String s_name = st_name.getText();
					String s_age = st_age.getText();
					String s_grade = st_grade.getText();
					
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
					String query = "update student set name = ?, age = ? , grade = ? where id = ?";
					PreparedStatement pst = con.prepareStatement(query);					
					pst.setString(1,s_name);
					pst.setInt(2, Integer.parseInt(s_age));
					pst.setString(3,s_grade);
					pst.setInt(4, Integer.parseInt(s_id));
					int flag = pst.executeUpdate();
					if(flag == 0) {
						JOptionPane.showMessageDialog(null, "User not found!");						
					}else {
						JOptionPane.showMessageDialog(null,"User updated!");
					}
				}catch(SQLException e1) {
					System.out.println(e1);
				}	
			}
		});
		btnNewButton_1.setBounds(86, 218, 84, 20);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("SHOW TABLE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String s_id = st_id.getText();
					String s_name = st_name.getText();
					String s_age = st_age.getText();
					String s_grade = st_grade.getText();
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();          //fetch data from table
					table.setModel(model);				//put
					
					String query = "select * from student";
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					model.setRowCount(0);		//clears table before head
					
					int flag = 0;
					while(rs.next()) {
						flag++;
						Object [] row = {rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getString("grade")};			//taking row
						model.addRow(row);			//add the row
					}
					table.setModel(model);			//add
					
					if(flag == 0) {
						JOptionPane.showMessageDialog(null, "Error happend!");
					}
					
				}catch (SQLException e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton_2.setBounds(298, 211, 106, 20);
		contentPane.add(btnNewButton_2);

	}
}
