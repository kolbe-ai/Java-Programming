//46. Create a Library Book Entry System.
package program;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class L45 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField b_id;
	private JTextField b_name;
	private JTextField a_name;
	private JTextField b_genre;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					L45 frame = new L45();
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
	public L45() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book ID: ");
		lblNewLabel.setBounds(33, 63, 104, 12);
		contentPane.add(lblNewLabel);
		
		b_id = new JTextField();
		b_id.setBounds(139, 60, 96, 18);
		contentPane.add(b_id);
		b_id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name:");
		lblNewLabel_1.setBounds(33, 91, 96, 12);
		contentPane.add(lblNewLabel_1);
		
		b_name = new JTextField();
		b_name.setBounds(139, 88, 96, 18);
		contentPane.add(b_name);
		b_name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Library Book Entry System");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(108, 10, 210, 26);
		contentPane.add(lblNewLabel_2);
		
		a_name = new JTextField();
		a_name.setColumns(10);
		a_name.setBounds(139, 116, 96, 18);
		contentPane.add(a_name);
		
		b_genre = new JTextField();
		b_genre.setColumns(10);
		b_genre.setBounds(139, 144, 96, 18);
		contentPane.add(b_genre);
		
		lblNewLabel_3 = new JLabel("Author Name: ");
		lblNewLabel_3.setBounds(33, 119, 96, 12);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Genre");
		lblNewLabel_4.setBounds(33, 147, 71, 12);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Add Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = b_id.getText();
				String name = b_name.getText();
				String author_name = a_name.getText();
				String genre = b_genre.getText();
				try {
					
					//step 1 load drivers
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					//step 2 create connection
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");

					//step3 create the statement object 
					String query = "insert into book_lib values(?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1,id);
					pst.setString(2,name);
					pst.setString(3,author_name);
					pst.setString(4, genre);
					
					int rows = pst.executeUpdate();
					if(rows>0) {
						JOptionPane.showMessageDialog(null,"Book sucessfully added!");
					}else {
						JOptionPane.showMessageDialog(null,"Book not added\nTry again!");
					}			
					//pst.close();
					//con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
				}
			}
		});
		btnNewButton.setBounds(139, 172, 96, 20);
		contentPane.add(btnNewButton);

	}
}
