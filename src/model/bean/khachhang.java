package model.bean;

public class khachhang extends taikhoan {
	private String tencongty, emailcty,  diachicty;
	
	private int sodienthoaicty,makhachhang;

	

	public khachhang(String matkhau, String diachi, String ngaysinh, String gioitinh, String hoten, int sodienthoai,
			int quyen, String tencongty, String emailcty, String diachicty, int sodienthoaicty, int makhachhang) {
		super(matkhau, diachi, ngaysinh, gioitinh, hoten, sodienthoai, quyen);
		this.tencongty = tencongty;
		this.emailcty = emailcty;
		this.diachicty = diachicty;
		this.sodienthoaicty = sodienthoaicty;
		this.makhachhang = makhachhang;
	}



	public String getTencongty() {
		return tencongty;
	}



	public void setTencongty(String tencongty) {
		this.tencongty = tencongty;
	}



	public String getEmailcty() {
		return emailcty;
	}



	public void setEmailcty(String emailcty) {
		this.emailcty = emailcty;
	}



	public String getDiachicty() {
		return diachicty;
	}



	public void setDiachicty(String diachicty) {
		this.diachicty = diachicty;
	}



	public int getSodienthoaicty() {
		return sodienthoaicty;
	}



	public void setSodienthoaicty(int sodienthoaicty) {
		this.sodienthoaicty = sodienthoaicty;
	}



	public int getMakhachhang() {
		return makhachhang;
	}



	public void setMakhachhang(int makhachhang) {
		this.makhachhang = makhachhang;
	}



	public khachhang() {
		super();
	}
	
}
