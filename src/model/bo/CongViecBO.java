package model.bo;

import java.util.ArrayList;

import model.bean.congviec;
import model.dao.CongViecDAO;

public class CongViecBO {
	CongViecDAO dv = new CongViecDAO();

	public ArrayList<congviec> layDanhSachcongviec(String madichvu) {
		return dv.layDanhSachcongviec( madichvu);
	}

	public ArrayList<congviec> laycongviecTheoSoDienThoai(int soDienThoai) {
		return dv.laycongviecTheoSoDienThoai(soDienThoai);
	}
	public void themcongviec(congviec req) {
		 dv.themcongviec(req);
	}
	public void suacongviecTheoSoDienThoai(String hoTen, String soDienThoai, int namSinh, String diaChi,
			String macongviec) {
		dv.suacongviecTheoSoDienThoai(hoTen, soDienThoai, namSinh, diaChi, macongviec);
	}
	public void xoacongviecTheoSoDienThoai(int soDienThoai) {
		dv.xoacongviecTheoSoDienThoai(soDienThoai);
	}
}
