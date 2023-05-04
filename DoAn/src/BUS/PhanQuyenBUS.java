package BUS;

import java.util.ArrayList;

import model.QuyenModel;

public class PhanQuyenBUS {
	public static boolean KTQuyen(int id_nv, int id_q) {
		for (QuyenModel q : DAO.ChucVu_QuyenDAO.getQuyenByidNhanVien(id_nv)) {
			if(q.getId_q()==id_q) {
				return true;
			}
		}
		return false;
	}
}
