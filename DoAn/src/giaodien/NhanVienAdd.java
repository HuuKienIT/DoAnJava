package giaodien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;

import DAO.NhanVienDAO;
import model.NhanVienModel;

import javax.swing.SwingConstants;
import java.awt.Dialog.ModalExclusionType;

public class NhanVienAdd extends JFrame {
	private JPanel contentPane;
	RoundJTextField txtHoTen = new RoundJTextField(15);
	RoundJTextField txtEmail = new RoundJTextField(15);
	RoundJTextField txtSodth = new RoundJTextField(15);
	RoundJTextField txtID = new RoundJTextField(15);
	JComboBox comboChucVu = new JComboBox();
	JLabel lblNewLabel = new JLabel("");
	JButton btnLu;
	public NhanVienAdd() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 734, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		RoundedJPanel panel = new RoundedJPanel(15);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 70, 700, 420);
		contentPane.add(panel);
		setLocationRelativeTo(null);
		
		btnLu = new JButton("Thêm");
		btnLu.setIcon(new ImageIcon(NhanVienAdd.class.getResource("/icon/save.jpg")));
		btnLu.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
		btnLu.setBackground(Color.WHITE);
		btnLu.setBounds(120, 310, 150, 40);
		panel.add(btnLu);
		
		JLabel lblNewLabel_1 = new JLabel("Họ Tên");
		lblNewLabel_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(260, 30, 80, 30);
		panel.add(lblNewLabel_1);
		
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(340, 30, 249, 30);
		panel.add(txtHoTen);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(70, 141, 99, 30);
		panel.add(lblNewLabel_1_1);
		
		txtSodth.setColumns(10);
		txtSodth.setBounds(197, 143, 200, 30);
		panel.add(txtSodth);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(87, 87, 80, 30);
		panel.add(lblNewLabel_1_2);
		
		txtEmail.setColumns(10);
		txtEmail.setBounds(195, 87, 227, 30);
		panel.add(txtEmail);
		
		JLabel lblNewLabel_1_4 = new JLabel("Mã NV");
		lblNewLabel_1_4.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(68, 30, 66, 30);
		panel.add(lblNewLabel_1_4);
		
		txtID.setEditable(false);
		txtID.setDisabledTextColor(Color.BLACK);
		txtID.setColumns(10);
		txtID.setBounds(132, 30, 100, 30);
		panel.add(txtID);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Chức vụ");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(87, 199, 80, 30);
		panel.add(lblNewLabel_1_2_1);
		

		comboChucVu.setBounds(195, 202, 168, 30);
		panel.add(comboChucVu);
		

		lblNewLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel.setBounds(467, 87, 150, 150);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Chọn ảnh");
		btnNewButton.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 14));
		btnNewButton.setBounds(493, 259, 100, 30);
		panel.add(btnNewButton);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setIcon(new ImageIcon(NhanVienAdd.class.getResource("/icon/delete.jpg")));
		btnXa.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
		btnXa.setBackground(Color.WHITE);
		btnXa.setBounds(300, 310, 150, 40);
		panel.add(btnXa);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 10, 700, 50);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("CHỈNH SỬA TÀI KHOẢN\r\n");
		lblNewLabel_1_4_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNewLabel_1_4_1.setBounds(245, 5, 300, 40);
		panel_1.add(lblNewLabel_1_4_1);
	}
	public void setDuLieu(int id_nv) {
		NhanVienModel u = NhanVienDAO.getUsersByID(id_nv);
		txtID.setText(id_nv+"");
   		txtHoTen.setText(u.getHoTen());
   		txtEmail.setText(u.getEmail());
   		txtSodth.setText(u.getSoDth()+"");
   		btnLu.setText("Cập Nhật");
   		layChucVu();
   		comboChucVu.setSelectedItem(u.getChucVu());
   		hienhinh(u.getPhoto());
	}
	public void layChucVu() {
		DefaultComboBoxModel model =  (DefaultComboBoxModel) comboChucVu.getModel();
		for(String cv : DAO.ChucVuDAO.getAllChucVu()) {
			model.addElement(cv);
		}
		comboChucVu.setModel(model);
	}
	public void hienhinh(String tenfile) {
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(BanHang.class.getResource("/photo/"+tenfile)).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(imageIcon);
		
	}
}
