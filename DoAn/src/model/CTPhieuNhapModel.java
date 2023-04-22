package model;

public class CTPhieuNhapModel {
	public int id_pn;
	public int id_sp;
	public int soluong;
	public int gia;
	public CTPhieuNhapModel() {
		this.id_pn=0;
		this.id_sp=0;
		this.soluong=0;
		this.gia=0;
	}
	public final int getId_pn() {
		return id_pn;
	}
	public final void setId_pn(int id_pn) {
		this.id_pn = id_pn;
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
