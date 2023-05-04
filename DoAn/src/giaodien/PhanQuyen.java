package giaodien;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import DAO.NhanVienDAO;
import model.ChucVuModel;
import model.NhanHieuModel;
import model.NhanVienModel;
import model.QuyenModel;
import model.SanPhamModel;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PhanQuyen extends JPanel {
	public DefaultTableModel model = new DefaultTableModel();
	public JPanel paneGia;
	private JTextField txtMax;
	private JTextField txtMin;
	JCheckBox ttbanhang;
	JCheckBox ttnhaphang;
	JCheckBox xnhanvien;
	JCheckBox ttnhanvien;
	JCheckBox xsanpham;
	JCheckBox xthongke;
	JCheckBox ttsanpham;
	JLabel lblPhnQuyn;
	JCheckBox ttphanquyen;
	JCheckBox xkhachhang;
	JCheckBox ttkhachhang;
	JComboBox comboBoxChucVu = new JComboBox();
	public class Item {
	    private String name;
	    private int value;

	    public Item(String name, int value) {
	        this.name = name;
	        this.value = value;
	    }

	    @Override
	    public String toString() {
	        return name;
	    }

	    public int getValue() {
	        return value;
	    }
	}
	public PhanQuyen() {
		setBackground(SystemColor.control);
		setLayout(null);

		JPanel panel_1 = new RoundedJPanel(15);
		panel_1.setBackground(SystemColor.text);
		panel_1.setBounds(10, 71, 1180, 749);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblDanhSchTi = new JLabel("DANH SÁCH QUYỀN");
		lblDanhSchTi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchTi.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
		lblDanhSchTi.setBounds(0, 20, 1140, 40);
		panel_1.add(lblDanhSchTi);

		JLabel lblBnHng = new JLabel("Bán Hàng");
		lblBnHng.setHorizontalAlignment(SwingConstants.LEFT);
		lblBnHng.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblBnHng.setBounds(209, 91, 157, 40);
		panel_1.add(lblBnHng);

		JLabel lblNhpHng = new JLabel("Nhập Hàng");
		lblNhpHng.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhpHng.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNhpHng.setBounds(209, 201, 157, 40);
		panel_1.add(lblNhpHng);

		JLabel lblTiKhon = new JLabel("Nhân Viên");
		lblTiKhon.setHorizontalAlignment(SwingConstants.LEFT);
		lblTiKhon.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblTiKhon.setBounds(209, 323, 157, 40);
		panel_1.add(lblTiKhon);

		JLabel lblThngK = new JLabel("Thống Kê");
		lblThngK.setHorizontalAlignment(SwingConstants.LEFT);
		lblThngK.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblThngK.setBounds(747, 91, 157, 40);
		panel_1.add(lblThngK);

		JLabel lblSnPhm = new JLabel("Sản Phẩm");
		lblSnPhm.setHorizontalAlignment(SwingConstants.LEFT);
		lblSnPhm.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblSnPhm.setBounds(747, 323, 157, 40);
		panel_1.add(lblSnPhm);

		ttbanhang = new JCheckBox("Thao Tác");
		ttbanhang.setBackground(Color.WHITE);
		ttbanhang.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		ttbanhang.setBounds(238, 138, 114, 23);
		panel_1.add(ttbanhang);

		ttnhaphang = new JCheckBox("Thao Tác");
		ttnhaphang.setBackground(Color.WHITE);
		ttnhaphang.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		ttnhaphang.setBounds(238, 248, 114, 23);
		panel_1.add(ttnhaphang);

		xnhanvien = new JCheckBox("Xem");
		xnhanvien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HanChe();
			}
		});
		xnhanvien.setBackground(Color.WHITE);
		xnhanvien.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		xnhanvien.setBounds(238, 362, 114, 23);
		panel_1.add(xnhanvien);

		ttnhanvien = new JCheckBox("Thao Tác");
		ttnhanvien.setBackground(Color.WHITE);
		ttnhanvien.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		ttnhanvien.setBounds(238, 403, 114, 23);
		panel_1.add(ttnhanvien);

		xsanpham = new JCheckBox("Xem");
		xsanpham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HanChe();
			}
		});
		xsanpham.setBackground(Color.WHITE);
		xsanpham.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		xsanpham.setBounds(778, 364, 114, 23);
		panel_1.add(xsanpham);

		ttsanpham = new JCheckBox("Thao Tác");
		ttsanpham.setBackground(Color.WHITE);
		ttsanpham.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		ttsanpham.setBounds(778, 405, 114, 23);
		panel_1.add(ttsanpham);

		xthongke = new JCheckBox("Xem");
		xthongke.setBackground(Color.WHITE);
		xthongke.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		xthongke.setBounds(778, 138, 114, 23);
		panel_1.add(xthongke);

		lblPhnQuyn = new JLabel("Phân Quyền");
		lblPhnQuyn.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhnQuyn.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblPhnQuyn.setBounds(747, 201, 157, 40);
		panel_1.add(lblPhnQuyn);

		ttphanquyen = new JCheckBox("Thao Tác");
		ttphanquyen.setBackground(Color.WHITE);
		ttphanquyen.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		ttphanquyen.setBounds(778, 248, 114, 23);
		panel_1.add(ttphanquyen);

		JButton btnLu = new JButton("   Lưu");
		btnLu.setIcon(new ImageIcon(PhanQuyen.class.getResource("/icon/save.jpg")));
		btnLu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id_cv=0;
				Object selectedItem = comboBoxChucVu.getSelectedItem();
				if (selectedItem instanceof Item) {
				    Item item = (Item) selectedItem;
				    id_cv = item.getValue();
				}
				DAO.ChucVu_QuyenDAO.XoaDi(id_cv);
				if(ttbanhang.isSelected()) {
					DAO.ChucVu_QuyenDAO.themVao(id_cv,1);
				}
				if(ttnhaphang.isSelected()) {
					DAO.ChucVu_QuyenDAO.themVao(id_cv,2);
				}
				if(xnhanvien.isSelected()) {
					DAO.ChucVu_QuyenDAO.themVao(id_cv,3);
				}
				if(ttnhanvien.isSelected()) {
					DAO.ChucVu_QuyenDAO.themVao(id_cv,4);
				}
				if(ttphanquyen.isSelected()) {
					DAO.ChucVu_QuyenDAO.themVao(id_cv,5);
				}
				if(xsanpham.isSelected()) {
					DAO.ChucVu_QuyenDAO.themVao(id_cv,6);
				}
				if(ttsanpham.isSelected()) {
					DAO.ChucVu_QuyenDAO.themVao(id_cv,7);
				}
				if(xthongke.isSelected()) {
					DAO.ChucVu_QuyenDAO.themVao(id_cv,8);
				}		
				if(xkhachhang.isSelected()) {
					DAO.ChucVu_QuyenDAO.themVao(id_cv,9);
				}
				if(ttkhachhang.isSelected()) {
					DAO.ChucVu_QuyenDAO.themVao(id_cv,10);
				}		
				JOptionPane.showMessageDialog(null,"Đã Cập Nhật");
			}
			
		});

		btnLu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLu.setBounds(483, 580, 150, 40);
		panel_1.add(btnLu);
		
		xkhachhang = new JCheckBox("Xem");
		xkhachhang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HanChe();
			}
		});
		xkhachhang.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		xkhachhang.setBackground(Color.WHITE);
		xkhachhang.setBounds(238, 491, 114, 23);
		panel_1.add(xkhachhang);
		
		ttkhachhang = new JCheckBox("Thao Tác");
		ttkhachhang.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		ttkhachhang.setBackground(Color.WHITE);
		ttkhachhang.setBounds(238, 532, 114, 23);
		panel_1.add(ttkhachhang);
		
		JLabel lblKhchHng = new JLabel("Khách Hàng");
		lblKhchHng.setHorizontalAlignment(SwingConstants.LEFT);
		lblKhchHng.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblKhchHng.setBounds(209, 452, 157, 40);
		panel_1.add(lblKhchHng);

		JPanel panel_2 = new RoundedJPanel(20);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 10, 1180, 50);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("PHÂN QUYỀN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
		lblNewLabel.setBounds(60, 5, 300, 40);
		panel_2.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\Picrure AT\\iconjava\\arrow.jpg"));
		lblNewLabel_2.setBounds(20, 5, 50, 40);
		panel_2.add(lblNewLabel_2);

		DefaultComboBoxModel LoaiSP = new DefaultComboBoxModel();
		comboBoxChucVu.setModel(LoaiSP);
		comboBoxChucVu.setBackground(Color.WHITE);

//		for (String nh : DAO.ChucVuDAO.getAllChucVu()) {
//			LoaiSP.addElement(nh);
//		}
		for (ChucVuModel cv : DAO.ChucVuDAO.getAllChucVu()) {
			Item i = new Item(cv.getTen_cv(),cv.getId_cv());
			comboBoxChucVu.addItem(i);
			
			}
		comboBoxChucVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ttbanhang.setSelected(false);
				ttnhaphang.setSelected(false);
				xnhanvien.setSelected(false);
				ttnhanvien.setSelected(false);
				ttphanquyen.setSelected(false);
				xsanpham.setSelected(false);
				ttsanpham.setSelected(false);
				xthongke.setSelected(false);
				xkhachhang.setSelected(false);
				ttkhachhang.setSelected(false);
				int id_cv=0;
				Object selectedItem = comboBoxChucVu.getSelectedItem();
				if (selectedItem instanceof Item) {
				    Item item = (Item) selectedItem;
				    id_cv = item.getValue();
				}
				HienThi(id_cv);
			}
		});
		int id_cv=0;
		Object selectedItem = comboBoxChucVu.getSelectedItem();
		if (selectedItem instanceof Item) {
		    Item item = (Item) selectedItem;
		    id_cv = item.getValue();
		}
		HienThi(id_cv);
		comboBoxChucVu.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		comboBoxChucVu.setBounds(394, 11, 300, 30);
		panel_2.add(comboBoxChucVu);

		comboBoxChucVu.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));

		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PhanQuyenAdd().setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(PhanQuyen.class.getResource("/icon/add.jpg")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(1060, 5, 100, 40);
		panel_2.add(btnNewButton);
	}
	public void HienThi(int id_cv) {
		for(QuyenModel q : DAO.ChucVu_QuyenDAO.getQuyenByidChucVu(id_cv)) {
			if (q.id_q == 1) {
				ttbanhang.setSelected(true);
			}
			if (q.id_q == 2) {
				ttnhaphang.setSelected(true);
			}
			if (q.id_q == 3) {
				xnhanvien.setSelected(true);
			}
			if (q.id_q == 4) {
				ttnhanvien.setSelected(true);
			}
			if (q.id_q == 5) {
				ttphanquyen.setSelected(true);
			}
			if (q.id_q == 6) {
				xsanpham.setSelected(true);
			}
			if (q.id_q == 7) {
				ttsanpham.setSelected(true);
			}
			if (q.id_q == 8) {
				xthongke.setSelected(true);
			}
			if (q.id_q == 9) {
				xkhachhang.setSelected(true);
			}
			if (q.id_q == 10) {
				ttkhachhang.setSelected(true);
			}
			HanChe();
		}
	}
	public void HanChe() {
		if(xkhachhang.isSelected()==false) {
			ttkhachhang.setSelected(false);
			ttkhachhang.setEnabled(false);
		}else {
			ttkhachhang.setEnabled(true);
		}
		if(xnhanvien.isSelected()==false) {
			ttnhanvien.setSelected(false);
			ttnhanvien.setEnabled(false);
		}else {
			ttnhanvien.setEnabled(true);
		}
		if(xsanpham.isSelected()==false) {
			ttsanpham.setSelected(false);
			ttsanpham.setEnabled(false);
		}else {
			ttsanpham.setEnabled(true);
		}
	}
}
