package model;

public class NhanVienModel {
	public int id_nv;
	public String hoTen;
	public String namSinh;
	public int gioiTinh;
	public String taiKhoan;
	public String matKhau;
	public String email;
	public String soDth;
	public String chucVu;
	public String photo;

	public NhanVienModel() {
		this.id_nv=0;
		this.hoTen=new String();
		this.namSinh=new String();
		this.gioiTinh= 0;
		this.taiKhoan=new String();
		this.email=new String();
		this.matKhau=new String();
		this.soDth=new String();
		this.chucVu=new String();
		this.photo=new String();
		
	}
	public NhanVienModel(int id,String manv,String hoTen,String namSinh, int gioitinh, String taiKhoan, String matKhau,String email, String soDth,String chucVu) {
		this.id_nv=id;
		this.hoTen=hoTen;
		this.namSinh=namSinh;
		this.gioiTinh=gioitinh;
		this.taiKhoan=taiKhoan;
		this.email=email;
		this.matKhau=matKhau;
		this.soDth=soDth;
		this.chucVu=chucVu;
	}
	public final String getPhoto() {
		return photo;
	}
	public final void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}
	public int getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public final int getId_nv() {
		return id_nv;
	}
	public final void setId_nv(int id_nv) {
		this.id_nv = id_nv;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSoDth() {
		return soDth;
	}
	public void setSoDth(String soDth) {
		this.soDth = soDth;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	
	
}
