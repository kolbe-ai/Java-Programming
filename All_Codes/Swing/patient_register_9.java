/*
Write a Java Swing program for a patient registration form with a text field for Name,
radio buttons for Gender, text field for address, and a Submit button. On clicking
Submit, display all the entered details in a text area.
 */

package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class patient_register_9 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField p_name;
	private JTextField p_address;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patient_register_9 frame = new patient_register_9();
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
	public patient_register_9() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient Register");
		lblNewLabel.setBounds(162, 10, 96, 12);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(10, 38, 73, 12);
		contentPane.add(lblNewLabel_1);
		
		p_name = new JTextField();
		p_name.setBounds(93, 35, 96, 18);
		contentPane.add(p_name);
		p_name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Address:");
		lblNewLabel_2.setBounds(10, 71, 73, 12);
		contentPane.add(lblNewLabel_2);
		
		p_address = new JTextField();
		p_address.setBounds(93, 68, 96, 18);
		contentPane.add(p_address);
		p_address.setColumns(10);
		
		JRadioButton female = new JRadioButton("Female");
		buttonGroup.add(female);
		female.setBounds(149, 92, 102, 20);
		contentPane.add(female);
		
		JRadioButton male = new JRadioButton("Male");
		buttonGroup.add(male);
		male.setBounds(87, 92, 60, 20);
		contentPane.add(male);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 128, 416, 125);
		contentPane.add(scrollPane_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_2.setViewportView(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int sel_row = table.getSelectedRow();
				String name, address,gender; 
				if(sel_row != -1) {
					name = table.getValueAt(sel_row,0).toString();
					gender = table.getValueAt(sel_row, 1).toString();
					address = table.getValueAt(sel_row,2).toString();
					p_name.setText(name);
					p_address.setText(address); 
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Name", "Gender", "Address"
			}
		));
		scrollPane_1.setViewportView(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 128, 416, 125);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = p_name.getText();
				String address = p_address.getText();
				String gender = "";
				if (male.isSelected()) {
					gender = "Male";
				}
				if(female.isSelected()) {
					gender = "Female";
				}
				try {
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
					String query = "insert into patient_fun values (?,?,?)";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, name);
					pst.setString(2,gender);
					pst.setString(3,address);
					int flag = pst.executeUpdate();
					if (flag == 0) {
						JOptionPane.showMessageDialog(null,"Insert not properly done!");
					}else {
						JOptionPane.showMessageDialog(null, "Inserted properly!");
					}
					
				}catch(Exception e1) {
					System.out.println(e1);
				}
 				
			}
		});
		btnNewButton.setBounds(299, 34, 84, 20);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SHOW TABLE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					model.setRowCount(0);
					
					//WWClass.forName("oracle.jdbc.driver.Oracledriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
					String query = "select * from patient_fun";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					while(rs.next()) {
						Object[] row = {rs.getString("name"),rs.getString("gender"),rs.getString("address")};
						model.addRow(row);						
					}
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton_1.setBounds(287, 67, 116, 20);
		contentPane.add(btnNewButton_1);

	}
}
