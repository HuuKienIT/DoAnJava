package giaodien;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import model.KhachHangModel;
import model.NhanVienModel;
import javax.swing.border.TitledBorder;

public class DonHang extends JPanel {
	JPanel panel_1 = new RoundedJPanel(20);
	private JTable table;
	private JTextField txtKhachHang;
	private JTextField txtStart;
	private JTextField txtEnd;

	public DonHang() {
		setBackground(SystemColor.control);
		setLayout(null);

		JPanel panel = new RoundedJPanel(20);
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 1180, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblTmKim = new JLabel("TÌM KIẾM");
		lblTmKim.setBackground(SystemColor.text);
		lblTmKim.setHorizontalAlignment(SwingConstants.CENTER);
		lblTmKim.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 25));
		lblTmKim.setBounds(0, 10, 150, 30);
		panel.add(lblTmKim);

		txtKhachHang = new RoundJTextField(10);
		txtKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtKhachHang.getText().equals("    Nhập tên Khách Hàng")) {
					txtKhachHang.setText("");
				}
			}
		});
		txtKhachHang.setText("    Nhập tên Khách Hàng / Nhân Viên");
		txtKhachHang.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		txtKhachHang.setBounds(200, 5, 300, 40);
		panel.add(txtKhachHang);
		txtKhachHang.setColumns(10);

		txtStart = new RoundJTextField(10);
		txtStart.setEditable(false);
		txtStart.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		txtStart.setColumns(10);
		txtStart.setBounds(618, 10, 120, 30);
		panel.add(txtStart);

		txtEnd = new RoundJTextField(10);
		txtEnd.setEditable(false);
		txtEnd.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		txtEnd.setColumns(10);
		txtEnd.setBounds(838, 10, 120, 30);
		panel.add(txtEnd);

		JLabel lbln = new JLabel("đến");
		lbln.setHorizontalAlignment(SwingConstants.CENTER);
		lbln.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 20));
		lbln.setBackground(Color.WHITE);
		lbln.setBounds(773, 10, 70, 30);
		panel.add(lbln);

		JLabel lblT = new JLabel("Từ");
		lblT.setHorizontalAlignment(SwingConstants.CENTER);
		lblT.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 20));
		lblT.setBackground(Color.WHITE);
		lblT.setBounds(558, 10, 50, 30);
		panel.add(lblT);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final pickdate dp = new pickdate();
				dp.popupShow(dp);
				dp.addPopupListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtStart.setText(dp.getFormattedDate());
						dp.popupHide();
					}
				});
			}
		});
		btnNewButton.setIcon(new ImageIcon(DonHang.class.getResource("/icon/datepick.jpg")));
		btnNewButton.setBounds(743, 10, 30, 30);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final pickdate dp = new pickdate();
				dp.popupShow(dp);
				dp.addPopupListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtEnd.setText(dp.getFormattedDate());
						dp.popupHide();
					}
				});
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(DonHang.class.getResource("/icon/datepick.jpg")));
		btnNewButton_1.setBounds(963, 10, 30, 30);
		panel.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtKhachHang.setText("    Nhập tên Khách Hàng / Nhân Viên");
				txtStart.setText("");
				txtEnd.setText("");
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(DonHang.class.getResource("/icon/reset.jpg")));
		btnNewButton_1_1.setBounds(1131, 10, 30, 30);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Tìm");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1_1.setBounds(1030, 5, 80, 40);
		panel.add(btnNewButton_1_1_1);

		panel_1.setBackground(SystemColor.text);
		panel_1.setBounds(0, 60, 1180, 739);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("DANH SÁCH ĐƠN HÀNG");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
		lblNewLabel.setBounds(0, 20, 1170, 30);
		panel_1.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 70, 1160, 650);
		panel_1.add(scrollPane);

		table = new cusTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Kh\u00E1ch H\u00E0ng",
				"Nh\u00E2n Vi\u00EAn", "Th\u1EDDi Gian", "T\u1ED5ng SL", "T\u1ED5ng Ti\u1EC1n" }));
		layDulieu();
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setMaxWidth(80);
		DefaultTableCellRenderer rendererRight = new DefaultTableCellRenderer();
		rendererRight.setHorizontalAlignment(SwingConstants.RIGHT);
		table.getColumnModel().getColumn(0).setCellRenderer(new CenterAlignRenderer());
		table.getColumnModel().getColumn(3).setCellRenderer(new CenterAlignRenderer());
		table.getColumnModel().getColumn(4).setCellRenderer(new CenterAlignRenderer());
		table.getColumnModel().getColumn(5).setCellRenderer(rendererRight);
		scrollPane.setViewportView(table);

		JButton btnNewButton_2 = new JButton("Xuất Excel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int output = JOptionPane.showConfirmDialog(null, "Bạn có muốn xuất File Excel không?", "",
						JOptionPane.YES_NO_OPTION);
				if (output == JOptionPane.YES_OPTION) {
					try {
						BUS.DonHangBUS.xuatExcel();
						
					} catch (IOException e1) {
						
					}
				}
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(DonHang.class.getResource("/icon/export.jpg")));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(1020, 11, 150, 40);
		panel_1.add(btnNewButton_2);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					new ChiTietDH(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0) + "")).setVisible(true);
				}
			}

		});
	}

	public static int moneyToInt(String value) throws ParseException {
		Locale locale = new Locale("vi", "VN");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		Number number = currencyFormatter.parse(value);
		return number.intValue();
	}

	public void layDulieu() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (model.DonHangModel dh : DAO.DonHangDAO.getAllDonHang()) {
			NhanVienModel nv = DAO.NhanVienDAO.getUsersByID(dh.getId_nv());
			KhachHangModel kh = DAO.KhachHangDAO.getKhachHangByid(dh.getId_kh());
			Object[] row = new Object[] { dh.id_dh, kh.getId_kh() + " - " + kh.getTenkh(),
					nv.getId_nv() + " - " + nv.getHoTen(), dh.getNgayban(), dh.getTongsl(),
					intToMoney(dh.getTongtien()) };
			model.addRow(row);
		}
		table.setModel(model);
	}

	public static String intToMoney(int value) {
		Locale locale = new Locale("vi", "VN");
		Currency currency = Currency.getInstance("VND");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		currencyFormatter.setCurrency(currency);
		return currencyFormatter.format(value);
	}
}
