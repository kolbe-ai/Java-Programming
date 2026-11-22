//44. Design a Login Form with validation.

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Practice_44 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t_id;
	private JTextField t_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Practice_44 frame = new Practice_44();
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
	public Practice_44() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN ");
		lblNewLabel.setBounds(179, 10, 86, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Teacher ID: ");
		lblNewLabel_1.setBounds(107, 62, 86, 12);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Teacher Name: ");
		lblNewLabel_2.setBounds(107, 93, 101, 12);
		contentPane.add(lblNewLabel_2);
		
		t_id = new JTextField();
		t_id.setBounds(203, 59, 96, 18);
		contentPane.add(t_id);
		t_id.setColumns(10);
		
		t_name = new JTextField();
		t_name.setBounds(203, 87, 96, 18);
		contentPane.add(t_name);
		t_name.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = t_id.getText();
					String name = t_name.getText();
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rcss123#");
					String query = "select id,name from teacher_new where id = ? and name = ?";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setInt(1,Integer.parseInt(id));
					pst.setString(2,name);
					
					ResultSet rs = pst.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Login Sucessfull!");
					}else {
						JOptionPane.showMessageDialog(null, "Unsucessfull login!");
					}					
				}catch (Exception e1){
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setBounds(166, 130, 84, 20);
		contentPane.add(btnNewButton);

	}
}
