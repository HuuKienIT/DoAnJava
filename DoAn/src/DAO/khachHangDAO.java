package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.khachHang;

public class khachHangDAO {
	public static ArrayList<khachHang> getAllKH(){
		ArrayList<khachHang> ds = new ArrayList<khachHang>();
		try {
			String sql = "SELECT * FROM khachHang";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				khachHang kh = new khachHang();
				
				ds.add(kh);
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ds;
	}
	public static ArrayList<khachHang> timKiemKH(int sodth){
		ArrayList<khachHang> ds = new ArrayList<khachHang>();
		try {
			String sql = "SELECT * FROM khachhang where sodth REGEXP "+sodth +" limit 5";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				khachHang kh = new khachHang();
				kh.setId_kh(rs.getInt("id_kh"));
				kh.setMakh(rs.getString("makh"));
				kh.setTenkh(rs.getString("tenkh"));
				kh.setSodth(rs.getInt("sodth"));
				kh.setDiemtl(rs.getInt("diemtl"));
				ds.add(kh);
			}
			helper.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ds;
	}
//	public static int themUsers(khachHang us) {
//		int n=-1;
//		try {
//			String sql = String.format("INSERT INTO hoten(hoten,email,taikhoan,makhhau.sodth,chucvu) VALUES('%s','%s','%s','%s','%d','%s')"
//					,us.getHoTen(),us.getEmail(),us.getTaiKhoan(),us.getMakhhau(),us.getSoDth(),us.getChucVu());
//			mySQLHelper helper = new mySQLHelper();
//			helper.open();
//			n = helper.executeUpdate(sql);
//			helper.close();
//		} catch (Exception e) {
//		}
//		return n;
//	}
//	public static int xoaUsers(int ID) {
//		int n=-1;
//		try {
//			String sql = "DELETE FROM users where id_user="+ID;
//			mySQLHelper helper = new mySQLHelper();
//			helper.open();
//			n = helper.executeUpdate(sql);
//			helper.close();
//		} catch (Exception e) {
//		}
//		return n;
//	}
//	public static khachHang getUsersByID(int ID) {
//		khachHang us = new khachHang();
//		try {
//			String sql = "SELECT * FROM users where id_user="+ID;
//			mySQLHelper helper = new mySQLHelper();
//			helper.open();
//			ResultSet rs = helper.executeQuery(sql);
//			while(rs.next()) {
//				us.setId_kh(rs.getInt("id_user"));
//				us.setHoTen(rs.getString("hoten"));
//				us.setEmail(rs.getString("email"));
//				us.setTaiKhoan(rs.getString("taikhoan"));
//				us.setMakhhau(rs.getString("makhhau"));
//				us.setSoDth(rs.getInt("sodth"));
//				us.setChucVu(rs.getString("chucvu"));
//			}
//			helper.close();
//			
//		} catch (Exception e) {
//		}
//		return us;
//	}
//	public static int chinhSuaUsers(int ID, khachHang us) {
//		int n=-1;
//		try {
//			String sql = String.format("UPDATE users SET hoten='%s',email='%s',taikhoan='%s',makhhau='%s',sodth='%d',chucvu='%s' WHERE id_user='%d'"
//					,us.getHoTen(),us.getEmail(),us.getTaiKhoan(),us.getMakhhau(),us.getSoDth(),us.getChucVu(),ID);
//			mySQLHelper helper = new mySQLHelper();
//			helper.open();
//			n = helper.executeUpdate(sql);
//			helper.close();
//		} catch (Exception e) {
//		}
//		return n;
//	}
//	public static String layMakhhau(String taikhoan) {
//		String makhhau="";
//		try {
//			String sql = String.format("SELECT makhhau from khachHang where taikhoan ='%s'",taikhoan);
//			mySQLHelper helper = new mySQLHelper();
//			helper.open();
//			ResultSet rs = helper.executeQuery(sql);
//			if(rs!=null) {
//				while(rs.next()) {
//					makhhau =rs.getString("makhhau");
//				}
//			}
//			helper.close();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		return makhhau;
//	}
}
