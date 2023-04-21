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

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DAO.nhanVienDAO;
import model.KhachHangModel;
import model.NhanVienModel;

import javax.swing.border.EtchedBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ChonKhachHang extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	DefaultTableModel model =new DefaultTableModel();
	JLabel txtTenKH ;
	JLabel txtMaKH ;
	JLabel txtID_KH;
	public ChonKhachHang(JLabel txtID_KH,JLabel MaKH,JLabel TenKH) {
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
		textField.setBorder(new TitledBorder(null, "T\u00EAn Kh\u00E1ch H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(230, 5, 200, 40);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textField_1.setBounds(473, 5, 200, 40);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(704, 10, 89, 30);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Tìm Kiếm");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(20, 10, 150, 30);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 70, 900, 400);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 880, 379);
		panel_1.add(scrollPane);
		table = new cusTable();	

		String[] columnNames = {"ID","Mã KH", "Họ Tên",  "Số Điện Thoại","Điểm"};
       	model.setColumnIdentifiers(columnNames);
       	layDuLieu();
       	table.setModel(model);
       	table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (e.getClickCount() == 2) { // Check if the click count is 2 (double-click)
					 txtID_KH.setText(table.getValueAt(table.getSelectedRow(), 0)+"");
					 MaKH.setText(table.getValueAt(table.getSelectedRow(), 1)+"");
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
		for(KhachHangModel kh :DAO.khachHangDAO.getAllKH() ) {
       		Object[] row = new Object[] {kh.getId_kh(),kh.getMakh(),kh.getTenkh(),"0"+kh.getSodth(),kh.getDiemtl()} ;
       		model.addRow(row);
       	}
		table.setModel(model);
	}
 
}
