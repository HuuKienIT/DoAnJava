package model;

public class ChucVuModel {
	public int id_cv;
	public String ten_cv;

	public ChucVuModel() {
		this.id_cv=0;
		this.ten_cv=new String();
	}
	public final int getId_cv() {
		return id_cv;
	}
	public final void setId_cv(int id_cv) {
		this.id_cv = id_cv;
	}
	public final String getTen_cv() {
		return ten_cv;
	}
	public final void setTen_cv(String ten_cv) {
		this.ten_cv = ten_cv;
	}

}
