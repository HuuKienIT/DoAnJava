package giaodien;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DAO.sanPhamDAO;
import model.sanPham;
import model.sanPhamGH;

import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class sanpham extends JPanel {
	private JTextField textField;
	private JTextField txtMin;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	public JComboBox comboBox = new JComboBox();
	public JComboBox comboLoaiSp = new JComboBox();
	private JTextField txtMax;
	private JTable table;
	public DefaultTableModel modelSP = new DefaultTableModel();


	public sanpham() {
		setBackground(SystemColor.control);
		setLayout(null);
		
		JPanel panel = new RoundedJPanel(20);
		panel.setBackground(SystemColor.text);
		panel.setBounds(10, 120, 1180, 700);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblDanhSchSn = new JLabel("DANH SÁCH SẢN PHẨM");
		lblDanhSchSn.setBounds(0, 20, 1180, 30);
		panel.add(lblDanhSchSn);
		lblDanhSchSn.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchSn.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
	 	scrollPane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	 	JScrollBar cuon = new ScrollBarCustom();
	 	scrollPane.setVerticalScrollBar(cuon);
		scrollPane.setBounds(10, 60, 1160, 500);
		panel.add(scrollPane);
		

		
		table = new cusTable();
	 	scrollPane.setViewportView(table);
	 	String[] columnNamesSP = {"Mã SP", "Tên SP","Nhãn Hiệu", "Giá nhập","Đơn giá", "Còn lại"};
       	modelSP.setColumnIdentifiers(columnNamesSP);
    	for(sanPham sp : sanPhamDAO.getAllSanPham() ) {
       		Object[] row = new Object[] {sp.getMasp(),sp.getTensp(),sp.getGia(),sp.getGia(),sp.getConlai()} ;
       		modelSP.addRow(row);
       	}
    	table.setModel(modelSP);
    	table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (e.getClickCount() == 2) { // Check if the click count is 2 (double-click)
					 new sanPhamAdd(table.getValueAt(table.getSelectedRow(), 0)+"").setVisible(true);
                 }
				
//				txtMaSPCT.setText(table.getValueAt(table.getSelectedRow(), 0)+"");
//				txtTenSPCT.setText(table.getValueAt(table.getSelectedRow(), 1)+"");
//				txtDonGiaCT.setText(table.getValueAt(table.getSelectedRow(), 3)+"");
//				txtDonViCT.setText(table.getValueAt(table.getSelectedRow(), 2)+"");
//				boolean co=false;
//				for(sanPhamGH spc :GH ) {
//	 				if(spc.getMasp().equals(txtMaSPCT.getText())){
//	 					txtSoLuongCT.setText(spc.getSoluong()+"");	
//	 					co=true;
//	 				}
//	 			}	
//				if(!co) {
//					txtSoLuongCT.setText("1");	
//				}
			}
    		
		});

    	table.getColumnModel().getColumn(0).setPreferredWidth(100);
    	table.getColumnModel().getColumn(1).setPreferredWidth(300);
    	table.getColumnModel().getColumn(2).setPreferredWidth(200);
    	table.getColumnModel().getColumn(3).setPreferredWidth(200);
    	table.getColumnModel().getColumn(4).setPreferredWidth(200);
    	table.getColumnModel().getColumn(5).setPreferredWidth(100);
    	table.getColumnModel().getColumn(3).setCellRenderer(new CenterAlignRenderer());
    	table.getColumnModel().getColumn(4).setCellRenderer(new CenterAlignRenderer());
    	table.getColumnModel().getColumn(5).setCellRenderer(new CenterAlignRenderer());
		
		JPanel panelHeader = new RoundedJPanel(20);
		panelHeader.setBackground(Color.WHITE);
		panelHeader.setBounds(10, 10, 1180, 50);
		add(panelHeader);
		panelHeader.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("QUẢN LÝ SẢN PHẨM");
		lblNewLabel_3.setBounds(80, 5, 261, 40);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
		panelHeader.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setIcon(new ImageIcon("E:\\Picrure AT\\iconjava\\arrow.jpg"));
		lblNewLabel.setBounds(20, 5, 46, 40);
		panelHeader.add(lblNewLabel);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Thêm SP");
		lblNewLabel_3_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new sanPhamAdd().setVisible(true);
			}
		});
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
		lblNewLabel_3_1_1.setBounds(1048, 5, 109, 40);
		panelHeader.add(lblNewLabel_3_1_1);
		
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
		
		JPanel paneThayDoi = new JPanel();
		paneThayDoi.setLayout(null);
		paneThayDoi.setBackground(Color.WHITE);
		paneThayDoi.setAlignmentY(0.0f);
		paneThayDoi.setAlignmentX(0.0f);
		paneThayDoi.setBounds(139, 10, 941, 30);
		panelTimKiem.add(paneThayDoi);
		comboLoaiSp.setLocation(264, 0);
		comboLoaiSp.setSize(200, 30);
		
		paneThayDoi.add(comboLoaiSp);
		
		RoundJTextField txtKiem = new RoundJTextField(20);
		txtKiem.setHorizontalAlignment(SwingConstants.LEFT);
		txtKiem.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		txtKiem.setColumns(15);
		txtKiem.setBounds(10, 0, 239, 30);
		paneThayDoi.add(txtKiem);
		
		txtMax = new JTextField();
		txtMax.setBounds(761, 0, 152, 29);
		paneThayDoi.add(txtMax);
		txtMax.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		txtMax.setColumns(10);
		
		JLabel lbln = new JLabel("đến");
		lbln.setBounds(710, 0, 40, 30);
		paneThayDoi.add(lbln);
		lbln.setHorizontalAlignment(SwingConstants.CENTER);
		lbln.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		
		txtMin = new JTextField();
		txtMin.setBounds(559, 0, 141, 30);
		paneThayDoi.add(txtMin);
		txtMin.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		txtMin.setColumns(10);
		
		JLabel lblT = new JLabel("Giá từ");
		lblT.setBounds(490, 0, 65, 30);
		paneThayDoi.add(lblT);
		lblT.setHorizontalAlignment(SwingConstants.CENTER);
		lblT.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Tìm");
		lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1.setBounds(1061, 5, 109, 40);
		panelTimKiem.add(lblNewLabel_3_1_1_1);
		
	}
}
