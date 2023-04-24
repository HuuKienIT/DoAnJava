package giaodien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.border.MatteBorder;

import model.NhanVienModel;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.awt.event.ActionEvent;

public class ProfileEdit extends JFrame {
	private NhanVienModel nv;
	private JPanel contentPane;
	JLabel txtID_NV;
	private JTextField txtHoTen;
	private JTextField txtEmail;
	private JTextField txtSoDth;
	JLabel txtChucVu;
	JLabel hinhanh;

	public ProfileEdit(NhanVienModel nv) {
		this.nv=nv;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 783, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 747, 478);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN TÀI KHOẢN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 23));
		lblNewLabel.setEnabled(true);
		lblNewLabel.setBounds(10, 20, 727, 30);
		panel.add(lblNewLabel);
		
		JLabel lblSinThoi = new JLabel("ID");
		lblSinThoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSinThoi.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		lblSinThoi.setEnabled(true);
		lblSinThoi.setBounds(-13, 84, 150, 30);
		panel.add(lblSinThoi);
		
		JLabel lblEmail = new JLabel("Họ Tên");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		lblEmail.setEnabled(true);
		lblEmail.setBounds(-13, 134, 150, 30);
		panel.add(lblEmail);
		
		txtHoTen = new JTextField();
		txtHoTen.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(171, 134, 200, 30);
		panel.add(txtHoTen);
		JButton btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCapNhat.setBackground(Color.WHITE);
		btnCapNhat.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		btnCapNhat.setBounds(289, 372, 150, 40);
		panel.add(btnCapNhat);
		
		JLabel lblChcV = new JLabel("Chức Vụ");
		lblChcV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChcV.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		lblChcV.setEnabled(true);
		lblChcV.setBounds(-13, 295, 150, 30);
		panel.add(lblChcV);
		
		txtChucVu = new JLabel("Nhân Viên");
		txtChucVu.setHorizontalAlignment(SwingConstants.LEFT);
		txtChucVu.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
		txtChucVu.setEnabled(true);
		txtChucVu.setBounds(171, 295, 150, 30);
		panel.add(txtChucVu);
		
		hinhanh = new JLabel("");
		hinhanh.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		hinhanh.setBounds(479, 84, 200, 200);
		panel.add(hinhanh);
		
		JButton btnChonAnh = new JButton("Chọn Ảnh");
		btnChonAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiHinh();
			}
		});
		btnChonAnh.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		btnChonAnh.setBackground(Color.WHITE);
		btnChonAnh.setBounds(507, 314, 150, 40);
		panel.add(btnChonAnh);
		
		txtID_NV = new JLabel("NV-01");
		txtID_NV.setHorizontalAlignment(SwingConstants.LEFT);
		txtID_NV.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
		txtID_NV.setEnabled(true);
		txtID_NV.setBounds(171, 84, 150, 30);
		panel.add(txtID_NV);
		
		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		lblEmail_1.setEnabled(true);
		lblEmail_1.setBounds(-13, 186, 150, 30);
		panel.add(lblEmail_1);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(171, 186, 200, 30);
		panel.add(txtEmail);
		
		txtSoDth = new JTextField();
		txtSoDth.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 16));
		txtSoDth.setColumns(10);
		txtSoDth.setBounds(171, 246, 200, 30);
		panel.add(txtSoDth);
		
		JLabel lblEmail_1_2 = new JLabel("Số ĐTH");
		lblEmail_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail_1_2.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 18));
		lblEmail_1_2.setEnabled(true);
		lblEmail_1_2.setBounds(-13, 245, 150, 30);
		panel.add(lblEmail_1_2);
		hienThongTin();
	}
	public void hienThongTin() {
		txtID_NV.setText(nv.getId_nv()+"");
		txtHoTen.setText(nv.getHoTen());
		txtEmail.setText(nv.getEmail());
		txtSoDth.setText(nv.getSoDth()+"");
		txtChucVu.setText(nv.getChucVu());
		hienhinh(nv.getPhoto());
	}
	public void hienhinh(String tenfile) {
	 	BufferedImage originalImage = null;
	 	if(tenfile.equals("")) {
	 		hinhanh.setIcon(null);
	 	}else {
	 		try {
	            InputStream inputStream = BanHang.class.getResourceAsStream("/photo/"+tenfile);
				originalImage = ImageIO.read(inputStream);
				Image resizedImage = originalImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		        ImageIcon icon = new ImageIcon(resizedImage);
			 	hinhanh.setIcon(icon);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
	 	}
	}

	public void doiHinh() {
		JFileChooser fileChooser = new JFileChooser();
	    int returnValue = fileChooser.showOpenDialog(null);
	    if (returnValue == JFileChooser.APPROVE_OPTION) {
	        File selectedFile = fileChooser.getSelectedFile();
	        
	        String fileUrl = null;
	        try {
	            fileUrl = selectedFile.toURI().toURL().toString();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	       
	        System.out.println("Selected file URL: " + fileUrl);
	
	        String sourceDirectoryPath = System.getProperty("user.dir");
	        String packageDirectoryPath = sourceDirectoryPath + "/src/photo";
	        Path sourcePath = selectedFile.toPath();
	        Path targetPath = Paths.get(packageDirectoryPath, "user-"+nv.getId_nv()+".jpg");

	        try {
	            Files.createDirectories(targetPath.getParent()); 
	            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
	            System.out.println("File moved successfully to " + targetPath.toAbsolutePath());
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	    
	}
}
