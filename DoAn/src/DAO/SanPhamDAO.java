package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.PhieuNhapModel;
import model.SanPhamModel;

public class SanPhamDAO {
	public static ArrayList<SanPhamModel> getAllSanPham() {
		ArrayList<SanPhamModel> ds = new ArrayList<SanPhamModel>();
		try {
			String sql = "SELECT * FROM sanpham join nhanhieu on sanpham.id_nh=nhanhieu.id_nh";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while (rs.next()) {
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

	public static SanPhamModel getSanPhamByIdSP(int id) {
		SanPhamModel sp = new SanPhamModel();
		try {
			String sql = "SELECT * FROM sanpham join nhanhieu on sanpham.id_nh=nhanhieu.id_nh where id_sp=" + id;
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while (rs.next()) {
				sp.setId_sp(rs.getInt("id_sp"));
				sp.setMasp(rs.getString("ma_sp"));
				sp.setTensp(rs.getString("ten_sp"));
				sp.setGia(rs.getInt("gia"));
				sp.setNhanhieu(rs.getString("ten_nh"));
				sp.setManh(rs.getString("id_nh"));
				sp.setConlai(rs.getInt("soluong"));
				sp.setPhoto(rs.getString("photo"));
			}
			helper.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sp;
	}

	public static String getTenSanPhamByIdSP(int id) {
		String ten_sp = new String();
		try {
			String sql = "SELECT ten_sp FROM sanpham where id_sp=" + id;
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while (rs.next()) {
				ten_sp = rs.getString("ten_sp");
			}
			helper.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ten_sp;
	}

	public static int demTongSoSP() {
		int dem = 0;
		try {
			String sql = "SELECT count(*) as soluong FROM sanpham";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while (rs.next()) {
				dem = rs.getInt("soluong");
			}
			helper.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dem;
	}

	public static int demSanPhamByNhanHieu(String ten_nh) {
		int dem = 0;
		try {
			String sql = "SELECT soluong FROM sanpham join nhanhieu on sanpham.id_nh=nhanhieu.id_nh where ten_nh='"
					+ ten_nh + "'";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while (rs.next()) {
				dem = dem + rs.getInt("soluong");
			}
			helper.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dem;
	}

	public static int demTongSoLuong() {
		int dem = 0;
		try {
			String sql = "SELECT soluong FROM sanpham";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while (rs.next()) {
				dem = dem + rs.getInt("soluong");
			}
			helper.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dem;
	}
	
	public static int themSanPham(SanPhamModel sp) {
		int n = -1;
		try {
			String sql = "insert into sanpham values('"+sp.id_sp+"','"+sp.masp+"','"+sp.tensp+"','"+sp.gia+"','"+sp.conlai+"','"+sp.manh+"','"+sp.photo+"')";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			n = helper.executeUpdate(sql);
			helper.close();
		} catch (Exception e) {
		}
		return n;
	}
	public static int suaSanPham(SanPhamModel sp) {
		int n = -1;
		try {
			String sql="update sanpham set ten_sp='"+sp.tensp+"',gia='"+sp.gia+"',id_nh='"+sp.manh+"',photo='"+sp.photo+"' where ma_sp='"+sp.masp+"'";
			mySQLHelper helper=new mySQLHelper();
			helper.open();
			n=helper.executeUpdate(sql);
		} catch (Exception e) {
		}
		return n;
	}
}
