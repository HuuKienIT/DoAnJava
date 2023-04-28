package giaodien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;

import model.SanPhamGHModel;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DAO.SanPhamDAO;
import DAO.KhachHangDAO;
import DAO.NhanVienDAO;
import model.CTDonHangModel;
import model.KhachHangModel;
import model.NhanVienModel;
import model.SanPhamModel;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.ComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class BanHang extends JPanel {
	private JTextField txtSoLuongCT;
	private JTable tableSP;
	public JTable tableGH;
	public DefaultTableModel modelSP = new DefaultTableModel();
	public DefaultTableModel modelGH = new DefaultTableModel();
	
	public ArrayList<SanPhamGHModel> GH = new ArrayList<SanPhamGHModel>();
	public ArrayList<SanPhamModel> sp = DAO.SanPhamDAO.getAllSanPham();
	private JTextField txtKiem;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JTextField textField_2;
	JPanel paneThayDoi = new JPanel();
	JPanel paneGia;
	JComboBox comboLoaiSp = new JComboBox();
	
 	JLabel txtMaSPCT = new JLabel("");
 	JLabel txtNhanHieuCT = new JLabel("");
 	JLabel txtID_KH = new JLabel("");
	JLabel txtTenSPCT = new JLabel("");
	JLabel txtDonGiaCT = new JLabel("");
 	JLabel txtTongTien = new JLabel("0");
 	JLabel txtTongsl = new JLabel("0");
 	
 	private NhanVienModel nv;

	public BanHang(NhanVienModel nv) {
		this.nv=nv;
		
		setForeground(SystemColor.text);
		setBackground(SystemColor.control);
		setLayout(null);
	 	
	 	JPanel panel_2 = new RoundedJPanel(20);
	 	panel_2.setBackground(SystemColor.text);
	 	panel_2.setBounds(790, 10, 400, 497);
	 	add(panel_2);
	 	panel_2.setLayout(null);
	 	
	 	JLabel lblNewLabel_1_4 = new JLabel("Số lượng");
	 	lblNewLabel_1_4.setBounds(15, 160, 73, 40);
	 	panel_2.add(lblNewLabel_1_4);
	 	lblNewLabel_1_4.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	
	 	txtSoLuongCT = new RoundJTextField(15);
	 	txtSoLuongCT.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!((c >= '0') && (c <= '9') ||
		           (c == KeyEvent.VK_BACK_SPACE) ||
		           (c == KeyEvent.VK_DELETE))) {
		          e.consume();
		        }
		      }
		    });
	 	txtSoLuongCT.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
	 	txtSoLuongCT.setText("0");
	 	txtSoLuongCT.setHorizontalAlignment(SwingConstants.CENTER);
	 	txtSoLuongCT.setBounds(133, 165, 50, 30);
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
	 	lblChiTitSn.setBounds(0, 10, 400, 35);
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
	 	btnPlus.setIcon(new ImageIcon(BanHang.class.getResource("/icon/plus.jpg")));
	 	btnPlus.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	btnPlus.setBounds(193, 165, 30, 30); 	
	 	panel_2.add(btnPlus);
	 	
	 	JLabel btnSubtract = new JLabel("");
	 	btnSubtract.addMouseListener(new MouseAdapter() {
	 		@Override
	 		public void mouseClicked(MouseEvent e) {
	 			if(Integer.parseInt(txtSoLuongCT.getText())>0)
	 			txtSoLuongCT.setText(Integer.parseInt(txtSoLuongCT.getText())-1+"");
	 		}
	 	});
	 	btnSubtract.setIcon(new ImageIcon(BanHang.class.getResource("/icon/subtract.jpg")));
	 	btnSubtract.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	btnSubtract.setBounds(93, 165, 30, 30);
	 	panel_2.add(btnSubtract);
	 	
	
	 	txtMaSPCT.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "M\u00E3 SP", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	 	txtMaSPCT.setHorizontalAlignment(SwingConstants.LEFT);
	 	txtMaSPCT.setForeground(Color.RED);
	 	txtMaSPCT.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	txtMaSPCT.setBounds(20, 48, 150, 45);
	 	panel_2.add(txtMaSPCT);
	 	 
	 	txtTenSPCT.setBorder(new TitledBorder(null, "T\u00EAn S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	 	txtTenSPCT.setHorizontalAlignment(SwingConstants.LEFT);
	 	txtTenSPCT.setForeground(Color.RED);
	 	txtTenSPCT.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	txtTenSPCT.setBounds(20, 99, 350, 45);
	 	panel_2.add(txtTenSPCT);
	 	
	 	txtDonGiaCT.setBorder(new TitledBorder(null, "\u0110\u01A1n Gi\u00E1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	 	txtDonGiaCT.setHorizontalAlignment(SwingConstants.LEFT);
	 	txtDonGiaCT.setForeground(Color.RED);
	 	txtDonGiaCT.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	txtDonGiaCT.setBounds(240, 160, 150, 45);
	 	panel_2.add(txtDonGiaCT);
	 	

	 	txtNhanHieuCT.setHorizontalAlignment(SwingConstants.LEFT);
	 	txtNhanHieuCT.setForeground(Color.RED);
	 	txtNhanHieuCT.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	txtNhanHieuCT.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nh\u00E3n Hi\u1EC7u", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	 	txtNhanHieuCT.setBounds(193, 48, 170, 45);
	 	panel_2.add(txtNhanHieuCT);
	 	
	 	JPanel panel_3 = new RoundedJPanel(20);
	 	panel_3.setBackground(SystemColor.text);
	 	panel_3.setBounds(790, 520, 400, 350);
	 	add(panel_3);
	 	panel_3.setLayout(null);
	 	JButton btnXutnHng = new cusButton("Xuất đơn hàng");
	 	btnXutnHng.addActionListener(new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 			if(GH.size()==0) {
					JOptionPane.showMessageDialog(null,"Giỏ Hàng đang trống");
					return;
				}
				if(txtID_KH.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Chưa có thông tin Khách Hàng");
					return;
				}
	 			int output = JOptionPane.showConfirmDialog(null, 
                        "Bạn có muốn xuất đơn hàng không?", "",
                        JOptionPane.YES_NO_OPTION);
	 			if(output==JOptionPane.YES_OPTION){  
	 				XuatDonHang();
	 			}
	 		}
	 	});
	 	btnXutnHng.setBounds(120, 290, 180, 40);
	 	panel_3.add(btnXutnHng);
	 	btnXutnHng.setBackground(SystemColor.text);
	 	btnXutnHng.setIcon(new ImageIcon("E:\\Picrure AT\\iconjava\\pdf.jpg"));
	 	btnXutnHng.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	

	 	txtTongTien.setHorizontalAlignment(SwingConstants.CENTER);
	 	txtTongTien.setBorder(new TitledBorder(null, "T\u1ED5ng Ti\u1EC1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	 	txtTongTien.setForeground(Color.RED);
	 	txtTongTien.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
	 	txtTongTien.setBounds(45, 229, 180, 50);
	 	panel_3.add(txtTongTien);
	 	
	 	JLabel lblNewLabel_1 = new JLabel("THANH TOÁN");
	 	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	 	lblNewLabel_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
	 	lblNewLabel_1.setBounds(0, 10, 400, 30);
	 	panel_3.add(lblNewLabel_1);
	 	

	 	txtTongsl.setHorizontalAlignment(SwingConstants.CENTER);
	 	txtTongsl.setBorder(new TitledBorder(null, "S\u1ED1 L\u01B0\u1EE3ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	 	txtTongsl.setForeground(Color.RED);
	 	txtTongsl.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
	 	txtTongsl.setBounds(259, 229, 100, 50);
	 	panel_3.add(txtTongsl);
	 	
	 	JLabel txtID_NV = new JLabel(nv.id_nv+"");
	 	txtID_NV.setBorder(new TitledBorder(null, "ID Nhân Viên", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	 	txtID_NV.setForeground(Color.BLUE);
	 	txtID_NV.setHorizontalAlignment(SwingConstants.CENTER);
	 	txtID_NV.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	txtID_NV.setBounds(10, 51, 117, 45);
	 	panel_3.add(txtID_NV);
	 	
	 	JLabel txtTenNV = new JLabel(nv.getHoTen());
	 	txtTenNV.setHorizontalAlignment(SwingConstants.CENTER);
	 	txtTenNV.setForeground(Color.BLUE);
	 	txtTenNV.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	txtTenNV.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00EAn Nh\u00E2n Vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	 	txtTenNV.setBounds(159, 51, 200, 45);
	 	panel_3.add(txtTenNV);

	 	txtID_KH.setHorizontalAlignment(SwingConstants.CENTER);
	 	txtID_KH.setForeground(Color.GREEN);
	 	txtID_KH.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	txtID_KH.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "ID Khách Hàng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	 	txtID_KH.setBounds(10, 116, 117, 45);
	 	panel_3.add(txtID_KH);
	 	
	 	JLabel txtTenKH = new JLabel("");
	 	txtTenKH.setHorizontalAlignment(SwingConstants.CENTER);
	 	txtTenKH.setForeground(Color.GREEN);
	 	txtTenKH.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
	 	txtTenKH.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00EAn Kh\u00E1ch H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	 	txtTenKH.setBounds(130, 116, 200, 45);
	 	panel_3.add(txtTenKH);
	 	
	 	JLabel txtTongsl_1 = new JLabel("0\r\n");
	 	txtTongsl_1.setHorizontalAlignment(SwingConstants.CENTER);
	 	txtTongsl_1.setForeground(Color.ORANGE);
	 	txtTongsl_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
	 	txtTongsl_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0110i\u1EC3m T\u00EDch L\u0169y", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	 	txtTongsl_1.setBounds(96, 172, 100, 50);
	 	panel_3.add(txtTongsl_1);
	 	
	 	JButton btnNewButton = new JButton("Chọn");
	 	btnNewButton.addActionListener(new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 			new ChonKhachHang(txtID_KH,txtTenKH).setVisible(true);
	 		}
	 	});
	 	btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
	 	btnNewButton.setBounds(335, 123, 50, 35);
	 	panel_3.add(btnNewButton);

	 	
	 	
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
	 	String[] columnNamesSP = {"Mã SP", "Tên SP", "Đơn giá", "Còn lại"};
       	modelSP.setColumnIdentifiers(columnNamesSP);
       	layDuLieu();
    	for(SanPhamModel sp : sp ) {
       		Object[] row = new Object[] {sp.getMasp(),sp.getTensp(),intToMoney(sp.getGia()),sp.getConlai()} ;
       		modelSP.addRow(row);
       	}
    	tableSP.setModel(modelSP);
    	tableSP.getColumnModel().getColumn(0).setPreferredWidth(100);
    	tableSP.getColumnModel().getColumn(1).setPreferredWidth(300);
    	tableSP.getColumnModel().getColumn(2).setPreferredWidth(200);
    	tableSP.getColumnModel().getColumn(3).setPreferredWidth(100);
    	DefaultTableCellRenderer rendererRight = new DefaultTableCellRenderer();
        rendererRight.setHorizontalAlignment(SwingConstants.RIGHT);
    	tableSP.getColumnModel().getColumn(2).setCellRenderer(rendererRight);
    	tableSP.getColumnModel().getColumn(3).setCellRenderer(new CenterAlignRenderer());
    	
    	tableSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HienChiTiet(tableSP.getValueAt(tableSP.getSelectedRow(), 0)+"");
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
				HienChiTiet(tableGH.getValueAt(tableGH.getSelectedRow(), 0)+"");
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
    	textField_1.addKeyListener(new KeyAdapter() {
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
    	textField_1.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!((c >= '0') && (c <= '9') ||
		           (c == KeyEvent.VK_BACK_SPACE) ||
		           (c == KeyEvent.VK_DELETE))) {
		          e.consume();
		        }
		      }
		    });
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
    	textField_2.addKeyListener(new KeyAdapter() {
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
    	textField_2.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!((c >= '0') && (c <= '9') ||
		           (c == KeyEvent.VK_BACK_SPACE) ||
		           (c == KeyEvent.VK_DELETE))) {
		          e.consume();
		        }
		      }
		    });
    	textField_2.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
    	textField_2.setColumns(10);
    	textField_2.setBounds(240, 0, 166, 29);
    	paneGia.add(textField_2);
    	
    	comboLoaiSp.setBounds(103, 0, 200, 30);
    	comboLoaiSp.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
    	DefaultComboBoxModel LoaiSP = new DefaultComboBoxModel();
    	comboLoaiSp.setModel(LoaiSP);
    	comboLoaiSp.setBackground(Color.WHITE);
    	
    	LoaiSP.addElement("Tất cả Nhãn Hiệu");
    	for(model.NhanHieuModel nh :DAO.NhanHieuDAO.getAllNhanHieu()) {
    		LoaiSP.addElement(nh.getTen_nh());
    	}
    	comboLoaiSp.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			TimKiem();
    		}
    	});
    	DefaultComboBoxModel chon = new DefaultComboBoxModel();
    	chon.addElement("Tên SP");
        chon.addElement("Nhãn Hiệu");
        chon.addElement("Giá");
    	JComboBox comboBox = new JComboBox(chon);
    	comboBox.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
    	comboBox.setBackground(Color.WHITE);
    	comboBox.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			String kq= (String) comboBox.getItemAt(comboBox.getSelectedIndex());
    			paneThayDoi.removeAll();
    			switch(kq) {
    			case"Tên SP":
    				paneThayDoi.add(txtKiem);
    				break;
    			case"Giá":
    				paneThayDoi.add(paneGia);
    				break;
    			case"Nhãn Hiệu":
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
    	txtKiem.addKeyListener(new KeyAdapter() {
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
    	txtKiem.setBounds(84, 0, 231, 30);
    	txtKiem.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
    	txtKiem.setHorizontalAlignment(SwingConstants.LEFT);
    	paneThayDoi.add(txtKiem);
    	txtKiem.setColumns(15);
    	btnThemGio.addActionListener(new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 			ThemGioHang();
	 		}
	 	});
	 	btnXa.addActionListener(new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 			xoaGH(txtMaSPCT.getText());
	 		}
	 	});
	}
	public void reset() {
		txtMaSPCT.setText("");
			txtTenSPCT.setText("");
			txtDonGiaCT.setText("");
			txtSoLuongCT.setText("0");
			lblNewLabel_2.setIcon(null);
			txtNhanHieuCT.setText("");
	}
	public void TinhTongTien() {
		int tongtien=0;
		int tongsl=0;
		for(SanPhamGHModel sp :GH ) {
			tongtien+=sp.getGia()*sp.getSoluong();
			tongsl+=sp.getSoluong();
		}
		txtTongTien.setText(intToMoney(tongtien));
		txtTongsl.setText(tongsl+"");
	}
	public void hienthiGH() {
		modelGH.setRowCount(0);
		for(SanPhamGHModel sp :GH ) {
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
		int co=0;
		for(SanPhamGHModel sp :GH ) {
			if(sp.getMasp().equals(ma_sp)){		
				int output = JOptionPane.showConfirmDialog(null, 
                        "Bạn có muốn xóa không?", "",
                        JOptionPane.YES_NO_OPTION);
	 			if(output==JOptionPane.YES_OPTION){  
	 				GH.remove(sp);
	 				hienthiGH();
	 				TinhTongTien();
	 			}	
				co=1;
				break;
			}
       	}
		if(co==0) {
			
			JOptionPane.showMessageDialog(null,"Sản phẩm không tồn tại trong giỏ hàng");
		}
		
	}
	public void hienhinh(String tenfile) {
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(BanHang.class.getResource("/photo/"+tenfile)).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		lblNewLabel_2.setIcon(imageIcon);
		
	}
	public void ThemGioHang() {
		if(txtMaSPCT.getText().equals("")==false) {
				boolean co=false;
 			for(SanPhamGHModel spc :GH ) {
 				if(spc.getMasp().equals(txtMaSPCT.getText())){
 					co=true;
 					spc.setSoluong(spc.getSoluong()+ Integer.parseInt((txtSoLuongCT.getText())));
 				}
 			}
 			if(!co) {
 				for(SanPhamModel s :sp ) {
 	 				if(s.getMasp().equals(txtMaSPCT.getText())){
 	 					SanPhamGHModel sp = new SanPhamGHModel();
 	 					sp.setId_sp(s.getId_sp());
 	 					sp.setMasp(s.getMasp());
 	 					sp.setTensp(s.getTensp());
 	 					sp.setNhanhieu(s.getNhanhieu());
 	 					sp.setGia(s.getGia());
 			 			sp.setSoluong(Integer.parseInt((txtSoLuongCT.getText())));
 			 			GH.add(sp);
 			 			break;
 	 				}
 	 			}
 			}
 			hienthiGH();
 			TinhTongTien();
 			reset();
 		}	
	}
	public void TimKiem() {
		ArrayList<SanPhamModel> spLoc = new ArrayList<SanPhamModel>();
		String tenSP = txtKiem.getText();
		if(tenSP.equals("Nhập tên Sản Phẩm")) {
			tenSP="";
		}
		String nhanHieu = (String) comboLoaiSp.getSelectedItem();
		if(nhanHieu.equals("Tất cả Nhãn Hiệu")) {
			nhanHieu="";
		}
		int giaMin=0;
		if(!textField_1.getText().equals("")) {
			giaMin=Integer.parseInt(textField_1.getText());
		}
		int giaMax=10000000;
		if(!textField_2.getText().equals("")) {
			giaMax=Integer.parseInt(textField_2.getText());
		}
		if(giaMin>giaMax) {
			return;
		}
		for(SanPhamModel sp :DAO.SanPhamDAO.getAllSanPham()) {
			if(sp.getTensp().toLowerCase().contains(tenSP.toLowerCase())&& sp.getNhanhieu().toLowerCase().contains(nhanHieu.toLowerCase())&&sp.getGia()>=giaMin && sp.getGia()<=giaMax) 
			{
				spLoc.add(sp);
			}
		}	
		modelSP.setRowCount(0);
		for(SanPhamModel sp : spLoc ) {
			Object[] row = new Object[] {sp.getMasp(),sp.getTensp(),intToMoney(sp.getGia()),sp.getConlai()} ;
      		modelSP.addRow(row);
		}
		tableSP.setModel(modelSP);
	}
	public void layDuLieu() {
		for(SanPhamModel s :DAO.SanPhamDAO.getAllSanPham()) {
			sp.add(s);
		}
	}
	public void HienChiTiet(String ma_sp) {
		for(SanPhamModel s: sp) {
			if(s.getMasp().equals(ma_sp)) {
				txtMaSPCT.setText(s.getMasp());
				txtTenSPCT.setText(s.getTensp());
				txtNhanHieuCT.setText(s.getNhanhieu());
				txtDonGiaCT.setText(intToMoney(s.getGia()));
				txtSoLuongCT.setText("1");	
				hienhinh(s.getPhoto());
			}
		}
		
	}

	public void XuatDonHang() {
			model.DonHangModel dh = new model.DonHangModel();
			dh.setId_nv(this.nv.getId_nv());
			dh.setTongsl(Integer.parseInt(txtTongsl.getText()));
			try {
			dh.setTongtien(moneyToInt(txtTongTien.getText()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
			DAO.DonHangDAO.themDonHang(dh);
			for(SanPhamGHModel u : GH ) {
				CTDonHangModel ctdh = new CTDonHangModel();
				ctdh.setId_sp(u.getId_sp());
				ctdh.setSoluong(u.getSoluong());
				ctdh.setGia(u.getGia());
	       		DAO.CTDonHangDAO.themCTDonHang(ctdh);
	       	}
	}
}
