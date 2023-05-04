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
import model.NhaCungCapModel;
import model.NhanHieuModel;
import model.NhanVienModel;
import model.PhieuNhapModel;

public class PhieuNhapBUS {
	public static void xuatExcel() throws IOException {
		ArrayList<PhieuNhapModel> ds = DAO.PhieuNhapDAO.getAllPhieuNhap();
		JFrame parentFrame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");
		fileChooser.setFileFilter(new FileNameExtensionFilter(".xlsx", "Microsoft Excel Documents"));
		fileChooser.setSelectedFile(new File("PhieuNhap.xlsx"));
		int userSelection = fileChooser.showSaveDialog(parentFrame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("PhieuNhap");
			FileOutputStream fileOut;
			fileOut = new FileOutputStream(fileToSave);
			Row rowhead = sheet.createRow(0);
			rowhead.createCell(0).setCellValue("ID Phiếu Nhập");
			rowhead.createCell(1).setCellValue("Nhân Viên");
			rowhead.createCell(2).setCellValue("Nhà Cung Cấp");
			rowhead.createCell(3).setCellValue("Ngày nhập");
			rowhead.createCell(4).setCellValue("Tổng Số Lượng");
			rowhead.createCell(5).setCellValue("Tổng Tiền");
			int r = 1;
			for (PhieuNhapModel pn : ds) {
				NhanVienModel nv = DAO.NhanVienDAO.getUsersByID(pn.getId_nv());
				NhaCungCapModel ncc = DAO.NhaCungCapDAO.getNCCByID(pn.getId_ncc());
				int c = 0;
				Row rh = sheet.createRow(r++);
				rh.createCell(c++).setCellValue(pn.getId_pn());
				rh.createCell(c++).setCellValue(nv.getId_nv()+" - "+nv.getHoTen());
				rh.createCell(c++).setCellValue(ncc.getId_ncc()+" - "+ ncc.getTen_ncc());
				rh.createCell(c++).setCellValue(pn.getNgaynhap()+"");
				rh.createCell(c++).setCellValue(pn.getTongsl());
				rh.createCell(c++).setCellValue(pn.getTongtien());
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
