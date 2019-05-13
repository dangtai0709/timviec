package model.bean;

public class congviec extends dichvu {
	@Override
	public String toString() {
		return "congviec [madichvu=" + madichvu + ", mota=" + mota + ", diadiem=" + diadiem + ", ngayhethan="
				+ ngayhethan + ", id=" + id + ", luong=" + luong + ", songuoi=" + songuoi + ", sogio=" + sogio
				+ ", makhachhang=" + makhachhang + "]";
	}

	private String madichvu, mota, diadiem, ngayhethan,tendichvu,tencongty,email,sodienthoai;
	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public String getTendichvu() {
		return tendichvu;
	}

	public void setTendichvu(String tendichvu) {
		this.tendichvu = tendichvu;
	}

	public String getTencongty() {
		return tencongty;
	}

	public void setTencongty(String tencongty) {
		this.tencongty = tencongty;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private int id, luong, songuoi, sogio, makhachhang,songuoinhan;

	public int getSonguoinhan() {
		return songuoinhan;
	}

	public void setSonguoinhan(int songuoinhan) {
		this.songuoinhan = songuoinhan;
	}

	public congviec() {
		super();
	}

	public String getMadichvu() {
		return madichvu;
	}

	public void setMadichvu(String madichvu) {
		this.madichvu = madichvu;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getDiadiem() {
		return diadiem;
	}

	public void setDiadiem(String diadiem) {
		this.diadiem = diadiem;
	}

	public String getNgayhethan() {
		return ngayhethan;
	}

	public void setNgayhethan(String ngayhethan) {
		this.ngayhethan = ngayhethan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLuong() {
		return luong;
	}

	public void setLuong(int luong) {
		this.luong = luong;
	}

	public int getSonguoi() {
		return songuoi;
	}

	public void setSonguoi(int songuoi) {
		this.songuoi = songuoi;
	}

	public int getSogio() {
		return sogio;
	}

	public void setSogio(int sogio) {
		this.sogio = sogio;
	}

	public int getMakhachhang() {
		return makhachhang;
	}

	public void setMakhachhang(int makhachhang) {
		this.makhachhang = makhachhang;
	}

	public congviec(String madichvu, String mota, String diadiem, String ngayhethan, int id, int luong, int songuoi,
			int sogio, int makhachhang) {
		super();
		this.madichvu = madichvu;
		this.mota = mota;
		this.diadiem = diadiem;
		this.ngayhethan = ngayhethan;
		this.id = id;
		this.luong = luong;
		this.songuoi = songuoi;
		this.sogio = sogio;
		this.makhachhang = makhachhang;
	}

}
