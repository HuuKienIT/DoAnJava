package giaodien;

import java.util.ArrayList;
import java.util.Currency;

import model.sanPhamGH;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.lang.model.type.NullType;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import DAO.sanPhamDAO;
import DAO.khachHangDAO;
import DAO.nhanVienDAO;
import model.khachHang;
import model.nhanVien;
import model.sanPham;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.ComboBoxModel;

public class banhang extends JPanel {
	private JTextField txtSoLuongCT;
	private JTextField txtSodth;
	private JTable tableSP;
	public JTable tableGH;
	public DefaultTableModel modelSP = new DefaultTableModel();
	public DefaultTableModel modelGH = new DefaultTableModel();
	
	public ArrayList<sanPhamGH> GH = new ArrayList<sanPhamGH>();
	private JTextField txtKiem;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JTextField textField_2;
	JPanel paneThayDoi = new JPanel();
	JPanel paneGia;
	JComboBox comboLoaiSp = new JComboBox();

	public banhang() {
    	
		setForeground(SystemColor.text);
		setBackground(SystemColor.control);
		setLayout(null);
	 	
	 	JPanel panel_2 = new RoundedJPanel(20);
	 	panel_2.setBackground(SystemColor.text);
	 	panel_2.setBounds(790, 10, 400, 497);
	 	add(panel_2);
	 	panel_2.setLayout(null);
	 	
	 	JLabel lblNewLabel_1_3 = new JLabel("Đơn giá:");
	 	lblNewLabel_1_3.setBounds(127, 141, 73, 30);
	 	panel_2.add(lblNewLabel_1_3);
	 	lblNewLabel_1_3.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	
	 	JLabel lblNewLabel_1_4 = new JLabel("Số lượng");
	 	lblNewLabel_1_4.setBounds(46, 192, 73, 30);
	 	panel_2.add(lblNewLabel_1_4);
	 	lblNewLabel_1_4.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	
	 	txtSoLuongCT = new RoundJTextField(15);
	 	txtSoLuongCT.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
	 	txtSoLuongCT.setText("0");
	 	txtSoLuongCT.setHorizontalAlignment(SwingConstants.CENTER);
	 	txtSoLuongCT.setBounds(197, 192, 50, 30);
	 	panel_2.add(txtSoLuongCT);
	 	txtSoLuongCT.setColumns(10);
	 	
	 	JButton btnThemGio = new cusButton("Thêm vào giỏ");
	 	
	 	btnThemGio.setBounds(166, 431, 191, 40);
	 	panel_2.add(btnThemGio);
	 	btnThemGio.setBackground(SystemColor.text);
	 	btnThemGio.setIcon(new ImageIcon("E:\\Picrure AT\\iconjava\\cart.jpg"));
	 	btnThemGio.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	
	 	JButton btnXa = new cusButton("Xóa");

	 	btnXa.setBounds(39, 431, 100, 40);
	 	panel_2.add(btnXa);
	 	btnXa.setBackground(SystemColor.text);
	 	btnXa.setIcon(new ImageIcon("E:\\Picrure AT\\iconjava\\delete.jpg"));
	 	btnXa.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	
	 	JLabel lblChiTitSn = new JLabel("CHI TIẾT SẢN PHẨM");
	 	lblChiTitSn.setHorizontalAlignment(SwingConstants.CENTER);
	 	lblChiTitSn.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 25));
	 	lblChiTitSn.setBounds(0, 20, 400, 35);
	 	panel_2.add(lblChiTitSn);
	 	
	 	lblNewLabel_2 = new JLabel("");
	 	lblNewLabel_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
	 	lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	 	lblNewLabel_2.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
	 	lblNewLabel_2.setBackground(SystemColor.control);
	 	lblNewLabel_2.setBounds(127, 245, 150, 150);
	 	panel_2.add(lblNewLabel_2);
	 	
	 	JLabel btnPlus = new JLabel("\r\n");
	 	btnPlus.addMouseListener(new MouseAdapter() {
	 		@Override
	 		public void mouseClicked(MouseEvent e) {
	 			txtSoLuongCT.setText(Integer.parseInt(txtSoLuongCT.getText())+1+"");
	 		}
	 	});
	 	btnPlus.setIcon(new ImageIcon(banhang.class.getResource("/icon/plus.jpg")));
	 	btnPlus.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	btnPlus.setBounds(260, 192, 30, 30); 	
	 	panel_2.add(btnPlus);
	 	
	 	JLabel btnSubtract = new JLabel("");
	 	btnSubtract.addMouseListener(new MouseAdapter() {
	 		@Override
	 		public void mouseClicked(MouseEvent e) {
	 			if(Integer.parseInt(txtSoLuongCT.getText())>0)
	 			txtSoLuongCT.setText(Integer.parseInt(txtSoLuongCT.getText())-1+"");
	 		}
	 	});
	 	btnSubtract.setIcon(new ImageIcon(banhang.class.getResource("/icon/subtract.jpg")));
	 	btnSubtract.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	btnSubtract.setBounds(152, 192, 30, 30);
	 	panel_2.add(btnSubtract);
	 	
	 	JLabel lblNewLabel_1_3_1_1 = new JLabel("Mã SP:");
	 	lblNewLabel_1_3_1_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	lblNewLabel_1_3_1_1.setBounds(29, 60, 93, 30);
	 	panel_2.add(lblNewLabel_1_3_1_1);
	 	
	 	JLabel lblNewLabel_1_3_1_2 = new JLabel("Tên SP:\r\n");
	 	lblNewLabel_1_3_1_2.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	lblNewLabel_1_3_1_2.setBounds(29, 100, 93, 30);
	 	panel_2.add(lblNewLabel_1_3_1_2);
	 	
	 	JLabel txtMaSPCT = new JLabel("");
	 	txtMaSPCT.setHorizontalAlignment(SwingConstants.LEFT);
	 	txtMaSPCT.setForeground(Color.RED);
	 	txtMaSPCT.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	txtMaSPCT.setBounds(110, 60, 150, 30);
	 	panel_2.add(txtMaSPCT);
	 	
	 	JLabel txtTenSPCT = new JLabel("");
	 	txtTenSPCT.setHorizontalAlignment(SwingConstants.LEFT);
	 	txtTenSPCT.setForeground(Color.RED);
	 	txtTenSPCT.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	txtTenSPCT.setBounds(105, 100, 250, 30);
	 	panel_2.add(txtTenSPCT);
	 	
	 	JLabel txtDonGiaCT = new JLabel("");
	 	txtDonGiaCT.setHorizontalAlignment(SwingConstants.LEFT);
	 	txtDonGiaCT.setForeground(Color.RED);
	 	txtDonGiaCT.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	txtDonGiaCT.setBounds(198, 141, 110, 30);
	 	panel_2.add(txtDonGiaCT);
	 	
	 	JPanel panel_3 = new RoundedJPanel(20);
	 	panel_3.setBackground(SystemColor.text);
	 	panel_3.setBounds(790, 520, 400, 350);
	 	add(panel_3);
	 	panel_3.setLayout(null);
	 	
	 	JLabel lblNewLabel_1_5 = new JLabel("Nhân viên:");
	 	lblNewLabel_1_5.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	lblNewLabel_1_5.setBounds(42, 51, 87, 30);
	 	panel_3.add(lblNewLabel_1_5);
	 	
	 	JLabel lblNewLabel_1_4_1 = new JLabel("SĐT KH");
	 	lblNewLabel_1_4_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	lblNewLabel_1_4_1.setBounds(39, 101, 100, 30);
	 	panel_3.add(lblNewLabel_1_4_1);
	 	
	 	txtSodth = new RoundJTextField(15);
	 	txtSodth.setColumns(10);
	 	txtSodth.setBounds(125, 101, 180, 30);
	 	panel_3.add(txtSodth);
	 	
	 	JButton btnXutnHng = new cusButton("Xuất đơn hàng");
	 	btnXutnHng.addActionListener(new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 			for(sanPhamGH u : GH ) {
	 	       		
	 	       	}
	 		}
	 	});
	 	btnXutnHng.setBounds(127, 298, 180, 40);
	 	panel_3.add(btnXutnHng);
	 	btnXutnHng.setBackground(SystemColor.text);
	 	btnXutnHng.setIcon(new ImageIcon("E:\\Picrure AT\\iconjava\\pdf.jpg"));
	 	btnXutnHng.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	
	 	JLabel lblNewLabel_1_4_1_1 = new JLabel("Tổng tiền:");
	 	lblNewLabel_1_4_1_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
	 	lblNewLabel_1_4_1_1.setBounds(22, 246, 100, 40);
	 	panel_3.add(lblNewLabel_1_4_1_1);
	 	
	 	JLabel txtTongTien = new JLabel("0");
	 	txtTongTien.setForeground(Color.RED);
	 	txtTongTien.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
	 	txtTongTien.setBounds(112, 246, 150, 40);
	 	panel_3.add(txtTongTien);
	 	
	 	JLabel lblNewLabel_1 = new JLabel("THANH TOÁN");
	 	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	 	lblNewLabel_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
	 	lblNewLabel_1.setBounds(0, 10, 400, 30);
	 	panel_3.add(lblNewLabel_1);
	 	
	 	JLabel lblNewLabel_1_4_1_1_2 = new JLabel("Số lượng:");
	 	lblNewLabel_1_4_1_1_2.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
	 	lblNewLabel_1_4_1_1_2.setBounds(260, 246, 80, 40);
	 	panel_3.add(lblNewLabel_1_4_1_1_2);
	 	
	 	JLabel txtTongsl = new JLabel("0\r\n");
	 	txtTongsl.setForeground(Color.RED);
	 	txtTongsl.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
	 	txtTongsl.setBounds(350, 246, 41, 40);
	 	panel_3.add(txtTongsl);
	 	
	 	JLabel lblNewLabel_1_5_1 = new JLabel("NV-001");
	 	lblNewLabel_1_5_1.setForeground(Color.BLUE);
	 	lblNewLabel_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
	 	lblNewLabel_1_5_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	lblNewLabel_1_5_1.setBounds(154, 51, 156, 30);
	 	panel_3.add(lblNewLabel_1_5_1);
	 	
	 	JLabel lblNewLabel_1_4_1_2 = new JLabel("Họ Tên\r\n");
	 	lblNewLabel_1_4_1_2.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	lblNewLabel_1_4_1_2.setBounds(42, 205, 100, 30);
	 	panel_3.add(lblNewLabel_1_4_1_2);
	 	
	 	JLabel lblNewLabel_1_4_1_2_1 = new JLabel("MaKH:");
	 	lblNewLabel_1_4_1_2_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	lblNewLabel_1_4_1_2_1.setBounds(42, 154, 62, 30);
	 	panel_3.add(lblNewLabel_1_4_1_2_1);
	 	
	 	JLabel lblNewLabel_1_4_1_2_1_1 = new JLabel("ĐIểm:");
	 	lblNewLabel_1_4_1_2_1_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	lblNewLabel_1_4_1_2_1_1.setBounds(193, 154, 62, 30);
	 	panel_3.add(lblNewLabel_1_4_1_2_1_1);
	 	
	 	JLabel txtMakh = new JLabel("KH-1");
	 	txtMakh.setHorizontalAlignment(SwingConstants.CENTER);
	 	txtMakh.setForeground(Color.BLUE);
	 	txtMakh.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	txtMakh.setBounds(100, 154, 80, 30);
	 	panel_3.add(txtMakh);
	 	
	 	JLabel txtDiemtl = new JLabel("NV-001");
	 	txtDiemtl.setHorizontalAlignment(SwingConstants.CENTER);
	 	txtDiemtl.setForeground(Color.ORANGE);
	 	txtDiemtl.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	txtDiemtl.setBounds(247, 154, 112, 30);
	 	panel_3.add(txtDiemtl);
	 	
	 	JLabel txtTenkh = new JLabel("Nguyen Van A");
	 	txtTenkh.setHorizontalAlignment(SwingConstants.CENTER);
	 	txtTenkh.setForeground(Color.BLUE);
	 	txtTenkh.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	txtTenkh.setBounds(132, 205, 156, 30);
	 	panel_3.add(txtTenkh);
	 	
	 	JLabel lblNewLabel_1_5_1_1_1 = new JLabel("Mới");
	 	lblNewLabel_1_5_1_1_1.addMouseListener(new MouseAdapter() {
	 		@Override
	 		public void mouseClicked(MouseEvent e) {
	 			new themKhachHang().setVisible(true);
	 		}
	 		public void mouseEntered(MouseEvent e) {
	 			lblNewLabel_1_5_1_1_1.setForeground(Color.BLACK);
	 		}
	 		public void mouseExited(MouseEvent e) {
	 			lblNewLabel_1_5_1_1_1.setForeground(Color.DARK_GRAY);
	 		}
	 	});
	 	lblNewLabel_1_5_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
	 	lblNewLabel_1_5_1_1_1.setForeground(Color.DARK_GRAY);
	 	lblNewLabel_1_5_1_1_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	lblNewLabel_1_5_1_1_1.setBounds(280, 99, 100, 30);
	 	panel_3.add(lblNewLabel_1_5_1_1_1);
	 	
	 	JLabel lblNewLabel_1_5_1_1_1_1 = new JLabel("Tìm");
	 	lblNewLabel_1_5_1_1_1_1.addMouseListener(new MouseAdapter() {
	 		@Override
	 		public void mouseClicked(MouseEvent e) {
	 			int sodth = Integer.parseInt(txtSodth.getText());
	 			JPopupMenu popupMenu = new JPopupMenu();
	 			txtSodth.add(popupMenu);
	 			for(khachHang kh :khachHangDAO.timKiemKH(sodth)) {
	 				txtTenkh.setText(kh.getTenkh());
	 				txtMakh.setText(kh.getMakh());
	 				txtDiemtl.setText(kh.getDiemtl()+"");
	 				popupMenu.add(new JMenuItem(kh.getTenkh()));
	 			}
	 			txtSodth.setComponentPopupMenu(popupMenu);
	 		
	 		}
	 	});
	 	lblNewLabel_1_5_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
	 	lblNewLabel_1_5_1_1_1_1.setForeground(Color.DARK_GRAY);
	 	lblNewLabel_1_5_1_1_1_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	lblNewLabel_1_5_1_1_1_1.setBounds(305, 51, 69, 30);
	 	panel_3.add(lblNewLabel_1_5_1_1_1_1);
	 	
	 	JPanel panel_4 = new RoundedJPanel(20);
	 	panel_4.setBackground(SystemColor.text);
	 	panel_4.setBounds(10, 80, 770, 400);
	 	add(panel_4);
	 	panel_4.setLayout(null);
	 	
	 	JLabel lblNewLabel = new JLabel("DANH SÁCH SẢN PHẨM");
	 	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	 	lblNewLabel.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 25));
	 	lblNewLabel.setBounds(0, 20, 770, 35);
	 	panel_4.add(lblNewLabel);
	 	
	 	JScrollPane scrollPane = new JScrollPane();
	 	scrollPane.setBounds(5, 70, 760, 325);
	 	scrollPane.getViewport().setBackground(Color.WHITE);
	 	scrollPane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	 	JScrollBar cuon = new ScrollBarCustom();
	 	scrollPane.setVerticalScrollBar(cuon);
	 	panel_4.add(scrollPane);
	 	
	 	tableSP = new cusTable();
	 	scrollPane.setViewportView(tableSP);
	 	String[] columnNamesSP = {"Mã SP", "Tên SP", "Đơn giá", "Còn lại",""};
       	modelSP.setColumnIdentifiers(columnNamesSP);
    	for(sanPham sp : sanPhamDAO.getAllSanPham() ) {
       		Object[] row = new Object[] {sp.getMasp(),sp.getTensp(),intToMoney(sp.getGia()),sp.getConlai(),sp.getPhoto()} ;
       		modelSP.addRow(row);
       	}
    	tableSP.setModel(modelSP);
    	tableSP.getColumnModel().getColumn(0).setPreferredWidth(100);
    	tableSP.getColumnModel().getColumn(1).setPreferredWidth(300);
    	tableSP.getColumnModel().getColumn(2).setPreferredWidth(200);
    	tableSP.getColumnModel().getColumn(3).setPreferredWidth(100);
    	tableSP.getColumnModel().getColumn(4).setMinWidth(0);
    	tableSP.getColumnModel().getColumn(4).setMaxWidth(0);
    	tableSP.getColumnModel().getColumn(4).setWidth(0);
    	tableSP.getColumnModel().getColumn(2).setCellRenderer(new CenterAlignRenderer());
    	tableSP.getColumnModel().getColumn(3).setCellRenderer(new CenterAlignRenderer());
    	
    	tableSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMaSPCT.setText(tableSP.getValueAt(tableSP.getSelectedRow(), 0)+"");
				txtTenSPCT.setText(tableSP.getValueAt(tableSP.getSelectedRow(), 1)+"");
				txtDonGiaCT.setText(tableSP.getValueAt(tableSP.getSelectedRow(), 2)+"");
				boolean co=false;
				for(sanPhamGH spc :GH ) {
	 				if(spc.getMasp().equals(txtMaSPCT.getText())){
	 					txtSoLuongCT.setText(spc.getSoluong()+"");	
	 					co=true;
	 				}
	 			}	
				if(!co) {
					txtSoLuongCT.setText("1");	
				}
				hienhinh(tableSP.getValueAt(tableSP.getSelectedRow(), 4)+"");
			}
    		
		});
	 	
	 	JPanel panel_5 = new RoundedJPanel(20);
	 	panel_5.setBackground(SystemColor.text);
	 	panel_5.setBounds(10, 490, 770, 390);
	 	add(panel_5);
	 	panel_5.setLayout(null);
	 	
	 	JLabel lblGiHng = new JLabel("GIỎ HÀNG");
	 	lblGiHng.setBounds(0, 20, 770, 35);
	 	lblGiHng.setHorizontalAlignment(SwingConstants.CENTER);
	 	lblGiHng.setForeground(Color.BLACK);
	 	lblGiHng.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 25));
	 	lblGiHng.setBackground(Color.WHITE);
	 	panel_5.add(lblGiHng);
	 	
	 	JScrollPane scrollPane_1 = new JScrollPane();
	 	scrollPane_1.setBounds(5, 70, 760, 300);
	 	panel_5.add(scrollPane_1);
	 	
	 	tableGH = new cusTable();
	 	((cusTable) tableGH).popUp(1);
	 	scrollPane_1.setViewportView(tableGH);
	 	String[] columnNamesGH = {"Mã SP", "Tên SP", "Đơn giá", "Số lượng"};
       	modelGH.setColumnIdentifiers(columnNamesGH);
       	hienthiGH();
       	tableGH.setModel(modelGH);
       	tableGH.getColumnModel().getColumn(0).setPreferredWidth(100);
    	tableGH.getColumnModel().getColumn(1).setPreferredWidth(300);
    	tableGH.getColumnModel().getColumn(2).setPreferredWidth(200);
    	tableGH.getColumnModel().getColumn(3).setPreferredWidth(100);
    	tableGH.getColumnModel().getColumn(2).setCellRenderer(new CenterAlignRenderer());
    	tableGH.getColumnModel().getColumn(3).setCellRenderer(new CenterAlignRenderer());
       	tableGH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMaSPCT.setText(tableGH.getValueAt(tableGH.getSelectedRow(), 0)+"");
				txtTenSPCT.setText(tableGH.getValueAt(tableGH.getSelectedRow(), 1)+"");
				txtDonGiaCT.setText(tableGH.getValueAt(tableGH.getSelectedRow(), 2)+"");
				txtSoLuongCT.setText(tableGH.getValueAt(tableGH.getSelectedRow(), 3)+"");
				btnXa.enable();
			}
		});
       	
       	
    	JPanel panel = new RoundedJPanel(20);
    	panel.setBackground(Color.WHITE);
    	panel.setBounds(10, 10, 770, 60);
    	add(panel);
    	panel.setLayout(null);
    	
    	
    	paneThayDoi.setAlignmentY(0.0f);
    	paneThayDoi.setAlignmentX(0.0f);
    	paneThayDoi.setBackground(SystemColor.text);
    	paneThayDoi.setBounds(149, 15, 410, 30);
    	panel.add(paneThayDoi);
    	paneThayDoi.setLayout(null);
    	
    	paneGia = new JPanel();
    	paneGia.setBackground(SystemColor.text);
    	paneGia.setBounds(0, 0, 410, 30);
//    	paneThayDoi.add(paneGia);
    	paneGia.setVisible(true);
    	paneGia.setLayout(null);
    	
    	JLabel lblT = new JLabel("Từ");
    	lblT.setHorizontalAlignment(SwingConstants.CENTER);
    	lblT.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
    	lblT.setBounds(0, 0, 20, 30);
    	paneGia.add(lblT);
    	
    	textField_1 = new JTextField();
    	textField_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
    	textField_1.setColumns(10);
    	textField_1.setBounds(30, 0, 166, 30);
    	paneGia.add(textField_1);
    	
    	JLabel lbln = new JLabel("đến");
    	lbln.setHorizontalAlignment(SwingConstants.CENTER);
    	lbln.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
    	lbln.setBounds(200, 0, 29, 30);
    	paneGia.add(lbln);
    	
    	textField_2 = new JTextField();
    	textField_2.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
    	textField_2.setColumns(10);
    	textField_2.setBounds(240, 0, 166, 29);
    	paneGia.add(textField_2);
    	comboLoaiSp.setBounds(103, 0, 200, 30);
    	
    	DefaultComboBoxModel chon = new DefaultComboBoxModel();
    	chon.addElement("Ten SP");
        chon.addElement("Loai SP");
        chon.addElement("Gia");
    	JComboBox comboBox = new JComboBox(chon);
    	comboBox.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
    	comboBox.setBackground(Color.WHITE);
    	comboBox.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			String kq= (String) comboBox.getItemAt(comboBox.getSelectedIndex());
    			paneThayDoi.removeAll();
    			switch(kq) {
    			case"Ten SP":
    				paneThayDoi.add(txtKiem);
    				break;
    			case"Gia":
    				paneThayDoi.add(paneGia);
    				break;
    			case"Loai SP":
    				paneThayDoi.add(comboLoaiSp);
    				break;
    			}
				paneThayDoi.repaint();
				paneThayDoi.validate();
    		}
    	});
    	comboBox.setBounds(580, 15, 150, 30);
    	panel.add(comboBox);
    	
    	JLabel labelTK = new JLabel("Tìm Kiếm");
    	labelTK.setHorizontalAlignment(SwingConstants.CENTER);
    	labelTK.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 23));
    	labelTK.setBounds(0, 15, 150, 30);
    	panel.add(labelTK);
    	
    	txtKiem = new JTextField();
    	txtKiem.setBounds(84, 0, 231, 30);
    	txtKiem.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
    	txtKiem.setHorizontalAlignment(SwingConstants.LEFT);
    	paneThayDoi.add(txtKiem);
    	txtKiem.setColumns(15);
    	btnThemGio.addActionListener(new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 			if(txtMaSPCT.getText().equals("")==false) {
	 				boolean co=false;
		 			for(sanPhamGH spc :GH ) {
		 				if(spc.getMasp().equals(txtMaSPCT.getText())){
		 					spc.setSoluong(Integer.parseInt((txtSoLuongCT.getText())));
		 					co=true;
		 				}
		 			}	
		 			if(!co) {
		 				sanPhamGH sp = new sanPhamGH();
	 		 			sp.setMasp(txtMaSPCT.getText());
	 		 			sp.setTensp(txtTenSPCT.getText());
	 		 			String money =txtDonGiaCT.getText();
	 		 			try {
							sp.setGia(moneyToInt(money));
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	 		 			sp.setSoluong(Integer.parseInt((txtSoLuongCT.getText())));
	 		 			GH.add(sp);
		 			}
		 			hienthiGH();
		 			int tongtien=0;
					int tongsl=0;
					for(sanPhamGH sp :GH ) {
						tongtien+=sp.getGia()*sp.getSoluong();
						tongsl+=sp.getSoluong();
					}
					txtTongTien.setText(intToMoney(tongtien));
					txtTongsl.setText(tongsl+"");
		 			txtMaSPCT.setText("");
		 			txtTenSPCT.setText("");
		 			txtDonGiaCT.setText("");
		 			txtSoLuongCT.setText("0");
		 			lblNewLabel_2.setIcon(null);
		 		}
	 			}
	 	});
	 	btnXa.addActionListener(new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 			 ImageIcon icon = new ImageIcon("E:\\Picrure AT\\iconjava\\hoi.jpg");
	 			int output = JOptionPane.showConfirmDialog(btnXa, 
                        "Bạn có muốn xóa không?", "",
                        JOptionPane.YES_NO_OPTION);
	 			if(output==JOptionPane.YES_OPTION){  
	 				xoaGH(txtMaSPCT.getText());
	 			}	
	 		}
	 	});
	}
	public void reset() {
		
	}
	public void hienthiGH() {
		modelGH.setRowCount(0);
		for(sanPhamGH sp :GH ) {
			Icon aboutIcon = new ImageIcon("E:\\Picrure AT\\iconjava\\pdf.jpg");
       		Object[] row = new Object[] {sp.getMasp(),sp.getTensp(),intToMoney(sp.getGia()),sp.getSoluong()} ;
       		modelGH.addRow(row);
       	}
    	
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
	public void xoaGH(String ma_sp) {
		for(sanPhamGH sp :GH ) {
			if(sp.getMasp().equals(ma_sp)){
				GH.remove(sp);
			}
       	}
		hienthiGH();
	}
	public void hienhinh(String tenfile) {
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(banhang.class.getResource("/photo/"+tenfile)).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		lblNewLabel_2.setIcon(imageIcon);
		
	}
}
