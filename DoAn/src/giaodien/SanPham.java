package giaodien;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import DAO.NhanHieuDAO;
import DAO.SanPhamDAO;
import model.SanPhamModel;
import model.NhanVienModel;
import model.SanPhamGHModel;

import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Locale;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SanPham extends JPanel {
	private JTextField textField;
	private JTextField txtMin;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	JButton btnNewButton_2_1;
	JButton btnNewButton_2;
	JButton btnNewButton_2_2;
	RoundJTextField txtTenSP = new RoundJTextField(20);
	JComboBox comboSLTG = new JComboBox();
	public JComboBox comboBox = new JComboBox();
	public JComboBox comboNhanHieu = new JComboBox();
	private JTextField txtMax;
	private JTable table;
	public DefaultTableModel modelSP = new DefaultTableModel();
	ArrayList<SanPhamModel> dsSP = SanPhamDAO.getAllSanPham();
	public static int id;
	NhanVienModel nv;

	public SanPham(NhanVienModel nv) {
		this.nv = nv;
		setBackground(SystemColor.control);
		setLayout(null);

		JPanel panel = new RoundedJPanel(20);
		panel.setBackground(SystemColor.text);
		panel.setBounds(10, 120, 1180, 700);
		add(panel);
		panel.setLayout(null);

		JLabel lblDanhSchSn = new JLabel("DANH SÁCH SẢN PHẨM");
		lblDanhSchSn.setBounds(0, 20, 1180, 30);
		panel.add(lblDanhSchSn);
		lblDanhSchSn.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchSn.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JScrollBar cuon = new ScrollBarCustom();
		scrollPane.setVerticalScrollBar(cuon);
		scrollPane.setBounds(10, 60, 1160, 629);
		panel.add(scrollPane);

		table = new cusTable();
		scrollPane.setViewportView(table);
		String[] columnNamesSP = { "ID", "Sản phẩm", "Nhãn Hiệu", "Đơn giá", "Còn lại" };
		modelSP.setColumnIdentifiers(columnNamesSP);
		layDuLieu();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) { // Check if the click count is 2 (double-click)
					SanPhamAdd spa = new SanPhamAdd();
					spa.setDuLieu(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0) + ""));
					spa.setVisible(true);
					spa.txtMaSP.setEditable(false);
					id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
					System.out.print(id);
					layDuLieu();
				}
			}
		});
		

		JPanel panelHeader = new RoundedJPanel(20);
		panelHeader.setBackground(Color.WHITE);
		panelHeader.setBounds(10, 10, 1180, 50);
		add(panelHeader);
		panelHeader.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("QUẢN LÝ SẢN PHẨM");
		lblNewLabel_3.setBounds(80, 5, 261, 40);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
		panelHeader.add(lblNewLabel_3);

		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setIcon(new ImageIcon(SanPham.class.getResource("/icon/arrow.jpg")));
		lblNewLabel.setBounds(20, 5, 46, 40);
		panelHeader.add(lblNewLabel);

		btnNewButton_2 = new JButton("New");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SanPhamAdd spa = new SanPhamAdd();
				spa.setVisible(true);
				layDuLieu();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(SanPham.class.getResource("/icon/add.jpg")));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(1060, 5, 100, 40);
		panelHeader.add(btnNewButton_2);

		btnNewButton_2_1 = new JButton("Nhập Excel");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1.setIcon(new ImageIcon(SanPham.class.getResource("/icon/import.jpg")));
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2_1.setBounds(750, 5, 150, 40);
		panelHeader.add(btnNewButton_2_1);

		btnNewButton_2_2 = new JButton("Xuất Excel");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int output = JOptionPane.showConfirmDialog(null, "Bạn có muốn xuất File Excel không?", "",
						JOptionPane.YES_NO_OPTION);
				if (output == JOptionPane.YES_OPTION) {
					try {
						BUS.SanPhamBUS.xuatExcel();
					} catch (IOException e1) {
					}
				}
			}
		});
		btnNewButton_2_2.setIcon(new ImageIcon(SanPham.class.getResource("/icon/export.jpg")));
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2_2.setBounds(905, 5, 150, 40);
		panelHeader.add(btnNewButton_2_2);

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

		JPanel paneThayDoi = new JPanel();
		paneThayDoi.setLayout(null);
		paneThayDoi.setBackground(Color.WHITE);
		paneThayDoi.setAlignmentY(0.0f);
		paneThayDoi.setAlignmentX(0.0f);
		paneThayDoi.setBounds(139, 10, 900, 30);
		panelTimKiem.add(paneThayDoi);
		comboNhanHieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiem();
			}
		});
		comboNhanHieu.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		comboNhanHieu.setLocation(220, 0);
		comboNhanHieu.setSize(200, 30);

		paneThayDoi.add(comboNhanHieu);
		txtTenSP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				TimKiem();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				TimKiem();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				TimKiem();
			}
		});
		txtTenSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtTenSP.getText().equals("Nhập tên Sản Phẩm")) {
					txtTenSP.setText("");
				}
			}
		});
		txtTenSP.setText("Nhập tên Sản Phẩm");
		txtTenSP.setHorizontalAlignment(SwingConstants.CENTER);
		txtTenSP.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		txtTenSP.setColumns(15);
		txtTenSP.setBounds(10, 0, 200, 30);
		paneThayDoi.add(txtTenSP);

		txtMax = new RoundJTextField(10);
		txtMax.setHorizontalAlignment(SwingConstants.CENTER);
		txtMax.setBounds(670, 0, 120, 29);
		paneThayDoi.add(txtMax);
		txtMax.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		txtMax.setColumns(10);
		txtMax.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		JLabel lbln = new JLabel("đến");
		lbln.setBounds(624, 0, 40, 30);
		paneThayDoi.add(lbln);
		lbln.setHorizontalAlignment(SwingConstants.CENTER);
		lbln.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));

		txtMin = new RoundJTextField(10);
		txtMin.setHorizontalAlignment(SwingConstants.CENTER);
		txtMin.setBounds(499, 0, 120, 30);
		paneThayDoi.add(txtMin);
		txtMin.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		txtMin.setColumns(10);
		txtMin.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});

		JLabel lblT = new JLabel("Giá từ");
		lblT.setBounds(430, 0, 65, 30);
		paneThayDoi.add(lblT);
		lblT.setHorizontalAlignment(SwingConstants.CENTER);
		lblT.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		comboSLTG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiem();
			}
		});
		comboSLTG.setModel(new DefaultComboBoxModel(new String[] { "SL Tăng", "SL Giảm" }));
		comboSLTG.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		comboSLTG.setBounds(800, 0, 100, 30);
		paneThayDoi.add(comboSLTG);

		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiem();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(1050, 10, 70, 30);
		panelTimKiem.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetAll();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(SanPham.class.getResource("/icon/reset.jpg")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(1130, 5, 40, 40);
		panelTimKiem.add(btnNewButton_1);
		setNhanHieu();
		HienSuDung();
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		DefaultTableCellRenderer rendererRight = new DefaultTableCellRenderer();
		rendererRight.setHorizontalAlignment(SwingConstants.RIGHT);
		table.getColumnModel().getColumn(3).setCellRenderer(rendererRight);
		table.getColumnModel().getColumn(4).setCellRenderer(new CenterAlignRenderer());
	}

	public static String intToMoney(int value) {
		Locale locale = new Locale("vi", "VN");
		Currency currency = Currency.getInstance("VND");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		currencyFormatter.setCurrency(currency);
		return currencyFormatter.format(value);
	}

	public static int moneyToInt(String value) throws ParseException {
		Locale locale = new Locale("vi", "VN");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		Number number = currencyFormatter.parse(value);
		return number.intValue();
	}

	public void resetAll() {
		txtTenSP.setText("Nhập tên Sản Phẩm");
		txtMax.setText("");
		txtMin.setText("");
		comboSLTG.setSelectedItem("SL Tăng");
		layDuLieu();
		setNhanHieu();
	}

	public void layDuLieu() {
		modelSP.setRowCount(0);
		for (SanPhamModel sp : DAO.SanPhamDAO.getAllSanPham()) {
			Object[] row = new Object[] { sp.getId_sp(), sp.getTensp(), sp.getNhanhieu(), intToMoney(sp.getGia()),
					sp.getConlai() };
			modelSP.addRow(row);
		}
	}

	public void TimKiem() {
		ArrayList<SanPhamModel> spLoc = new ArrayList<SanPhamModel>();
		String tenSP = txtTenSP.getText();
		if (tenSP.equals("Nhập tên Sản Phẩm")) {
			tenSP = "";
		}
		String nhanHieu = (String) comboNhanHieu.getSelectedItem();
		if (nhanHieu.equals("Tất cả Nhãn Hiệu")) {
			nhanHieu = "";
		}
		int giaMin = 0;
		if (!txtMin.getText().equals("")) {
			giaMin = Integer.parseInt(txtMin.getText());
		}
		int giaMax = 10000000;
		if (!txtMax.getText().equals("")) {
			giaMax = Integer.parseInt(txtMax.getText());
		}
		if (giaMin > giaMax) {
			return;
		}
		for (SanPhamModel sp : dsSP) {
			if (sp.getTensp().toLowerCase().contains(tenSP.toLowerCase())
					&& sp.getNhanhieu().toLowerCase().contains(nhanHieu.toLowerCase()) && sp.getGia() >= giaMin
					&& sp.getGia() <= giaMax) {
				spLoc.add(sp);
			}
		} // Sắp xếp
		String sltg = (String) comboSLTG.getSelectedItem();

		if (sltg.equals("SL Tăng")) {
			Collections.sort(spLoc, new Comparator<SanPhamModel>() {
				@Override
				public int compare(SanPhamModel s1, SanPhamModel s2) {
					return s1.getConlai() - s2.getConlai();
				}
			});
		} else {
			Collections.sort(spLoc, new Comparator<SanPhamModel>() {
				@Override
				public int compare(SanPhamModel s1, SanPhamModel s2) {
					return s2.getConlai() - s1.getConlai();
				}
			});
		}
		modelSP.setRowCount(0);
		for (SanPhamModel sp : spLoc) {
			Object[] row = new Object[] { sp.getId_sp(), sp.getTensp(), sp.getNhanhieu(), intToMoney(sp.getGia()),
					sp.getConlai() };
			modelSP.addRow(row);
		}
		table.setModel(modelSP);
	}

	public void setNhanHieu() {
		((DefaultComboBoxModel) comboNhanHieu.getModel()).addElement("Tất cả Nhãn Hiệu");
		comboNhanHieu.setSelectedItem("Tất cả Nhãn Hiệu");
		for (model.NhanHieuModel nh : NhanHieuDAO.getAllNhanHieu()) {
			((DefaultComboBoxModel) comboNhanHieu.getModel()).addElement(nh.getTen_nh());
		}
	}

	public void HienSuDung() {
		if (!BUS.PhanQuyenBUS.KTQuyen(nv.getId_nv(), 7)) {
			btnNewButton_2.setEnabled(false);
			btnNewButton_2_1.setEnabled(false);
			btnNewButton_2_2.setEnabled(false);
			table.setEnabled(false);
		}

	}
}
