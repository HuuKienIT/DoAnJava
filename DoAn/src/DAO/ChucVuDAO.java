package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.ChucVuModel;
import model.SanPhamModel;

public class ChucVuDAO {
	public static ArrayList<ChucVuModel> getAllChucVu() {
		ArrayList<ChucVuModel> ds = new ArrayList<ChucVuModel>();
		try {
			String sql = "SELECT * FROM chucvu";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while (rs.next()) {
				ChucVuModel cv = new ChucVuModel();
				cv.setId_cv(rs.getInt("id_cv"));
				cv.setTen_cv(rs.getString("ten_cv"));
				ds.add(cv);
			}
			helper.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ds;
	}
	public static int getidChucVuByName(String tencv) {
		int id_cv=0;
		try {
			String sql = "SELECT id_cv FROM chucvu where ten_cv regexp '"+tencv+"'";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				id_cv = rs.getInt("id_cv");
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id_cv;
	}


}
