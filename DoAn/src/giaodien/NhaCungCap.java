package giaodien;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import model.NhaCungCapModel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NhaCungCap extends JPanel {
	private JTextField textField_1;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();

	public NhaCungCap() {
		setBackground(SystemColor.control);
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.text);
		panel_1.setBounds(10, 131, 1180, 700);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDanhSchLoi = new JLabel("DANH SÁCH NHÀ CUNG CẤP\r\n");
		lblDanhSchLoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchLoi.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblDanhSchLoi.setBackground(new Color(173, 255, 47));
		lblDanhSchLoi.setBounds(0, 20, 1140, 40);
		panel_1.add(lblDanhSchLoi);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 10, 1180, 50);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ NHÀ CUNG CẤP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
		lblNewLabel.setBackground(new Color(173, 255, 47));
		lblNewLabel.setBounds(80, 5, 330, 40);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(NhaCungCap.class.getResource("/icon/arrow.jpg")));
		lblNewLabel_2.setBounds(20, 5, 46, 40);
		panel_2.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NhaCungCapAdd().setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(NhaCungCap.class.getResource("/icon/add.jpg")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(1060, 5, 100, 40);
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 70, 1180, 50);
		add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("TÌM KIẾM");
		lblNewLabel_1_1.setBounds(24, 11, 100, 30);
		panel_3.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		
		textField_1 = new RoundJTextField(15);
		textField_1.setBounds(200, 10, 256, 30);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("ID/Tên");
		lblNewLabel_1_2.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(124, 10, 78, 30);
		panel_3.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Tìm");
		lblNewLabel_1_2_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(479, 11, 78, 30);
		panel_3.add(lblNewLabel_1_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBounds(140, 80, 900, 500);
		panel_1.add(scrollPane);
		
		table = new cusTable();
	 	scrollPane.setViewportView(table);
	 	String[] columnNamesGH = {"ID",  "Tên Nhà cung cấp"};
       	model.setColumnIdentifiers(columnNamesGH);
       	layDuLieu();
       	if(model !=null) {
       		table.getColumnModel().getColumn(0).setPreferredWidth(100);
        	table.getColumnModel().getColumn(1).setPreferredWidth(300);
        	table.getColumnModel().getColumn(0).setCellRenderer(new CenterAlignRenderer());
       	}
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (e.getClickCount() == 2) { // Check if the click count is 2 (double-click)
					 NhaCungCapAdd ncc =new NhaCungCapAdd();
					 ncc.setDuLieu(table.getValueAt(table.getSelectedRow(), 0)+"",table.getValueAt(table.getSelectedRow(), 1)+"");
					 ncc.setVisible(true);
					 
                 }
			}
		});

	}
	public void layDuLieu() {
		for(NhaCungCapModel ncc :DAO.NhaCungCapDAO.getAllNCC() ) {
       		Object[] row = new Object[] {ncc.getId_ncc(),ncc.getTen_ncc()} ;
       		model.addRow(row);
       	}
		table.setModel(model);
	}
}
