package giaodien;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class ThongKeSanPham extends JPanel {

	public ThongKeSanPham() {
		setLayout(null);
		JPanel panel_5 = new RoundedJPanel(20);
		panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBackground(SystemColor.text);
		panel_5.setBounds(0, 0, 1180, 543);
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

        JFreeChart chart = ChartFactory.createPieChart("SỐ LƯỢNG SẢN PHẨM ĐÃ BÁN THEO NHÃN HIỆU", dataset, true, true, true);

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
        chartPanel.setSize(1140, 509);
        chartPanel.setLocation(20, 20);
        chartPanel.setPreferredSize(new Dimension(500, 500));
        panel_5.add(chartPanel);
        
	}
}
