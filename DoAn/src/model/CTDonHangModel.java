package model;

public class CTDonHangModel {
	public int id_dh;
	public int id_sp;
	public int soluong;
	public int gia;
	public CTDonHangModel() {
		this.id_dh=0;
		this.id_sp=0;
		this.soluong=0;
		this.gia=0;
	}
	public final int getId_dh() {
		return id_dh;
	}
	public final void setId_dh(int id_dh) {
		this.id_dh = id_dh;
	}
	public final int getId_sp() {
		return id_sp;
	}
	public final void setId_sp(int id_sp) {
		this.id_sp = id_sp;
	}
	public final int getSoluong() {
		return soluong;
	}
	public final void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public final int getGia() {
		return gia;
	}
	public final void setGia(int gia) {
		this.gia = gia;
	}
	
	
}
