package program;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class book_database extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField book_id;
	private JTextField b_name;
	private JTextField b_author;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					book_database frame = new book_database();
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
	public book_database() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Register");
		lblNewLabel.setBounds(185, 10, 88, 12);
		contentPane.add(lblNewLabel);
		
		book_id = new JTextField();
		book_id.setBounds(103, 55, 96, 18);
		contentPane.add(book_id);
		book_id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Book ID: ");
		lblNewLabel_1.setBounds(10, 58, 71, 12);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Book Name: ");
		lblNewLabel_2.setBounds(10, 80, 71, 12);
		contentPane.add(lblNewLabel_2);
		
		b_name = new JTextField();
		b_name.setBounds(103, 77, 96, 18);
		contentPane.add(b_name);
		b_name.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Author: ");
		lblNewLabel_3.setBounds(245, 58, 66, 12);
		contentPane.add(lblNewLabel_3);
		
		b_author = new JTextField();
		b_author.setBounds(295, 55, 96, 18);
		contentPane.add(b_author);
		b_author.setColumns(10);
		
		JRadioButton scifi = new JRadioButton("Sci-fi");
		buttonGroup.add(scifi);
		scifi.setBounds(282, 76, 57, 20);
		contentPane.add(scifi);
		
		JRadioButton biography = new JRadioButton("Biography");
		buttonGroup.add(biography);
		biography.setBounds(338, 76, 88, 20);
		contentPane.add(biography);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = book_id.getText();
				String name = b_name.getText();
				String author = b_author.getText();
				String genre;
				if(scifi.isSelected()) {
					genre = "Sci-fi";
				}else {
					genre = "Biography";
				}
				try {
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
					String query = "insert into book_fun values(?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setInt(1, Integer.parseInt(id));
					pst.setString(2, name);
					pst.setString(3, author);
					pst.setString(4,genre);
					int flag = pst.executeUpdate();
					if(flag == 0) {
						JOptionPane.showMessageDialog(null,"Invalid Input!");
					}else {
						JOptionPane.showMessageDialog(null, "Inserted sucessfully!");
					}
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setBounds(185, 98, 71, 12);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SHOW TABLE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
					
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					model.setRowCount(0);
					
					String query = "select * from book_fun";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					while(rs.next()) {
						Object[] row = {rs.getInt("book_id"),rs.getString("title"), rs.getString("author"), rs.getString("genre")};	
						model.addRow(row);
					}
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton_1.setBounds(163, 116, 118, 12);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 140, 416, 113);
		contentPane.add(scrollPane_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_2.setViewportView(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectRow = table.getSelectedRow();
				if(selectRow != -1) {
					String b_id = table.getValueAt(selectRow, 0).toString();
					String b_name1 = table.getValueAt(selectRow, 1).toString();
					String b_author1 = table.getValueAt(selectRow, 2).toString();
					String b_genre = table.getValueAt(selectRow,3).toString();
					book_id.setText(b_id);
					b_name.setText(b_name1);
					b_author.setText(b_author1);
					
					
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
			},
			new String[] {
				"Book ID", "Book Name", "Author", "Genre"
			}
		));
		scrollPane_1.setViewportView(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 139, 416, 114);
		contentPane.add(scrollPane);

	}

}
