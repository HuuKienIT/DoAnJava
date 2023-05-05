package BUS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.CTDonHangModel;
import model.DonHangModel;
import model.KhachHangModel;
import model.NhanVienModel;
import model.SanPhamGHModel;
import model.SanPhamModel;

public class BanHangBUS {
	public static void XuatDonHang(ArrayList<SanPhamGHModel> GH, NhanVienModel nv, int tongsl, int tongtien, int id_kh,
			int sd) {
		if (sd == 1 && DAO.KhachHangDAO.layDiem(id_kh) != 0) {
			Float giam = (float) (DAO.KhachHangDAO.layDiem(id_kh)*1.0 / 100);
			tongtien = Math.round(tongtien-tongtien * giam);
			DAO.KhachHangDAO.truDiem(id_kh);
		}
		DAO.KhachHangDAO.tangDiem(id_kh, tongtien / 1000000);
		model.DonHangModel dh = new model.DonHangModel();
		dh.setId_nv(nv.getId_nv());
		dh.setId_kh(id_kh);
		dh.setTongsl(tongsl);//
		dh.setTongtien(tongtien);
		DAO.DonHangDAO.themDonHang(dh);
		for (SanPhamGHModel u : GH) {
			CTDonHangModel ctdh = new CTDonHangModel();
			ctdh.setId_sp(u.getId_sp());
			ctdh.setSoluong(u.getSoluong());
			DAO.SanPhamDAO.giamSoLuong(u.getId_sp(), u.getSoluong());
			ctdh.setGia(u.getGia());
			DAO.CTDonHangDAO.themCTDonHang(ctdh);
		}
		int output = JOptionPane.showConfirmDialog(null, "Bạn có muốn xuất ra File không?", "",
				JOptionPane.YES_NO_OPTION);
		if (output == JOptionPane.YES_OPTION) {
			try {
				xuatPDF(DAO.DonHangDAO.layIDcuoi());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}

	}

	public static ArrayList<SanPhamGHModel> xoaGH(ArrayList<SanPhamModel> sp1, ArrayList<SanPhamGHModel> GH,
			int id_sp) {
		int co = 0;
		for (SanPhamGHModel sp : GH) {
			if (sp.getId_sp() == id_sp) {
				int output = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "",
						JOptionPane.YES_NO_OPTION);
				if (output == JOptionPane.YES_OPTION) {
					for (SanPhamModel s : sp1) {
						if (s.getId_sp() == id_sp) {
							s.setConlai(s.getConlai() + sp.getSoluong());
						}
					}
					GH.remove(sp);
				}
				co = 1;
				break;
			}
		}
		if (co == 0) {
			JOptionPane.showMessageDialog(null, "Sản phẩm không tồn tại trong giỏ hàng");
		}
		return GH;
	}

	public static ArrayList<SanPhamGHModel> themGioHang(ArrayList<SanPhamModel> sp, ArrayList<SanPhamGHModel> GH,
			int id_sp, int soluong) {
		boolean co = false;
		for (SanPhamModel s : sp) {
			if (s.getConlai() < soluong && s.getId_sp() == id_sp) {
				JOptionPane.showMessageDialog(null, "Không đủ sản phẩm");
				return GH;
			}
		}
		for (SanPhamModel s : sp) {
			if (s.getId_sp() == id_sp) {
				s.setConlai(s.getConlai() - soluong);
			}
		}
		for (SanPhamGHModel spc : GH) {
			if (spc.getId_sp() == id_sp) {
				co = true;
				spc.setSoluong(spc.getSoluong() + soluong);
			}
		}
		if (!co) {
			for (SanPhamModel s : sp) {
				if (s.getId_sp() == id_sp) {
					SanPhamGHModel sp1 = new SanPhamGHModel();
					sp1.setId_sp(s.getId_sp());
					sp1.setMasp(s.getMasp());
					sp1.setTensp(s.getTensp());
					sp1.setNhanhieu(s.getNhanhieu());
					sp1.setGia(s.getGia());
					sp1.setSoluong(soluong);
					GH.add(sp1);
					break;
				}
			}
		}
		return GH;
	}

	public static ArrayList<SanPhamModel> TimKiem(ArrayList<SanPhamModel> sp, String txtKiem, String nhanHieu,
			String Min, String Max) {
		ArrayList<SanPhamModel> spLoc = new ArrayList<SanPhamModel>();
		String tenSP = txtKiem; // txtKiem.getText()
		if (tenSP.equals("Nhập tên Sản Phẩm")) {
			tenSP = "";
		}
		if (nhanHieu.equals("Tất cả Nhãn Hiệu")) {
			nhanHieu = "";
		}
		int giaMin = 0;
		if (!Min.equals("")) {
			giaMin = Integer.parseInt(Min);
		}
		int giaMax = 10000000;
		if (!Max.equals("")) {
			giaMax = Integer.parseInt(Max);
		}
		if (giaMin > giaMax) {
			return spLoc;
		}
		for (SanPhamModel sp1 : sp) {

			if (sp1.getTensp().toLowerCase().contains(tenSP.toLowerCase())
					&& sp1.getNhanhieu().toLowerCase().contains(nhanHieu.toLowerCase()) && sp1.getGia() >= giaMin
					&& sp1.getGia() <= giaMax) {
				spLoc.add(sp1);

			}
		}
		return spLoc;
	}

	public static void xuatPDF(int id_dh) throws FileNotFoundException, DocumentException {

		JFrame parentFrame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");
		fileChooser.setFileFilter(new FileNameExtensionFilter(".pdf", "Portable Document Format"));
		fileChooser.setSelectedFile(new File("HoaDon-"+ id_dh +".pdf"));
		int userSelection = fileChooser.showSaveDialog(parentFrame);
		File fileToSave = null;
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			fileToSave = fileChooser.getSelectedFile();
		}
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(fileToSave));

		document.open();
		DonHangModel dh = DAO.DonHangDAO.getDonHangByID(id_dh);
		NhanVienModel nv = DAO.NhanVienDAO.getUsersByID(dh.getId_nv());
		KhachHangModel kh = DAO.KhachHangDAO.getKhachHangByid(dh.getId_kh());
		// add title and date
		Paragraph id_dh1 = new Paragraph("Ma Hoa Don: " + dh.getId_dh());
		Paragraph KhachHang = new Paragraph("Khach Hang: " + dh.getId_kh() + "-" + kh.getTenkh());
		Paragraph NhanVien = new Paragraph("Nhan Vien : " + dh.getId_nv() + "-" + nv.getHoTen());
		Paragraph date = new Paragraph("Date: " + dh.getNgayban() + "");
		Paragraph tongsl = new Paragraph("Tong So Luong: " + dh.getTongsl());
		Paragraph tongtien = new Paragraph("Tong Tien: " + intToMoney(dh.getTongtien()));
		Paragraph trong = new Paragraph("  ");
		document.add(id_dh1);
		document.add(KhachHang);
		document.add(NhanVien);
		document.add(date);
		document.add(tongsl);
		document.add(tongtien);
		document.add(trong);

		PdfPTable table = new PdfPTable(new float[] { 1, 1, 1, 1 });
		table.addCell("STT");
		table.addCell("San Pham");
		table.addCell("So Luong");
		table.addCell("Gia Tien");
		int dem = 1;
		for (CTDonHangModel ctdh : DAO.CTDonHangDAO.getCTDonHangByID(id_dh)) {
			table.addCell(dem + "");
			dem++;
			table.addCell(ctdh.getId_sp() + "-" + DAO.SanPhamDAO.getTenSanPhamByIdSP(ctdh.getId_sp()));
			table.addCell(ctdh.getSoluong() + "");
			table.addCell(intToMoney(ctdh.getGia()));
		}
		document.add(table);
		document.close();
	}

	public static String intToMoney(int value) {
		Locale locale = new Locale("vi", "VN");
		Currency currency = Currency.getInstance("VND");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		currencyFormatter.setCurrency(currency);
		return currencyFormatter.format(value);
	}

}
