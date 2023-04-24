package giaodien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TongQuan extends JPanel {
	
	JLabel txtSanPham = new JLabel();
	JLabel txtKhachHang = new JLabel();
	JLabel txtDoanhThu = new JLabel();
	JLabel txtNhanVien = new JLabel();
	
	JPanel panel_6 = new RoundedJPanel(20);
	JPanel panel_4 = new JPanel();
	
	public TongQuan() {
		setLayout(null);
		JPanel panel_5 = new RoundedJPanel(20);
		panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBackground(SystemColor.text);
		panel_5.setBounds(0, 0, 1180, 291);
		add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ CỬA HÀNG");
		lblNewLabel.setBounds(0, 20, 1140, 35);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
		panel_5.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 80, 280, 170);
		panel_5.add(panel);
//		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panel.setOpaque(false);
		panel.setBackground(Color.CYAN);
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("LOẠI  SẢN PHẨM");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 75, 180, 50);
		lblNewLabel_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 20));
		panel.add(lblNewLabel_1);
		

		txtSanPham.setHorizontalAlignment(SwingConstants.CENTER);
		txtSanPham.setFont(new Font("Open Sans ExtraBold", Font.BOLD, 22));
		txtSanPham.setBounds(0, 45, 180, 39);
		panel.add(txtSanPham);
		
		JLabel lblNewLabel_3 = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(BanHang.class.getResource("/icon/sanpham.jpg")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		lblNewLabel_3.setIcon(imageIcon);
		lblNewLabel_3.setBounds(180, 45, 80, 80);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(300, 80, 280, 170);
		panel_5.add(panel_1);
		panel_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panel_1.setOpaque(false);
		panel_1.setBackground(new Color(127, 255, 212));
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("KHÁCH HÀNG");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(0, 75, 180, 50);
		lblNewLabel_1_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_1_1);
		

		txtKhachHang.setBackground(new Color(240, 255, 255));
		txtKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		txtKhachHang.setFont(new Font("Open Sans ExtraBold", Font.BOLD, 22));
		txtKhachHang.setBounds(0, 45, 180, 39);
		panel_1.add(txtKhachHang);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(BanHang.class.getResource("/icon/users.jpg")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		lblNewLabel_3_1.setIcon(imageIcon1);
		lblNewLabel_3_1.setBounds(180, 45, 80, 80);
		panel_1.add(lblNewLabel_3_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setOpaque(false);
		panel_2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(new Color(127, 255, 212));
		panel_2.setBounds(880, 80, 280, 170);
		panel_5.add(panel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("NHÂN VIÊN");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNewLabel_1_2.setBounds(0, 75, 180, 50);
		panel_2.add(lblNewLabel_1_2);
		
		
		txtNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		txtNhanVien.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		txtNhanVien.setBounds(0, 45, 180, 39);
		panel_2.add(txtNhanVien);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(BanHang.class.getResource("/icon/nhanvien.jpg")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		lblNewLabel_3_2.setIcon(imageIcon2);
		lblNewLabel_3_2.setBounds(180, 45, 80, 80);
		panel_2.add(lblNewLabel_3_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setOpaque(false);
		panel_3.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panel_3.setBackground(new Color(127, 255, 212));
		panel_3.setBounds(590, 80, 280, 170);
		panel_5.add(panel_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("DOANH THU");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNewLabel_1_3.setBounds(0, 75, 180, 50);
		panel_3.add(lblNewLabel_1_3);
		
		
		txtDoanhThu.setHorizontalAlignment(SwingConstants.CENTER);
		txtDoanhThu.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		txtDoanhThu.setBounds(0, 45, 180, 40);
		panel_3.add(txtDoanhThu);
		
		JLabel lblNewLabel_3_3 = new JLabel("");
		ImageIcon imageIcon3 = new ImageIcon(new ImageIcon(BanHang.class.getResource("/icon/cash.jpg")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		lblNewLabel_3_3.setIcon(imageIcon3);
		lblNewLabel_3_3.setBounds(180, 45, 80, 80);
		panel_3.add(lblNewLabel_3_3);
		

		panel_6.setBackground(SystemColor.text);
		panel_6.setBounds(0, 311, 1180, 488);
		add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblThngKDoanh = new JLabel("THỐNG KÊ DOANH THU");
		lblThngKDoanh.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngKDoanh.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
		lblThngKDoanh.setBackground(Color.LIGHT_GRAY);
		lblThngKDoanh.setBounds(0, 10, 1140, 40);
		panel_6.add(lblThngKDoanh);
        
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        hienBieuDo((int) comboBox.getItemAt(comboBox.getSelectedIndex()));
			}
		});
		DefaultComboBoxModel Nam = new DefaultComboBoxModel();
		for(int i=2016;i<2030;i++) {
			Nam.addElement(i);
		}
		comboBox.setModel(Nam);
		comboBox.setSelectedItem(2023);
		comboBox.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
		comboBox.setBackground(SystemColor.text);
		comboBox.setBounds(560, 50, 80, 30);
		panel_6.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("NĂM");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(500, 50, 46, 30);
		panel_6.add(lblNewLabel_2);
		

		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(20, 91, 1140, 379);
		panel_6.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(230, 5, 1, 1);
		add(panel_7);
		panel_7.setLayout(null);
		
		hienThongSo();
		hienBieuDo(2023);
		 
	}
	
	private static CategoryDataset createDataset(int nam) {
        // Create a dataset with sales by quarter
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i=1;i<=12;i++) {
        	dataset.addValue(DAO.DonHangDAO.doanhThuThang(i,nam), "Doanh Thu", i+"");
        }     

        return dataset;
    }

    private static JFreeChart createChart(CategoryDataset dataset) {
        // Create a bar chart with sales by quarter
        JFreeChart chart = ChartFactory.createBarChart(
            "", // chart title
            "Tháng", // domain axis label
            "Doanh Thu", // range axis label
            dataset, // data
            PlotOrientation.VERTICAL, // orientation
            true, // include legend
            true, // tooltips
            true // urls
        );

        // Customize the chart
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setRangeGridlineStroke(new java.awt.BasicStroke(0.5f));

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setTickLabelFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 16));

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setTickLabelFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 16));

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new java.awt.Color(79, 129, 189));
        renderer.setDrawBarOutline(false);

        return chart;
    }
    public void hienBieuDo(int nam) {

    	CategoryDataset dataset = createDataset(nam);
        // Create a bar chart with sales by quarter
        JFreeChart chart = createChart(dataset);

        // Create a chart panel with the chart
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setSize(1140, 379);
        chartPanel.setLocation(0, 0);
        chartPanel.setPreferredSize(new Dimension(1140, 371));
        panel_4.removeAll();
        panel_4.add(chartPanel);
        panel_4.revalidate();
        panel_4.repaint();
    }
    
    
    public void hienThongSo() {
    	txtSanPham.setText(DAO.SanPhamDAO.demTongSoSP()+"");
    	txtKhachHang.setText(DAO.KhachHangDAO.demTongSoKH()+"");
    	txtNhanVien.setText(DAO.NhanVienDAO.demTongSoNV()+"");
    	txtDoanhThu.setText(intToMoney(DAO.DonHangDAO.tongDoanhThu()));
    }
	public static String intToMoney(int value) {
	    Locale locale = new Locale("vi", "VN");
	    Currency currency = Currency.getInstance("VND");
	    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
	    currencyFormatter.setCurrency(currency);
	    return currencyFormatter.format(value);
	}
}
