package model;

public class NhanHieu {
	public int id_nh;
	public String ma_nh;
	public String ten_nh;
	public NhanHieu() {
		this.id_nh=0;
		this.ma_nh= new String();
		this.ten_nh = new String();
	}
	public final int getId_nh() {
		return id_nh;
	}
	public final void setId_nh(int id_nh) {
		this.id_nh = id_nh;
	}
	public final String getMa_nh() {
		return ma_nh;
	}
	public final void setMa_nh(String ma_nh) {
		this.ma_nh = ma_nh;
	}
	public final String getTen_nh() {
		return ten_nh;
	}
	public final void setTen_nh(String ten_nh) {
		this.ten_nh = ten_nh;
	}
	
}
