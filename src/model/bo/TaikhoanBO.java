package model.bo;

import java.util.ArrayList;

import model.bean.taikhoan;
import model.dao.TaikhoanDAO;

public class TaikhoanBO {
	TaikhoanDAO tk = new TaikhoanDAO();

	public int checkLogin(String tenDangNhap, String matKhau) {
		return tk.checkLogin(tenDangNhap, matKhau);
	}
	public ArrayList<taikhoan> layDanhSachtaikhoan() {
		return tk.layDanhSachtaikhoan();
	}
	public taikhoan laytaikhoanTheoMataikhoan(String mataikhoan) {
		return tk.laytaikhoanTheoMataikhoan(mataikhoan);
	}
	public boolean themtaikhoan(taikhoan req) {
	 return	tk.themtaikhoan(req);
	}
}
