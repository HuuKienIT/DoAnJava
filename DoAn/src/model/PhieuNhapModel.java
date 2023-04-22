package model;

import java.time.LocalDate;

public class PhieuNhapModel {
	public int id_pn;
	public int id_ncc;
	public int id_nv;
	public int tongtien;
	public LocalDate ngaynhap;
	public int tongsl;
	public PhieuNhapModel() {
		this.id_pn =0;
		this.id_ncc =0;
		this.id_nv =0;
		this.tongtien =0;
		this.tongsl =0;
		this.ngaynhap =java.time.LocalDate.now();
	}
	public final int getId_pn() {
		return id_pn;
	}
	public final void setId_pn(int id_pn) {
		this.id_pn = id_pn;
	}
	public final int getId_ncc() {
		return id_ncc;
	}
	public final void setId_ncc(int id_ncc) {
		this.id_ncc = id_ncc;
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
	public final LocalDate getNgaynhap() {
		return ngaynhap;
	}
	public final void setNgaynhap(LocalDate ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
	public final int getTongsl() {
		return tongsl;
	}
	public final void setTongsl(int tongsl) {
		this.tongsl = tongsl;
	}
	
	
}
