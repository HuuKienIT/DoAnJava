package model;

public class loai {
	public int id_loai;
	public String ten_loai;
	public loai() {
		this.id_loai=0;
		this.ten_loai= new String();
		
	}
	public final int getId_loai() {
		return id_loai;
	}
	public final void setId_loai(int id_loai) {
		this.id_loai = id_loai;
	}
	public final String getTen_loai() {
		return ten_loai;
	}
	public final void setTen_loai(String ten_loai) {
		this.ten_loai = ten_loai;
	}
	
}
