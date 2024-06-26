package giaodien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.KhachHangModel;

import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThemKhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField txtHoTen;
	private JTextField txtSoDth;
	private JTextField txtMaKh;
	JButton btnNewButton;
	private JTextField txtEmail;
	public ThemKhachHang() {

		setType(Type.UTILITY);
		setBounds(100, 100, 591, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 555, 350);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHI TIẾT KHÁCH HÀNG");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 23));
		lblNewLabel.setEnabled(true);
		lblNewLabel.setBounds(10, 20, 535, 30);
		panel.add(lblNewLabel);
		
		JLabel lblHTn = new JLabel("Họ Tên");
		lblHTn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHTn.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		lblHTn.setEnabled(true);
		lblHTn.setBounds(42, 128, 150, 30);
		panel.add(lblHTn);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSinThoi.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		lblSinThoi.setEnabled(true);
		lblSinThoi.setBounds(42, 178, 150, 30);
		panel.add(lblSinThoi);
		
		txtHoTen = new JTextField();
		txtHoTen.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		txtHoTen.setBounds(226, 128, 200, 30);
		panel.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		txtSoDth = new JTextField();
		txtSoDth.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		txtSoDth.setColumns(10);
		txtSoDth.setBounds(226, 178, 200, 30);
		panel.add(txtSoDth);
		
		btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtHoTen.getText().equals("") || txtEmail.getText().equals("") || txtSoDth.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Không để trống");
				}else {
					if(txtMaKh.getText().equals("")) {
						KhachHangModel kh = new KhachHangModel();
						kh.setTenkh(txtHoTen.getText());
						kh.setSodth(Integer.parseInt(txtSoDth.getText()));
						kh.setEmail(txtEmail.getText());
						DAO.KhachHangDAO.themKhachHang(kh);
						JOptionPane.showMessageDialog(null,"Thêm Thành công");
						dispose();
					}else {
						KhachHangModel kh = new KhachHangModel();
						kh.setTenkh(txtHoTen.getText());
						kh.setSodth(Integer.parseInt(txtSoDth.getText()));
						kh.setEmail(txtEmail.getText());
						DAO.KhachHangDAO.updateKhachHang(kh, Integer.parseInt(txtMaKh.getText()));
						JOptionPane.showMessageDialog(null,"Sửa Thành công");
						dispose();
					}
				}	
			}
		});
		btnNewButton.setIcon(new ImageIcon(ThemKhachHang.class.getResource("/icon/save.jpg")));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		btnNewButton.setBounds(210, 285, 150, 40);
		panel.add(btnNewButton);
		
		txtMaKh = new JTextField();
		txtMaKh.disable();
		txtMaKh.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		txtMaKh.setColumns(10);
		txtMaKh.setBounds(226, 80, 200, 30);
		panel.add(txtMaKh);
		
		JLabel akbask = new JLabel("Mã KH");
		akbask.setHorizontalAlignment(SwingConstants.RIGHT);
		akbask.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		akbask.setEnabled(true);
		akbask.setBounds(42, 80, 150, 30);
		panel.add(akbask);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		lblEmail.setEnabled(true);
		lblEmail.setBounds(42, 233, 150, 30);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(226, 233, 200, 30);
		panel.add(txtEmail);
	}
	public void setDuLieu(int id_kh) {
		KhachHangModel kh =DAO.KhachHangDAO.getKhachHangByid(id_kh);
		txtMaKh.setText(kh.getId_kh()+"");
		txtHoTen.setText(kh.getTenkh());
		txtSoDth.setText(kh.getSodth()+"");
		txtEmail.setText(kh.getEmail());
		btnNewButton.setText("Cập nhật");
	}
}
