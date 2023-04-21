package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.KhachHangModel;

public class khachHangDAO {
	public static int demTongSoKH() {
		int dem=0;
		try {
			String sql = "SELECT count(*) as soluong FROM khachhang";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				dem=rs.getInt("soluong");
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dem;
	}
	public static ArrayList<KhachHangModel> getAllKH(){
		ArrayList<KhachHangModel> ds = new ArrayList<KhachHangModel>();
		try {
			String sql = "SELECT * FROM khachHang";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				KhachHangModel kh = new KhachHangModel();
				kh.setId_kh(rs.getInt("id_kh"));
				kh.setMakh(rs.getString("ma_kh"));
				kh.setTenkh(rs.getString("ten_kh"));
				kh.setSodth(rs.getInt("sdth"));
				kh.setDiemtl(rs.getInt("diem"));
				ds.add(kh);
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ds;
	}
	public static KhachHangModel getKhachHangByid(int id_kh){
		KhachHangModel kh = new KhachHangModel();
		try {
			String sql = "SELECT * FROM khachhang where id_kh="+id_kh;
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				kh.setId_kh(rs.getInt("id_kh"));
				kh.setMakh(rs.getString("ma_kh"));
				kh.setTenkh(rs.getString("ten_kh"));
				kh.setSodth(rs.getInt("sdth"));
				kh.setDiemtl(rs.getInt("diem"));
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return kh;
	}

}
