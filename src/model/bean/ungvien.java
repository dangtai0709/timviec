package model.bean;

public class ungvien extends taikhoan {
	
	
	@Override
	public String toString() {
		return "gioithieubanthan=" + gioithieubanthan + ", madichvu=" + madichvu + ", maungvien=" + maungvien
				+ ", cmnd=" + cmnd + "";
	}
	public ungvien(String matkhau, String diachi, String ngaysinh, String gioitinh, String hoten, int sodienthoai,
			int quyen, String gioithieubanthan, String madichvu, int maungvien, int cmnd, int trangthai) {
		super(matkhau, diachi, ngaysinh, gioitinh, hoten, sodienthoai, quyen);
		this.gioithieubanthan = gioithieubanthan;
		this.madichvu = madichvu;
		this.maungvien = maungvien;
		this.cmnd = cmnd;
		this.trangthai = trangthai;
	}
	public String getGioithieubanthan() {
		return gioithieubanthan;
	}
	public void setGioithieubanthan(String gioithieubanthan) {
		this.gioithieubanthan = gioithieubanthan;
	}
	public String getMadichvu() {
		return madichvu;
	}
	public void setMadichvu(String madichvu) {
		this.madichvu = madichvu;
	}
	public int getMaungvien() {
		return maungvien;
	}
	public void setMaungvien(int maungvien) {
		this.maungvien = maungvien;
	}
	public int getCmnd() {
		return cmnd;
	}
	public void setCmnd(int cmnd) {
		this.cmnd = cmnd;
	}
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	private String gioithieubanthan, madichvu;
	private int maungvien, cmnd, trangthai;
	public ungvien() {
		super();
	}
	
}
