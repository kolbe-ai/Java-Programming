/*
4. Write a Java Swing program with a text field to enter an Student Number and a
Search button. On clicking Search, fetch the corresponding student details from the
student table using JDBC and display them in the form fields.
 */

package program;

import java.sql.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class search_student extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField s_name;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search_student frame = new search_student();
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
	public search_student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Student");
		lblNewLabel.setBounds(182, 10, 102, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student name: ");
		lblNewLabel_1.setBounds(52, 51, 80, 12);
		contentPane.add(lblNewLabel_1);
		
		s_name = new JTextField();
		s_name.setBounds(163, 48, 96, 18);
		contentPane.add(s_name);
		s_name.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = s_name.getText();
				try {
					
					DefaultTableModel model = (DefaultTableModel)table.getModel();            
					model.setRowCount(0);
					
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
					String query = "select * from student where name = ?";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, name);
					ResultSet rs = pst.executeQuery();
					int flag = 0;
					while(rs.next()) {
						flag++;
						Object [] row = {rs.getInt("id"),rs.getString("name"), rs.getInt("age"), rs.getString("grade")};
						model.addRow(row);
					}
					if(flag == 0) {
						JOptionPane.showMessageDialog(null,"No student found in this name!");
						
					}
					
				}catch(Exception e1) {
					System.out.println(e1);
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		btnNewButton.setBounds(304, 47, 71, 20);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(52, 88, 347, 133);
		contentPane.add(scrollPane_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_2.setViewportView(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
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
		scrollPane.setBounds(52, 88, 347, 133);
		contentPane.add(scrollPane);

	}
}
