package model.bean;

public class dangkydichvu extends congviec {
	@Override
	public String toString() {
		return "dangkydichvu [macongviec=" + macongviec + ", maungvien=" + maungvien + ", trangthai=" + trangthai + "]";
	}

	private int macongviec, maungvien, trangthai;
	private ungvien ungvien;

	public ungvien getUngvien() {
		return ungvien;
	}

	public void setUngvien(ungvien ungvien) {
		this.ungvien = ungvien;
	}

	public dangkydichvu(int macongviec, int maungvien, int trangthai) {
		super();
		this.macongviec = macongviec;
		this.maungvien = maungvien;
		this.trangthai = trangthai;
	}

	public int getMacongviec() {
		return macongviec;
	}

	public void setMacongviec(int macongviec) {
		this.macongviec = macongviec;
	}

	public int getMaungvien() {
		return maungvien;
	}

	public void setMaungvien(int maungvien) {
		this.maungvien = maungvien;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public dangkydichvu() {
		super();
	}

}
