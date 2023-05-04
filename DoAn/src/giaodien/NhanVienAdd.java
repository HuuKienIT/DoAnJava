package giaodien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.border.MatteBorder;

import DAO.ChucVuDAO;
import DAO.NhanVienDAO;
import DAO.SanPhamDAO;
import model.NhanVienModel;
import model.SanPhamModel;

import javax.swing.SwingConstants;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;

public class NhanVienAdd extends JFrame {
	private JPanel contentPane;
	RoundJTextField txtHoTen = new RoundJTextField(15);
	RoundJTextField txtEmail = new RoundJTextField(15);
	RoundJTextField txtSodth = new RoundJTextField(15);
	RoundJTextField txtID = new RoundJTextField(15);
	RoundJTextField txtTaikhoan = new RoundJTextField(15);
	RoundJTextField txtNgaySinh = new RoundJTextField(10);
	JComboBox comboChucVu = new JComboBox();
	JLabel lblNewLabel = new JLabel("");
	JButton btnLu;
	private JPasswordField txtMatKhau;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton rdobtnNam, rdobtnNu;
	JLabel lblHideshow;
	int show = 1;
	boolean doianh = false;
	String filename = "null";
	ArrayList<NhanVienModel> dsNV = NhanVienDAO.getAllUsers();

	public NhanVienAdd() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 734, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		RoundedJPanel panel = new RoundedJPanel(15);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 70, 700, 518);
		contentPane.add(panel);
		setLocationRelativeTo(null);
		
		btnLu = new JButton("Thêm");
		btnLu.setIcon(new ImageIcon(NhanVienAdd.class.getResource("/icon/save.jpg")));
		btnLu.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
		btnLu.setBackground(Color.WHITE);
		btnLu.setBounds(116, 448, 150, 40);
		btnLu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (txtHoTen.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nhập Họ tên nhân viên");
                    txtHoTen.requestFocus();
                    return;
                }
				if(rdobtnNam.isSelected() && rdobtnNu.isSelected()) {
					JOptionPane.showMessageDialog(null, "Chọn giới tính");
                    rdobtnNam.requestFocus();
                    return;
				}
				if (txtNgaySinh.getText().length()<10) {
                    JOptionPane.showMessageDialog(null, "Nhập đủ 10 ký tự");
                    txtNgaySinh.requestFocus();
                    return;
                }
				if (txtTaikhoan.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nhập Tài khoản");
                    txtTaikhoan.requestFocus();
                    return;
                }
				if (txtMatKhau.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nhập Mật khẩu");
                    txtMatKhau.requestFocus();
                    return;
                }
				if (txtSodth.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nhập SĐT");
                    txtSodth.requestFocus();
                    return;
                }
				if (txtEmail.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nhập Email");
                    txtEmail.requestFocus();
                    return;
                }
				String hotennv=txtHoTen.getText();
				int gt=0;
				if(rdobtnNam.isSelected()) {
					gt=1;
				}else if(rdobtnNu.isSelected()) {
					gt=0;
				}
				String ngaysinh=txtNgaySinh.getText();
				String taikhoan=txtTaikhoan.getText();
				String matkhau=txtMatKhau.getText();
				String email=txtEmail.getText();
				String sdt=txtEmail.getText();
				String photo="";
				String chucvu=String.valueOf(comboChucVu.getSelectedItem());
				System.out.print(chucvu);
				if(txtID.getText().equals("")){
					photo=filename;
					if(BUS.NhanVienBUS.addNV(hotennv,gt,ngaysinh,taikhoan,matkhau,email,sdt,photo,chucvu)) {
						setVisible(false);
						dsNV=NhanVienDAO.getAllUsers();
					}
				}
				else {
					if(doianh==true) {
						photo=filename;
					}
					else {
						NhanVienModel nv = NhanVienDAO.getUsersByID(Integer.parseInt(txtID.getText()));
						photo=nv.getPhoto();
					}
					if(BUS.NhanVienBUS.updateNV(Integer.valueOf(txtID.getText()),hotennv,gt,ngaysinh,taikhoan,matkhau,email,sdt,photo,chucvu)) {
						setVisible(false);
						dsNV=NhanVienDAO.getAllUsers();
					}
				}
			}
		});
		panel.add(btnLu);
		
		JLabel lblNewLabel_1 = new JLabel("Họ Tên");
		lblNewLabel_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(260, 30, 80, 30);
		panel.add(lblNewLabel_1);
		
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(340, 30, 249, 30);
		panel.add(txtHoTen);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(68, 330, 99, 30);
		panel.add(lblNewLabel_1_1);
		
		txtSodth.setColumns(10);
		txtSodth.setBounds(205, 330, 227, 30);
		panel.add(txtSodth);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(87, 280, 80, 30);
		panel.add(lblNewLabel_1_2);
		
		txtEmail.setColumns(10);
		txtEmail.setBounds(205, 280, 227, 30);
		panel.add(txtEmail);
		
		JLabel lblNewLabel_1_4 = new JLabel("Mã NV");
		lblNewLabel_1_4.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(68, 30, 66, 30);
		panel.add(lblNewLabel_1_4);
		
		txtID.setEditable(false);
		txtID.setDisabledTextColor(Color.BLACK);
		txtID.setColumns(10);
		txtID.setBounds(132, 30, 100, 30);
		panel.add(txtID);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Chức vụ");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(89, 380, 80, 30);
		panel.add(lblNewLabel_1_2_1);
		

		comboChucVu.setBounds(206, 380, 168, 30);
		panel.add(comboChucVu);
		

		lblNewLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel.setBounds(479, 80, 150, 150);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Chọn ảnh");
		btnNewButton.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 14));
		btnNewButton.setBounds(509, 250, 100, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doianh=true;
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
		panel.add(btnNewButton);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setIcon(new ImageIcon(NhanVienAdd.class.getResource("/icon/delete.jpg")));
		btnXa.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
		btnXa.setBackground(Color.WHITE);
		btnXa.setBounds(307, 448, 150, 40);
		panel.add(btnXa);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Giới tính");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_1_2_2.setBounds(87, 80, 80, 30);
		panel.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Tài khoản");
		lblNewLabel_1_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_3.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_1_2_3.setBounds(87, 180, 80, 30);
		panel.add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Mật khẩu");
		lblNewLabel_1_2_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_4.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_1_2_4.setBounds(87, 230, 80, 30);
		panel.add(lblNewLabel_1_2_4);
		
		txtTaikhoan = new RoundJTextField(15);
		txtTaikhoan.setColumns(10);
		txtTaikhoan.setBounds(205, 180, 227, 30);
		panel.add(txtTaikhoan);
		
		rdobtnNam = new JRadioButton("Nam");
		buttonGroup.add(rdobtnNam);
		rdobtnNam.setFont(new Font("Dialog", Font.PLAIN, 14));
		rdobtnNam.setBounds(203, 80, 103, 30);
		panel.add(rdobtnNam);
		
		rdobtnNu = new JRadioButton("Nữ");
		buttonGroup.add(rdobtnNu);
		rdobtnNu.setFont(new Font("Dialog", Font.PLAIN, 14));
		rdobtnNu.setBounds(329, 80, 103, 30);
		panel.add(rdobtnNu);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(205, 230, 227, 30);
		panel.add(txtMatKhau);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("Ngày sinh");
		lblNewLabel_1_2_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_3_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_1_2_3_1.setBounds(87, 130, 80, 30);
		panel.add(lblNewLabel_1_2_3_1);
		
		txtNgaySinh = new RoundJTextField(15);
		txtNgaySinh.setColumns(15);
		txtNgaySinh.setBounds(205, 134, 227, 30);
		panel.add(txtNgaySinh);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 10, 700, 50);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("CHỈNH SỬA TÀI KHOẢN\r\n");
		lblNewLabel_1_4_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNewLabel_1_4_1.setBounds(245, 5, 300, 40);
		panel_1.add(lblNewLabel_1_4_1);
		
		lblHideshow = new JLabel("");
		lblHideshow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showHide();
			}
		});
		lblHideshow.setIcon(new ImageIcon(Login.class.getResource("/icon/show.jpg")));
		lblHideshow.setBounds(442, 230, 30, 30);
		panel.add(lblHideshow);
		layChucVu();
	}

	public void setDuLieu(int id_nv) {
		NhanVienModel u = NhanVienDAO.getUsersByID(id_nv);
		txtID.setText(id_nv + "");
		txtHoTen.setText(u.getHoTen());
		if (u.getGioiTinh() == 1) {
			rdobtnNam.setSelected(true);
		}else
		{
			rdobtnNu.setSelected(true);
		}
		txtTaikhoan.setText(u.getTaiKhoan());
		txtMatKhau.setText(u.getMatKhau());
		txtEmail.setText(u.getEmail());
		txtSodth.setText(u.getSoDth() + "");
		txtNgaySinh.setText(u.namSinh);
		btnLu.setText("Cập Nhật");
		comboChucVu.setSelectedItem(u.getChucVu());
		hienhinh(u.getPhoto());
		
	}

	public void layChucVu() {
		DefaultComboBoxModel model = (DefaultComboBoxModel) comboChucVu.getModel();
		for (String cv : DAO.ChucVuDAO.getAllChucVu()) {
			model.addElement(cv);
		}
		comboChucVu.setModel(model);
	}

	public void hienhinh(String tenfile) {
		if (tenfile.equals("null")) {
			lblNewLabel.setIcon(null);
		} else {
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(BanHang.class.getResource("/photo/" + tenfile)).getImage()
					.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
			lblNewLabel.setIcon(imageIcon);
		}
	}

	public void showHide() {
		if (show == 1) {
			lblHideshow.setIcon(new ImageIcon(Login.class.getResource("/icon/hide.jpg")));
			txtMatKhau.setEchoChar((char) 0);
			show = 0;
		} else {
			lblHideshow.setIcon(new ImageIcon(Login.class.getResource("/icon/show.jpg")));
			txtMatKhau.setEchoChar('*');
			show = 1;
		}
	}

	public boolean checkExistNV(int idnv) {
		for (int i = 0; i < dsNV.size(); i++) {
			if (dsNV.get(i).getId_nv() == idnv) {
				return true;
			}
		}
		return false;

	}
}
