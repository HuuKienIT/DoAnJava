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
			String sql = "SELECT * FROM nhanvien join chucvu on nhanvien.id_cv=chucvu.id_cv";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				NhanVienModel tk = new NhanVienModel();
				tk.setId_nv(rs.getInt("id_nv"));
				tk.setHoTen(rs.getString("ten_nv"));
				tk.setGioiTinh(rs.getInt("gioitinh"));
				tk.setEmail(rs.getString("email"));
				tk.setSoDth(rs.getString("sodth"));
				tk.setTaiKhoan(rs.getString("taikhoan"));
				tk.setMatKhau(rs.getString("matkhau"));
				tk.setChucVu(rs.getString("ten_cv"));
				tk.setPhoto(rs.getString("photo"));
				tk.setNamSinh(rs.getString("ngaysinh"));
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
				tk.setGioiTinh(rs.getInt("gioitinh"));
				tk.setEmail(rs.getString("email"));
				tk.setSoDth(rs.getString("sodth"));
				tk.setTaiKhoan(rs.getString("taikhoan"));
				tk.setMatKhau(rs.getString("matkhau"));
				tk.setChucVu(rs.getString("ten_cv"));
				tk.setPhoto(rs.getString("photo"));
				tk.setNamSinh(rs.getString("ngaysinh"));
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
			int id_nv=demTongSoNV()+1;
			int id_cv=ChucVuDAO.getidChucVuByName(us.chucVu);
			String sql = "insert into nhanvien values('"+id_nv+"','"+us.hoTen+"','"+us.namSinh+"','"+us.taiKhoan+"','"+us.matKhau+"','"+id_cv+"','"+us.photo+"','"+us.soDth+"','"+us.email+"','"+us.gioiTinh+"')";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			n = helper.executeUpdate(sql);
			helper.close();
		} catch (Exception e) {
			System.out.print(e.toString());
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
			String sql = "SELECT * FROM nhanvien join chucvu on nhanvien.id_cv=chucvu.id_cv where nhanvien.id_nv='"+ID+"'";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				tk.setId_nv(rs.getInt("id_nv"));
				tk.setHoTen(rs.getString("ten_nv"));
				tk.setGioiTinh(rs.getInt("gioitinh"));
				tk.setEmail(rs.getString("email"));
				tk.setSoDth(rs.getString("sodth"));
				tk.setTaiKhoan(rs.getString("taikhoan"));
				tk.setMatKhau(rs.getString("matkhau"));
				tk.setChucVu(rs.getString("ten_cv"));
				tk.setPhoto(rs.getString("photo"));
				tk.setNamSinh(rs.getString("ngaysinh"));
			}
			helper.close();
		} catch (Exception e) {
		}
		return tk;
	}
	public static int chinhSuaUsers(int ID, NhanVienModel us) {
		int n=-1;
		try {
			int id_cv=ChucVuDAO.getidChucVuByName(us.chucVu);
			String sql = "update nhanvien set ten_nv='"+us.hoTen+"',ngaysinh='"+us.namSinh+"',taikhoan='"+us.taiKhoan+"',matkhau='"+us.matKhau+"',id_cv='"+id_cv+"',photo='"+us.photo+"',sodth='"+us.soDth+"',email='"+us.email+"',gioitinh='"+us.gioiTinh+"' where id_nv='"+ID+"'";
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
