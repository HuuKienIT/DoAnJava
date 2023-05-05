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

import model.NhaCungCapModel;
import model.NhaCungCapModel;

public class NhaCungCapBUS {

	public static boolean addNCC(int idncc, String tenncc, String sdt, String email) {
		NhaCungCapModel ncc = new NhaCungCapModel();
		ncc.setId_ncc(idncc);
		ncc.setTen_ncc(tenncc);
		ncc.setEmail(email);
		ncc.setSodth(sdt);
		int ktra = DAO.NhaCungCapDAO.themNCC(ncc);
		if (ktra != -1) {
			JOptionPane.showMessageDialog(null, "Thêm nhà cung cấp thành công");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Thêm nhà cung cấp thất bại");
			return false;
		}
	}

	public static boolean updateNCC(int idncc, String tenncc, String sdt, String email) {
		NhaCungCapModel ncc = new NhaCungCapModel();
		ncc.setId_ncc(idncc);
		ncc.setTen_ncc(tenncc);
		ncc.setEmail(email);
		ncc.setSodth(sdt);
		int ktra = DAO.NhaCungCapDAO.suaNCC(ncc);
		if (ktra != -1) {
			JOptionPane.showMessageDialog(null, "Sửa nhà cung cấp thành công");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Sửa nhà cung cấp thất bại");
			return false;
		}
	}
	public static void xuatExcel() throws IOException {
		JFrame parentFrame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");
		fileChooser.setFileFilter(new FileNameExtensionFilter(".xlsx", "Microsoft Excel Documents"));
		fileChooser.setSelectedFile(new File("NNhaCungCapXuat.xlsx"));
		int userSelection = fileChooser.showSaveDialog(parentFrame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("NhaCungCap");
			FileOutputStream fileOut;
			fileOut = new FileOutputStream(fileToSave);
			Row rowhead = sheet.createRow(0);
			rowhead.createCell(0).setCellValue("ID ncc");
			rowhead.createCell(1).setCellValue("Tên Nhà Cung Cấp");
			rowhead.createCell(1).setCellValue("Email");
			rowhead.createCell(1).setCellValue("Số đth");
			int r = 1;
			for (NhaCungCapModel ncc  : DAO.NhaCungCapDAO.getAllNCC()) {
				int c = 0;
				Row rh = sheet.createRow(r++);
				rh.createCell(c++).setCellValue(ncc.getId_ncc());
				rh.createCell(c++).setCellValue(ncc.getTen_ncc());
				rh.createCell(c++).setCellValue(ncc.getEmail());
				rh.createCell(c++).setCellValue(ncc.getSDT());
			}
			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			wb.write(fileOut);
			fileOut.close();
			wb.close();
			JOptionPane.showMessageDialog(null, "Xuất File thành công");
		}else {
			JOptionPane.showMessageDialog(null, "Xuất File thất bại");
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
					NhaCungCapModel ncc = new NhaCungCapModel();
					ncc.setTen_ncc(row.getCell(0).getStringCellValue());
					ncc.setSodth(row.getCell(1).getStringCellValue());
					ncc.setEmail(row.getCell(2).getStringCellValue());
					DAO.NhaCungCapDAO.themNCC(ncc);
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
	public static void LayMauExcel() throws IOException {
		JFrame parentFrame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");
		fileChooser.setFileFilter(new FileNameExtensionFilter(".xlsx", "Microsoft Excel Documents"));
		fileChooser.setSelectedFile(new File("NNhaCungCapMau.xlsx"));
		int userSelection = fileChooser.showSaveDialog(parentFrame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("NhaCungCap");
			FileOutputStream fileOut;
			fileOut = new FileOutputStream(fileToSave);
			Row rowhead = sheet.createRow(0);
			rowhead.createCell(1).setCellValue("Tên Nhà Cung Cấp");
			rowhead.createCell(1).setCellValue("Email");
			rowhead.createCell(1).setCellValue("Số đth");
			
			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			wb.write(fileOut);
			fileOut.close();
			wb.close();
			JOptionPane.showMessageDialog(null, "Xuất File thành công");
		}else {
			JOptionPane.showMessageDialog(null, "Xuất File thất bại");
		}
	}

}
