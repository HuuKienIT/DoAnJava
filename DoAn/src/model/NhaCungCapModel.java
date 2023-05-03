package model;

public class NhaCungCapModel {
	public int id_ncc;
	public String ten_ncc;
	public String sodth;
	public String email;
	public NhaCungCapModel() {
		this.id_ncc= 0;
		this.ten_ncc=new String();
		this.sodth=new String();
		this.email=new String();
	}
	public final int getId_ncc() {
		return id_ncc;
	}
	public final void setId_ncc(int id_ncc) {
		this.id_ncc = id_ncc;
	}
	public final String getTen_ncc() {
		return ten_ncc;
	}
	public final void setTen_ncc(String ten_ncc) {
		this.ten_ncc = ten_ncc;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final String getSDT() {
		return sodth;
	}
	public final void setSodth(String sodth) {
		this.sodth = sodth;
	}
}
