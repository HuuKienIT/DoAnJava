package giaodien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;

	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1056, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 487, 441);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(SignUp.class.getResource("/img/38434537-removebg-preview.png")));
		lblNewLabel_4.setBounds(79, 36, 256, 233);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("To keep connected with us please \r\n\r\n");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(116, 257, 257, 49);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("login with your personal info");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(124, 305, 211, 27);
		panel.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("Sign In");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("VNI-Centur", Font.BOLD, 18));
		btnNewButton_1.setForeground(new Color(173, 216, 230));
		btnNewButton_1.setBounds(151, 354, 134, 43);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(484, 0, 563, 441);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setIcon(new ImageIcon(SignUp.class.getResource("/img/icons8-edit-100.png")));
		lblNewLabel.setBounds(184, 10, 113, 75);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sign Up");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setForeground(new Color(176, 224, 230));
		lblNewLabel_1.setBounds(204, 95, 82, 32);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(173, 216, 230));
		panel_2.setBounds(10, 200, 182, 40);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("User Name");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 11, 122, 26);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setIcon(new ImageIcon(SignUp.class.getResource("/img/icons8-test-account-40.png")));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setBounds(193, 200, 294, 40);
		panel_1.add(textField);
		textField.setBackground(new Color(255, 255, 255));
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(173, 216, 230));
		panel_3.setBounds(10, 251, 182, 40);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(10, 0, 132, 40);
		lblNewLabel_3.setIcon(new ImageIcon(SignUp.class.getResource("/img/icons8-password-window-40.png")));
		panel_3.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(193, 251, 294, 40);
		panel_1.add(passwordField);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(173, 216, 230));
		panel_3_1.setBounds(10, 302, 182, 40);
		panel_1.add(panel_3_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Confirm Password");
		lblNewLabel_3_1.setIcon(new ImageIcon(SignUp.class.getResource("/img/icons8-password-window-40.png")));
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(10, 0, 170, 40);
		panel_3_1.add(lblNewLabel_3_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(192, 302, 294, 40);
		panel_1.add(passwordField_1);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(173, 216, 230));
		btnNewButton.setBounds(204, 377, 139, 40);
		panel_1.add(btnNewButton);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(173, 216, 230));
		panel_2_1.setBounds(10, 149, 182, 40);
		panel_1.add(panel_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Full Name");
		lblNewLabel_2_1.setIcon(new ImageIcon(SignUp.class.getResource("/img/icons8-test-account-40.png")));
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(10, 8, 150, 26);
		panel_2_1.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(193, 149, 294, 40);
		panel_1.add(textField_1);
	}
}
