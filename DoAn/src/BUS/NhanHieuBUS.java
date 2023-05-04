package BUS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.NhanHieuModel;
import model.SanPhamModel;

public class NhanHieuBUS {
	public static boolean addNH(String tennh) {
		NhanHieuModel nh = new NhanHieuModel();
		nh.setTen_nh(tennh);
		int ktra = DAO.NhanHieuDAO.themNhanHieu(nh);
		if (ktra != -1) {
			JOptionPane.showMessageDialog(null, "Thêm nhãn hiệu thành công");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Thêm nhãn hiệu thất bại");
			return false;
		}
	}

	public static boolean updateNH(int idnh, String tennh) {
		NhanHieuModel nh = new NhanHieuModel();
		nh.setId_nh(idnh);
		nh.setTen_nh(tennh);
		int ktra = DAO.NhanHieuDAO.suaNhanHieu(nh);
		if (ktra != -1) {
			JOptionPane.showMessageDialog(null, "Sửa nhãn hiệu thành công");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Sửa nhãn hiệu thất bại");
			return false;
		}
	}

	public static void xuatExcel(ArrayList<NhanHieuModel> ds) throws IOException {
		JFrame parentFrame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");
		fileChooser.setFileFilter(new FileNameExtensionFilter(".xlsx", "Microsoft Excel Documents"));
		fileChooser.setSelectedFile(new File("NhanHieuXuat.xlsx"));
		int userSelection = fileChooser.showSaveDialog(parentFrame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("NhanHieu");
			FileOutputStream fileOut;
			fileOut = new FileOutputStream(fileToSave);
			Row rowhead = sheet.createRow(0);
			rowhead.createCell(0).setCellValue("ID Nhãn Hiệu");
			rowhead.createCell(1).setCellValue("Nhãn Hiệu");
			int r = 1;
			for (NhanHieuModel nh : ds) {
				int c = 0;
				Row rh = sheet.createRow(r++);
				rh.createCell(c++).setCellValue(nh.getId_nh());
				rh.createCell(c++).setCellValue(nh.getTen_nh());
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
					String name = row.getCell(0).getStringCellValue();
					NhanHieuModel nh = new NhanHieuModel();
					nh.setTen_nh(name);
					DAO.NhanHieuDAO.themNhanHieu(nh);
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
}
