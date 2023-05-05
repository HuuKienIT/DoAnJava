package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.KhachHangModel;

public class KhachHangDAO {
	public static int tangDiem(int id_kh, int diem) {
		int n = -1;
		int sl=layDiem(id_kh)+diem;
		try {
			String sql="update khachhang set diem="+sl+" where id_kh="+id_kh;
			mySQLHelper helper=new mySQLHelper();
			helper.open();
			n=helper.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return n;
	}
	public static int truDiem(int id_kh) {
		int n = -1;
		try {
			String sql="update khachhang set diem = 0 where id_kh="+id_kh;
			mySQLHelper helper=new mySQLHelper();
			helper.open();
			n=helper.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return n;
	}
	public static int layDiem(int id_kh) {
		int diem = 0;
		try {
			String sql="select diem from khachhang where id_kh="+id_kh;
			mySQLHelper helper=new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				diem=rs.getInt("diem");
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return diem;
	}
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
				kh.setEmail(rs.getString("email"));
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return kh;
	}
	public static int  themKhachHang(KhachHangModel kh) {
		int n = -1;
		try {
			String sql = "insert into khachhang(ten_kh,sdth,email) values ('"+kh.getTenkh()+"','"+kh.getSodth()+"','"+kh.getEmail()+"')";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			n = helper.executeUpdate(sql);
			helper.close();
		} catch (Exception e) {
		}
		return n;
	}
	public static int  updateKhachHang(KhachHangModel kh,int id_kh) {
		int n = -1;
		try {
			String sql = "update khachhang set ten_kh = '"+kh.getTenkh()+"', sdth = "+kh.getSodth() +", email = '"+kh.getEmail()+"' where id_kh ="+id_kh;
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			n = helper.executeUpdate(sql);
			helper.close();
		} catch (Exception e) {
		}
		return n;
	}

}
