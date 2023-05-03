package BUS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.NhanHieuModel;
import model.SanPhamModel;

public class NhanHieuBUS {
	public static boolean addNH(String tennh) {
		NhanHieuModel nh = new NhanHieuModel();
		nh.setTen_nh(tennh);
		int ktra=DAO.NhanHieuDAO.themNhanHieu(nh);
		if(ktra!=-1) {
			JOptionPane.showMessageDialog(null,"Thêm nhãn hiệu thành công");
			return true;
		}else {
			JOptionPane.showMessageDialog(null,"Thêm nhãn hiệu thất bại");
			return false;
		}
	}

	public static boolean updateNH(int idnh,String tennh) {
		NhanHieuModel nh = new NhanHieuModel();
		nh.setId_nh(idnh);
		nh.setTen_nh(tennh);
		int ktra=DAO.NhanHieuDAO.suaNhanHieu(nh);
		if(ktra!=-1) {
			JOptionPane.showMessageDialog(null,"Sửa nhãn hiệu thành công");
			return true;
		}else {
			JOptionPane.showMessageDialog(null,"Sửa nhãn hiệu thất bại");
			return false;
		}	
	}
	public static void xuatExcel(ArrayList<NhanHieuModel> ds) throws IOException {
		try {
			XSSFWorkbook wb =new XSSFWorkbook();
			XSSFSheet sheet= wb.createSheet("NhanHieu");
			FileOutputStream fileOut;
			fileOut = new FileOutputStream("NhanHieuXuat.xlsx");
			Row rowhead=sheet.createRow(0);
			rowhead.createCell(0).setCellValue("ID Nhãn Hiệu");
			rowhead.createCell(1).setCellValue("Nhãn Hiệu");
			int r=1;
			for (NhanHieuModel nh  : ds) {
				int c=0;
				Row rh=sheet.createRow(r++);
				rh.createCell(c++).setCellValue(nh.getId_nh());
				rh.createCell(c++).setCellValue(nh.getTen_nh());
			}		
			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			wb.write(fileOut);
			fileOut.close();
			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void nhapExcel() throws IOException {
		File file = new File("NhanHieuNhap.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis); 
		XSSFSheet sheet = wb.getSheetAt(0);
		Row row;
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			row=sheet.getRow(i);
			String name = row.getCell(0).getStringCellValue();
			NhanHieuModel nh = new NhanHieuModel();
			nh.setTen_nh(name);
			DAO.NhanHieuDAO.themNhanHieu(nh);
		}
		wb.close();
	}
}
