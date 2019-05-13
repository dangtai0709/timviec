package model.bo;

import java.util.ArrayList;

import model.bean.ungvien;
import model.dao.ConnectDB;
import model.dao.UngVienDAO;

public class UngVienBO {
	UngVienDAO ungVienDAO = new UngVienDAO();

	public ungvien layUngVienTheoSoDienThoai(String soDienThoai) {
		return ungVienDAO.layungvienTheoSoDienThoai(soDienThoai);
	}
	
	public void themungvien(ungvien req) {
		ungVienDAO.themungvien(req);
	}
	
	public void suaUngVienTheoSoDienThoai(String hoTen,String soDienThoai, int namSinh, String diaChi, String maDichVu) {
		ungVienDAO.suaungvienTheoSoDienThoai(hoTen, soDienThoai, namSinh, diaChi, maDichVu);
	}
	
	public void xoaUngVienTheoSoDienThoai(String soDienThoai) {
		ungVienDAO.xoaungvienTheoSoDienThoai(soDienThoai);
	}
	
	public ArrayList<ungvien> layDanhSachUngVien() {
		return ungVienDAO.layDanhSachungvien();
	}
	
	public ArrayList<ungvien> layDanhSachUngVienTheoDV(String maDichVu) {
		return ungVienDAO.layDanhSachungvienTheoDV(maDichVu);
	}
	
}
