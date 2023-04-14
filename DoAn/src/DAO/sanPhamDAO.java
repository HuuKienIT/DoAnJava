package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.sanPham;


public class sanPhamDAO {
	public static ArrayList<sanPham> getAllSanPham(){
		ArrayList<sanPham> ds = new ArrayList<sanPham>();
		try {
			String sql = "SELECT * FROM sanpham";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				sanPham sp = new sanPham();
				sp.setId_sp(rs.getInt("id_sp"));
				sp.setMasp(rs.getString("ma_sp"));
				sp.setTensp(rs.getString("ten_sp"));
				sp.setGia(rs.getInt("gia"));
				sp.setConlai(rs.getInt("soluong"));
				sp.setPhoto(rs.getString("photo"));
				ds.add(sp);
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ds;
	}
//	public static ArrayList<sanPham> timKiemUsers(int idsp){
//		ArrayList<sanPham> ds = new ArrayList<sanPham>();
//		try {
//			String sql = "SELECT * FROM users where taikhoan="+idsp;
//			mySQLHelper helper = new mySQLHelper();
//			helper.open();
//			ResultSet rs = helper.executeQuery(sql);
//			while(rs.next()) {
//				sanPham sp = new sanPham();
//				
//				ds.add(sp);
//			}
//			helper.close();
//			
//		} catch (Exception e) {
//		}
//		return ds;
//	}
//	public static int themUsers(sanPham us) {
//		int n=-1;
//		try {
//			String sql = String.format("INSERT INTO hoten(hoten,email,taikhoan,masphau.sodth,chucvu) VALUES('%s','%s','%s','%s','%d','%s')"
//					,);
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
//	public static sanPham getUsersByID(int ID) {
//		sanPham us = new sanPham();
//		try {
//			String sql = "SELECT * FROM users where id_user="+ID;
//			mySQLHelper helper = new mySQLHelper();
//			helper.open();
//			ResultSet rs = helper.executeQuery(sql);
//			while(rs.next()) {
//				
//			}
//			helper.close();
//			
//		} catch (Exception e) {
//		}
//		return us;
//	}
//	public static int chinhSuaUsers(int ID, sanPham us) {
//		int n=-1;
//		try {
//			String sql = String.format("UPDATE users SET hoten='%s',email='%s',taikhoan='%s',masphau='%s',sodth='%d',chucvu='%s' WHERE id_user='%d'"
//					,);
//			mySQLHelper helper = new mySQLHelper();
//			helper.open();
//			n = helper.executeUpdate(sql);
//			helper.close();
//		} catch (Exception e) {
//		}
//		return n;
//	}
}
