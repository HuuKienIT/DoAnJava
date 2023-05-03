package BUS;

import javax.swing.JOptionPane;

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
}
