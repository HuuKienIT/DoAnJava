package giaodien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.NhanHieuDAO;
import model.NhanHieuModel;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NhanHieuAdd extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	JButton btnNewButton;
	ArrayList<NhanHieuModel> dsNH=NhanHieuDAO.getAllNhanHieu();
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
		
		JLabel lblEmail = new JLabel("Tên Nhãn Hiệu");
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
				if (textField_2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nhập Tên nhãn hiệu");
                    textField_2.requestFocus();
                    return;
                }
				int idnh=NhanHieuDAO.demTongSoNH()+1;
				String tennh=textField_2.getText();
				if(!checkExistTenNH(tennh)) {
					if(BUS.NhanHieuBUS.addNH(idnh,tennh)) {
						setVisible(false);
					}
				}
				else {
					if(BUS.NhanHieuBUS.updateNH(Integer.valueOf(textField.getText()),tennh)) {
						setVisible(false);
					}
				}
			}
		});
		panel.add(btnNewButton);
	}
	public void setDuLieu(String id, String ten) {
		textField.setText(id);
		textField_2.setText(ten);
		btnNewButton.setText("Cập Nhật");
	}
	public boolean checkExistTenNH(String tennh) {
		for(int i=0;i<dsNH.size();i++) {
			if(dsNH.get(i).getTen_nh().equalsIgnoreCase(tennh)) {
				return true;
			}
		}
		return false;
	}
}
