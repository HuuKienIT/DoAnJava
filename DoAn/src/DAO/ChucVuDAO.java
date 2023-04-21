package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.SanPhamModel;

public class ChucVuDAO {
	public static ArrayList<String> getAllChucVu(){
		 ArrayList<String> ds = new ArrayList<String>();
		try {
			String sql = "SELECT * FROM chucvu";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				ds.add(rs.getString("ten_cv"));
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ds;
	}
}
