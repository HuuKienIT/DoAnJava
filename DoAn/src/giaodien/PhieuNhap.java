package giaodien;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
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

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PhieuNhap extends JPanel {
	private JTable table;
	public PhieuNhap() {
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
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Nh\u00E0 Cung C\u1EA5p", "Nh\u00E2n Vi\u00EAn", "Th\u1EDDi Gian", "T\u1ED5ng SL", "T\u1ED5ng Ti\u1EC1n"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (e.getClickCount() == 2) {
					 new ChiTietPN().setVisible(true);
                 }
			}
    		
		});
	}
}
