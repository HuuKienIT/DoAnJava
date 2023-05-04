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

import model.DonHangModel;
import model.KhachHangModel;
import model.NhanHieuModel;
import model.NhanVienModel;
import model.SanPhamModel;

public class SanPhamBUS {
	public static boolean addSP(String masp, String tensp, String manh, int gia, String tenfile) {
		SanPhamModel sp = new SanPhamModel();
		sp.setId_sp(DAO.SanPhamDAO.demTongSoSP() + 1);
		sp.setMasp(masp);
		sp.setTensp(tensp);
		sp.setManh(manh);
		sp.setGia(gia);
		sp.setConlai(0);
		sp.setPhoto(tenfile);
		int ktra=DAO.SanPhamDAO.themSanPham(sp);
		if(ktra!=-1) {
			JOptionPane.showMessageDialog(null,"Thêm sản phẩm thành công");
			return true;
		}else {
			JOptionPane.showMessageDialog(null,"Thêm sản phẩm thất bại");
			return false;
		}
	}

	public static boolean updateSP(String masp, String tensp, String manh, int gia, String tenfile) {
		SanPhamModel sp = new SanPhamModel();
		sp.setMasp(masp);
		sp.setTensp(tensp);
		sp.setManh(manh);
		sp.setGia(gia);
		sp.setPhoto(tenfile);
		int ktra=DAO.SanPhamDAO.suaSanPham(sp);
		if(ktra!=-1) {
			JOptionPane.showMessageDialog(null,"Sửa sản phẩm thành công");
			return true;
		}else {
			JOptionPane.showMessageDialog(null,"Sửa sản phẩm thất bại");
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
					String name = row.getCell(0).getStringCellValue();
					String nhanhieu = row.getCell(1).getStringCellValue();
					int  gia = Integer.parseInt(row.getCell(2).getStringCellValue()) ;
					SanPhamModel sp = new SanPhamModel();
					sp.setTensp(name);
					sp.setGia(gia);
					sp.setNhanhieu(nhanhieu);
					DAO.SanPhamDAO.themSanPham(sp);
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
		ArrayList<SanPhamModel> ds = DAO.SanPhamDAO.getAllSanPham();
		JFrame parentFrame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");
		fileChooser.setFileFilter(new FileNameExtensionFilter(".xlsx", "Microsoft Excel Documents"));
		fileChooser.setSelectedFile(new File("SanPham.xlsx"));
		int userSelection = fileChooser.showSaveDialog(parentFrame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("SanPham");
			FileOutputStream fileOut;
			fileOut = new FileOutputStream(fileToSave);
			Row rowhead = sheet.createRow(0);
			rowhead.createCell(0).setCellValue("ID Sản Phẩm");
			rowhead.createCell(1).setCellValue("Tên Sản Phẩm");
			rowhead.createCell(2).setCellValue("Nhãn Hiệu");
			rowhead.createCell(3).setCellValue("Giá");
			rowhead.createCell(4).setCellValue("Số lượng còn lại");
			rowhead.createCell(5).setCellValue("Hình ảnh");
			int r = 1;
			for (SanPhamModel sp : ds) {
				int c = 0;
				Row rh = sheet.createRow(r++);
				rh.createCell(c++).setCellValue(sp.getId_sp());
				rh.createCell(c++).setCellValue(sp.getTensp());
				rh.createCell(c++).setCellValue(sp.getNhanhieu());
				rh.createCell(c++).setCellValue(sp.getGia());
				rh.createCell(c++).setCellValue(sp.getConlai());
				rh.createCell(c++).setCellValue(sp.getPhoto());
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
}
