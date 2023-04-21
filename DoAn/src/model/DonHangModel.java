package model;

import java.time.LocalDate;

public class DonHangModel {
	public int id_dh;
	public int id_kh;
	public int id_nv;
	public int tongtien;
	public LocalDate ngayban;
	public int tongsl;
	public DonHangModel() {
		this.id_dh =0;
		this.id_kh =0;
		this.id_nv =0;
		this.tongtien =0;
		this.tongsl =0;
		this.ngayban =java.time.LocalDate.now();
	}
	public final int getId_dh() {
		return id_dh;
	}
	public final void setId_dh(int id_dh) {
		this.id_dh = id_dh;
	}
	public final int getId_kh() {
		return id_kh;
	}
	public final void setId_kh(int id_kh) {
		this.id_kh = id_kh;
	}
	public final int getId_nv() {
		return id_nv;
	}
	public final void setId_nv(int id_nv) {
		this.id_nv = id_nv;
	}
	public final int getTongtien() {
		return tongtien;
	}
	public final void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}
	public final LocalDate getNgayban() {
		return ngayban;
	}
	public final void setNgayban(LocalDate localDate) {
		this.ngayban = localDate;
	}
	public final int getTongsl() {
		return tongsl;
	}
	public final void setTongsl(int tongsl) {
		this.tongsl = tongsl;
	}
	
}
