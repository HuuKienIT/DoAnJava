package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.QuyenModel;

public class ChucVu_QuyenDAO {
	public static ArrayList<QuyenModel>  getQuyenByidChucVu(int id_cv) {
		ArrayList<QuyenModel> ds = new ArrayList<QuyenModel>();
		try {
			String sql = "SELECT id_q FROM chucvu_quyen where id_cv="+id_cv;
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				QuyenModel q = new QuyenModel();
				q.setId_q(rs.getInt("id_q"));
				ds.add(q);
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ds;
	}
	public static ArrayList<QuyenModel>  getQuyenByidNhanVien(int id_nv) {
		ArrayList<QuyenModel> ds = new ArrayList<QuyenModel>();
		try {
			String sql = "SELECT id_q FROM chucvu_quyen join nhanvien on nhanvien.id_cv = chucvu_quyen.id_cv where id_nv ="+id_nv ;
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				QuyenModel q = new QuyenModel();
				q.setId_q(rs.getInt("id_q"));
				ds.add(q);
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ds;
	}
	public static void themVao(int id_cv, int id_q) {
		try {
			String sql = "insert into chucvu_quyen(id_cv,id_q) value("+id_cv+","+id_q+")";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			helper.executeUpdate(sql);
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void XoaDi(int id_cv) {
		try {
			String sql = "delete from chucvu_quyen where id_cv=" +id_cv;
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			helper.executeUpdate(sql);
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
