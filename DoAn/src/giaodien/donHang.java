package giaodien;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class donHang extends JPanel {
	
//	@Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//        int w = getWidth(), h = getHeight();
//        Color color1 = Color.PINK;
//        Color color2 = Color.GREEN;
//        GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);
//        g2d.setPaint(gp);
//        g2d.fillRect(0, 0, w, h);
//    }
	private JTextField textField_1;
	public donHang() {
		setBackground(SystemColor.control);
		setLayout(null);
		
		JPanel panel = new RoundedJPanel(20);
		panel.setBackground(SystemColor.text);
		panel.setBounds(30, 30, 700, 140);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm theo");
		lblNewLabel_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(30, 70, 120, 30);
		panel.add(lblNewLabel_1);
		
		textField_1 = new RoundJTextField(15);
		textField_1.setColumns(10);
		textField_1.setBounds(340, 70, 200, 30);
		panel.add(textField_1);
		
		JLabel lblTmKim = new JLabel("TÌM KIẾM");
		lblTmKim.setBackground(SystemColor.text);
		lblTmKim.setHorizontalAlignment(SwingConstants.CENTER);
		lblTmKim.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 25));
		lblTmKim.setBounds(0, 20, 700, 30);
		panel.add(lblTmKim);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(SystemColor.text);
		comboBox.setBounds(160, 70, 150, 30);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setBackground(SystemColor.text);
		btnNewButton.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 14));
		btnNewButton.setIcon(new ImageIcon("E:\\Picrure AT\\iconjava\\find5.jpg"));
		btnNewButton.setBounds(565, 65, 110, 40);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new RoundedJPanel(20);
		panel_1.setBackground(SystemColor.text);
		panel_1.setBounds(30, 195, 700, 675);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH ĐƠN HÀNG");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 25));
		lblNewLabel.setBounds(0, 20, 700, 30);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new RoundedJPanel(20);
		panel_2.setBackground(SystemColor.text);
		panel_2.setBounds(760, 312, 420, 558);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblChiTitn = new JLabel("CHI TIẾT ĐƠN HÀNG");
		lblChiTitn.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTitn.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 25));
		lblChiTitn.setBounds(0, 20, 420, 30);
		panel_2.add(lblChiTitn);
		
		JPanel panel_3 = new RoundedJPanel(20);
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(760, 30, 420, 254);
		add(panel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên nhân viên: ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(79, 65, 150, 30);
		panel_3.add(lblNewLabel_1_1);
		
		JLabel lblnHng = new JLabel("ĐƠN HÀNG");
		lblnHng.setHorizontalAlignment(SwingConstants.CENTER);
		lblnHng.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 25));
		lblnHng.setBackground(Color.WHITE);
		lblnHng.setBounds(0, 20, 420, 30);
		panel_3.add(lblnHng);
		
		JButton btnNewButton_1 = new JButton("Tìm");
		btnNewButton_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 14));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(584, 72, 110, 40);
		panel_3.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Lê Văn B");
		lblNewLabel_1_1_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(229, 65, 140, 30);
		panel_3.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Tên khách hàng: ");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(79, 110, 150, 30);
		panel_3.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Lê Văn B");
		lblNewLabel_1_1_1_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(229, 110, 140, 30);
		panel_3.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Ngày mua: \r\n");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1.setBounds(61, 155, 150, 30);
		panel_3.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("31/2/2023\r\n");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(211, 155, 140, 30);
		panel_3.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Số lượng: ");
		lblNewLabel_1_1_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2_1_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1_1.setBounds(30, 200, 83, 30);
		panel_3.add(lblNewLabel_1_1_2_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("10");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_1_1.setForeground(Color.RED);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(115, 200, 50, 30);
		panel_3.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_2_1_2 = new JLabel("Tổng tiền: ");
		lblNewLabel_1_1_2_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2_1_2.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1_2.setBounds(150, 200, 110, 30);
		panel_3.add(lblNewLabel_1_1_2_1_2);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("100 000 đ\r\n");
		lblNewLabel_1_1_1_1_1_2.setForeground(Color.RED);
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_2.setBounds(260, 200, 140, 30);
		panel_3.add(lblNewLabel_1_1_1_1_1_2);

	}
}
