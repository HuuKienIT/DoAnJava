package giaodien;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
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

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DAO.NhanVienDAO;
import model.KhachHangModel;
import model.NhanVienModel;

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
	
	public KhachHang() {
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
		String[] columnNames = {"ID","Mã KH", "Họ Tên", "Số điện thoại", "Điểm"};
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
        
        JLabel lblNewLabel_3_1_1 = new JLabel("Thêm KH");
        lblNewLabel_3_1_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		new ThemKhachHang(0).setVisible(true);
        	}
        });
        lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3_1_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
        lblNewLabel_3_1_1.setBounds(1050, 7, 109, 40);
        panel_2.add(lblNewLabel_3_1_1);
        table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (e.getClickCount() == 2) { // Check if the click count is 2 (double-click)
					 new ThemKhachHang(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0)+"")).setVisible(true);
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
	}
	public void layDuLieu() {
		for(KhachHangModel kh :DAO.KhachHangDAO.getAllKH() ) {
       		Object[] row = new Object[] {kh.getId_kh(),kh.getMakh(),kh.getTenkh(),"0"+kh.getSodth(),kh.getDiemtl()} ;
       		model.addRow(row);
       	}
		table.setModel(model);
	}
	public Object[] timkiem() {
		Object[] row = new Object[] {};
		return row;
	}
}
