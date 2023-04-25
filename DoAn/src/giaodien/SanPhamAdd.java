package giaodien;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import com.mysql.jdbc.PreparedStatement;

import DAO.NhanHieuDAO;
import DAO.NhanVienDAO;
import DAO.SanPhamDAO;
import DAO.mySQLHelper;
import model.NhanVienModel;
import model.SanPhamModel;

import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class SanPhamAdd extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaSP;
	JTextArea txtTenSP = new JTextArea();
	private JTextField txtNhanHieu;
	private JTextField txtDonGia;
	public int id;
	JLabel hinhanh = new JLabel("");
	ArrayList<SanPhamModel> dsSP = SanPhamDAO.getAllSanPham();
	String filename;
	public SanPhamAdd(int id) {
		this.id=id;
		setType(Type.UTILITY);
		setBounds(100, 100, 1000,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel_1 = new RoundedJPanel(20);
		panel_1.setBackground(SystemColor.text);
		panel_1.setBounds(10, 70, 965, 480);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã sp");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(62, 50, 100, 35);
		panel_1.add(lblNewLabel_1);
		
		txtMaSP = new RoundJTextField(15);
		txtMaSP.setColumns(10);
		txtMaSP.setBounds(200, 50, 125, 35);
		if(id==0) {
			txtMaSP.setEditable(true);
		}
		else {
			txtMaSP.setEditable(false);
		}
		
		panel_1.add(txtMaSP);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sp");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(62, 111, 100, 35);
		panel_1.add(lblNewLabel_1_1);
		
		txtNhanHieu = new RoundJTextField(15);
		txtNhanHieu.setColumns(10);
		txtNhanHieu.setBounds(199, 201, 250, 35);
		panel_1.add(txtNhanHieu);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nhãn Hiệu");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(25, 201, 136, 35);
		panel_1.add(lblNewLabel_1_2);
		
		txtDonGia = new RoundJTextField(15);
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(200, 260, 250, 35);
		panel_1.add(txtDonGia);
		
		JLabel lblNewLabel_1_4 = new JLabel("Đơn giá");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(62, 260, 100, 35);
		panel_1.add(lblNewLabel_1_4);
		
		JButton btnNewButton_1 = new JButton("Chọn ảnh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		            filename=selectedFile.getName().toString();
		            System.out.println("Selected file URL: " + fileUrl);

		            // do something with the selected file
		            String sourceDirectoryPath = System.getProperty("user.dir");
		            System.out.println("1"+sourceDirectoryPath);
		            String packageDirectoryPath = sourceDirectoryPath + "/src/photo";
		            System.out.println("2"+packageDirectoryPath);
		            Path sourcePath = selectedFile.toPath();
		            System.out.println("3"+sourcePath);
		            Path targetPath = Paths.get(packageDirectoryPath,filename);
		            System.out.println("4"+targetPath);
		            try {
		            	if(sourcePath.toString().equals(targetPath.toString())){
		            		hienhinh(filename);
		            	}
		            	else {
		            		Files.createDirectories(targetPath.getParent()); // create the package directory if it doesn't exist
			                Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
			                System.out.println("File moved successfully to " + targetPath.toAbsolutePath());
		            	}
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            }
		        }
			}
		});
		btnNewButton_1.setBackground(SystemColor.text);
		btnNewButton_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 15));
		btnNewButton_1.setBounds(690, 354, 125, 40);
		panel_1.add(btnNewButton_1);
		
		
		JButton btnNewButton_1_1_1 = new JButton("Lưu");
		btnNewButton_1_1_1.setBackground(SystemColor.text);
		btnNewButton_1_1_1.setIcon(new ImageIcon("E:\\Picrure AT\\iconjava\\save.jpg"));
		btnNewButton_1_1_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 15));
		btnNewButton_1_1_1.setBounds(245, 354, 150, 50);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idsp= String.valueOf(DAO.SanPhamDAO.demTongSoSP()+1);
				String masp=txtMaSP.getText();
				String tensp=txtTenSP.getText();
				String manh=String.valueOf(NhanHieuDAO.Id_NhByName(txtNhanHieu.getText())) ;
				String gia=String.valueOf(txtDonGia.getText());
				String sl="0";
				String tenfile="";
				tenfile=filename;
				String sql="insert into sanpham values('"+idsp+"','"+masp+"','"+tensp+"','"+gia+"','"+sl+"','"+manh+"','"+tenfile+"')";
				mySQLHelper conn=new mySQLHelper();
				conn.open();
				int n=conn.executeUpdate(sql);
				if(n!=-1) {
					JOptionPane.showMessageDialog(null, "Thêm thành công");
					setVisible(false);
				}
				conn.close();
				dsSP=SanPhamDAO.getAllSanPham();
			}
		});
		panel_1.add(btnNewButton_1_1_1);
		

//		lblNewLabel.setIcon(new ImageIcon(sanPhamAdd.class.getResource("/photo/sp-6.jpg")));
		hinhanh.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		hinhanh.setBounds(604, 25, 300, 300);
		panel_1.add(hinhanh);
		txtTenSP.setLineWrap(true);
		txtTenSP.setWrapStyleWord(true);
		txtTenSP.setRows(2);
		txtTenSP.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		
		
		txtTenSP.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtTenSP.setBounds(200, 111, 300, 60);
		panel_1.add(txtTenSP);
		
		JPanel panel = new RoundedJPanel(20);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 10, 965, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_6 = new JLabel("SẢN PHẨM");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_6.setBounds(0, 5, 965, 40);
		lblNewLabel_1_6.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 25));
		panel.add(lblNewLabel_1_6);
		setDuLieu();
	}

	public void setDuLieu() {
		SanPhamModel sp = SanPhamDAO.getSanPhamByIdSP(id);
		txtMaSP.setText(sp.getMasp());
//		txtTenSP.setText(sp.getTensp());
		txtTenSP.append(sp.getTensp());
		txtNhanHieu.setText(sp.getNhanhieu());
		txtDonGia.setText(sp.getGia()+"");		
		hienhinh(sp.getPhoto());
	}
	public void hienhinh(String tenfile) {
	 	
	 	if(tenfile.equals("null")) {
	 		hinhanh.setIcon(null);
	 	}else {
	 		ImageIcon imageIcon = new ImageIcon(new ImageIcon(BanHang.class.getResource
					("/photo/"+tenfile)).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));
			hinhanh.setIcon(imageIcon);
	 	}
	}
	
	public void moveFile(String urlup,String ten) {
		File uploadedFile = new File(urlup);
		String newDirectory = "/photo";
		String newFilename = ten;
		try {
		    File newFile = moveUploadedFile(uploadedFile, newDirectory, newFilename);
		    System.out.println("File moved to: " + newFile.getAbsolutePath());
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	public File moveUploadedFile(File uploadedFile, String newDirectory, String newFilename) throws IOException {
	    Path source = uploadedFile.toPath();
	    Path destination = Paths.get(newDirectory, newFilename);
	    Files.move(source, destination);
	    return destination.toFile();
	}
}
