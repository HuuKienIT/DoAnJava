package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.NhanHieuModel;
import model.SanPhamModel;

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
	public static int Id_NhByName(String tennh) {
		ArrayList<NhanHieuModel> ds = new ArrayList<NhanHieuModel>();
		int kq=0;
		try {
			String sql="select id_nh from nhanhieu where ten_nh='"+tennh+"'";
			System.out.println(sql);
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			if(rs.next()) {
				kq= rs.getInt("id_nh");
			}
			helper.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return kq;
	}
	public static int demTongSoNH() {
		int dem = 0;
		try {
			String sql = "SELECT count(*) as soluong FROM nhanhieu";
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
	public static int themNhanHieu(NhanHieuModel nh) {
		int n = -1;
		try {
			String sql = "insert into nhanhieu(ten_nh) values('"+nh.ten_nh+"')";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			n = helper.executeUpdate(sql);
			helper.close();
		} catch (Exception e) {
		}
		return n;
	}
	public static int suaNhanHieu(NhanHieuModel nh) {
		int n = -1;
		try {
			String sql="update nhanhieu set ten_nh='"+nh.ten_nh+"' where id_nh='"+nh.id_nh+"'";
			mySQLHelper helper=new mySQLHelper();
			helper.open();
			n=helper.executeUpdate(sql);
		} catch (Exception e) {
		}
		return n;
	}
}
