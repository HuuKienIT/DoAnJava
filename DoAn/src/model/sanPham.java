package model;

public class sanPham {
	public int id_sp;
	public String masp;
	public String manh;
	public String tensp;
	public int gia;
	public int conlai ;
	public String photo;
	
	public sanPham() {
		this.id_sp=0;
		this.masp=new String();
		this.manh=new String();
		this.tensp=new String();
		this.gia=0;
		this.conlai=0;
		this.photo=new String();
		
	}

	public int getId_sp() {
		return id_sp;
	}

	public void setId_sp(int id_sp) {
		this.id_sp = id_sp;
	}

	public String getMasp() {
		return masp;
	}

	public void setMasp(String masp) {
		this.masp = masp;
	}

	public String getManh() {
		return manh;
	}

	public void setManh(String manh) {
		this.manh = manh;
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public final String getPhoto() {
		return photo;
	}

	public final void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}


	public int getConlai() {
		return conlai;
	}

	public void setConlai(int conlai) {
		this.conlai = conlai;
	}

	

	
	
	
}
