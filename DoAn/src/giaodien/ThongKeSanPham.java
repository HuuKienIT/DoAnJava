package giaodien;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import giaodien.PhanQuyen.Item;
import model.SanPhamModel;

public class ThongKeSanPham extends JPanel {
	cusTable table;
	DefaultTableModel model =new DefaultTableModel();
	public ThongKeSanPham() {
		setLayout(null);
		JPanel panel_5 = new RoundedJPanel(20);
		panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBackground(SystemColor.text);
		panel_5.setBounds(0, 400, 1180, 400);
		add(panel_5);
		panel_5.setLayout(null);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(BanHang.class.getResource("/icon/sanpham.jpg")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(BanHang.class.getResource("/icon/users.jpg")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(BanHang.class.getResource("/icon/nhanvien.jpg")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		ImageIcon imageIcon3 = new ImageIcon(new ImageIcon(BanHang.class.getResource("/icon/cash.jpg")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(230, 5, 1, 1);
		add(panel_7);
		panel_7.setLayout(null);
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		int TongSL =DAO.SanPhamDAO.demTongSoLuong();
		ArrayList<model.NhanHieuModel> dsNH = DAO.NhanHieuDAO.getAllNhanHieu();
		for(model.NhanHieuModel nh :dsNH) {
//			if(DAO.sanPhamDAO.demSanPhamByNhanHieu(nh.getTen_nh())!=0) {
				dataset.setValue(nh.getTen_nh(), DAO.SanPhamDAO.demSanPhamByNhanHieu(nh.getTen_nh())*100/TongSL);
//			}
		}

        JFreeChart chart = ChartFactory.createPieChart("TỈ LỆ SẢN PHẨM ĐÃ BÁN THEO NHÃN HIỆU", dataset, true, true, true);

        // Tuỳ chỉnh biểu đồ
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setCircular(true);
        plot.setLabelGap(0.02);
        plot.setLabelBackgroundPaint(new Color(220, 220, 220));
        plot.setLabelFont(plot.getLabelFont().deriveFont(14f));
        plot.setSimpleLabels(true);

        // Hiển thị biểu đồ trong JFrame
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(Color.WHITE);
        chartPanel.setSize(1140, 350);
        chartPanel.setLocation(20, 20);
        chartPanel.setPreferredSize(new Dimension(500, 500));
        panel_5.add(chartPanel);
        
        RoundedJPanel panel_5_1 = new RoundedJPanel(20);
        panel_5_1.setLayout(null);
        panel_5_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_5_1.setBackground(Color.WHITE);
        panel_5_1.setBounds(0, 0, 1180, 400);
        add(panel_5_1);
        
        JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBounds(10, 30, 1160, 350);
		panel_5_1.add(scrollPane);

		table = new cusTable();
		scrollPane.setViewportView(table);
		String[] columnNamesGH = { "ID SP", "Tên Sản Phẩm", "Nhãn Hiệu","Giá", "Còn Lại","Đã Bán" };
		model.setColumnIdentifiers(columnNamesGH);
		table.setModel(model);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(0).setCellRenderer(new CenterAlignRenderer());
		table.getColumnModel().getColumn(1).setCellRenderer(new CenterAlignRenderer());
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {				
		});
		hienthi();
    	table.getColumnModel().getColumn(0).setCellRenderer(new CenterAlignRenderer());
    	DefaultTableCellRenderer rendererRight = new DefaultTableCellRenderer();
        rendererRight.setHorizontalAlignment(SwingConstants.RIGHT);
    	table.getColumnModel().getColumn(3).setCellRenderer(rendererRight);
    	table.getColumnModel().getColumn(4).setCellRenderer(new CenterAlignRenderer());
    	table.getColumnModel().getColumn(5).setCellRenderer(new CenterAlignRenderer());
    
	}
	public void hienthi() {
		ArrayList<SanPhamModel> ds ;
		for(SanPhamModel sp :DAO.SanPhamDAO.getAllSanPham()) {
			if(DAO.CTDonHangDAO.laySoLuongById(sp.getId_sp())<1) {
				continue;
			}
			Object[] row = new Object[] {sp.getId_sp(),sp.getNhanhieu(),sp.getTensp(),intToMoney(sp.getGia()),sp.getConlai(),DAO.CTDonHangDAO.laySoLuongById(sp.getId_sp())} ;
      		model.addRow(row);
		}
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
		table.setRowSorter(sorter);
		sorter.setSortable(5, true); 
		sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(5, SortOrder.DESCENDING))); 
		sorter.sort();
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
