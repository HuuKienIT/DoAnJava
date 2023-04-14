package giaodien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NhanHieuAdd extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					themKhachHang frame = new themKhachHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NhanHieuAdd() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 591, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 555, 284);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NHÃN HIỆU");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 23));
		lblNewLabel.setEnabled(true);
		lblNewLabel.setBounds(10, 20, 535, 30);
		panel.add(lblNewLabel);
		
		JLabel lblHTn = new JLabel("ID");
		lblHTn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHTn.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		lblHTn.setEnabled(true);
		lblHTn.setBounds(46, 80, 150, 30);
		panel.add(lblHTn);
		
		JLabel lblSinThoi = new JLabel("Mã Nhãn Hiệu");
		lblSinThoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSinThoi.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		lblSinThoi.setEnabled(true);
		lblSinThoi.setBounds(46, 130, 150, 30);
		panel.add(lblSinThoi);
		
		JLabel lblEmail = new JLabel("Tên Nhãn Hiệu");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		lblEmail.setEnabled(true);
		lblEmail.setBounds(46, 180, 150, 30);
		panel.add(lblEmail);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		textField.setBounds(230, 80, 200, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(230, 130, 200, 30);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(230, 180, 200, 30);
		panel.add(textField_2);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		btnNewButton.setBounds(224, 230, 100, 30);
		panel.add(btnNewButton);
	}
}
