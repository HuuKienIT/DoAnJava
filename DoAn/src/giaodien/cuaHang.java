package giaodien;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class cuaHang extends JPanel {

	JPanel DiChuyen = new JPanel();
	public cuaHang() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1200, 40);
		add(panel);
		panel.setLayout(null);
		
		JPanel body = new JPanel();
		body.setBounds(0, 40, 1200, 860);
		add(body);
		body.setLayout(new BorderLayout(0, 0));

		// add panel san pham
		sanpham tsp = new sanpham();
		tsp.setBackground(SystemColor.control);
		tsp.setLayout(null);
		tsp.setVisible(true);
		body.add(tsp);
		
		// add panel ql loai sp
		Loai qlloaisp = new Loai();
		qlloaisp.setLayout(null);
		qlloaisp.setVisible(true);
		
		// add panel ql nhà cung cấp
		NhaCungCap tncc = new NhaCungCap();
		tncc.setLayout(null);
		tncc.setVisible(true);
		// add panel ql don vi tinh
		NhanHieu tdvt = new NhanHieu();
		tdvt.setLayout(null);
		tdvt.setVisible(true);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 200, 35);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SẢN PHẨM");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int targetX = 0; // target x position
		        int targetY = 35; // target y position
		        int stepSize = 40; // how many pixels to move at each step

		        Timer timer = new Timer(1, new ActionListener() {
		            int x = DiChuyen.getLocation().x;
		            int y = 35;
		            @Override
		            
		            public void actionPerformed(ActionEvent e) {
		                int dx = targetX - x; 
		                int dy = targetY - y;
		                double distance = Math.sqrt(dx*dx + dy*dy);

		                double stepX = stepSize * dx / distance;
		                double stepY = stepSize * dy / distance;

		                // update x and y positions
		                x += (int) stepX;
		                y += (int) stepY;
		                if (distance < stepSize) {
		                    return;
		                }
		                DiChuyen.setLocation(x, y);
		            }
		            
		        });
		        timer.start();
		        body.removeAll();
		        body.add(new sanpham());
		        body.repaint();
		        body.validate();
		      
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		lblNewLabel.setBounds(0, 0, 200, 35);
		panel_1.add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(200, 0, 200, 35);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("LOẠI SẢN PHẨM\r\n");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int targetX = 200; // target x position
		        int targetY = 35; // target y position
		        int stepSize = 40; // how many pixels to move at each step

		        Timer timer = new Timer(1, new ActionListener() {
		            int x = DiChuyen.getLocation().x;
		            int y = 35;
		            @Override
		            
		            public void actionPerformed(ActionEvent e) {
		                int dx = targetX - x; 
		                int dy = targetY - y;
		                double distance = Math.sqrt(dx*dx + dy*dy);

		                double stepX = stepSize * dx / distance;
		                double stepY = stepSize * dy / distance;

		                // update x and y positions
		                x += (int) stepX;
		                y += (int) stepY;
		                if (distance < stepSize) {
		                    return;
		                }
		                DiChuyen.setLocation(x, y);
		            }
		            
		        });
		        timer.start();
		        body.removeAll();
		        body.add(new Loai());
		        body.repaint();
		        body.validate();
		     
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(0, 0, 200, 35);
		panel_1_1.add(lblNewLabel_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setBounds(400, 0, 200, 35);
		panel.add(panel_1_2);
		
		JLabel lblNhCungCp = new JLabel("NHÀ CUNG CẤP");
		lblNhCungCp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int targetX = 400; // target x position
		        int targetY = 35; // target y position
		        int stepSize = 40; // how many pixels to move at each step

		        Timer timer = new Timer(1, new ActionListener() {
		            int x = DiChuyen.getLocation().x;
		            int y = 35;
		            @Override
		            
		            public void actionPerformed(ActionEvent e) {
		                int dx = targetX - x; 
		                int dy = targetY - y;
		                double distance = Math.sqrt(dx*dx + dy*dy);

		                double stepX = stepSize * dx / distance;
		                double stepY = stepSize * dy / distance;

		                // update x and y positions
		                x += (int) stepX;
		                y += (int) stepY;
		                if (distance < stepSize) {
		                    // if distance is less than stepSize, stop the animation
		                    
		                    return;
		                }
		                DiChuyen.setLocation(x, y); // set the new location
		            }
		            
		        });
		        timer.start();
		        body.removeAll();
		        body.add(new NhaCungCap());
		        body.repaint();
		        body.validate();
		        
			}
		});
		lblNhCungCp.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhCungCp.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		lblNhCungCp.setBounds(0, 0, 200, 35);
		panel_1_2.add(lblNhCungCp);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBackground(Color.WHITE);
		panel_1_3.setBounds(600, 0, 200, 35);
		panel.add(panel_1_3);
		
		JLabel lblnVTnh = new JLabel("NHÃN HIỆU\r\n");
		lblnVTnh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int targetX = 600; // target x position
		        int targetY = 35; // target y position
		        int stepSize = 40; // how many pixels to move at each step

		        Timer timer = new Timer(1, new ActionListener() {
		            int x = DiChuyen.getLocation().x;
		            int y = 35;
		            @Override
		            
		            public void actionPerformed(ActionEvent e) {
		                int dx = targetX - x; 
		                int dy = targetY - y;
		                double distance = Math.sqrt(dx*dx + dy*dy);

		                double stepX = stepSize * dx / distance;
		                double stepY = stepSize * dy / distance;

		                // update x and y positions
		                x += (int) stepX;
		                y += (int) stepY;
		                if (distance < stepSize) {
		                    // if distance is less than stepSize, stop the animation
		                    
		                    return;
		                }
		                DiChuyen.setLocation(x, y); // set the new location
		            }
		            
		        });
		        timer.start();
		        body.removeAll();
		        body.add(new NhanHieu());
		        body.repaint();
		        body.validate();
			}
		});
		lblnVTnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblnVTnh.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		lblnVTnh.setBounds(0, 0, 200, 35);
		panel_1_3.add(lblnVTnh);
		
		DiChuyen.setBackground(Color.CYAN);
		DiChuyen.setBounds(0, 35, 200, 5);
		panel.add(DiChuyen);
		
		

	}
}
