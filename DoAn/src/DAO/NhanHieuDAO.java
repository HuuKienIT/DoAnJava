package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.NhanHieuModel;

public class NhanHieuDAO {
	public static ArrayList<NhanHieuModel> getAllNhanHieu(){
		ArrayList<NhanHieuModel> ds = new ArrayList<NhanHieuModel>();
		try {
			String sql = "SELECT * FROM nhanhieu";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				NhanHieuModel nh = new NhanHieuModel();
				nh.setId_nh(rs.getInt("id_nh"));
				nh.setTen_nh(rs.getString("ten_nh"));
				ds.add(nh);
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ds;
	}
//	public static ArrayList<loai> timKiemUsers(String taikhoan){
//		ArrayList<loai> ds = new ArrayList<loai>();
//		try {
//			String sql = "SELECT * FROM loai where taikhoan="+taikhoan;
//			mySQLHelper helper = new mySQLHelper();
//			helper.open();
//			ResultSet rs = helper.executeQuery(sql);
//			while(rs.next()) {
//				loai tk = new loai();
//				tk.setId_Tk(rs.getInt("id_user"));
//				tk.setManv(rs.getString("manv"));
//				tk.setHoTen(rs.getString("hoten"));
//				tk.setEmail(rs.getString("email"));
//				tk.setTaiKhoan(rs.getString("taikhoan"));
//				tk.setMatKhau(rs.getString("matkhau"));
//				tk.setSoDth(rs.getInt("sodth"));
//				tk.setChucVu(rs.getString("chucvu"));
//				ds.add(tk);
//			}
//			helper.close();
//			
//		} catch (Exception e) {
//		}
//		return ds;
//	}
//	public static loai getUserByManv(String manv){
//		loai us = new loai();
//		try {
//			String sql = "SELECT * FROM loai where manv='"+manv+"'";
//			mySQLHelper helper = new mySQLHelper();
//			helper.open();
//			ResultSet rs = helper.executeQuery(sql);
//			while(rs.next()) {
//				us.setId_Tk(rs.getInt("id_nv"));
//				us.setManv(rs.getString("manv"));
//				us.setHoTen(rs.getString("tennv"));
//				us.setEmail(rs.getString("email"));
//				us.setTaiKhoan(rs.getString("taikhoan"));
//				us.setMatKhau(rs.getString("matkhau"));
//				us.setSoDth(rs.getInt("sodth"));
//				us.setChucVu(rs.getString("chucvu"));
//			}
//			helper.close();
//			
//		} catch (Exception e) {
//			System.out.print(e.getMessage());
//		}
//		return us;
//	}
//	public static int themUsers(loai us) {
//		int n=-1;
//		try {
//			String sql = String.format("INSERT INTO hoten(hoten,email,taikhoan,matkhau.sodth,chucvu) VALUES('%s','%s','%s','%s','%d','%s')"
//					,us.getHoTen(),us.getEmail(),us.getTaiKhoan(),us.getMatKhau(),us.getSoDth(),us.getChucVu());
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
//	public static loai getUsersByID(int ID) {
//		loai us = new loai();
//		try {
//			String sql = "SELECT * FROM users where id_user="+ID;
//			mySQLHelper helper = new mySQLHelper();
//			helper.open();
//			ResultSet rs = helper.executeQuery(sql);
//			while(rs.next()) {
//				us.setId_Tk(rs.getInt("id_user"));
//				us.setHoTen(rs.getString("hoten"));
//				us.setEmail(rs.getString("email"));
//				us.setTaiKhoan(rs.getString("taikhoan"));
//				us.setMatKhau(rs.getString("matkhau"));
//				us.setSoDth(rs.getInt("sodth"));
//				us.setChucVu(rs.getString("chucvu"));
//			}
//			helper.close();
//			
//		} catch (Exception e) {
//		}
//		return us;
//	}
//	public static int chinhSuaUsers(int ID, loai us) {
//		int n=-1;
//		try {
//			String sql = String.format("UPDATE users SET hoten='%s',email='%s',taikhoan='%s',matkhau='%s',sodth='%d',chucvu='%s' WHERE id_user='%d'"
//					,us.getHoTen(),us.getEmail(),us.getTaiKhoan(),us.getMatKhau(),us.getSoDth(),us.getChucVu(),ID);
//			mySQLHelper helper = new mySQLHelper();
//			helper.open();
//			n = helper.executeUpdate(sql);
//			helper.close();
//		} catch (Exception e) {
//		}
//		return n;
//	}
//	public static String layMatKhau(String taikhoan) {
//		String matkhau="";
//		try {
//			String sql = String.format("SELECT matkhau from loai where taikhoan ='%s'",taikhoan);
//			mySQLHelper helper = new mySQLHelper();
//			helper.open();
//			ResultSet rs = helper.executeQuery(sql);
//			if(rs!=null) {
//				while(rs.next()) {
//					matkhau =rs.getString("matkhau");
//				}
//			}
//			helper.close();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		return matkhau;
//	}
}
