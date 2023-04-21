package giaodien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Window.Type;

public class ChiTietPN extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public ChiTietPN() {
		setType(Type.UTILITY);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 10, 865, 440);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH SẢN PHẨM PHIẾU NHẬP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
		lblNewLabel.setBounds(0, 10, 865, 30);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 845, 306);
		panel.add(scrollPane);
		
		table = new cusTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"STT", "S\u1EA3n Ph\u1EA9m", "\u0110\u01A1n Gi\u00E1", "S\u1ED1 L\u01B0\u1EE3ng", "Th\u00E0nh Ti\u1EC1n"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(37);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		scrollPane.setViewportView(table);
		
		JLabel lblTng = new JLabel("Tổng: ");
		lblTng.setHorizontalAlignment(SwingConstants.CENTER);
		lblTng.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
		lblTng.setBounds(410, 399, 100, 30);
		panel.add(lblTng);
		
		JLabel txtTongSL = new JLabel("\r\n5");
		txtTongSL.setForeground(Color.RED);
		txtTongSL.setHorizontalAlignment(SwingConstants.CENTER);
		txtTongSL.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
		txtTongSL.setBounds(554, 399, 100, 30);
		panel.add(txtTongSL);
		
		JLabel txtTongTien = new JLabel("100k\r\n");
		txtTongTien.setForeground(Color.RED);
		txtTongTien.setHorizontalAlignment(SwingConstants.CENTER);
		txtTongTien.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
		txtTongTien.setBounds(717, 399, 100, 30);
		panel.add(txtTongTien);
	}

}
