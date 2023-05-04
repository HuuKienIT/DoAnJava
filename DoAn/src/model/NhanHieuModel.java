package model;

public class NhanHieuModel {
	public int id_nh;
	public String ten_nh;
	public NhanHieuModel() {
		this.id_nh=0;
		this.ten_nh = new String();
	}
	public final int getId_nh() {
		return id_nh;
	}
	public final void setId_nh(int id_nh) {
		this.id_nh = id_nh;
	}
	public final String getTen_nh() {
		return ten_nh;
	}
	public final void setTen_nh(String ten_nh) {
		this.ten_nh = ten_nh;
	}
	
}
