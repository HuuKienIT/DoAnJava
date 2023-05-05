package giaodien;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.NhanHieuDAO;
import model.NhanHieuModel;

public class PhanQuyenAdd extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	JButton btnNewButton;
	public PhanQuyenAdd() {
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
		
		JLabel lblNewLabel = new JLabel("Nhóm Quyền");
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
		
		JLabel lblEmail = new JLabel("Tên Quyền");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		lblEmail.setEnabled(true);
		lblEmail.setBounds(46, 141, 150, 30);
		panel.add(lblEmail);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		textField.setBounds(230, 80, 200, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(230, 141, 200, 30);
		panel.add(textField_2);
		
		btnNewButton = new JButton("Thêm");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		btnNewButton.setBounds(215, 200, 150, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_2.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Chưa có thông tin ");
				}else {
					DAO.QuyenDAO.addQuyen(textField_2.getText());
					JOptionPane.showMessageDialog(null,"Thêm Thành công");
					dispose();
				}
			}
		});
		panel.add(btnNewButton);
	}
}
