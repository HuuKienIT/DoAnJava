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

import model.KhachHangModel;

public class KhachHangBUS {
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
					KhachHangModel kh = new KhachHangModel();
					kh.setTenkh(row.getCell(0).getStringCellValue());
					kh.setEmail(row.getCell(1).getStringCellValue());
					kh.setSodth(Integer.parseInt(row.getCell(2).getStringCellValue()));
					kh.setDiemtl(0);
//					KhachHangDAO.
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
		ArrayList<KhachHangModel> ds = DAO.KhachHangDAO.getAllKH();
		JFrame parentFrame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");
		fileChooser.setFileFilter(new FileNameExtensionFilter(".xlsx", "Microsoft Excel Documents"));
		fileChooser.setSelectedFile(new File("KhachHangXuat.xlsx"));
		int userSelection = fileChooser.showSaveDialog(parentFrame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("NhanVien");
			FileOutputStream fileOut;
			fileOut = new FileOutputStream(fileToSave);
			Row rowhead = sheet.createRow(0);
			rowhead.createCell(0).setCellValue("ID kh");
			rowhead.createCell(1).setCellValue("Ho Ten");
			rowhead.createCell(2).setCellValue("Email");
			rowhead.createCell(3).setCellValue("Số điện thoại");
			rowhead.createCell(4).setCellValue("Điểm");
			int r = 1;
			for (KhachHangModel nv : ds) {
				int c = 0;
				Row rh = sheet.createRow(r++);
				rh.createCell(c++).setCellValue(nv.getId_kh());
				rh.createCell(c++).setCellValue(nv.getTenkh());
				rh.createCell(c++).setCellValue(nv.getEmail());
				rh.createCell(c++).setCellValue(nv.getSodth());
				rh.createCell(c++).setCellValue(nv.getDiemtl());
			}
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
	public static void FielExcelMau() throws IOException {
		ArrayList<KhachHangModel> ds = DAO.KhachHangDAO.getAllKH();
		JFrame parentFrame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");
		fileChooser.setFileFilter(new FileNameExtensionFilter(".xlsx", "Microsoft Excel Documents"));
		fileChooser.setSelectedFile(new File("KhachHangMau.xlsx"));
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
			rowhead.createCell(4).setCellValue("Điểm");

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
