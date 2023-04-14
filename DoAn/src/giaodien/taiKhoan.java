package giaodien;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Component;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DAO.nhanVienDAO;
import model.nhanVien;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;

public class taiKhoan extends JPanel {
	private JTable table;
	public DefaultTableModel model =new DefaultTableModel();
	public JPanel paneGia;
	public JComboBox comboBox = new JComboBox();
	public JComboBox comboLoaiSp = new JComboBox();
	public JTextField txtKiem = new RoundJTextField(20);
	private JTextField txtMax;
	private JTextField txtMin;
	
	public taiKhoan() {
		setBackground(SystemColor.control);
		setLayout(null);
		
		JPanel panel_1 = new RoundedJPanel(15);
		panel_1.setBackground(SystemColor.text);
		panel_1.setBounds(10, 120, 1180, 749);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDanhSchTi = new JLabel("DANH SÁCH TÀI KHOẢN");
		lblDanhSchTi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchTi.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 25));
		lblDanhSchTi.setBounds(0, 20, 1140, 40);
		panel_1.add(lblDanhSchTi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1, 80, 1178, 658);
		panel_1.add(scrollPane);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		scrollPane.getViewport().setBackground(Color.WHITE);
		
		table = new cusTable();	
		String[] columnNames = {"Mã NV", "Ho Ten", "Email", "Mat Khau", "Chuc Vu"};
       	model.setColumnIdentifiers(columnNames);
       	for(nhanVien u : nhanVienDAO.getAllUsers() ) {
       		Object[] row = new Object[] {u.getManv()+"",u.getHoTen(),u.getEmail(),u.getMatKhau(),u.getChucVu()} ;
       		model.addRow(row);
       	}
//       	hienthi();

        table.setModel(model);
//        if(model.getRowCount()>0) {
//        	table.getColumnModel().getColumn(0).setPreferredWidth(80);
//    		table.getColumnModel().getColumn(0).setMinWidth(80);
//    		table.getColumnModel().getColumn(0).setMaxWidth(80);
//    		table.getColumnModel().getColumn(4).setPreferredWidth(200);
//    		table.getColumnModel().getColumn(4).setMinWidth(200);
//    		table.getColumnModel().getColumn(4).setMaxWidth(200);
//        }	
        scrollPane.setViewportView(table);
        
        JPanel panel_2 = new RoundedJPanel(20);
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(10, 10, 1180, 50);
        add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("QUẢN LÝ TÀI KHOẢN");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
        lblNewLabel.setBounds(60, 5, 300, 40);
        panel_2.add(lblNewLabel);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("E:\\Picrure AT\\iconjava\\arrow.jpg"));
        lblNewLabel_2.setBounds(20, 5, 50, 40);
        panel_2.add(lblNewLabel_2);
        table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (e.getClickCount() == 2) { // Check if the click count is 2 (double-click)
					 new taiKhoanAdd(table.getValueAt(table.getSelectedRow(), 0)+"").setVisible(true);
                 }
				
//				txtID.setText(table.getValueAt(table.getSelectedRow(), 0)+"");
//				txtHoTen.setText(table.getValueAt(table.getSelectedRow(), 1)+"");
//				txtNamSinh.setText(table.getValueAt(table.getSelectedRow(), 3)+"");
//				txtSodth.setText(table.getValueAt(table.getSelectedRow(), 4)+"");
//				txtEmail.setText(table.getValueAt(table.getSelectedRow(), 2)+"");
//				txtID.disable();
			}
		});
        
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
		paneThayDoi.setBounds(170, 10, 600, 30);
		panelTimKiem.add(paneThayDoi);
		
		
		txtKiem.setHorizontalAlignment(SwingConstants.LEFT);
		txtKiem.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		txtKiem.setColumns(15);
		txtKiem.setBounds(143, 0, 300, 30);
//		paneThayDoi.add(txtKiem);
		
		paneGia = new JPanel();
    	paneGia.setBackground(SystemColor.text);
    	paneGia.setBounds(0, 0, 590, 30);
//    	paneThayDoi.add(paneGia);
    	paneGia.setVisible(true);
    	paneGia.setLayout(null);
    	
    	JLabel lblT = new JLabel("Từ");
    	lblT.setHorizontalAlignment(SwingConstants.CENTER);
    	lblT.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
    	lblT.setBounds(0, 0, 20, 30);
    	paneGia.add(lblT);
    	
    	txtMin = new JTextField();
    	txtMin.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
    	txtMin.setColumns(10);
    	txtMin.setBounds(45, 1, 200, 30);
    	paneGia.add(txtMin);
    	
    	JLabel lbln = new JLabel("đến");
    	lbln.setHorizontalAlignment(SwingConstants.CENTER);
    	lbln.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
    	lbln.setBounds(269, 0, 29, 30);
    	paneGia.add(lbln);
    	comboLoaiSp.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
    	
    	comboLoaiSp.setBounds(164, 0, 250, 30);
    	
    	DefaultComboBoxModel chon = new DefaultComboBoxModel();
    	chon.addElement("Ten SP");
        chon.addElement("Loai SP");
        chon.addElement("Gia");
        
		comboBox = new JComboBox(chon);
		comboBox.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(788, 11, 150, 30);
		panelTimKiem.add(comboBox);
		paneThayDoi.add(txtKiem);
		
		txtMax = new JTextField();
		txtMax.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		txtMax.setColumns(10);
		txtMax.setBounds(338, 1, 200, 29);
		paneGia.add(txtMax);
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
    			System.out.println("Doi");
				paneThayDoi.repaint();
				paneThayDoi.validate();
    		}
    	});
		
	}
	public void hienthi() {
		model.setRowCount(0);
		for(nhanVien u : nhanVienDAO.getAllUsers() ) {
       		String rows[] = new String[5];
       		rows[0] = u.getId_Tk()+"";
       		rows[1] = u.getHoTen();
       		rows[2] = u.getEmail();
       		rows[2] = u.getMatKhau();
       		rows[4] = u.getChucVu();
           	System.out.println(u.getHoTen());
     	   model.addRow(rows);
        }
	
	}
	public Object[] timkiem() {
		Object[] row = new Object[] {};
		return row;
	}
}
