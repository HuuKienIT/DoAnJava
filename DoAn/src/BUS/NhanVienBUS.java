package BUS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.NhanVienModel;
import model.NhanVienModel;

public class NhanVienBUS {
	public static boolean addNV(String hotennv,int gt,String ngaysinh,String taikhoan,String matkhau,String email,String sdt,String photo,String chucvu) {
		NhanVienModel nv = new NhanVienModel();
		nv.setHoTen(hotennv);
		nv.setNamSinh(ngaysinh);
		nv.setGioiTinh(gt);
		nv.setTaiKhoan(taikhoan);
		nv.setMatKhau(matkhau);
		nv.setSoDth(sdt);
		nv.setChucVu(chucvu);
		nv.setEmail(email);
		nv.setPhoto(photo);
		int ktra=DAO.NhanVienDAO.themUsers(nv);
		if(ktra!=-1) {
			JOptionPane.showMessageDialog(null,"Thêm nhân viên thành công");
			return true;
		}else {
			JOptionPane.showMessageDialog(null,"Thêm nhân viên thất bại");
			return false;
		}
	}

	public static boolean updateNV(int idnv,String hotennv,int gt,String ngaysinh,String taikhoan,String matkhau,String email,String sdt,String photo,String chucvu) {
		NhanVienModel nv = new NhanVienModel();
		nv.setHoTen(hotennv);
		nv.setNamSinh(ngaysinh);
		nv.setGioiTinh(gt);
		nv.setTaiKhoan(taikhoan);
		nv.setMatKhau(matkhau);
		nv.setSoDth(sdt);
		nv.setChucVu(chucvu);
		nv.setEmail(email);
		nv.setPhoto(photo);
		int ktra=DAO.NhanVienDAO.chinhSuaUsers(idnv,nv);
		if(ktra!=-1) {
			JOptionPane.showMessageDialog(null,"Sửa nhân viên thành công");
			return true;
		}else {
			JOptionPane.showMessageDialog(null,"Sửa nhân viên thất bại");
			return false;
		}	
	}
	public static void nhapExcel() throws IOException {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter(".xlsx", "Microsoft Excel Documents"));
		int returnValue = fileChooser.showOpenDialog(null);
		String fileUrl = null;
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			try {
				FileInputStream fis = new FileInputStream(selectedFile);
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sheet = wb.getSheetAt(0);
				Row row;
				for (int i = 1; i <= sheet.getLastRowNum(); i++) {
					row = sheet.getRow(i);
					NhanVienModel nv = new NhanVienModel();
					nv.setHoTen(row.getCell(0).getStringCellValue());
					nv.setEmail(row.getCell(1).getStringCellValue());
					nv.setSoDth(row.getCell(2).getStringCellValue());
					nv.setTaiKhoan(row.getCell(3).getStringCellValue());
					nv.setMatKhau(row.getCell(4).getStringCellValue());
					DAO.NhanVienDAO.themUsers(nv);
				}
				wb.close();
				JOptionPane.showMessageDialog(null, "Nhập thành công");
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Nhập thất bại");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Nhập thất bại");
		}

	}
	public static void xuatExcel() throws IOException {
		ArrayList<NhanVienModel> ds = DAO.NhanVienDAO.getAllUsers();
		JFrame parentFrame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");
		fileChooser.setFileFilter(new FileNameExtensionFilter(".xlsx", "Microsoft Excel Documents"));
		fileChooser.setSelectedFile(new File("NhanVienXuat.xlsx"));
		int userSelection = fileChooser.showSaveDialog(parentFrame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("NhanVien");
			FileOutputStream fileOut;
			fileOut = new FileOutputStream(fileToSave);
			Row rowhead = sheet.createRow(0);
			rowhead.createCell(0).setCellValue("ID nv");
			rowhead.createCell(1).setCellValue("Ho Ten");
			rowhead.createCell(2).setCellValue("Email");
			rowhead.createCell(3).setCellValue("Số điện thoại");
			rowhead.createCell(4).setCellValue("Tài Khoản");
			rowhead.createCell(5).setCellValue("Mật Khẩu");
			int r = 1;
			for (NhanVienModel nv : ds) {
				int c = 0;
				Row rh = sheet.createRow(r++);
				rh.createCell(c++).setCellValue(nv.getId_nv());
				rh.createCell(c++).setCellValue(nv.getHoTen());
				rh.createCell(c++).setCellValue(nv.getEmail());
				rh.createCell(c++).setCellValue(nv.getSoDth());
				rh.createCell(c++).setCellValue(nv.getTaiKhoan());
				rh.createCell(c++).setCellValue(nv.getMatKhau());
			}
			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);
			sheet.autoSizeColumn(4);
			sheet.autoSizeColumn(5);
			wb.write(fileOut);
			fileOut.close();
			wb.close();
			JOptionPane.showMessageDialog(null, "Xuất File thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Xuất File thất bại");
		}
	}
	public static void FielExcelMau() throws IOException {
		ArrayList<NhanVienModel> ds = DAO.NhanVienDAO.getAllUsers();
		JFrame parentFrame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");
		fileChooser.setFileFilter(new FileNameExtensionFilter(".xlsx", "Microsoft Excel Documents"));
		fileChooser.setSelectedFile(new File("NhanVienMau.xlsx"));
		int userSelection = fileChooser.showSaveDialog(parentFrame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("NhanVien");
			FileOutputStream fileOut;
			fileOut = new FileOutputStream(fileToSave);
			Row rowhead = sheet.createRow(0);
			rowhead.createCell(1).setCellValue("Ho Ten");
			rowhead.createCell(2).setCellValue("Email");
			rowhead.createCell(3).setCellValue("Số điện thoại");
			rowhead.createCell(4).setCellValue("Tài Khoản");
			rowhead.createCell(5).setCellValue("Mật Khẩu");

			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);
			sheet.autoSizeColumn(4);
			wb.write(fileOut);
			fileOut.close();
			wb.close();
			JOptionPane.showMessageDialog(null, "Xuất File thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Xuất File thất bại");
		}
	}
}
