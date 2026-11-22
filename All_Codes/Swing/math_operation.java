/*
3. Write a Java Swing program with two text fields to enter two numbers and four
buttons (+, −, ×, ÷). On clicking a button, perform the corresponding operation and
display the result in a label.
*/

package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class math_operation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField num_1;
	private JTextField num_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					math_operation frame = new math_operation();
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
	public math_operation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Calculator");
		lblNewLabel.setBounds(168, 10, 57, 12);
		contentPane.add(lblNewLabel);
		
		num_1 = new JTextField();
		num_1.setBounds(156, 76, 113, 18);
		contentPane.add(num_1);
		num_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Number 1:");
		lblNewLabel_1.setBounds(54, 79, 57, 12);
		contentPane.add(lblNewLabel_1);
		
		num_2 = new JTextField();
		num_2.setBounds(156, 104, 113, 18);
		contentPane.add(num_2);
		num_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Number 2:");
		lblNewLabel_2.setBounds(54, 107, 57, 12);
		contentPane.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("Result: ");
		lblNewLabel_3.setBounds(54, 202, 189, 12);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1 = Integer.parseInt(num_1.getText());
				int num2 = Integer.parseInt(num_2.getText());
				int result = num1+num2;
				lblNewLabel_3.setText("Result: "+(num1+num2));				
			}
		});
		btnNewButton.setBounds(154, 132, 55, 21);
		contentPane.add(btnNewButton);
		
		JButton btnSub = new JButton("SUB");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int num1 = Integer.parseInt(num_1.getText());
				int num2 = Integer.parseInt(num_2.getText());
				int result = num1-num2;
				lblNewLabel_3.setText("Result: "+result);
				
			}
		});
		btnSub.setBounds(212, 132, 57, 21);
		contentPane.add(btnSub);
		
		JButton btnMul = new JButton("MUL");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1 = Integer.parseInt(num_1.getText());
				int num2 = Integer.parseInt(num_2.getText());
				int result = num1*num2;
				lblNewLabel_3.setText("Result: "+result);
			}
		});
		btnMul.setBounds(154, 162, 57, 21);
		contentPane.add(btnMul);
		
		JButton btnDiv = new JButton("DIV");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1 = Integer.parseInt(num_1.getText());
				int num2 = Integer.parseInt(num_2.getText());
				int result = num1/num2;
				lblNewLabel_3.setText("Result: "+result);
			}
		});
		btnDiv.setBounds(212, 163, 57, 21);
		contentPane.add(btnDiv);
		

	}

}
