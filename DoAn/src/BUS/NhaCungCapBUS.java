package BUS;

import javax.swing.JOptionPane;

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

}
