package giaodien;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


import DAO.NhanVienDAO;
import model.NhanVienModel;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class NhanVien extends JPanel {
	private JTable table;
	public DefaultTableModel model =new DefaultTableModel();
	public JPanel paneGia;
	public JComboBox comboBox = new JComboBox();
	public JComboBox comboLoaiSp = new JComboBox();
	private JTextField txtMax;
	private JTextField txtMin;
	public ArrayList<NhanVienModel> dsNV = NhanVienDAO.getAllUsers();
	
	public NhanVien() {
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
		String[] columnNames = {"ID", "Họ Tên", "Email", "Số Điện Thoại","Chức Vụ"};
       	model.setColumnIdentifiers(columnNames);
       	layDuLieu();
        table.setModel(model);
        	table.getColumnModel().getColumn(0).setMaxWidth(70);
        	table.getColumnModel().getColumn(1).setPreferredWidth(100);
        	table.getColumnModel().getColumn(2).setPreferredWidth(100);
        	table.getColumnModel().getColumn(3).setPreferredWidth(100);
        	//table.getColumnModel().getColumn(4).setPreferredWidth(100);
        	table.getColumnModel().getColumn(0).setCellRenderer(new CenterAlignRenderer());
        	table.getColumnModel().getColumn(4).setCellRenderer(new CenterAlignRenderer());

        scrollPane.setViewportView(table);
        
        JPanel panel_2 = new RoundedJPanel(20);
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(10, 10, 1180, 50);
        add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("QUẢN LÝ NHÂN VIÊN");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
        lblNewLabel.setBounds(80, 5, 300, 40);
        panel_2.add(lblNewLabel);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(NhanVien.class.getResource("/icon/arrow.jpg")));
        lblNewLabel_2.setBounds(20, 5, 50, 40);
        panel_2.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3_1_1 = new JLabel("Thêm NV");
        lblNewLabel_3_1_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		new NhanVienAdd(0).setVisible(true);;
        	}
        });
        lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3_1_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
        lblNewLabel_3_1_1.setBounds(1050, 5, 109, 40);
        panel_2.add(lblNewLabel_3_1_1);
        table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (e.getClickCount() == 2) { // Check if the click count is 2 (double-click)
					 new NhanVienAdd((int) table.getValueAt(table.getSelectedRow(), 0)).setVisible(true);
                 }
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
//		paneThayDoi.add(txtKiem);
		
		
		
	}
	public void hienthi() {
		model.setRowCount(0);
		for(NhanVienModel u : NhanVienDAO.getAllUsers() ) {
       		String rows[] = new String[5];
       		rows[0] = u.getId_nv()+"";
       		rows[1] = u.getHoTen();
       		rows[2] = u.getEmail();
       		rows[2] = u.getMatKhau();
       		rows[4] = u.getChucVu();
     	   model.addRow(rows);
        }
	}
	public void layDuLieu() {
       	for( NhanVienModel u : dsNV) {
       		Object[] row = new Object[] {u.getId_nv(),u.getHoTen(),u.getEmail(),"0"+u.getSoDth(),u.getChucVu()} ;
       		model.addRow(row);
       	}
       	table.setModel(model);
	}
	public void TimKiem() {
		ArrayList<NhanVienModel> spLoc = new ArrayList<NhanVienModel>();
//		String tenSP = txtKiem.getText();
//		if(tenSP.equals("Nhập tên Sản Phẩm")) {
//			tenSP="";
//		}
//		String nhanHieu = (String) comboLoaiSp.getSelectedItem();
//		if(nhanHieu.equals("Tất cả Nhãn Hiệu")) {
//			nhanHieu="";
//		}
//		int giaMin=0;
//		if(!textField_1.getText().equals("")) {
//			giaMin=Integer.parseInt(textField_1.getText());
//		}
//		int giaMax=10000000;
//		if(!textField_2.getText().equals("")) {
//			giaMax=Integer.parseInt(textField_2.getText());
//		}
//		if(giaMin>giaMax) {
//			return;
//		}
//		for(NhanVienModel sp :DAO.sanPhamDAO.getAllSanPham()) {
//			if(sp.getTensp().toLowerCase().contains(tenSP.toLowerCase())&& sp.getNhanhieu().toLowerCase().contains(nhanHieu.toLowerCase())&&sp.getGia()>=giaMin && sp.getGia()<=giaMax) 
//			{
//				spLoc.add(sp);
//			}
//		}	
//		modelSP.setRowCount(0);
//		for(NhanVienModel sp : spLoc ) {
//			Object[] row = new Object[] {sp.getMasp(),sp.getTensp(),intToMoney(sp.getGia()),sp.getConlai()} ;
//      		modelSP.addRow(row);
//		}
//		tableSP.setModel(modelSP);
	}
}
