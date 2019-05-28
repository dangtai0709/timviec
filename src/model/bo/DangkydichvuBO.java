package model.bo;

import java.util.ArrayList;

import model.bean.dangkydichvu;
import model.dao.DangkydichvuDAO;


public class DangkydichvuBO {
	DangkydichvuDAO dv= new DangkydichvuDAO();
	public ArrayList<dangkydichvu> layDanhSachdangkydichvu() {
		return dv.layDanhSachdangkydichvu();
	}

	public ArrayList<dangkydichvu> laydsdangkydichvuTheoSoDienThoai(int soDienThoai) {
		return dv.laydsdangkydichvuTheoSoDienThoai(soDienThoai);
	}

	public boolean themdangkydichvu(dangkydichvu req) {
	 return	dv.themdangkydichvu(req);
	}

	public void suadangkydichvuTheoSoDienThoai(int macongviec, int maungvien) {
		dv.suadangkydichvuTheoSoDienThoai(macongviec, maungvien);
	}
	public void suadangkydichvu(int macongviec, int maungvien) {
		dv.suadangkydichvu(macongviec, maungvien);
	}

	public void xoadangkydichvuTheoSoDienThoai(int soDienThoai,int maungvien) {
		dv.xoadangkydichvuTheoSoDienThoai(soDienThoai, maungvien);
	}
	public ArrayList<dangkydichvu> laydsdangky(int soDienThoai) {
		return dv.laydsdangky(soDienThoai);
	}
}
