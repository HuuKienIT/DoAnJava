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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import model.CTDonHangModel;
import model.KhachHangModel;

import java.awt.Window.Type;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import javax.swing.border.TitledBorder;

public class ChiTietDH extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private int id_dh;
	JLabel txtTongTien = new JLabel();
	JLabel txtTongSL = new JLabel();

	public ChiTietDH(int id_dh) {
		this.id_dh=id_dh;
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
		
		JLabel lblNewLabel = new JLabel("CHI TIẾT ĐƠN HÀNG");
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
			},
			new String[] {
				"STT", "S\u1EA3n Ph\u1EA9m", "\u0110\u01A1n Gi\u00E1", "S\u1ED1 L\u01B0\u1EE3ng", "Th\u00E0nh Ti\u1EC1n"
			}
		));
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(3).setMaxWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		DefaultTableCellRenderer rendererRight = new DefaultTableCellRenderer();
        rendererRight.setHorizontalAlignment(SwingConstants.RIGHT);
        table.getColumnModel().getColumn(0).setCellRenderer(new CenterAlignRenderer());
        table.getColumnModel().getColumn(2).setCellRenderer(rendererRight);
        table.getColumnModel().getColumn(3).setCellRenderer(new CenterAlignRenderer());
        table.getColumnModel().getColumn(4).setCellRenderer(rendererRight);

		scrollPane.setViewportView(table);
		
		
		txtTongSL.setBorder(new TitledBorder(null, "T\u1ED5ng S\u1ED1 l\u01B0\u1EE3ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtTongSL.setForeground(Color.RED);
		txtTongSL.setHorizontalAlignment(SwingConstants.CENTER);
		txtTongSL.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
		txtTongSL.setBounds(576, 380, 100, 50);
		panel.add(txtTongSL);
		
		
		txtTongTien.setBorder(new TitledBorder(null, "T\u1ED5ng Ti\u1EC1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtTongTien.setForeground(Color.RED);
		txtTongTien.setHorizontalAlignment(SwingConstants.CENTER);
		txtTongTien.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
		txtTongTien.setBounds(700, 380, 150, 50);
		panel.add(txtTongTien);
		layDuLieu();
	}
	public void layDuLieu() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int stt=1;
		int tongtien=0;int tongsl=0;
		for(CTDonHangModel ctdh: DAO.CTDonHangDAO.getCTDonHangByID(this.id_dh) ) {
       		Object[] row = new Object[] {stt++,DAO.SanPhamDAO.getTenSanPhamByIdSP(ctdh.getId_sp()),intToMoney(ctdh.getGia()),ctdh.getSoluong(),intToMoney(ctdh.getSoluong()*ctdh.getGia())} ;
       		model.addRow(row);
       		tongtien+=ctdh.getSoluong()*ctdh.getGia();
       		tongsl+=ctdh.getSoluong();
       	}
		txtTongTien.setText(intToMoney(tongtien));
		txtTongSL.setText(tongsl+"");
		table.setModel(model);
	}
	public static String intToMoney(int value) {
	    Locale locale = new Locale("vi", "VN");
	    Currency currency = Currency.getInstance("VND");
	    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
	    currencyFormatter.setCurrency(currency);
	    return currencyFormatter.format(value);
	}

}
