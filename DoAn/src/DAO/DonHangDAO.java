package DAO;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.DonHangModel;
import model.SanPhamModel;
public class DonHangDAO {
	public static int doanhThuThang(int thang, int nam) {
		int tong=0;
		try {
			String sql = "SELECT tongtien,MONTH(ngayban)as thang,YEAR(ngayban)as nam FROM donhang ";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				if(rs.getInt("thang")==thang && rs.getInt("nam")==nam) {
					tong=tong+rs.getInt("tongtien");
				}	
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return tong;
	}
	public static int tongDoanhThu() {
		int tong=0;
		try {
			String sql = "SELECT tongtien FROM donhang";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				tong=tong+rs.getInt("tongtien");
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return tong;
	}
	public static ArrayList<DonHangModel> getAllDonHang() {
		ArrayList<DonHangModel> ds = new ArrayList<DonHangModel>();
		try {
			String sql = "SELECT * FROM donhang";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				DonHangModel dh = new DonHangModel();
				dh.setId_dh(rs.getInt("id_dh"));
				dh.setId_kh(rs.getInt("id_kh"));
				dh.setId_nv(rs.getInt("id_nv"));
				dh.setNgayban(rs.getDate("ngayban").toLocalDate());
				dh.setTongsl(rs.getInt("tongsl"));
				dh.setTongtien(rs.getInt("tongtien"));
				ds.add(dh);
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return ds;
	}
	public static int themDonHang(DonHangModel dh) {
	int n=-1;
	try {
		String sql = String.format("INSERT INTO donhang(id_kh,id_nv,tongtien,tongsl,ngayban) VALUES("+dh.getId_kh()+","+dh.getId_nv()+","+dh.getTongtien()+","+dh.getTongsl())+",'"+dh.getNgayban()+"')";
		mySQLHelper helper = new mySQLHelper();
		helper.open();
		n = helper.executeUpdate(sql);
		helper.close();
	} catch (Exception e) {
	}
	return n;
	}
	public static int layIDcuoi() {
		DonHangModel dh = new DonHangModel();
		try {
			String sql = "SELECT id_dh FROM donhang ORDER BY id_dh DESC LIMIT 1";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				dh.setId_dh(rs.getInt("id_dh"));
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dh.getId_dh();
	}
}

