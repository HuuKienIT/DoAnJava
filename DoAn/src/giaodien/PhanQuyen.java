package giaodien;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.SystemColor;

import DAO.nhanVienDAO;
import model.NhanVienModel;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;

public class PhanQuyen extends JPanel {
	public DefaultTableModel model =new DefaultTableModel();
	public JPanel paneGia;
	public JComboBox comboBox = new JComboBox();
	public JComboBox comboLoaiSp = new JComboBox();
	private JTextField txtMax;
	private JTextField txtMin;
	
	public PhanQuyen() {
		setBackground(SystemColor.control);
		setLayout(null);
		
		JPanel panel_1 = new RoundedJPanel(15);
		panel_1.setBackground(SystemColor.text);
		panel_1.setBounds(10, 71, 1180, 749);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDanhSchTi = new JLabel("DANH SÁCH QUYỀN");
		lblDanhSchTi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchTi.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
		lblDanhSchTi.setBounds(0, 20, 1140, 40);
		panel_1.add(lblDanhSchTi);
		
		JLabel lblBnHng = new JLabel("Bán Hàng");
		lblBnHng.setHorizontalAlignment(SwingConstants.LEFT);
		lblBnHng.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblBnHng.setBounds(209, 91, 157, 40);
		panel_1.add(lblBnHng);
		
		JLabel lblNhpHng = new JLabel("Nhập Hàng");
		lblNhpHng.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhpHng.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNhpHng.setBounds(209, 201, 157, 40);
		panel_1.add(lblNhpHng);
		
		JLabel lblTiKhon = new JLabel("Nhân Viên");
		lblTiKhon.setHorizontalAlignment(SwingConstants.LEFT);
		lblTiKhon.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblTiKhon.setBounds(209, 323, 157, 40);
		panel_1.add(lblTiKhon);
		
		JLabel lblNhnHiu = new JLabel("Nhãn Hiệu");
		lblNhnHiu.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhnHiu.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNhnHiu.setBounds(209, 465, 157, 40);
		panel_1.add(lblNhnHiu);
		
		JLabel lblThngK = new JLabel("Thống Kê");
		lblThngK.setHorizontalAlignment(SwingConstants.LEFT);
		lblThngK.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblThngK.setBounds(747, 91, 157, 40);
		panel_1.add(lblThngK);
		
		JLabel lblSnPhm = new JLabel("Sản Phẩm");
		lblSnPhm.setHorizontalAlignment(SwingConstants.LEFT);
		lblSnPhm.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblSnPhm.setBounds(747, 323, 157, 40);
		panel_1.add(lblSnPhm);
		
		JLabel lblNhCungCp = new JLabel("Nhà Cung Cấp");
		lblNhCungCp.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhCungCp.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNhCungCp.setBounds(747, 464, 157, 40);
		panel_1.add(lblNhCungCp);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Thao Tác");
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		chckbxNewCheckBox.setBounds(238, 138, 114, 23);
		panel_1.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNhp = new JCheckBox("Thao Tác");
		chckbxNhp.setBackground(Color.WHITE);
		chckbxNhp.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		chckbxNhp.setBounds(238, 248, 114, 23);
		panel_1.add(chckbxNhp);
		
		JCheckBox chckbxXem = new JCheckBox("Xem");
		chckbxXem.setBackground(Color.WHITE);
		chckbxXem.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		chckbxXem.setBounds(238, 362, 114, 23);
		panel_1.add(chckbxXem);
		
		JCheckBox chckbxSa = new JCheckBox("Thao Tác");
		chckbxSa.setBackground(Color.WHITE);
		chckbxSa.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		chckbxSa.setBounds(238, 403, 114, 23);
		panel_1.add(chckbxSa);
		
		JCheckBox chckbxXem_1 = new JCheckBox("Xem");
		chckbxXem_1.setBackground(Color.WHITE);
		chckbxXem_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		chckbxXem_1.setBounds(238, 513, 114, 23);
		panel_1.add(chckbxXem_1);
		
		JCheckBox chckbxSa_1 = new JCheckBox("Thao Tác\r\n");
		chckbxSa_1.setBackground(Color.WHITE);
		chckbxSa_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		chckbxSa_1.setBounds(238, 554, 114, 23);
		panel_1.add(chckbxSa_1);
		
		JCheckBox chckbxXem_2 = new JCheckBox("Xem");
		chckbxXem_2.setBackground(Color.WHITE);
		chckbxXem_2.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		chckbxXem_2.setBounds(778, 364, 114, 23);
		panel_1.add(chckbxXem_2);
		
		JCheckBox chckbxSa_2 = new JCheckBox("Thao Tác");
		chckbxSa_2.setBackground(Color.WHITE);
		chckbxSa_2.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		chckbxSa_2.setBounds(778, 405, 114, 23);
		panel_1.add(chckbxSa_2);
		
		JCheckBox chckbxXem_3 = new JCheckBox("Xem");
		chckbxXem_3.setBackground(Color.WHITE);
		chckbxXem_3.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		chckbxXem_3.setBounds(778, 138, 114, 23);
		panel_1.add(chckbxXem_3);
		
		JCheckBox chckbxXem_2_1 = new JCheckBox("Xem");
		chckbxXem_2_1.setBackground(Color.WHITE);
		chckbxXem_2_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		chckbxXem_2_1.setBounds(778, 520, 114, 23);
		panel_1.add(chckbxXem_2_1);
		
		JCheckBox chckbxSa_2_1 = new JCheckBox("Thao Tác");
		chckbxSa_2_1.setBackground(Color.WHITE);
		chckbxSa_2_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		chckbxSa_2_1.setBounds(778, 561, 114, 23);
		panel_1.add(chckbxSa_2_1);
		
		JLabel lblPhnQuyn = new JLabel("Phân Quyền");
		lblPhnQuyn.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhnQuyn.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblPhnQuyn.setBounds(747, 201, 157, 40);
		panel_1.add(lblPhnQuyn);
		
		JCheckBox chckbxXem_3_1 = new JCheckBox("Thao Tác");
		chckbxXem_3_1.setBackground(Color.WHITE);
		chckbxXem_3_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		chckbxXem_3_1.setBounds(778, 248, 114, 23);
		panel_1.add(chckbxXem_3_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 180, 1080, 4);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(50, 300, 1080, 4);
		panel_1.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(50, 450, 1080, 4);
		panel_1.add(separator_2);
		String[] columnNames = {"Mã NV", "Ho Ten", "Email", "Mat Khau", "Chuc Vu"};
       	model.setColumnIdentifiers(columnNames);
       	for(NhanVienModel u : nhanVienDAO.getAllUsers() ) {
       		Object[] row = new Object[] {u.getId_nv(),u.getHoTen(),u.getEmail(),u.getMatKhau(),u.getChucVu()} ;
       		model.addRow(row);
       	}
        
        JPanel panel_2 = new RoundedJPanel(20);
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(10, 10, 1180, 50);
        add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("PHÂN QUYỀN");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
        lblNewLabel.setBounds(60, 5, 300, 40);
        panel_2.add(lblNewLabel);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("E:\\Picrure AT\\iconjava\\arrow.jpg"));
        lblNewLabel_2.setBounds(20, 5, 50, 40);
        panel_2.add(lblNewLabel_2);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
        comboBox_1.setBounds(420, 10, 300, 30);
        panel_2.add(comboBox_1);
        
        JLabel lblThmNhmQuyn = new JLabel("Thêm Nhóm Quyền");
        lblThmNhmQuyn.setHorizontalAlignment(SwingConstants.LEFT);
        lblThmNhmQuyn.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
        lblThmNhmQuyn.setBounds(939, 5, 241, 40);
        panel_2.add(lblThmNhmQuyn);
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
		
		txtMax = new JTextField();
		txtMax.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		txtMax.setColumns(10);
		txtMax.setBounds(338, 1, 200, 29);
		paneGia.add(txtMax);
		
	}
	public void hienthi() {
		model.setRowCount(0);
		for(NhanVienModel u : nhanVienDAO.getAllUsers() ) {
       		String rows[] = new String[5];
       		rows[0] = u.getId_nv()+"";
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
