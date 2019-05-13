package model.bo;

import java.util.ArrayList;

import model.bean.khachhang;
import model.dao.ConnectDB;
import model.dao.KhachHangDAO;


public class KhachHangBO {
	KhachHangDAO khachhangDAO = new KhachHangDAO();

	public khachhang laykhachhangTheoSoDienThoai(String soDienThoai) {
		return khachhangDAO.laykhachhangTheoSoDienThoai(soDienThoai);
	}
	
	public void themkhachhang(khachhang req) {
		khachhangDAO.themkhachhang(req);
	}
	
	public void suakhachhangTheoSoDienThoai(String hoTen,String soDienThoai, int namSinh, String diaChi, String maDichVu) {
		khachhangDAO.suakhachhangTheoSoDienThoai(hoTen, soDienThoai, namSinh, diaChi, maDichVu);
	}
	
	public void xoakhachhangTheoSoDienThoai(String soDienThoai) {
		khachhangDAO.xoakhachhangTheoSoDienThoai(soDienThoai);
	}
	
	public ArrayList<khachhang> layDanhSachkhachhang() {
		return khachhangDAO.layDanhSachkhachhang();
	}
	
	
}
