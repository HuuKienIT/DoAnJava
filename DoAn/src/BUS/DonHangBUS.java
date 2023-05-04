package BUS;

import java.io.File;
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
import model.NhanVienModel;

public class DonHangBUS {
	public static void xuatExcel() throws IOException {
		ArrayList<DonHangModel> ds = DAO.DonHangDAO.getAllDonHang();
		JFrame parentFrame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");
		fileChooser.setFileFilter(new FileNameExtensionFilter(".xlsx", "Microsoft Excel Documents"));
		fileChooser.setSelectedFile(new File("DonHang.xlsx"));
		int userSelection = fileChooser.showSaveDialog(parentFrame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("DonHang");
			FileOutputStream fileOut;
			fileOut = new FileOutputStream(fileToSave);
			Row rowhead = sheet.createRow(0);
			rowhead.createCell(0).setCellValue("ID Đơn Hàng");
			rowhead.createCell(1).setCellValue("Nhân Viên");
			rowhead.createCell(2).setCellValue("Khách Hàng");
			rowhead.createCell(3).setCellValue("Ngày Xuất");
			rowhead.createCell(4).setCellValue("Tổng Số Lượng");
			rowhead.createCell(5).setCellValue("Tổng Tiền");
			int r = 1;
			for (DonHangModel dh : ds) {
				NhanVienModel nv = DAO.NhanVienDAO.getUsersByID(dh.getId_nv());
				KhachHangModel kh = DAO.KhachHangDAO.getKhachHangByid(dh.getId_kh());
				int c = 0;
				Row rh = sheet.createRow(r++);
				rh.createCell(c++).setCellValue(dh.getId_dh());
				rh.createCell(c++).setCellValue(nv.getId_nv() + " - " + nv.getHoTen());
				rh.createCell(c++).setCellValue(kh.getId_kh()+" - "+kh.getTenkh());
				rh.createCell(c++).setCellValue(dh.getNgayban()+"");
				rh.createCell(c++).setCellValue(dh.getTongsl());
				rh.createCell(c++).setCellValue(dh.getTongtien());
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
