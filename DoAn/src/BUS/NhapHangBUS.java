package BUS;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.CTDonHangModel;
import model.CTPhieuNhapModel;
import model.NhanVienModel;
import model.SanPhamGHModel;
import model.SanPhamModel;

public class NhapHangBUS {
	public static void NhapHang(ArrayList<SanPhamGHModel> GH, NhanVienModel nv, int tongsl, int tongtien, int id_ncc) {

		model.PhieuNhapModel pn = new model.PhieuNhapModel();
		pn.setId_nv(nv.getId_nv());
		pn.setId_ncc(id_ncc);// Integer.parseInt(txtID_KH.getText())
		pn.setTongsl(tongsl);
		pn.setTongtien(tongtien);
		DAO.PhieuNhapDAO.themPhieuNhap(pn);
		for (SanPhamGHModel u : GH) {
			CTPhieuNhapModel ctpn = new CTPhieuNhapModel();
			ctpn.setId_sp(u.getId_sp());
			ctpn.setSoluong(u.getSoluong());
			ctpn.setGia(u.getGia());
			DAO.CTPhieuNhapDAO.themCTPhieuNhap(ctpn);
		}
	}

	public static void XuatDonHang(ArrayList<SanPhamGHModel> GH, NhanVienModel nv, int tongsl, int tongtien) {
		model.DonHangModel dh = new model.DonHangModel();
		dh.setId_nv(nv.getId_nv());
		dh.setTongsl(tongsl);//
		dh.setTongtien(tongtien);
		DAO.DonHangDAO.themDonHang(dh);
		for (SanPhamGHModel u : GH) {
			CTDonHangModel ctdh = new CTDonHangModel();
			ctdh.setId_sp(u.getId_sp());
			ctdh.setSoluong(u.getSoluong());
			ctdh.setGia(u.getGia());
			DAO.CTDonHangDAO.themCTDonHang(ctdh);
		}
	}

	public static ArrayList<SanPhamGHModel> xoaGH(ArrayList<SanPhamGHModel> GH, String ma_sp) {
		int co = 0;
		for (SanPhamGHModel sp : GH) {
			if (sp.getMasp().equals(ma_sp)) {
				int output = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "",
						JOptionPane.YES_NO_OPTION);
				if (output == JOptionPane.YES_OPTION) {
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
			String ma_sp, int soluong) {
		boolean co = false;
		for (SanPhamGHModel spc : GH) {
			if (spc.getMasp().equals(ma_sp)) {
				co = true;
				spc.setSoluong(spc.getSoluong() + soluong);
			}
		}
		if (!co) {
			for (SanPhamModel s : sp) {
				if (s.getMasp().equals(ma_sp)) {
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

}
