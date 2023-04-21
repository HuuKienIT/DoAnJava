package model;

public class NhanVienModel {
	public int id_Tk;
	public String manv;
	public String hoTen;
	public String namSinh;
	public String gioiTinh;
	public String taiKhoan;
	public String matKhau;
	public String email;
	public int soDth;
	public String chucVu;
	public String photo;

	public NhanVienModel() {
		this.id_Tk=0;
		this.manv=new String();
		this.hoTen=new String();
		this.namSinh=new String();
		this.gioiTinh= new String();
		this.taiKhoan=new String();
		this.email=new String();
		this.matKhau=new String();
		this.soDth=0;
		this.chucVu=new String();
		this.photo=new String();
		
	}
	public NhanVienModel(int id,String manv,String hoTen,String namSinh, String gioitinh, String taiKhoan, String matKhau,String email, int soDth,String chucVu) {
		this.id_Tk=id;
		this.manv=manv;
		this.hoTen=hoTen;
		this.namSinh=namSinh;
		this.gioiTinh=gioiTinh;
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
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public int getId_Tk() {
		return id_Tk;
	}
	public void setId_Tk(int id_Tk) {
		this.id_Tk = id_Tk;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
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
	public int getSoDth() {
		return soDth;
	}
	public void setSoDth(int soDth) {
		this.soDth = soDth;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	
	
}
