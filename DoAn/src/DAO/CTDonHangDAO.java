package DAO;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.CTDonHangModel;
public class CTDonHangDAO {
	public static ArrayList<CTDonHangModel> getCTDonHangByID(int id_dh) {
		ArrayList<CTDonHangModel> ds = new ArrayList<CTDonHangModel>();
		try {
			String sql = "SELECT * FROM ctdonhang where id_dh="+id_dh;
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				CTDonHangModel ctdh = new CTDonHangModel();
				ctdh.setId_dh(rs.getInt("id_dh"));
				ctdh.setId_sp(rs.getInt("id_sp"));
				ctdh.setGia(rs.getInt("gia"));
				ctdh.setSoluong(rs.getInt("soluong"));
				ds.add(ctdh);
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ds;
	}
	public static int themCTDonHang(CTDonHangModel ctdh) {
	int n=-1;
	int id_dh=DonHangDAO.layIDcuoi();
	try {
		String sql = String.format("INSERT INTO ctdonhang(id_dh,id_sp,soluong,gia) VALUES("+id_dh+","+ctdh.getId_sp()+","+ctdh.getSoluong()+","+ctdh.getGia()+")");
		mySQLHelper helper = new mySQLHelper();
		helper.open();
		n = helper.executeUpdate(sql);
		helper.close();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return n;
	}
	public static int laySoLuongById(int id_sp) {
		int soluong=0;
		try {
			String sql = "SELECT sum(soluong) FROM ctdonhang where id_sp="+id_sp;
			mySQLHelper helper = new mySQLHelper();
			helper.open();
			ResultSet rs = helper.executeQuery(sql);
			while(rs.next()) {
				soluong =rs.getInt("soluong");
			}
			helper.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return soluong;
	}
}

