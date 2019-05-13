package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.taikhoan;

public class TaikhoanDAO {
	Connection connection = null;;

	private void connect() {
		connection = ConnectDB.getConnection();
	}

	public int checkLogin(String tenDangNhap, String matKhau) {
		connect();
		String sql = "select * from taikhoan where sodienthoai = ? and matkhau = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, tenDangNhap);
			ps.setString(2, matKhau);
			rs = ps.executeQuery();
			if (rs.next()) {
				if(rs.getInt(4) == 1) {
					return 1;
				}if(rs.getInt(4) == 2) {
					return 2;
				}if(rs.getInt(4) == 3){
					return 3;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	public ArrayList<taikhoan> layDanhSachtaikhoan() {
		connect();
		
		String sql = "select * from taikhoan";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		ArrayList<taikhoan> danhSachtaikhoan = new ArrayList<>();
		taikhoan taikhoan;
		try {
			while (rs.next()) {
				taikhoan = new taikhoan();
				taikhoan.setSodienthoai(rs.getInt(1));
				taikhoan.setMatkhau(rs.getString(2));
				taikhoan.setDiachi(rs.getString(3));
				taikhoan.setQuyen(rs.getInt(4));
				taikhoan.setNgaysinh(rs.getString(5));
				taikhoan.setGioitinh(rs.getString(6));
				taikhoan.setHoten(rs.getString(7));
//				if (rs.getInt(6) != 2) {
//					taikhoan.setMaCongTacVien("None");
//				} else {
//					taikhoan.setMaCongTacVien(rs.getString(7));
//				}
				danhSachtaikhoan.add(taikhoan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return danhSachtaikhoan;
	}

	public taikhoan laytaikhoanTheoMataikhoan(String mataikhoan) {
		taikhoan taikhoan = new taikhoan();
		connect();
		String sql = "select * from taikhoan where sodienthoai = ?";
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, mataikhoan);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				taikhoan = new taikhoan();
				taikhoan.setSodienthoai(rs.getInt(1));
				taikhoan.setMatkhau(rs.getString(2));
				taikhoan.setDiachi(rs.getString(3));
				taikhoan.setQuyen(rs.getInt(4));
				taikhoan.setNgaysinh(rs.getString(5));
				taikhoan.setGioitinh(rs.getString(6));
				taikhoan.setHoten(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return taikhoan;
	}
	
	

	public boolean themtaikhoan(taikhoan req) {
		connect();
		PreparedStatement ps = null;
		String sql1 = "insert into taikhoan values(?,?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql1);
			ps.setInt(1, req.getSodienthoai());
			ps.setString(2, req.getMatkhau());
			ps.setString(3, req.getDiachi());
			ps.setInt(4, req.getQuyen());
			ps.setString(5, req.getNgaysinh());
			ps.setString(6, req.getGioitinh());
			ps.setString(7, req.getHoten());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

//	public void suataikhoanTheoMa(String mataikhoan, String tenTaiKhoan, String soDienThoai, String matKhau,
//			String email, int maQuyen, String maCongTacVien) {
//		connect();
//		String sql = "update taikhoan set TenTaiKhoan = ?, SoDienThoai = ?,MatKhau = ?, Email = ?,MaQuyen = ?, MaCTV= ? where Mataikhoan = ? ";
//		PreparedStatement ps = null;
//
//		try {
//			ps = connection.prepareStatement(sql);
//			ps.setString(7, mataikhoan);
//			ps.setString(1, tenTaiKhoan);
//			ps.setString(2, soDienThoai);
//			ps.setString(3, matKhau);
//			ps.setString(4, email);
//			ps.setInt(5, maQuyen);
//			if (maQuyen == 2) {
//				ps.setString(6, maCongTacVien);
//			}
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	} 
//	
//	public void xoataikhoanTheoMa(String mataikhoan) {
//			connect();
//			String sql = "delete from taikhoan where Mataikhoan = ? ";
//			try {
//				PreparedStatement ps = connection.prepareStatement(sql);
//				ps.setString(1, mataikhoan);
//				ps.executeUpdate();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}
	public static void main(String[] args) {
		TaikhoanDAO tkdao= new TaikhoanDAO();
		taikhoan tk = new taikhoan();
		tk.setDiachi("1");
		tk.setGioitinh("1");
		tk.setHoten("1");
		tk.setMatkhau("1");
		tk.setNgaysinh("1");
		tk.setQuyen(1);
		tk.setSodienthoai(123456);
		System.out.println(tkdao.themtaikhoan(tk));
	}
	
}
