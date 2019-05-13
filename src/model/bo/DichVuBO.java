package model.bo;

import java.util.ArrayList;

import model.bean.dichvu;
import model.dao.ConnectDB;
import model.dao.DichVuDAO;

public class DichVuBO {
	DichVuDAO dv = new DichVuDAO();

	public ArrayList<dichvu> layDanhSachdichvu() {
		return dv.layDanhSachdichvu();
	}

	public dichvu laydichvuTheoSoDienThoai(String soDienThoai) {
		return dv.laydichvuTheoSoDienThoai(soDienThoai);
	}
	public void themdichvu(dichvu req) {
		 dv.themdichvu(req);
	}
	public void suadichvuTheoSoDienThoai(dichvu req) {
		dv.suadichvuTheoSoDienThoai(req);
	}
	public void xoadichvuTheoSoDienThoai(String soDienThoai) {
		dv.xoadichvuTheoSoDienThoai(soDienThoai);
	}
	public int sinhMa() {
		return ConnectDB.sinhMa("dichvu");
	}
}
