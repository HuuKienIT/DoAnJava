package giaodien;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import DAO.NhanVienDAO;
import model.NhanVienModel;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NhanVien extends JPanel {
	private JTable table;
	public DefaultTableModel model = new DefaultTableModel();
	public JPanel paneGia;
	public JComboBox comboBox = new JComboBox();
	public JComboBox comboLoaiSp = new JComboBox();
	private JTextField txtMax;
	private JTextField txtMin;
	public ArrayList<NhanVienModel> dsNV = NhanVienDAO.getAllUsers();
	private JTextField textField;

	public NhanVien() {
		setBackground(SystemColor.control);
		setLayout(null);

		JPanel panel_1 = new RoundedJPanel(15);
		panel_1.setBackground(SystemColor.text);
		panel_1.setBounds(10, 120, 1180, 749);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblDanhSchTi = new JLabel("DANH SÁCH TÀI KHOẢN");
		lblDanhSchTi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchTi.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 25));
		lblDanhSchTi.setBounds(0, 20, 1140, 40);
		panel_1.add(lblDanhSchTi);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1, 80, 1178, 658);
		panel_1.add(scrollPane);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		scrollPane.getViewport().setBackground(Color.WHITE);

		table = new cusTable();
		String[] columnNames = { "ID", "Họ Tên", "Giới Tính", "Ngày Sinh", "Tài Khoản", "Mật Khẩu", "Email", "Số Điện Thoại",
				"Chức Vụ" };
		model.setColumnIdentifiers(columnNames);
		layDuLieu();
		table.setModel(model);
		table.getColumnModel().getColumn(0).setMaxWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		table.getColumnModel().getColumn(8).setPreferredWidth(100);
		table.getColumnModel().getColumn(0).setCellRenderer(new CenterAlignRenderer());

		scrollPane.setViewportView(table);

		JPanel panel_2 = new RoundedJPanel(20);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 10, 1180, 50);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
		lblNewLabel.setBounds(80, 5, 300, 40);
		panel_2.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(NhanVien.class.getResource("/icon/arrow.jpg")));
		lblNewLabel_2.setBounds(20, 5, 50, 40);
		panel_2.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NhanVienAdd().setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(NhanVien.class.getResource("/icon/add.jpg")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(1060, 5, 100, 40);
		panel_2.add(btnNewButton);

		JButton btnNhpExcel = new JButton("Nhập Excel");
		btnNhpExcel.setIcon(new ImageIcon(NhanVien.class.getResource("/icon/import.jpg")));
		btnNhpExcel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNhpExcel.setBounds(745, 5, 150, 40);
		panel_2.add(btnNhpExcel);

		JButton btnXutExcel = new JButton("Xuất Excel");
		btnXutExcel.setIcon(new ImageIcon(NhanVien.class.getResource("/icon/export.jpg")));
		btnXutExcel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXutExcel.setBounds(905, 5, 150, 40);
		panel_2.add(btnXutExcel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) { // Check if the click count is 2 (double-click)
					NhanVienAdd nva = new NhanVienAdd();
					nva.setDuLieu((int) table.getValueAt(table.getSelectedRow(), 0));
					nva.setVisible(true);
				}
			}
		});

		RoundedJPanel panelTimKiem = new RoundedJPanel(20);
		panelTimKiem.setLayout(null);
		panelTimKiem.setBackground(Color.WHITE);
		panelTimKiem.setBounds(10, 71, 1180, 50);
		add(panelTimKiem);

		JLabel lblNewLabel_3_1 = new JLabel("TÌM KIẾM");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(20, 5, 109, 40);
		panelTimKiem.add(lblNewLabel_3_1);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(350, 10, 250, 30);
		panelTimKiem.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Tên / Email / Số ĐT");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(174, 10, 150, 30);
		panelTimKiem.add(lblNewLabel_1);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1.setBounds(748, 10, 150, 30);
		panelTimKiem.add(comboBox_1);

		JLabel lblNewLabel_1_1 = new JLabel("Chức Vụ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(660, 10, 150, 30);
		panelTimKiem.add(lblNewLabel_1_1);

		JButton btnTm = new JButton("Tìm");
		btnTm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTm.setBounds(941, 5, 100, 40);
		panelTimKiem.add(btnTm);
//		paneThayDoi.add(txtKiem);

	}

	public void layDuLieu() {
		for (NhanVienModel u : dsNV) {
			String gt;
			if (u.getGioiTinh() == 1) {
				gt = "Nam";
			} else {
				gt = "Nữ";
			}
			Object[] row = new Object[] { u.getId_nv(), u.getHoTen(), gt,u.getNamSinh(), u.getTaiKhoan(), u.getMatKhau(), u.getEmail(),
					 u.getSoDth(), u.getChucVu() };
			model.addRow(row);
		}
		table.setModel(model);
	}

	public void TimKiem() {
		ArrayList<NhanVienModel> spLoc = new ArrayList<NhanVienModel>();
//		String tenSP = txtKiem.getText();
//		if(tenSP.equals("Nhập tên Sản Phẩm")) {
//			tenSP="";
//		}
//		String nhanHieu = (String) comboLoaiSp.getSelectedItem();
//		if(nhanHieu.equals("Tất cả Nhãn Hiệu")) {
//			nhanHieu="";
//		}
//		int giaMin=0;
//		if(!textField_1.getText().equals("")) {
//			giaMin=Integer.parseInt(textField_1.getText());
//		}
//		int giaMax=10000000;
//		if(!textField_2.getText().equals("")) {
//			giaMax=Integer.parseInt(textField_2.getText());
//		}
//		if(giaMin>giaMax) {
//			return;
//		}
//		for(NhanVienModel sp :DAO.sanPhamDAO.getAllSanPham()) {
//			if(sp.getTensp().toLowerCase().contains(tenSP.toLowerCase())&& sp.getNhanhieu().toLowerCase().contains(nhanHieu.toLowerCase())&&sp.getGia()>=giaMin && sp.getGia()<=giaMax) 
//			{
//				spLoc.add(sp);
//			}
//		}	
//		modelSP.setRowCount(0);
//		for(NhanVienModel sp : spLoc ) {
//			Object[] row = new Object[] {sp.getMasp(),sp.getTensp(),intToMoney(sp.getGia()),sp.getConlai()} ;
//      		modelSP.addRow(row);
//		}
//		tableSP.setModel(modelSP);
	}
}
