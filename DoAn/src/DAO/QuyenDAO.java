package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.QuyenModel;

public class QuyenDAO {
	public static ArrayList<QuyenModel> getAllQuyen() {
		ArrayList<QuyenModel> ds = new ArrayList<QuyenModel>();
		try {
			QuyenModel q = new QuyenModel();
			String sql = "SELECT * FROM chucvu";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while (rs.next()) {
				q.setId_q(rs.getInt("id_q"));
				q.setTen_q(rs.getString("ten_q"));
				ds.add(q);
			}
			helper.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ds;
	}
}
