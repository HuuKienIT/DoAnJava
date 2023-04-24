package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.SanPhamModel;


public class SanPhamDAO {
	public static ArrayList<SanPhamModel> getAllSanPham(){
		ArrayList<SanPhamModel> ds = new ArrayList<SanPhamModel>();
		try {
			String sql = "SELECT * FROM sanpham join nhanhieu on sanpham.id_nh=nhanhieu.id_nh";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				SanPhamModel sp = new SanPhamModel();
				sp.setId_sp(rs.getInt("id_sp"));
				sp.setMasp(rs.getString("ma_sp"));
				sp.setTensp(rs.getString("ten_sp"));
				sp.setGia(rs.getInt("gia"));
				sp.setNhanhieu(rs.getString("ten_nh"));
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
	public static SanPhamModel getSanPhamByIdSP(int id){
		SanPhamModel sp = new SanPhamModel();
		try {
			String sql = "SELECT * FROM sanpham join nhanhieu on sanpham.id_nh=nhanhieu.id_nh where id_sp="+id;
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				sp.setId_sp(rs.getInt("id_sp"));
				sp.setMasp(rs.getString("ma_sp"));
				sp.setTensp(rs.getString("ten_sp"));
				sp.setGia(rs.getInt("gia"));
				sp.setNhanhieu(rs.getString("ten_nh"));
				sp.setConlai(rs.getInt("soluong"));
				sp.setPhoto(rs.getString("photo"));
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sp;
	}
	public static String getTenSanPhamByIdSP(int id){
		String ten_sp=new String();
		try {
			String sql = "SELECT ten_sp FROM sanpham where id_sp="+id;
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				ten_sp=rs.getString("ten_sp");
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ten_sp;
	}
	public static int demTongSoSP() {
		int dem=0;
		try {
			String sql = "SELECT count(*) as soluong FROM sanpham";
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
	public static int demSanPhamByNhanHieu(String ten_nh) {
		int dem=0;
		try {
			String sql = "SELECT soluong FROM sanpham join nhanhieu on sanpham.id_nh=nhanhieu.id_nh where ten_nh='"+ten_nh+"'";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				dem=dem+rs.getInt("soluong");
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dem;
	}
	public static int demTongSoLuong() {
		int dem=0;
		try {
			String sql = "SELECT soluong FROM sanpham";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				dem=dem+rs.getInt("soluong");
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dem;
	}
	
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
