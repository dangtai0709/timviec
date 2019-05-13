package model.bean;

public class taikhoan {
	@Override
	public String toString() {
		return "taikhoan [matkhau=" + matkhau + ", diachi=" + diachi + ", ngaysinh=" + ngaysinh + ", gioitinh="
				+ gioitinh + ", hoten=" + hoten + ", sodienthoai=" + sodienthoai + ", quyen=" + quyen + "]";
	}

	private String matkhau, diachi, ngaysinh, gioitinh, hoten;
	private int sodienthoai, quyen;

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public int getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(int sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public int getQuyen() {
		return quyen;
	}

	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}

	public taikhoan(String matkhau, String diachi, String ngaysinh, String gioitinh, String hoten, int sodienthoai,
			int quyen) {
		super();
		this.matkhau = matkhau;
		this.diachi = diachi;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.hoten = hoten;
		this.sodienthoai = sodienthoai;
		this.quyen = quyen;
	}

	public taikhoan() {
		super();
	}

}
