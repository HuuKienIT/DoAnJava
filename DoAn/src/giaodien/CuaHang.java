package giaodien;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;

import model.NhanVienModel;

public class CuaHang extends JPanel {
	
	JLabel lblSanPham = new JLabel("SẢN PHẨM");
	JLabel lblNCC = new JLabel("NHÀ CUNG CẤP");
	JLabel lblNhanHieu = new JLabel("NHÃN HIỆU");
	NhanVienModel nv;
	public CuaHang(NhanVienModel nv) {
		this.nv=nv;
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1200, 40);
		add(panel);
		panel.setLayout(null);
		
		JPanel body = new JPanel();
		body.setBounds(0, 40, 1200, 860);
		add(body);
		body.setLayout(new BorderLayout(0, 0));

		// add panel san pham
		SanPham tsp = new SanPham(nv);
		tsp.setBackground(SystemColor.control);
		tsp.setLayout(null);
		tsp.setVisible(true);
		body.add(tsp);

		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 200, 40);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblSanPham.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		lblSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetLabel();
				lblSanPham.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		        body.removeAll();
		        body.add(new SanPham(nv));
		        body.repaint();
		        body.validate();
		      
			}
		});
		lblSanPham.setHorizontalAlignment(SwingConstants.CENTER);
		lblSanPham.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		lblSanPham.setBounds(0, 0, 200, 40);
		panel_1.add(lblSanPham);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(200, 0, 200, 40);
		panel.add(panel_1_1);
		
		lblNCC.setBounds(0, 0, 200, 40);
		panel_1_1.add(lblNCC);
		lblNCC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetLabel();
				lblNCC.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		        body.removeAll();
		        body.add(new NhaCungCap(nv));
		        body.repaint();
		        body.validate();
		        
			}
		});
		lblNCC.setHorizontalAlignment(SwingConstants.CENTER);
		lblNCC.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setBounds(400, 0, 200, 40);
		panel.add(panel_1_2);
		
		lblNhanHieu.setBounds(0, 0, 200, 40);
		panel_1_2.add(lblNhanHieu);
		lblNhanHieu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetLabel();
				lblNhanHieu.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		        body.removeAll();
		        body.add(new NhanHieu(nv));
		        body.repaint();
		        body.validate();
			}
		});
		lblNhanHieu.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhanHieu.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		
	}
	public void resetLabel() {
		lblSanPham.setBorder(null);
		lblNCC.setBorder(null);
		lblNhanHieu.setBorder(null);
	}
}
