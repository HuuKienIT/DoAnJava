package DAO;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.PhieuNhapModel;
public class PhieuNhapDAO {

	public static ArrayList<PhieuNhapModel> getAllPhieuNhap() {
		ArrayList<PhieuNhapModel> ds = new ArrayList<PhieuNhapModel>();
		try {
			String sql = "SELECT * FROM phieunhap ";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				PhieuNhapModel pn = new PhieuNhapModel();
				pn.setId_pn(rs.getInt("id_pn"));
				pn.setId_nv(rs.getInt("id_nv"));
				pn.setId_ncc(rs.getInt("id_ncc"));
				pn.setNgaynhap(rs.getDate("ngaynhap").toLocalDate());
				pn.setTongsl(rs.getInt("tongsl"));
				pn.setTongtien(rs.getInt("tongtien"));
				ds.add(pn);
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return ds;
	}
	public static int themPhieuNhap(PhieuNhapModel pn) {
	int n=-1;
	try {
		String sql = String.format("INSERT INTO phieunhap(id_nv,id_ncc,tongtien,tongsl,ngaynhap) VALUES("+pn.getId_nv()+","+pn.getId_ncc()+","+pn.getTongtien()+","+pn.getTongsl())+",'"+pn.getNgaynhap()+"')";
		mySQLHelper helper = new mySQLHelper();
		helper.open();
		n = helper.executeUpdate(sql);
		helper.close();
	} catch (Exception e) {
	}
	return n;
	}
	public static int layIDcuoi() {
		PhieuNhapModel dh = new PhieuNhapModel();
		try {
			String sql = "SELECT id_pn FROM phieunhap ORDER BY id_pn DESC LIMIT 1";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				dh.setId_pn(rs.getInt("id_pn"));
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dh.getId_pn();
	}
}

