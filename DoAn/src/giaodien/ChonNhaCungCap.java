package giaodien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DAO.NhanVienDAO;
import model.KhachHangModel;
import model.NhaCungCapModel;
import model.NhanVienModel;

import javax.swing.border.EtchedBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChonNhaCungCap extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	DefaultTableModel model =new DefaultTableModel();
	JLabel txtTenKH ;
	JLabel txtMaKH ;
	JLabel txtID_KH;
	public ChonNhaCungCap(JLabel txtID_KH,JLabel TenKH) {
		setBounds(100, 100, 936, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 10, 900, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00EAn Nh\u00E0 Cung C\u1EA5p / S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(200, 5, 300, 40);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiem();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(647, 8, 89, 35);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Tìm Kiếm");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(20, 10, 150, 30);
		panel.add(lblNewLabel);
		
		JButton btnNew = new JButton("New");
		btnNew.setIcon(new ImageIcon(ChonNhaCungCap.class.getResource("/icon/add.jpg")));
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNew.setBounds(750, 8, 120, 35);
		panel.add(btnNew);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 70, 900, 400);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 880, 379);
		panel_1.add(scrollPane);
		table = new cusTable();	

		String[] columnNames = {"ID", "Tên NCC" , "Số Điện Thoại", "Email"};
       	model.setColumnIdentifiers(columnNames);
       	layDuLieu();
       	table.setModel(model);
       	table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (e.getClickCount() == 2) { // Check if the click count is 2 (double-click)
					 txtID_KH.setText(table.getValueAt(table.getSelectedRow(), 0)+"");
					 TenKH.setText(table.getValueAt(table.getSelectedRow(), 2)+"");
					 dispose();
                 }
			}
		});
		scrollPane.setViewportView(table);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		scrollPane.getViewport().setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		
	}
	public void layDuLieu() {
		model.setRowCount(0);
		for(NhaCungCapModel ncc :DAO.NhaCungCapDAO.getAllNCC() ) {
       		Object[] row = new Object[] {ncc.getId_ncc(),ncc.getTen_ncc(),ncc.getSDT(),ncc.getEmail()} ;
       		model.addRow(row);
       	}
		table.setModel(model);
	}
	public void TimKiem() {
		ArrayList<NhaCungCapModel> spLoc = new ArrayList<NhaCungCapModel>();
		String chuoiTim =textField.getText();
		for(NhaCungCapModel u :DAO.NhaCungCapDAO.getAllNCC()) {
			if(u.getTen_ncc().toLowerCase().contains(chuoiTim.toLowerCase()) || String.valueOf(u.getSDT()).contains(chuoiTim) ) 
			{
				spLoc.add(u);
			}
		}	
		model.setRowCount(0);
		for(NhaCungCapModel ncc : spLoc ) {
			Object[] row = new Object[] {ncc.getId_ncc(),ncc.getTen_ncc(),ncc.getSDT(),ncc.getEmail()} ;
      		model.addRow(row);
		}
		table.setModel(model);
	}

}
