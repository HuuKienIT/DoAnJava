package model;

public class ChucVu_QuyenModel {
	public int id_cv;
	public int id_q;
	public ChucVu_QuyenModel() {
		this.id_cv=0;
		this.id_q=0;
	}
	public final int getId_cv() {
		return id_cv;
	}
	public final void setId_cv(int id_cv) {
		this.id_cv = id_cv;
	}
	public final int getId_q() {
		return id_q;
	}
	public final void setId_q(int id_q) {
		this.id_q = id_q;
	}
}
