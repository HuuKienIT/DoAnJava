package giaodien;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Component;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DAO.NhanVienDAO;
import model.KhachHangModel;
import model.NhanVienModel;
import model.KhachHangModel;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;

public class KhachHang extends JPanel {
	private JTable table;
	public DefaultTableModel model =new DefaultTableModel();
	public JPanel paneGia;
	public JComboBox comboBox = new JComboBox();
	public JComboBox comboLoaiSp = new JComboBox();
	private JTextField txtMax;
	private JTextField txtMin;
	private JTextField textField;
	JButton btnNewButton ;
	JButton btnNhpExcel;
	JButton btnXutExcel;
	NhanVienModel nv;
	public KhachHang(NhanVienModel nv) {
		this.nv=nv;
		setBackground(SystemColor.control);
		setLayout(null);
		
		JPanel panel_1 = new RoundedJPanel(15);
		panel_1.setBackground(SystemColor.text);
		panel_1.setBounds(10, 120, 1180, 749);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDanhSchTi = new JLabel("DANH SÁCH KHÁCH HÀNG");
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
		String[] columnNames = {"ID", "Họ Tên", "Số điện thoại", "Điểm"};
       	model.setColumnIdentifiers(columnNames);
       
       	layDuLieu();
        scrollPane.setViewportView(table);
        
        JPanel panel_2 = new RoundedJPanel(20);
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(10, 10, 1180, 50);
        add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("QUẢN LÝ KHÁCH HÀNG");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
        lblNewLabel.setBounds(80, 5, 300, 40);
        panel_2.add(lblNewLabel);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(KhachHang.class.getResource("/icon/arrow.jpg")));
        lblNewLabel_2.setBounds(20, 5, 50, 40);
        panel_2.add(lblNewLabel_2);
        
        btnNewButton = new JButton("New");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new ThemKhachHang().setVisible(true);;
        	}
        });
        btnNewButton.setIcon(new ImageIcon(KhachHang.class.getResource("/icon/add.jpg")));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton.setBounds(1060, 5, 100, 40);
        panel_2.add(btnNewButton);
        
       btnNhpExcel = new JButton("Nhập Excel");
       btnNhpExcel.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		int output = JOptionPane.showConfirmDialog(null, "Bạn có muốn xuất lấy file mẫu không?", "",
					JOptionPane.YES_NO_OPTION);
			if (output == JOptionPane.YES_OPTION) {
				try {
					BUS.KhachHangBUS.FielExcelMau();;
				} catch (IOException e1) {
				}
			}
			try {
				BUS.KhachHangBUS.nhapExcel();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
       	}
       });
        btnNhpExcel.setIcon(new ImageIcon(KhachHang.class.getResource("/icon/import.jpg")));
        btnNhpExcel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNhpExcel.setBounds(750, 5, 150, 40);
        panel_2.add(btnNhpExcel);
        
       btnXutExcel = new JButton("Xuất Excel");
       btnXutExcel.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		try {
				BUS.KhachHangBUS.xuatExcel();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
       	}
       });
        btnXutExcel.setIcon(new ImageIcon(KhachHang.class.getResource("/icon/export.jpg")));
        btnXutExcel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnXutExcel.setBounds(905, 5, 150, 40);
        panel_2.add(btnXutExcel);
        table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (e.getClickCount() == 2) { // Check if the click count is 2 (double-click)
					 ThemKhachHang tkh = new ThemKhachHang();
					 tkh.setDuLieu(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0)+""));
					 tkh.setVisible(true);
                 }
			}
		});
    	table.getColumnModel().getColumn(0).setCellRenderer(new CenterAlignRenderer());
    	table.getColumnModel().getColumn(2).setCellRenderer(new CenterAlignRenderer());
    	table.getColumnModel().getColumn(3).setCellRenderer(new CenterAlignRenderer());
      
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
		
		JLabel lblNewLabel_1 = new JLabel("Tên / Số ĐT");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(250, 10, 150, 30);
		panelTimKiem.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(413, 10, 300, 30);
		panelTimKiem.add(textField);
		textField.setColumns(10);
		
		JButton btnTm = new JButton("Tìm");
		btnTm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiem();
			}
		});
		btnTm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTm.setBounds(822, 5, 100, 40);
		panelTimKiem.add(btnTm);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layDuLieu();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReset.setBounds(948, 5, 100, 40);
		panelTimKiem.add(btnReset);
//		paneThayDoi.add(txtKiem);
		
		paneGia = new JPanel();
    	paneGia.setBackground(SystemColor.text);
    	paneGia.setBounds(0, 0, 590, 30);
//    	paneThayDoi.add(paneGia);
    	paneGia.setVisible(true);
    	paneGia.setLayout(null);
    	
    	JLabel lblT = new JLabel("Từ");
    	lblT.setHorizontalAlignment(SwingConstants.CENTER);
    	lblT.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
    	lblT.setBounds(0, 0, 20, 30);
    	paneGia.add(lblT);
    	
    	txtMin = new JTextField();
    	txtMin.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
    	txtMin.setColumns(10);
    	txtMin.setBounds(45, 1, 200, 30);
    	paneGia.add(txtMin);
    	
    	JLabel lbln = new JLabel("đến");
    	lbln.setHorizontalAlignment(SwingConstants.CENTER);
    	lbln.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
    	lbln.setBounds(269, 0, 29, 30);
    	paneGia.add(lbln);
    	comboLoaiSp.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
    	
    	comboLoaiSp.setBounds(164, 0, 250, 30);
    	
    	DefaultComboBoxModel chon = new DefaultComboBoxModel();
    	chon.addElement("Ten SP");
        chon.addElement("Loai SP");
        chon.addElement("Gia");
		
		txtMax = new JTextField();
		txtMax.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		txtMax.setColumns(10);
		txtMax.setBounds(338, 1, 200, 29);
		paneGia.add(txtMax);
		HienSuDung();
	}
	public void layDuLieu() {
		model.setRowCount(0);
		for(KhachHangModel kh :DAO.KhachHangDAO.getAllKH() ) {
       		Object[] row = new Object[] {kh.getId_kh(),kh.getTenkh(),kh.getSodth(),kh.getDiemtl()} ;
       		model.addRow(row);
       	}
		table.setModel(model);
	}
	public void TimKiem() {
		ArrayList<KhachHangModel> spLoc = new ArrayList<KhachHangModel>();
		String chuoiTim =textField.getText();
		for(KhachHangModel u :DAO.KhachHangDAO.getAllKH()) {
			if(u.getTenkh().toLowerCase().contains(chuoiTim.toLowerCase()) || String.valueOf(u.getSodth()).contains(chuoiTim) ) 
			{
				spLoc.add(u);
			}
		}	
		model.setRowCount(0);
		for(KhachHangModel u : spLoc ) {
			Object[] row = new Object[] {u.getId_kh(),u.getTenkh(),u.getSodth(),u.getDiemtl()} ;
      		model.addRow(row);
		}
		table.setModel(model);
	}
	public void HienSuDung() {
		if (!BUS.PhanQuyenBUS.KTQuyen(nv.getId_nv(), 10)) {
			btnNhpExcel.setEnabled(false);
			btnXutExcel.setEnabled(false);
			btnNewButton.setEnabled(false);
			table.setEnabled(false);
		}
	}
}
