package giaodien;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JToolBar;
import java.awt.Choice;
import java.awt.Panel;
import javax.swing.border.MatteBorder;
import java.awt.BorderLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ThongKe extends JPanel {

	JPanel panel = new RoundedJPanel(50);
	JLabel lblTongQuan = new JLabel("TỔNG QUAN");
	JLabel lblDonHang = new JLabel("ĐƠN HÀNG");
	JLabel lblPhieuNhap = new JLabel("PHIẾU NHẬP");
	JLabel lblSanPham = new JLabel("SẢN PHẨM");
	public ThongKe() {
		setBackground(SystemColor.control);
		setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(10, 10, 1180, 50);
		add(panel_7);
		panel_7.setLayout(null);
		lblTongQuan.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		lblTongQuan.setBackground(Color.WHITE);
		

		lblTongQuan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetLabel();
				lblTongQuan.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
				panel.removeAll();
				panel.add(new TongQuan());
				panel.revalidate();
				panel.repaint();
			}
		});
		
		lblTongQuan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongQuan.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblTongQuan.setBounds(0, 0, 200, 50);
		panel_7.add(lblTongQuan);
		

		lblDonHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetLabel();
				lblDonHang.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
				panel.removeAll();
				panel.add(new DonHang());
				panel.revalidate();
				panel.repaint();
			}
		});
		lblDonHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonHang.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblDonHang.setBounds(211, 0, 200, 50);
		panel_7.add(lblDonHang);
		

		lblPhieuNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetLabel();
				lblPhieuNhap.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
				panel.removeAll();
				panel.add(new PhieuNhap());
				panel.revalidate();
				panel.repaint();
			}
		});
		lblPhieuNhap.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhieuNhap.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblPhieuNhap.setBounds(421, 0, 200, 50);
		panel_7.add(lblPhieuNhap);
		
		
		
		lblSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetLabel();
				lblSanPham.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
				panel.removeAll();
				panel.add(new ThongKeSanPham());
				panel.revalidate();
				panel.repaint();
			}
		});
		lblSanPham.setHorizontalAlignment(SwingConstants.CENTER);
		lblSanPham.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblSanPham.setBounds(622, 0, 200, 50);
		panel_7.add(lblSanPham);
		

		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 70, 1180, 810);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		TongQuan TQ = new TongQuan();
		panel.add(TQ);
	}
	public void resetLabel() {
		lblTongQuan.setBorder(null);
		lblDonHang.setBorder(null);
		lblPhieuNhap.setBorder(null);
		lblSanPham.setBorder(null);
	}
}
