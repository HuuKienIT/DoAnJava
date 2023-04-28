package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.NhaCungCapModel;
import model.NhanHieuModel;

public class NhaCungCapDAO {
	public static NhaCungCapModel getNCCByID(int id_ncc){
		NhaCungCapModel ncc = new NhaCungCapModel();
		try {
			String sql = "SELECT * FROM nhacungcap where id_ncc="+id_ncc;
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				ncc.setId_ncc(rs.getInt("id_ncc"));
				ncc.setTen_ncc(rs.getString("ten_ncc"));
				ncc.setEmail(rs.getString("sdth"));
				ncc.setEmail(rs.getString("email"));
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ncc;
	}
	public static ArrayList<NhaCungCapModel> getAllNCC(){
		ArrayList<NhaCungCapModel> ds =new ArrayList<NhaCungCapModel>();
		try {
			String sql = "SELECT * FROM nhacungcap";
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				NhaCungCapModel ncc = new NhaCungCapModel();

				ncc.setId_ncc(rs.getInt("id_ncc"));
				ncc.setTen_ncc(rs.getString("ten_ncc"));
				ncc.setEmail(rs.getString("sdth"));
				ncc.setEmail(rs.getString("email"));
				ds.add(ncc);
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ds;
	}
	public static int demTongSoNCC() {
		int dem=0;
		try {
			String sql = "SELECT count(*) as soluong FROM nhacungcap";
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

}
