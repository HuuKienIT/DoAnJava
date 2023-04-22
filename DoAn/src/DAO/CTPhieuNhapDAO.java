package DAO;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.CTPhieuNhapModel;
public class CTPhieuNhapDAO {
	public static ArrayList<CTPhieuNhapModel> getCTPhieuNhapByID(int id_pn) {
		ArrayList<CTPhieuNhapModel> ds = new ArrayList<CTPhieuNhapModel>();
		try {
			String sql = "SELECT * FROM ctphieunhap where id_pn="+id_pn;
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				CTPhieuNhapModel ctpn = new CTPhieuNhapModel();
				ctpn.setId_pn(rs.getInt("id_pn"));
				ctpn.setId_sp(rs.getInt("id_sp"));
				ctpn.setGia(rs.getInt("gianhap"));
				ctpn.setSoluong(rs.getInt("soluong"));
				ds.add(ctpn);
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ds;
	}
	public static int themCTPhieuNhap(CTPhieuNhapModel ctpn) {
	int n=-1;
	int id_pn=PhieuNhapDAO.layIDcuoi();
	try {
		String sql = String.format("INSERT INTO ctphieunhap (id_pn,id_sp,soluong,gianhap) VALUES("+id_pn+","+ctpn.getId_sp()+","+ctpn.getSoluong()+","+ctpn.getGia()+")");
		mySQLHelper helper = new mySQLHelper();
		helper.open();
		n = helper.executeUpdate(sql);
		helper.close();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return n;
	}
}

