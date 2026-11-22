/*
6. Write a Java Swing program with a form to enter Student ID, Name, Age and Grade,
and Update and Delete buttons. Update should modify the given student record in
the student table, and Delete should remove it, both via JDBC. 
 */

package program;

import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class student_CRUD_6 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField s_id;
	private JTextField s_name;
	private JTextField s_grade;
	private JTextField s_age;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_CRUD_6 frame = new student_CRUD_6();
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
	public student_CRUD_6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Register");
		lblNewLabel.setBounds(173, 10, 151, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID: ");
		lblNewLabel_1.setBounds(10, 58, 106, 12);
		contentPane.add(lblNewLabel_1);
		
		s_id = new JTextField();
		s_id.setBounds(86, 55, 96, 18);
		contentPane.add(s_id);
		s_id.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Student Name:");
		lblNewLabel_2.setBounds(10, 80, 106, 12);
		contentPane.add(lblNewLabel_2);
		
		s_name = new JTextField();
		s_name.setBounds(86, 77, 96, 18);
		contentPane.add(s_name);
		s_name.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Age:");
		lblNewLabel_3.setBounds(241, 58, 114, 12);
		contentPane.add(lblNewLabel_3);
		
		s_grade = new JTextField();
		s_grade.setBounds(330, 77, 96, 18);
		contentPane.add(s_grade);
		s_grade.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Grade:");
		lblNewLabel_4.setBounds(241, 80, 83, 12);
		contentPane.add(lblNewLabel_4);
		
		s_age = new JTextField();
		s_age.setBounds(330, 55, 96, 18);
		contentPane.add(s_age);
		s_age.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = s_id.getText();
				String name = s_name.getText();
				String age = s_age.getText();
				String grade = s_grade.getText();
				
				try {
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
					String query = "insert into student values (?, ? ,? ,? )";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setInt(1, Integer.parseInt(id));
					pst.setString(2, name);
					pst.setInt(3, Integer.parseInt(age));
					pst.setString(4, grade);
					pst.executeUpdate();
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setBounds(86, 102, 83, 12);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = s_id.getText();
				String name = s_name.getText();
				String age = s_age.getText();
				String grade = s_grade.getText();
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
					String query = "update student set name = ?, age = ?, grade = ? where id = ?";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, name);
					pst.setInt(2,Integer.parseInt(age));
					pst.setString(3, grade);
					pst.setInt(4, Integer.parseInt(id));
					pst.executeUpdate();
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnUpdate.setBounds(86, 115, 83, 12);
		contentPane.add(btnUpdate);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 135, 416, 118);
		contentPane.add(scrollPane_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_2.setViewportView(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowCount = table.getSelectedRow();
				if(rowCount != -1) {
					String id = table.getValueAt(rowCount, 0).toString();
					String name = table.getValueAt(rowCount, 1).toString();
					String age = table.getValueAt(rowCount, 2).toString();
					String grade = table.getValueAt(rowCount, 3).toString();
					s_id.setText(id);
					s_name.setText(name);
					s_age.setText(age);
					s_grade.setText(grade);
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
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Age", "Grade"
			}
		));
		scrollPane_1.setViewportView(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, 416, 117);
		contentPane.add(scrollPane);
		
		JButton btnNewButton_1 = new JButton("Show Table");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				
				String id = s_id.getText();
				String name = s_name.getText();
				String age = s_age.getText();
				String grade = s_grade.getText();
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
					String query = "select * from student";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					int flag = 0;
					while(rs.next()) {
						flag++;
						Object[] row = {rs.getInt("id"), rs.getString("name"),rs.getString("age"),rs.getString("grade")};
						model.addRow(row);
					}
					if(flag == 0) {
						JOptionPane.showMessageDialog(null,"Error");
					}
				}catch(Exception e1) {
					System.out.println(e1);
				}				
			}
		});
		btnNewButton_1.setBounds(200, 115, 106, 12);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = s_id.getText();
					String query = "delete from student where id = ?";
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
					PreparedStatement pst = con.prepareStatement(query);
					pst.setInt(1, Integer.parseInt(id));
					int result = pst.executeUpdate();	
					if ( result == 0) {
						JOptionPane.showMessageDialog(null,"Unsucessfull delete!");
					}else {
						JOptionPane.showMessageDialog(null, "Sucessfully deleted!");
					}					
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton_2.setBounds(340, 105, 72, 9);
		contentPane.add(btnNewButton_2);

	}

}
