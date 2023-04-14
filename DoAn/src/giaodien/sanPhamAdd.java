package giaodien;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sanPhamAdd extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sanPhamAdd frame = new sanPhamAdd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public sanPhamAdd() {
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
		
		textField = new RoundJTextField(15);
		textField.setColumns(10);
		textField.setBounds(200, 50, 250, 35);
		textField.setEditable(false);
		panel_1.add(textField);
		
		textField_1 = new RoundJTextField(15);
		textField_1.setColumns(10);
		textField_1.setBounds(200, 100, 250, 35);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sp");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(62, 100, 100, 35);
		panel_1.add(lblNewLabel_1_1);
		
		textField_2 = new RoundJTextField(15);
		textField_2.setColumns(10);
		textField_2.setBounds(200, 150, 250, 35);
		panel_1.add(textField_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Loại");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(62, 150, 100, 35);
		panel_1.add(lblNewLabel_1_2);
		
		textField_3 = new RoundJTextField(15);
		textField_3.setColumns(10);
		textField_3.setBounds(200, 200, 250, 35);
		panel_1.add(textField_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Đơn vị tính");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(49, 200, 113, 35);
		panel_1.add(lblNewLabel_1_3);
		
		textField_4 = new RoundJTextField(15);
		textField_4.setColumns(10);
		textField_4.setBounds(200, 250, 250, 35);
		panel_1.add(textField_4);
		
		JLabel lblNewLabel_1_4 = new JLabel("Đơn giá");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(62, 250, 100, 35);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Số lượng\r\n");
		lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
		lblNewLabel_1_4_1.setBounds(62, 300, 100, 35);
		panel_1.add(lblNewLabel_1_4_1);
		
		textField_5 = new RoundJTextField(15);
		textField_5.setColumns(10);
		textField_5.setBounds(200, 300, 250, 35);
		panel_1.add(textField_5);
		
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
		           
		            System.out.println("Selected file URL: " + fileUrl);

		            // do something with the selected file
		            String sourceDirectoryPath = System.getProperty("user.dir");
		            String packageDirectoryPath = sourceDirectoryPath + "/src/photo";
		            Path sourcePath = selectedFile.toPath();
		            Path targetPath = Paths.get(packageDirectoryPath, "sp-1.wedp");
		            try {
		                Files.createDirectories(targetPath.getParent()); // create the package directory if it doesn't exist
		                Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
		                System.out.println("File moved successfully to " + targetPath.toAbsolutePath());
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            }
		        }
			}
		});
		btnNewButton_1.setBackground(SystemColor.text);
		btnNewButton_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 15));
		btnNewButton_1.setBounds(650, 270, 125, 40);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Lưu");
		btnNewButton_1_1_1.setBackground(SystemColor.text);
		btnNewButton_1_1_1.setIcon(new ImageIcon("E:\\Picrure AT\\iconjava\\save.jpg"));
		btnNewButton_1_1_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 15));
		btnNewButton_1_1_1.setBounds(220, 384, 150, 50);
		panel_1.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_5 = new JButton("Nhập");
		btnNewButton_1_1_5.setBackground(SystemColor.text);
		btnNewButton_1_1_5.setIcon(new ImageIcon("E:\\Picrure AT\\iconjava\\import.jpg"));
		btnNewButton_1_1_5.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 15));
		btnNewButton_1_1_5.setBounds(464, 384, 150, 50);
		panel_1.add(btnNewButton_1_1_5);
		
		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon(sanPhamAdd.class.getResource("/photo/sp-6.jpg")));
		lblNewLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel.setBounds(637, 100, 150, 150);
		panel_1.add(lblNewLabel);
		
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
		
	}

	public sanPhamAdd(String masp) {
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
		
		JLabel lblNewLabel_1 = new JLabel("Mã SP");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(62, 50, 100, 35);
		panel_1.add(lblNewLabel_1);
		
		textField = new RoundJTextField(15);
		textField.setText(masp);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(200, 50, 250, 35);
		panel_1.add(textField);
		
		textField_1 = new RoundJTextField(15);
		textField_1.setColumns(10);
		textField_1.setBounds(200, 100, 250, 35);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sp");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(62, 100, 100, 35);
		panel_1.add(lblNewLabel_1_1);
		
		textField_2 = new RoundJTextField(15);
		textField_2.setColumns(10);
		textField_2.setBounds(200, 150, 250, 35);
		panel_1.add(textField_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Loại");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(62, 150, 100, 35);
		panel_1.add(lblNewLabel_1_2);
		
		textField_3 = new RoundJTextField(15);
		textField_3.setColumns(10);
		textField_3.setBounds(200, 200, 250, 35);
		panel_1.add(textField_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Đơn vị tính");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(49, 200, 113, 35);
		panel_1.add(lblNewLabel_1_3);
		
		textField_4 = new RoundJTextField(15);
		textField_4.setColumns(10);
		textField_4.setBounds(200, 250, 250, 35);
		panel_1.add(textField_4);
		
		JLabel lblNewLabel_1_4 = new JLabel("Đơn giá");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(62, 250, 100, 35);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Số lượng\r\n");
		lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4_1.setFont(new Font("Open Sans ExtraBold", Font.PLAIN, 20));
		lblNewLabel_1_4_1.setBounds(62, 300, 100, 35);
		panel_1.add(lblNewLabel_1_4_1);
		
		textField_5 = new RoundJTextField(15);
		textField_5.setColumns(10);
		textField_5.setBounds(200, 300, 250, 35);
		panel_1.add(textField_5);
		
		JButton btnNewButton_1 = new JButton("Chọn ảnh");
		btnNewButton_1.setBackground(SystemColor.text);
		btnNewButton_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 15));
		btnNewButton_1.setBounds(650, 270, 125, 40);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Cập nhật");
		btnNewButton_1_1_1.setBackground(SystemColor.text);
		btnNewButton_1_1_1.setIcon(new ImageIcon("E:\\Picrure AT\\iconjava\\save.jpg"));
		btnNewButton_1_1_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 15));
		btnNewButton_1_1_1.setBounds(220, 384, 150, 50);
		panel_1.add(btnNewButton_1_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel.setBounds(637, 100, 150, 150);
		panel_1.add(lblNewLabel);
		
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
