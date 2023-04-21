package model;

public class KhachHangModel {
	public int id_kh;
	public String makh;
	public String tenkh;
	public String gioitinh;
	public String email;
	public int sodth;
	public int diemtl;

	public KhachHangModel() {
		this.id_kh=0;
		this.makh=new String();
		this.tenkh=new String();
		this.gioitinh= new String();
		this.email=new String();
		this.sodth=0;
		this.diemtl=0;
	
		
	}
	public KhachHangModel(int id,String makh,String tenkh, String gioitinh, String email, int sodth,int diemtl) {
		this.id_kh=id;
		this.makh=makh;
		this.tenkh=tenkh;
		this.gioitinh=gioitinh;
		this.email=email;
		this.sodth=sodth;
		this.diemtl=diemtl;
	}
	public final int getId_kh() {
		return id_kh;
	}
	public final void setId_kh(int id_kh) {
		this.id_kh = id_kh;
	}
	public final String getMakh() {
		return makh;
	}
	public final void setMakh(String makh) {
		this.makh = makh;
	}
	public final String getTenkh() {
		return tenkh;
	}
	public final void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}
	public final String getGioitinh() {
		return gioitinh;
	}
	public final void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final int getSodth() {
		return sodth;
	}
	public final void setSodth(int sodth) {
		this.sodth = sodth;
	}
	public final int getDiemtl() {
		return diemtl;
	}
	public final void setDiemtl(int diemtl) {
		this.diemtl = diemtl;
	}
	
	
	
}
