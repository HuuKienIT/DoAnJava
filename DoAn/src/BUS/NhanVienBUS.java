package BUS;

import javax.swing.JOptionPane;

import model.NhanVienModel;
import model.SanPhamModel;

public class NhanVienBUS {
	public static boolean addNV(String hotennv,int gt,String ngaysinh,String taikhoan,String matkhau,String email,String sdt,String photo,String chucvu) {
		NhanVienModel nv = new NhanVienModel();
		nv.setHoTen(hotennv);
		nv.setNamSinh(ngaysinh);
		nv.setGioiTinh(gt);
		nv.setTaiKhoan(taikhoan);
		nv.setMatKhau(matkhau);
		nv.setSoDth(sdt);
		nv.setChucVu(chucvu);
		nv.setEmail(email);
		nv.setPhoto(photo);
		int ktra=DAO.NhanVienDAO.themUsers(nv);
		if(ktra!=-1) {
			JOptionPane.showMessageDialog(null,"Thêm nhân viên thành công");
			return true;
		}else {
			JOptionPane.showMessageDialog(null,"Thêm nhân viên thất bại");
			return false;
		}
	}

	public static boolean updateNV(int idnv,String hotennv,int gt,String ngaysinh,String taikhoan,String matkhau,String email,String sdt,String photo,String chucvu) {
		NhanVienModel nv = new NhanVienModel();
		nv.setHoTen(hotennv);
		nv.setNamSinh(ngaysinh);
		nv.setGioiTinh(gt);
		nv.setTaiKhoan(taikhoan);
		nv.setMatKhau(matkhau);
		nv.setSoDth(sdt);
		nv.setChucVu(chucvu);
		nv.setEmail(email);
		nv.setPhoto(photo);
		int ktra=DAO.NhanVienDAO.chinhSuaUsers(idnv,nv);
		if(ktra!=-1) {
			JOptionPane.showMessageDialog(null,"Sửa nhân viên thành công");
			return true;
		}else {
			JOptionPane.showMessageDialog(null,"Sửa nhân viên thất bại");
			return false;
		}	
	}
}
