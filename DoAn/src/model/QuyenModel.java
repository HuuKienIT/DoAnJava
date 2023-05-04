package model;

public class QuyenModel {
	public int id_q;
	public String ten_q;
	public QuyenModel() {
		this.id_q=0;
		this.ten_q=new String();
	}
	public final int getId_q() {
		return id_q;
	}
	public final void setId_q(int id_q) {
		this.id_q = id_q;
	}
	public final String getTen_q() {
		return ten_q;
	}
	public final void setTen_q(String ten_q) {
		this.ten_q = ten_q;
	}
	
}
