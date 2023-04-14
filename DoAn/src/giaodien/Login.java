package giaodien;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenDn;
	private JPasswordField txtMatKhau;
	JCheckBox checkLuuDN ;
	JLabel lblNewLabel_4;
	int show=1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1044, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel jlabel1 = new JLabel("\r\n");
		jlabel1.setBackground(new Color(173, 216, 230));
		jlabel1.setIcon(new ImageIcon(Login.class.getResource("/img/328746ab9fc0439e1ad1.jpg")));
		jlabel1.setBounds(481, 0, 549, 396);
		contentPane.add(jlabel1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(0, 0, 482, 396);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dangnhap();
			}
		});
		btnLogin.setForeground(new Color(65, 105, 225));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.setBackground(new Color(224, 255, 255));
		
		btnLogin.setBounds(52, 296, 339, 38);
		panel.add(btnLogin);
		
		JLabel jlabel2 = new JLabel("LOGIN");
		jlabel2.setForeground(new Color(255, 255, 255));
		jlabel2.setFont(new Font("Tahoma", Font.BOLD, 20));
		jlabel2.setBounds(206, 20, 121, 25);
		panel.add(jlabel2);
		
		JLabel jlabel3 = new JLabel("Hello! Let's get started");
		jlabel3.setForeground(new Color(248, 248, 255));
		jlabel3.setFont(new Font("Tahoma", Font.ITALIC, 13));
		jlabel3.setBounds(172, 55, 215, 16);
		panel.add(jlabel3);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(28, 113, 92, 25);
		panel.add(lblNewLabel);
		
		txtTenDn = new JTextField();
		txtTenDn.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtTenDn.setBackground(new Color(224, 255, 255));
		txtTenDn.setBounds(28, 148, 385, 32);
		panel.add(txtTenDn);
		txtTenDn.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblPassword.setBounds(28, 192, 92, 25);
		panel.add(lblPassword);
		
		checkLuuDN = new JCheckBox("Lưu đăng nhập\r\n");
		checkLuuDN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		checkLuuDN.setBackground(new Color(173, 216, 230));
		checkLuuDN.setBounds(38, 266, 150, 23);
		panel.add(checkLuuDN);
		
		txtMatKhau = new JPasswordField();
		Action action = new AbstractAction()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		        dangnhap();	
//		        ghiTaiKhoan(txtTenDn.getText(),txtMatKhau.getText());
		    }
		};
        docTaiKhoan();
		txtMatKhau.addActionListener( action );
		txtMatKhau.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtMatKhau.setBackground(new Color(224, 255, 255));
		txtMatKhau.setBounds(28, 227, 385, 32);
		txtMatKhau.setEchoChar('*');
		panel.add(txtMatKhau);
		
		JLabel lblNewLabel_1 = new JLabel("Don't have an account?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(new Color(248, 248, 255));
		lblNewLabel_1.setBounds(89, 351, 148, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sign Up");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SignUp().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2.setForeground(new Color(248, 248, 255));
		lblNewLabel_2.setBounds(233, 353, 65, 18);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/img/icons8-male-user-80.png")));
		lblNewLabel_3.setBounds(10, 22, 92, 69);
		panel.add(lblNewLabel_3);
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showHide();
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/icon/show.jpg")));
		lblNewLabel_4.setBounds(425, 227, 30, 32);
		panel.add(lblNewLabel_4);
		
		
	}
	public void dangnhap() {
		String tendn,matkhau;
		tendn=txtTenDn.getText();
		matkhau=txtMatKhau.getText();
		if(tendn.equals("")||matkhau.equals("")) {
			JOptionPane.showMessageDialog(contentPane, "Không để trống tên đăng nhập hoặc mật khẩu");
		}else {
			if(DAO.nhanVienDAO.layMatKhau(tendn).equals(matkhau)) {
				new trangchinh(DAO.nhanVienDAO.getUserByTaiKhoan(tendn)).setVisible(true);
				dispose();
			}else {
				JOptionPane.showMessageDialog(contentPane, "Tên đăng nhập hoặc mật khẩu sai");
			}
		}
	}
	public void showHide() {
		if(show==1) {
			lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/icon/hide.jpg")));
			txtMatKhau.setEchoChar((char)0); 
			show=0;
		}else {
			lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/icon/show.jpg")));
			   txtMatKhau.setEchoChar('*');
			show=1;
		}
	
	}
	public void docTaiKhoan() {
		try {
            FileReader reader = new FileReader("LuuDangNhap.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            int dem=0;
            while ((line = bufferedReader.readLine()) != null) {
            		if(dem==0) {
            			txtTenDn.setText(line);
            		}else {
            			txtMatKhau.setText(line);
            		}
            		dem++;
            checkLuuDN.setSelected(true);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public void ghiTaiKhoan(String taikhoan,String matkhau) {
		  try {
	            FileWriter writer = new FileWriter("LuuDangNhap.txt", true);
	            BufferedWriter bufferedWriter = new BufferedWriter(writer);
	 
	            bufferedWriter.write(taikhoan);
	            bufferedWriter.newLine();
	            bufferedWriter.write(matkhau);
	 
	            bufferedWriter.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
