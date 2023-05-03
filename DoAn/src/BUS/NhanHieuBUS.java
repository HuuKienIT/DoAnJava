package BUS;

import javax.swing.JOptionPane;

import model.NhanHieuModel;
import model.SanPhamModel;

public class NhanHieuBUS {
	public static boolean addNH(int idnh,String tennh) {
		NhanHieuModel nh = new NhanHieuModel();
		nh.setId_nh(idnh);
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
}
