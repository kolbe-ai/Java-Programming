//45. Create a Library Book Entry System.

package program;

import java.awt.EventQueue;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;

public class Practice_45 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField b_id;
	private JTextField b_name;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Practice_45 frame = new Practice_45();
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
	public Practice_45() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Manager");
		lblNewLabel.setBounds(175, 10, 97, 12);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book ID:");
		lblNewLabel_1.setBounds(10, 45, 60, 12);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Book Name:");
		lblNewLabel_2.setBounds(10, 67, 76, 12);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton bio = new JRadioButton("Biography");
		buttonGroup.add(bio);
		bio.setBounds(0, 85, 90, 20);
		contentPane.add(bio);
		
		JRadioButton fic = new JRadioButton("Fictional");
		buttonGroup.add(fic);
		fic.setBounds(90, 85, 102, 20);
		contentPane.add(fic);
		
		b_id = new JTextField();
		b_id.setBounds(80, 42, 96, 18);
		contentPane.add(b_id);
		b_id.setColumns(10);
		
		b_name = new JTextField();
		b_name.setBounds(80, 64, 96, 18);
		contentPane.add(b_name);
		b_name.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String bid = b_id.getText();
					String bname = b_name.getText();
					String genre ="";
					if(bio.isSelected()) {
						genre = "Biography";						
					}
					if(bio.isSelected()){
						genre = "Fictional";
					}
					String query = "insert into library_new values(?,?,?)";
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
					PreparedStatement pst = con.prepareStatement(query);
					pst.setInt(1, Integer.parseInt(bid));
					pst.setString(2,bname);
					pst.setString(3, genre);
					
					int flag = pst.executeUpdate();
					if (flag > 0) {
						JOptionPane.showMessageDialog(null, "Added Successfull!");						
					}else {
						JOptionPane.showMessageDialog(null, "Added Unsucessfull!");
					}					
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
		btnNewButton.setBounds(10, 111, 70, 20);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(96, 111, 96, 20);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(40, 137, 90, 20);
		contentPane.add(btnDelete);
		
		JCheckBox combo1 = new JCheckBox("New check box");
		combo1.setBounds(10, 170, 92, 20);
		contentPane.add(combo1);
		
		JCheckBox combo2 = new JCheckBox("New check box");
		combo2.setBounds(10, 191, 92, 20);
		contentPane.add(combo2);

		
		JButton btnNewButton_1 = new JButton("SHOW");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String combo;
					if(combo1.isSelected()) {
						combo = "Combo1";
						System.out.println(combo);
					}
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
					String query = "select * from library_new";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					model.setRowCount(0);
					
					while(rs.next()) {
						Object[] row = {rs.getInt("b_id"), rs.getString("b_name"),rs.getString("genre")};
						model.addRow(row);
					}
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnNewButton_1.setBounds(285, 170, 84, 20);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(248, 44, 178, 113);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "Name", "Genre"
			}
		));
		
		
	}
}
