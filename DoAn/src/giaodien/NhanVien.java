package giaodien;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.io.IOException;
import java.util.ArrayList;


import DAO.NhanVienDAO;
import giaodien.PhanQuyen.Item;
import model.ChucVuModel;
import model.NhanVienModel;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NhanVien extends JPanel {
	public class Item {
	    private String name;
	    private int value;

	    public Item(String name, int value) {
	        this.name = name;
	        this.value = value;
	    }

	    @Override
	    public String toString() {
	        return name;
	    }

	    public int getValue() {
	        return value;
	    }
	}
	private JTable table;
	public DefaultTableModel model =new DefaultTableModel();
	public JPanel paneGia;
	private JTextField txtMax;
	private JTextField txtMin;
	public ArrayList<NhanVienModel> dsNV = NhanVienDAO.getAllUsers();
	private JTextField textField;
	JButton btnNhpExcel;
	JButton btnNewButton;
	JButton btnXutExcel;
	NhanVienModel nvn;
	public NhanVien(NhanVienModel nvn) {
		this.nvn=nvn;
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
        
        btnNewButton = new JButton("New");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new NhanVienAdd().setVisible(true);
        	}
        });
        btnNewButton.setIcon(new ImageIcon(NhanVien.class.getResource("/icon/add.jpg")));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton.setBounds(1060, 5, 100, 40);
        panel_2.add(btnNewButton);
        
        btnNhpExcel = new JButton("Nhập Excel");
        btnNhpExcel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int output = JOptionPane.showConfirmDialog(null, "Bạn có muốn xuất lấy file mẫu không?", "",
						JOptionPane.YES_NO_OPTION);
				if (output == JOptionPane.YES_OPTION) {
					try {
						BUS.NhanVienBUS.FielExcelMau();
					} catch (IOException e1) {
					}
				}
				try {
					BUS.NhanVienBUS.nhapExcel();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        btnNhpExcel.setIcon(new ImageIcon(NhanVien.class.getResource("/icon/import.jpg")));
        btnNhpExcel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNhpExcel.setBounds(745, 5, 150, 40);
        panel_2.add(btnNhpExcel);
        
        btnXutExcel = new JButton("Xuất Excel");
        btnXutExcel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					BUS.NhanVienBUS.xuatExcel();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        btnXutExcel.setIcon(new ImageIcon(NhanVien.class.getResource("/icon/export.jpg")));
        btnXutExcel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnXutExcel.setBounds(905, 5, 150, 40);
        panel_2.add(btnXutExcel);
        table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (e.getClickCount() == 2) { // Check if the click count is 2 (double-click)
					 NhanVienAdd nva = new NhanVienAdd();
					 nva.setDuLieu((int) table.getValueAt(table.getSelectedRow(), 0));
					 nva.setVisible(true);
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
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(430, 10, 350, 30);
		panelTimKiem.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tên / Email / Số ĐT ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(174, 10, 250, 30);
		panelTimKiem.add(lblNewLabel_1);
		
		JButton btnTm = new JButton("Tìm");
		btnTm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiem();
			}
		});
		btnTm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTm.setBounds(900, 5, 100, 40);
		panelTimKiem.add(btnTm);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layDuLieu();
				textField.setText("");
			}
		});
		btnReset.setIcon(new ImageIcon(NhanVien.class.getResource("/icon/reset.jpg")));
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReset.setBounds(1028, 5, 120, 40);
		panelTimKiem.add(btnReset);
		HienSuDung();	
	}

	public void layDuLieu() {
		model.setRowCount(0);
       	for( NhanVienModel u : dsNV) {
       		Object[] row = new Object[] {u.getId_nv(),u.getHoTen(),u.getEmail(),"0"+u.getSoDth(),u.getChucVu()} ;
       		model.addRow(row);
       	}
       	table.setModel(model);
	}
	public void TimKiem() {
		ArrayList<NhanVienModel> spLoc = new ArrayList<NhanVienModel>();
		String chuoiTim =textField.getText();
		for(NhanVienModel u :DAO.NhanVienDAO.getAllUsers()) {
			if(u.getHoTen().toLowerCase().contains(chuoiTim.toLowerCase()) || String.valueOf("+"+u.getSoDth()).contains(chuoiTim) || u.getEmail().toLowerCase().contains(chuoiTim.toLowerCase())  ) 
			{
				spLoc.add(u);
			}
		}	
		model.setRowCount(0);
		for(NhanVienModel u : spLoc ) {
			Object[] row = new Object[] {u.getId_nv(),u.getHoTen(),u.getEmail(),"0"+u.getSoDth(),u.getChucVu()} ;
      		model.addRow(row);
		}
		table.setModel(model);
	}
	public void HienSuDung() {
		if (!BUS.PhanQuyenBUS.KTQuyen(nvn.getId_nv(), 10)) {
			btnNhpExcel.setEnabled(false);
			btnXutExcel.setEnabled(false);
			btnNewButton.setEnabled(false);
			table.setEnabled(false);
		}
	}
}
