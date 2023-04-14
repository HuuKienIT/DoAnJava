package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.nhanVien;

public class nhanVienDAO {
	public static ArrayList<nhanVien> getAllUsers(){
		ArrayList<nhanVien> ds = new ArrayList<nhanVien>();
		try {
			String sql = "SELECT * FROM nhanvien";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				nhanVien tk = new nhanVien();
				tk.setManv(rs.getString("manv"));
				tk.setHoTen(rs.getString("tennv"));
				tk.setTaiKhoan(rs.getString("taikhoan"));
				tk.setGioiTinh(rs.getString("gioitinh"));
				tk.setMatKhau(rs.getString("matkhau"));
				tk.setSoDth(rs.getInt("sodth"));
				tk.setChucVu(rs.getString("sodth"));
				ds.add(tk);
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ds;
	}
	public static nhanVien getUserByTaiKhoan(String taikhoan){
		nhanVien tk = new nhanVien();
		try {
			String sql = "SELECT * FROM nhanvien where taikhoan='"+taikhoan+"'";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				
				tk.setId_Tk(rs.getInt("id_nv"));
				tk.setManv(rs.getString("ma_nv"));
				tk.setHoTen(rs.getString("ten_nv"));
				tk.setEmail(rs.getString("email"));
				tk.setSoDth(rs.getInt("sodth"));
				tk.setChucVu(rs.getString("ten_cv"));
				tk.setPhoto(rs.getString("photo"));
			}
			helper.close();
			
		} catch (Exception e) {
		}
		return tk;
	}
	public static nhanVien getUserByManv(String manv){
		nhanVien us = new nhanVien();
		try {
			String sql = "SELECT * FROM nhanvien where manv='"+manv+"'";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				us.setId_Tk(rs.getInt("id_nv"));
				us.setManv(rs.getString("manv"));
				us.setHoTen(rs.getString("tennv"));
				us.setEmail(rs.getString("email"));
				us.setTaiKhoan(rs.getString("taikhoan"));
				us.setMatKhau(rs.getString("matkhau"));
				us.setSoDth(rs.getInt("sodth"));
				us.setChucVu(rs.getString("chucvu"));
			}
			helper.close();
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return us;
	}
	public static int themUsers(nhanVien us) {
		int n=-1;
		try {
			String sql = String.format("INSERT INTO hoten(hoten,email,taikhoan,matkhau.sodth,chucvu) VALUES('%s','%s','%s','%s','%d','%s')"
					,us.getHoTen(),us.getEmail(),us.getTaiKhoan(),us.getMatKhau(),us.getSoDth(),us.getChucVu());
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			n = helper.executeUpdate(sql);
			helper.close();
		} catch (Exception e) {
		}
		return n;
	}
	public static int xoaUsers(int ID) {
		int n=-1;
		try {
			String sql = "DELETE FROM users where id_user="+ID;
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			n = helper.executeUpdate(sql);
			helper.close();
		} catch (Exception e) {
		}
		return n;
	}
	public static nhanVien getUsersByID(int ID) {
		nhanVien us = new nhanVien();
		try {
			String sql = "SELECT * FROM users where id_user="+ID;
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				us.setId_Tk(rs.getInt("id_user"));
				us.setHoTen(rs.getString("hoten"));
				us.setEmail(rs.getString("email"));
				us.setTaiKhoan(rs.getString("taikhoan"));
				us.setMatKhau(rs.getString("matkhau"));
				us.setSoDth(rs.getInt("sodth"));
				us.setChucVu(rs.getString("chucvu"));
			}
			helper.close();
			
		} catch (Exception e) {
		}
		return us;
	}
	public static int chinhSuaUsers(int ID, nhanVien us) {
		int n=-1;
		try {
			String sql = String.format("UPDATE users SET hoten='%s',email='%s',taikhoan='%s',matkhau='%s',sodth='%d',chucvu='%s' WHERE id_user='%d'"
					,us.getHoTen(),us.getEmail(),us.getTaiKhoan(),us.getMatKhau(),us.getSoDth(),us.getChucVu(),ID);
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			n = helper.executeUpdate(sql);
			helper.close();
		} catch (Exception e) {
		}
		return n;
	}
	public static String layMatKhau(String taikhoan) {
		String matkhau="";
		try {
			String sql = String.format("SELECT matkhau from nhanvien where taikhoan ='%s'",taikhoan);
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			if(rs!=null) {
				while(rs.next()) {
					matkhau =rs.getString("matkhau");
				}
			}
			helper.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return matkhau;
	}
}
