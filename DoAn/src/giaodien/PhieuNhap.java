package giaodien;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DAO.NhanHieuDAO;
import model.PhieuNhapModel;
import model.KhachHangModel;
import model.NhaCungCapModel;
import model.NhanVienModel;
import model.PhieuNhapModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PhieuNhap extends JPanel {
	private JTable table;
	ArrayList<PhieuNhapModel> dsPN;
	RoundJTextField txtKhachHang = new RoundJTextField(10);
	public PhieuNhap() {
		setBackground(SystemColor.control);
		setLayout(null);
		
		JPanel panel = new RoundedJPanel(20);
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 1180, 50);
		add(panel);
		panel.setLayout(null);
		
		RoundedJPanel panel_2 = new RoundedJPanel(20);
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 0, 1180, 50);
		panel.add(panel_2);
		
		JLabel lblTmKim_1 = new JLabel("TÌM KIẾM");
		lblTmKim_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTmKim_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 25));
		lblTmKim_1.setBackground(Color.WHITE);
		lblTmKim_1.setBounds(0, 10, 150, 30);
		panel_2.add(lblTmKim_1);
		

		txtKhachHang.setText("");
		txtKhachHang.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		txtKhachHang.setColumns(10);
		txtKhachHang.setBounds(300, 10, 250, 30);
		panel_2.add(txtKhachHang);
		
//		RoundJTextField txtStart = new RoundJTextField(10);
//		txtStart.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
//		txtStart.setEditable(false);
//		txtStart.setColumns(10);
//		txtStart.setBounds(618, 10, 120, 30);
//		panel_2.add(txtStart);
//		
//		RoundJTextField txtEnd = new RoundJTextField(10);
//		txtEnd.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
//		txtEnd.setEditable(false);
//		txtEnd.setColumns(10);
//		txtEnd.setBounds(838, 10, 120, 30);
//		panel_2.add(txtEnd);
//		
//		JLabel lbln = new JLabel("đến");
//		lbln.setHorizontalAlignment(SwingConstants.CENTER);
//		lbln.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 20));
//		lbln.setBackground(Color.WHITE);
//		lbln.setBounds(773, 10, 70, 30);
//		panel_2.add(lbln);
//		
//		JLabel lblT = new JLabel("Từ");
//		lblT.setHorizontalAlignment(SwingConstants.CENTER);
//		lblT.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 20));
//		lblT.setBackground(Color.WHITE);
//		lblT.setBounds(558, 10, 50, 30);
//		panel_2.add(lblT);
		
//		JButton btnNewButton = new JButton("");
//		btnNewButton.setIcon(new ImageIcon(PhieuNhap.class.getResource("/icon/datepick.jpg")));
//		btnNewButton.setBounds(743, 10, 30, 30);
//		panel_2.add(btnNewButton);
//		
//		JButton btnNewButton_1 = new JButton("");
//		btnNewButton_1.setIcon(new ImageIcon(PhieuNhap.class.getResource("/icon/datepick.jpg")));
//		btnNewButton_1.setBounds(963, 10, 30, 30);
//		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layDuLieu();
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(PhieuNhap.class.getResource("/icon/reset.jpg")));
		btnNewButton_1_1.setBounds(1131, 5, 40, 40);
		panel_2.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Tìm");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiem();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1_1.setBounds(1030, 5, 80, 40);
		panel_2.add(btnNewButton_1_1_1);
		
		JLabel lblTnNccNv = new JLabel("Tên NCC/ NV");
		lblTnNccNv.setHorizontalAlignment(SwingConstants.CENTER);
		lblTnNccNv.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 20));
		lblTnNccNv.setBackground(Color.WHITE);
		lblTnNccNv.setBounds(150, 10, 150, 30);
		panel_2.add(lblTnNccNv);
		
		JPanel panel_1 = new RoundedJPanel(20);
		panel_1.setBackground(SystemColor.text);
		panel_1.setBounds(0, 60, 1180, 739);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH PHIẾU NHẬP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
		lblNewLabel.setBounds(0, 20, 1170, 30);
		panel_1.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 70, 1160, 650);
		panel_1.add(scrollPane);
		
		table = new cusTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nh\u00E0 Cung C\u1EA5p", "Nh\u00E2n Vi\u00EAn", "Th\u1EDDi Gian", "T\u1ED5ng SL", "T\u1ED5ng Ti\u1EC1n"
			}
		));
		layDuLieu();
		
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
		
		JButton btnNewButton_1_1_1_1 = new JButton("Xuất Excel");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int output = JOptionPane.showConfirmDialog(null, 
                        "Bạn có muốn xuất Excel không?", "",
                        JOptionPane.YES_NO_OPTION);
	 			if(output==JOptionPane.YES_OPTION){  
	 				try {
						BUS.PhieuNhapBUS.xuatExcel();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	 			}
				
			}
		});
		btnNewButton_1_1_1_1.setIcon(new ImageIcon(PhieuNhap.class.getResource("/icon/export.jpg")));
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1_1_1.setBounds(1020, 11, 150, 40);
		panel_1.add(btnNewButton_1_1_1_1);
		

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (e.getClickCount() == 2) {
					 new ChiTietPN(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0)+"")).setVisible(true);
                 }
			}
		});
	}
	public void layDuLieu() {
		this.dsPN=DAO.PhieuNhapDAO.getAllPhieuNhap();
		DefaultTableModel model =(DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for(PhieuNhapModel pn:dsPN) {
			NhanVienModel nv = DAO.NhanVienDAO.getUsersByID(pn.getId_nv());
			NhaCungCapModel ncc = DAO.NhaCungCapDAO.getNCCByID(pn.getId_ncc());
			Object[] row = new Object[] {pn.getId_pn(),ncc.getId_ncc()+" - "+ncc.getTen_ncc(),nv.getId_nv()+" - "+nv.getHoTen(),pn.getNgaynhap(),pn.getTongsl(),intToMoney(pn.getTongtien())} ;
			model.addRow(row);
		}
		table.setModel(model);
	}
	public void TimKiem() {
		DefaultTableModel model =(DefaultTableModel) table.getModel();
		ArrayList<PhieuNhapModel> spLoc = new ArrayList<PhieuNhapModel>();
		String chuoiTim =txtKhachHang.getText();
		DateFormat df = new SimpleDateFormat("yyyy/mm/dd"); 
//		Date startDate =  (Date) df.parse(txtEnd.getText());
//		Date endDate = (Date) df.parse(txtEnd.getText());
		for(PhieuNhapModel u :DAO.PhieuNhapDAO.getAllPhieuNhap()) {
			NhanVienModel nv = DAO.NhanVienDAO.getUsersByID(u.getId_nv());
			NhaCungCapModel ncc = DAO.NhaCungCapDAO.getNCCByID(u.getId_ncc());
			if(ncc.getTen_ncc().toLowerCase().contains(chuoiTim.toLowerCase()) || nv.getHoTen().toLowerCase().contains(chuoiTim.toLowerCase())  ) 
			{
				spLoc.add(u);
			}
		}	
		model.setRowCount(0);
		for(PhieuNhapModel u : spLoc ) {
			NhanVienModel nv = DAO.NhanVienDAO.getUsersByID(u.getId_nv());
			NhaCungCapModel ncc = DAO.NhaCungCapDAO.getNCCByID(u.getId_ncc());
			Object[] row = new Object[] { u.id_pn, ncc.getId_ncc() + " - " + ncc.getTen_ncc(),
					nv.getId_nv() + " - " + nv.getHoTen(), u.getNgaynhap(), u.getTongsl(),
					intToMoney(u.getTongtien()) };
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
