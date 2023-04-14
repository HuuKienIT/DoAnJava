package model;

public class sanPhamGH extends sanPham{
	@Override
	public String toString() {
		return "sanPhamGH [soluong=" + soluong + ", id_sp=" + id_sp + ", masp=" + masp + ", tensp=" + tensp + ", gia="
				+ gia + ", donvi=" + ", conlai=" + conlai + "]";
	}
	public int soluong;
	public sanPhamGH() {
		super();
		this.soluong=0;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
}
