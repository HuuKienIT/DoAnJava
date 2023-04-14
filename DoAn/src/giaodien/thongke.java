package giaodien;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JToolBar;
import java.awt.Choice;
import java.awt.Panel;
import javax.swing.border.MatteBorder;

public class thongke extends JPanel {
//
//
//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2d = (Graphics2D) g;
//        GradientPaint p = new GradientPaint(
//            0, 0, color1, getWidth(), 0, color2);
//        g2d.setPaint(p);
//        g2d.fillRect(0, 0, getWidth(), getHeight());
//    }
//
//    @Override
//    public Dimension getPreferredSize() {
//        return new Dimension(WIDE, HIGH);
//    }
//	@Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//        int w = getWidth(), h = getHeight();
//        Color color1 = Color.BLUE;
//        Color color2 = Color.GREEN;
//        GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);
//        g2d.setPaint(gp);
//        g2d.fillRect(0, 0, w, h);
//    }
	
	public thongke() {
//		ActionListener action = new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                hue += delta;
//                if (hue > HUE_MAX) {
//                    hue = HUE_MIN;
//                }
//                color1 = Color.getHSBColor(hue, 1, 1);
//                color2 = Color.getHSBColor(hue + 16 * delta, 1, 1);
//                repaint();
//            }
//        };
//        timer = new Timer(20, action);
//        timer.start();
		setBackground(SystemColor.control);
		setLayout(null);
		
		JPanel panel_5 = new RoundedJPanel(20);
		panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBackground(SystemColor.text);
		panel_5.setBounds(30, 30, 1140, 500);
		add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ CỬA HÀNG");
		lblNewLabel.setBounds(0, 20, 1140, 35);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 25));
		panel_5.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(110, 79, 326, 170);
		panel_5.add(panel);
//		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBorder(new MatteBorder(3, 3, 1, 3, (Color) new Color(0, 0, 0)));
		panel.setOpaque(false);
		panel.setBackground(Color.CYAN);
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("LOẠI  SẢN PHẨM");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 81, 241, 57);
		lblNewLabel_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("150");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNewLabel_1_4.setBounds(0, 44, 205, 39);
		panel.add(lblNewLabel_1_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(714, 79, 326, 170);
		panel_5.add(panel_1);
//		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBorder(new RoundedBorder(10, Color.RED));
		panel_1.setOpaque(false);
		panel_1.setBackground(new Color(127, 255, 212));
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("KHÁCH HÀNG");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(0, 103, 216, 31);
		lblNewLabel_1_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("500");
		lblNewLabel_1_4_1.setBackground(new Color(240, 255, 255));
		lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNewLabel_1_4_1.setBounds(0, 32, 216, 75);
		panel_1.add(lblNewLabel_1_4_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setOpaque(false);
		panel_2.setBorder(new RoundedBorder(10, Color.RED));
		panel_2.setBackground(new Color(127, 255, 212));
		panel_2.setBounds(110, 291, 326, 170);
		panel_5.add(panel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("NHÂN VIÊN");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNewLabel_1_2.setBounds(0, 96, 220, 43);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("20");
		lblNewLabel_1_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_2.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNewLabel_1_4_2.setBounds(0, 39, 214, 52);
		panel_2.add(lblNewLabel_1_4_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setOpaque(false);
		panel_3.setBorder(new RoundedBorder(10, Color.RED));
		panel_3.setBackground(new Color(127, 255, 212));
		panel_3.setBounds(714, 291, 326, 170);
		panel_5.add(panel_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("TỔNG DOANH THU");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNewLabel_1_3.setBounds(0, 92, 250, 46);
		panel_3.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4_3 = new JLabel("10000$");
		lblNewLabel_1_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_3.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNewLabel_1_4_3.setBounds(0, 33, 215, 75);
		panel_3.add(lblNewLabel_1_4_3);
		
		JPanel panel_6 = new RoundedJPanel(20);
		panel_6.setBackground(SystemColor.text);
		panel_6.setBounds(30, 550, 1140, 320);
		add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblThngKDoanh = new JLabel("THỐNG KÊ DOANH THU");
		lblThngKDoanh.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngKDoanh.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 25));
		lblThngKDoanh.setBackground(Color.LIGHT_GRAY);
		lblThngKDoanh.setBounds(0, 20, 1140, 40);
		panel_6.add(lblThngKDoanh);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(SystemColor.text);
		comboBox.setBounds(560, 62, 80, 30);
		panel_6.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("NĂM");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(500, 62, 46, 30);
		panel_6.add(lblNewLabel_2);
		
		Panel panel_4 = new Panel();
		panel_4.setBounds(new Rectangle(10, 0, 0, 0));
		panel_4.setBounds(170, 120, 749, 129);
		panel_6.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("QUÝ");
		lblNewLabel_1_2_1.setBorder(new MatteBorder(2, 3, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNewLabel_1_2_1.setBounds(0, 0, 150, 43);
		panel_4.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("I\r\n");
		lblNewLabel_1_2_1_1.setBorder(new MatteBorder(2, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNewLabel_1_2_1_1.setBounds(150, 0, 150, 43);
		panel_4.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("II");
		lblNewLabel_1_2_1_2.setBorder(new MatteBorder(2, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_2.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNewLabel_1_2_1_2.setBounds(300, 0, 150, 43);
		panel_4.add(lblNewLabel_1_2_1_2);
		
		JLabel lblNewLabel_1_2_1_3 = new JLabel("III");
		lblNewLabel_1_2_1_3.setBorder(new MatteBorder(2, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_1_2_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_3.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNewLabel_1_2_1_3.setBounds(450, 0, 150, 43);
		panel_4.add(lblNewLabel_1_2_1_3);
		
		JLabel lblNewLabel_1_2_1_4 = new JLabel("III");
		lblNewLabel_1_2_1_4.setBorder(new MatteBorder(2, 1, 1, 3, (Color) new Color(0, 0, 0)));
		lblNewLabel_1_2_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_4.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNewLabel_1_2_1_4.setBounds(600, 0, 150, 43);
		panel_4.add(lblNewLabel_1_2_1_4);
		
		JLabel lblNewLabel_1_2_1_5 = new JLabel("DOANH THU");
		lblNewLabel_1_2_1_5.setBorder(new MatteBorder(1, 2, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_1_2_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_5.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNewLabel_1_2_1_5.setBounds(0, 43, 150, 43);
		panel_4.add(lblNewLabel_1_2_1_5);
		
		JLabel lblNewLabel_1_2_1_6 = new JLabel("");
		lblNewLabel_1_2_1_6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_1_2_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_6.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNewLabel_1_2_1_6.setBounds(150, 43, 150, 43);
		panel_4.add(lblNewLabel_1_2_1_6);
		
		JLabel lblNewLabel_1_2_1_7 = new JLabel("");
		lblNewLabel_1_2_1_7.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_1_2_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_7.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNewLabel_1_2_1_7.setBounds(300, 43, 150, 43);
		panel_4.add(lblNewLabel_1_2_1_7);
		
		JLabel lblNewLabel_1_2_1_8 = new JLabel("");
		lblNewLabel_1_2_1_8.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_1_2_1_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_8.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNewLabel_1_2_1_8.setBounds(450, 43, 150, 43);
		panel_4.add(lblNewLabel_1_2_1_8);
		
		JLabel lblNewLabel_1_2_1_9 = new JLabel("");
		lblNewLabel_1_2_1_9.setBorder(new MatteBorder(1, 1, 1, 3, (Color) new Color(0, 0, 0)));
		lblNewLabel_1_2_1_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_9.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNewLabel_1_2_1_9.setBounds(600, 43, 150, 43);
		panel_4.add(lblNewLabel_1_2_1_9);
		
		JLabel lblNewLabel_1_2_1_5_1 = new JLabel("TỔNG DOANH THU");
		lblNewLabel_1_2_1_5_1.setBorder(new MatteBorder(2, 2, 2, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_1_2_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_5_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNewLabel_1_2_1_5_1.setBounds(0, 85, 228, 43);
		panel_4.add(lblNewLabel_1_2_1_5_1);
		
		JLabel lblNewLabel_1_2_1_5_2 = new JLabel("100 000 000 đ");
		lblNewLabel_1_2_1_5_2.setBorder(new MatteBorder(2, 1, 2, 2, (Color) new Color(0, 0, 0)));
		lblNewLabel_1_2_1_5_2.setForeground(Color.RED);
		lblNewLabel_1_2_1_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_5_2.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNewLabel_1_2_1_5_2.setBounds(228, 85, 520, 43);
		panel_4.add(lblNewLabel_1_2_1_5_2);
	}
}
