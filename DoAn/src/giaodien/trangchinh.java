package giaodien;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.SystemColor;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;

import model.nhanVien;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class trangchinh extends JFrame {

	public nhanVien nv;
	private JPanel contentPane;
	Container container = getContentPane();
	JPanel panel_BH = new RoundedJPanel(10);
	JPanel panel_SP = new RoundedJPanel(10);
	JPanel panel_DH = new RoundedJPanel(10);
	JPanel panel_TK = new RoundedJPanel(10);
	JPanel panel_TKE = new RoundedJPanel(10);
	JLabel txtAvatar;
	JLabel txtTenNv;
	JPanel content;
	RoundedJPanel panel_NH = new RoundedJPanel(10);
	public void setLayout() {
		container.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
	}
	public trangchinh(nhanVien nv) {
		this.nv=nv;
		getContentPane().setLayout(new CardLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		getContentPane().add(panel, "name_1983022305675100");
		panel.setLayout(null);
		
		this.setUndecorated(true);
		this.setShape(new RoundRectangle2D.Double(0, 0, 1509,939, 50, 50));	
        this.setTitle("Quản lý Siêu thị mini");
        this.setVisible(true);
        this.setBounds(10, 10, 1510, 940);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
       	
		JPanel navMenu = new JPanel();
		navMenu.setFocusCycleRoot(true);
		navMenu.setInheritsPopupMenu(true);
		navMenu.setIgnoreRepaint(true);
		navMenu.setForeground(SystemColor.text);
		navMenu.setBackground(new Color(65, 105, 225));
		navMenu.setBounds(0, 50, 300, 930);
		panel.add(navMenu);
		navMenu.setLayout(null);
		
		content = new JPanel();
		content.setBackground(Color.YELLOW);
		content.setBounds(300, 50, 1220, 930);	
		panel.add(content);
		content.setLayout(new BorderLayout(0, 0));
			
		JPanel banHang = new JPanel();
		banHang.setBackground(Color.RED);
		banHang.setBounds(300, 0, 1200, 930);
		banHang.setVisible(false);
		content.add(banHang);
		
		JPanel timkiem = new JPanel();
		timkiem.setBackground(Color.BLUE);
		timkiem.setBounds(0,0,1200,930);
		timkiem.setLayout(null);
		timkiem.setVisible(false);
		content.add(timkiem);
		//Panel banhang
		
		banhang bh = new banhang();
		bh.setVisible(true);
		content.add(bh);
		
		txtTenNv = new JLabel("Tên NV");
		txtTenNv.setForeground(Color.WHITE);
		txtTenNv.setHorizontalAlignment(SwingConstants.CENTER);
		txtTenNv.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 23));
		txtTenNv.setBounds(0, 220, 300, 30);
		navMenu.add(txtTenNv);
		
		panel_BH.setBackground(Color.WHITE);
		panel_BH.setBounds(10, 290, 270, 50);
		navMenu.add(panel_BH);
		panel_BH.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   Bán Hàng");
		lblNewLabel.setIcon(new ImageIcon(trangchinh.class.getResource("/icon/banhang.jpg")));
		lblNewLabel.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 24));
		lblNewLabel.setBounds(50, 0, 185, 50);
		panel_BH.add(lblNewLabel);
		

		panel_SP.setLayout(null);
		panel_SP.setBackground(Color.WHITE);
		panel_SP.setBounds(10, 360, 270, 50);
		navMenu.add(panel_SP);
		panel_BH.setBackground(new Color(87, 197, 182));
			
		JLabel lblSnPhm = new JLabel("   Sản Phẩm");
		lblSnPhm.setIcon(new ImageIcon(trangchinh.class.getResource("/icon/sanpham.jpg")));
		lblSnPhm.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 24));
		lblSnPhm.setBounds(50, 0, 185, 50);
		panel_SP.add(lblSnPhm);
		
		panel_DH.setLayout(null);
		panel_DH.setBackground(Color.WHITE);
		panel_DH.setBounds(10, 430, 270, 50);
		navMenu.add(panel_DH);

		JLabel lblnHng = new JLabel("   Đơn Hàng");
		lblnHng.setIcon(new ImageIcon(trangchinh.class.getResource("/icon/donhang.jpg")));
		lblnHng.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 24));
		lblnHng.setBounds(50, 0, 185, 50);
		panel_DH.add(lblnHng);

		panel_TK.setLayout(null);
		panel_TK.setBackground(Color.WHITE);
		panel_TK.setBounds(10, 500, 270, 50);
		navMenu.add(panel_TK);

		JLabel lblTiKhon = new JLabel("   Tài Khoản");
		lblTiKhon.setIcon(new ImageIcon(trangchinh.class.getResource("/icon/users.jpg")));
		lblTiKhon.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 24));
		lblTiKhon.setBounds(50, 0, 185, 50);
		panel_TK.add(lblTiKhon);
		
		panel_TKE.setLayout(null);
		panel_TKE.setBackground(Color.WHITE);
		panel_TKE.setBounds(10, 570, 270, 50);
		navMenu.add(panel_TKE);

		JLabel lblThngK = new JLabel("   Thống Kê");
		lblThngK.setIcon(new ImageIcon(trangchinh.class.getResource("/icon/thongke.jpg")));
		lblThngK.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 24));
		lblThngK.setBounds(50, 0, 185, 50);
		panel_TKE.add(lblThngK);
		
		JPanel panel_2 = new RoundedJPanel(25);
		panel_2.setBounds(73, 60, 150, 150);
		navMenu.add(panel_2);
		
		txtAvatar = new JLabel("");
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBackground(Color.WHITE);
		JMenuItem chitiet = new JMenuItem("   Chi Tiết");
		chitiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProfileEdit(nv).setVisible(true);
			}
		});
		chitiet.setIcon(new ImageIcon(trangchinh.class.getResource("/icon/user-detail.jpg")));
		chitiet.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
		JMenuItem dangxuat = new JMenuItem("   Đăng Xuất");
		dangxuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int output = JOptionPane.showConfirmDialog(contentPane, 
	                        "Bạn có muốn đăng xuất không", "",
	                        JOptionPane.YES_NO_OPTION);
	                if (output == JOptionPane.YES_OPTION) {
	                    new Login().setVisible(true);
	                    dispose();
	                } 
			}
		});
		dangxuat.setIcon(new ImageIcon(trangchinh.class.getResource("/icon/logout.jpg")));
		dangxuat.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
		popupMenu.add(chitiet);
		popupMenu.add(dangxuat);
		txtAvatar.setComponentPopupMenu(popupMenu);
		panel_2.add(txtAvatar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(10, 38, 71));
		panel_1.setBounds(0, 0, 1520, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setIcon(new ImageIcon(trangchinh.class.getResource("/icon/close1.jpg")));
			}
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setIcon(new ImageIcon(trangchinh.class.getResource("/icon/close.jpg")));
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(trangchinh.class.getResource("/icon/close.jpg")));
		lblNewLabel_1.setBounds(1450, 0, 50, 50);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setIcon(new ImageIcon(trangchinh.class.getResource("/icon/minimize1.jpg")));
			}
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setIcon(new ImageIcon(trangchinh.class.getResource("/icon/minimize.jpg")));
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(trangchinh.class.getResource("/icon/minimize.jpg")));
		lblNewLabel_2.setBounds(1405, 0, 50, 50);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("MINISHOP");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(0, 10, 1510, 30);
		panel_1.add(lblNewLabel_3);
		panel_BH.setLocation(20, 290);
		navMenu.add(panel_NH);
		doiPanel();
		hienUser();
		
	}
	public void setMacDinh() {
		panel_SP.setBackground(Color.WHITE);
		panel_BH.setBackground(Color.WHITE);
		panel_DH.setBackground(Color.WHITE);
		panel_TK.setBackground(Color.WHITE);
		panel_TKE.setBackground(Color.WHITE);
		panel_NH.setBackground(Color.WHITE);
		
		
		panel_BH.setLocation(10, 290);
		panel_SP.setLocation(10, 360);
		panel_DH.setLocation(10, 430);
		panel_TK.setLocation(10, 500);
		panel_TKE.setLocation(10, 570);
		panel_NH.setLocation(10, 640);
		
	}
	public void doiPanel() {
		panel_NH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setMacDinh();
				panel_NH.setBackground(new Color(87, 197, 182));
				panel_NH.setLocation(20, 640);
				banhang bh = new banhang();
				bh.setVisible(true);
				content.removeAll();
				content.add(bh);
				content.repaint();
				content.validate();
			}
		});
		panel_NH.setLayout(null);
		panel_NH.setBackground(Color.WHITE);
		panel_NH.setBounds(10, 637, 270, 50);
		
		
		JLabel labelnh = new JLabel("   Nhập Hàng");
		labelnh.setIcon(new ImageIcon(trangchinh.class.getResource("/icon/nhaphang.jpg")));
		labelnh.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 24));
		labelnh.setBounds(50, 0, 200, 50);
		panel_NH.add(labelnh);
        //set su kien
        panel_BH.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setMacDinh();
				panel_BH.setBackground(new Color(87, 197, 182));
				panel_BH.setLocation(20, 290);
				NhapHang nh = new NhapHang();
				nh.setVisible(true);
				content.removeAll();
				content.add(nh);
				content.repaint();
				content.validate();
				
			}
		});
        panel_SP.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setMacDinh();
				panel_SP.setBackground(new Color(87, 197, 182));
				panel_SP.setLocation(20, 360);
				cuaHang ch = new cuaHang();
				ch.setVisible(true);
				content.removeAll();
				content.add(ch);
				content.repaint();
				content.validate();
			}
		});
        panel_DH.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setMacDinh();
				panel_DH.setBackground(new Color(87, 197, 182));
				panel_DH.setLocation(20, 430);
				donHang dhne = new donHang();
				dhne.setVisible(true);
				content.removeAll();
				content.add(dhne);
				content.repaint();
				content.validate();
				
			}
		});
        panel_TK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setMacDinh();
				panel_TK.setBackground(new Color(87, 197, 182));
				panel_TK.setLocation(20,500);
				taiKhoan taik = new taiKhoan();
				taik.setVisible(true);
				content.removeAll();
				content.add(taik);
				content.validate();
				content.repaint();
			
			}
		});
        panel_TKE.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setMacDinh();
				panel_TKE.setBackground(new Color(87, 197, 182));
				panel_TKE.setLocation(20, 570);
				thongke tke = new thongke();
				tke.setVisible(true);
				content.removeAll();
				content.add(tke);
				content.repaint();
				content.validate();
				
			}
		});	
	}
	public void hienhinh(String tenfile) {
	 	BufferedImage originalImage = null;
	 	if(tenfile.equals("")) {
	 		txtAvatar.setIcon(null);
	 	}else {
	 		try {
	            InputStream inputStream = banhang.class.getResourceAsStream("/photo/"+tenfile);
				originalImage = ImageIO.read(inputStream);
				Image resizedImage = originalImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		        ImageIcon icon = new ImageIcon(resizedImage);
			 	txtAvatar.setIcon(icon);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
	 	}
	}

	public void hienUser() {
		txtTenNv.setText(nv.getHoTen());
		hienhinh(nv.getPhoto());
	}
}
