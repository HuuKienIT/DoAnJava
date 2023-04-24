package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.NhanVienModel;

public class NhanVienDAO {
	public static int demTongSoNV() {
		int dem=0;
		try {
			String sql = "SELECT count(*) as soluong FROM nhanvien";
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
	public static ArrayList<NhanVienModel> getAllUsers(){
		ArrayList<NhanVienModel> ds = new ArrayList<NhanVienModel>();
		try {
			String sql = "SELECT * FROM nhanvien";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				NhanVienModel tk = new NhanVienModel();
				tk.setId_nv(rs.getInt("id_nv"));
				tk.setHoTen(rs.getString("ten_nv"));
				tk.setEmail(rs.getString("email"));
				tk.setSoDth(rs.getInt("sodth"));
				tk.setChucVu(rs.getString("ten_cv"));
				tk.setPhoto(rs.getString("photo"));
				ds.add(tk);
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ds;
	}
	public static NhanVienModel getUserByTaiKhoan(String taikhoan){
		NhanVienModel tk = new NhanVienModel();
		try {
			String sql = "SELECT * FROM nhanvien join chucvu on nhanvien.id_cv=chucvu.id_cv where taikhoan='"+taikhoan+"'";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {	
				tk.setId_nv(rs.getInt("id_nv"));
				tk.setHoTen(rs.getString("ten_nv"));
				tk.setEmail(rs.getString("email"));
				tk.setSoDth(rs.getInt("sodth"));
				tk.setChucVu(rs.getString("ten_cv"));
				tk.setPhoto(rs.getString("photo"));
			}
			helper.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return tk;
	}
	public static int themUsers(NhanVienModel us) {
		int n=-1;
		try {
			String sql = String.format("INSERT INTO nhanvien(hoten,email,taikhoan,matkhau.sodth,chucvu) VALUES('%s','%s','%s','%s','%d','%s')"
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
			String sql = "DELETE FROM users nhanvien id_nv="+ID;
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			n = helper.executeUpdate(sql);
			helper.close();
		} catch (Exception e) {
		}
		return n;
	}
	public static NhanVienModel getUsersByID(int ID) {
		NhanVienModel tk = new NhanVienModel();
		try {
			String sql = "SELECT * FROM nhanvien where id_nv="+ID;
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				tk.setId_nv(rs.getInt("id_nv"));
				tk.setHoTen(rs.getString("ten_nv"));
				tk.setEmail(rs.getString("email"));
				tk.setSoDth(rs.getInt("sodth"));
//				tk.setChucVu(rs.getString("ten_cv"));
				tk.setPhoto(rs.getString("photo"));
			}
			helper.close();
		} catch (Exception e) {
		}
		return tk;
	}
	public static int chinhSuaUsers(int ID, NhanVienModel us) {
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
