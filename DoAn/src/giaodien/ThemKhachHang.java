package giaodien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.KhachHangModel;

import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ThemKhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField txtHoTen;
	private JTextField txtSoDth;
	public int id_kh;
	private JTextField txtMaKh;

	public ThemKhachHang(int id_kh) {
		this.id_kh= id_kh;
		setType(Type.UTILITY);
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
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		btnNewButton.setBounds(224, 230, 100, 30);
		panel.add(btnNewButton);
		
		txtMaKh = new JTextField();
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
		layDuLieu();
	}
	public void layDuLieu() {
		KhachHangModel kh =DAO.khachHangDAO.getKhachHangByid(id_kh);
		txtMaKh.setText(kh.getMakh());
		txtHoTen.setText(kh.getTenkh());
		txtSoDth.setText(kh.getSodth()+"");
	}
}
