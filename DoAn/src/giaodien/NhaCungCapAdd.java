
package giaodien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.NhaCungCapDAO;
import DAO.NhanHieuDAO;
import model.NhaCungCapModel;

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

public class NhaCungCapAdd extends JFrame {

	private JPanel contentPane;
	private JTextField txtidncc;
	private JTextField txttenncc;
	private JTextField txtsdt;
	private JTextField txtemail;
	ArrayList<NhaCungCapModel> dsNCC = NhaCungCapDAO.getAllNCC();
	JButton btnNewButton;

	public NhaCungCapAdd() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 591, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 555, 417);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("NHÀ CUNG CẤP");
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

		JLabel lblSinThoi = new JLabel("Nhà Cung Cấp");
		lblSinThoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSinThoi.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		lblSinThoi.setEnabled(true);
		lblSinThoi.setBounds(46, 130, 150, 30);
		panel.add(lblSinThoi);

		txtidncc = new JTextField();
		txtidncc.setEditable(false);
		txtidncc.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		txtidncc.setBounds(230, 80, 200, 30);
		panel.add(txtidncc);
		txtidncc.setColumns(10);

		txttenncc = new JTextField();
		txttenncc.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		txttenncc.setColumns(10);
		txttenncc.setBounds(230, 130, 200, 30);
		panel.add(txttenncc);

		txtsdt = new JTextField();
		txtsdt.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		txtsdt.setColumns(10);
		txtsdt.setBounds(230, 180, 200, 30);
		panel.add(txtsdt);

		txtemail = new JTextField();
		txtemail.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		txtemail.setColumns(10);
		txtemail.setBounds(230, 230, 200, 30);
		panel.add(txtemail);

		btnNewButton = new JButton("Thêm");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		btnNewButton.setBounds(220, 300, 150, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txttenncc.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Nhập Tên nhà cung cấp");
					txttenncc.requestFocus();
					return;
				}
				if (txtsdt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Nhập Số điện thoại nhà cung cấp");
					txtsdt.requestFocus();
					return;
				}
				if (txtemail.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Nhập Email nhà cung cấp");
					txtemail.requestFocus();
					return;
				}
				String tenncc = txttenncc.getText();
				String sdt = txtsdt.getText();
				String email = txtemail.getText();
				if (!checkExistIdNCC(Integer.valueOf(txtidncc.getText()))) {
					if (BUS.NhaCungCapBUS.addNCC(tenncc, sdt, email)) {
						setVisible(false);
					}
				} else {
					if (BUS.NhaCungCapBUS.updateNCC(Integer.valueOf(txtidncc.getText()), tenncc, sdt, email)) {
						setVisible(false);
					}
				}
			}
		});
		panel.add(btnNewButton);

		JLabel lblSinThoi_1 = new JLabel("Số Điện Thoại");
		lblSinThoi_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSinThoi_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblSinThoi_1.setEnabled(true);
		lblSinThoi_1.setBounds(46, 180, 150, 30);
		panel.add(lblSinThoi_1);

		JLabel lblSinThoi_1_1 = new JLabel("Email");
		lblSinThoi_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSinThoi_1_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblSinThoi_1_1.setEnabled(true);
		lblSinThoi_1_1.setBounds(46, 230, 150, 30);
		panel.add(lblSinThoi_1_1);
	}

	public void setDuLieu(String id, String ten, String sdt, String email) {
		txtidncc.setText(id);
		txttenncc.setText(ten);
		txtsdt.setText(sdt);
		txtemail.setText(email);
		btnNewButton.setText("Cập Nhật");
	}

	public boolean checkExistIdNCC(int idncc) {
		for (int i = 0; i < dsNCC.size(); i++) {
			if (dsNCC.get(i).getId_ncc() == idncc) {
				return true;
			}
		}
		return false;
	}
}
