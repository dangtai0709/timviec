package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.ungvien;

public class UngVienDAO {
	Connection connection = null;;

	private void connect() {
		connection = ConnectDB.getConnection();
	}

	public ArrayList<ungvien> layDanhSachungvien() {
		connect();
		String sql = "select * from ungvien join taikhoan on ungvien.maungvien=taikhoan.sodienthoai    ";
		ResultSet rs = null;
		try {
			Statement ps = connection.createStatement();
			rs = ps.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<ungvien> list = new ArrayList<ungvien>();
		ungvien ungvien;
		try {
			while (rs.next()) {
				ungvien = new ungvien();
				ungvien.setMaungvien(rs.getInt(1));
				ungvien.setGioithieubanthan(rs.getString(3));
				ungvien.setMadichvu(rs.getString(4));
				ungvien.setDiachi(rs.getString(7));
				ungvien.setNgaysinh(rs.getString(9));
				ungvien.setGioitinh(rs.getString(10));
				ungvien.setHoten(rs.getString(11));
				list.add(ungvien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public ArrayList<ungvien> layDanhSachungvienTheoDV(String maDichVu) {
		connect();
		String sql = "select * from ungvien join taikhoan on ungvien.maungvien=taikhoan.sodienthoai where madichvu=?  ";
		ResultSet rs = null;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, maDichVu);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<ungvien> list = new ArrayList<ungvien>();
		ungvien ungvien;
		try {
			while (rs.next()) {
				ungvien = new ungvien();
				ungvien.setMaungvien(rs.getInt(1));
				ungvien.setGioithieubanthan(rs.getString(3));
				ungvien.setMadichvu(rs.getString(4));
				ungvien.setDiachi(rs.getString(7));
				ungvien.setNgaysinh(rs.getString(9));
				ungvien.setGioitinh(rs.getString(10));
				ungvien.setHoten(rs.getString(11));
				list.add(ungvien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public ungvien layungvienTheoSoDienThoai(String soDienThoai) {
		connect();
		ungvien ungvien = null;
		String sql = "select * from ungvien join taikhoan on ungvien.maungvien=taikhoan.sodienthoai where sodienthoai=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, soDienThoai);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ungvien = new ungvien();
				ungvien.setCmnd(rs.getInt(2));
				ungvien.setMaungvien(rs.getInt(1));
				ungvien.setGioithieubanthan(rs.getString(3));
				ungvien.setMadichvu(rs.getString(4));
				ungvien.setDiachi(rs.getString(8));
				ungvien.setNgaysinh(rs.getString(10));
				ungvien.setGioitinh(rs.getString(11));
				ungvien.setHoten(rs.getString(12));
				;
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
		return ungvien;
	}

	public void themungvien(ungvien req) {
		connect();
		// dau vao la array

		String sql = "insert into ungvien values(?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, req.getMaungvien());
			ps.setInt(2, req.getCmnd());
			ps.setString(3, req.getGioithieubanthan());
			ps.setString(4, req.getMadichvu());
			ps.executeUpdate();

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
	}

	public void suaungvienTheoSoDienThoai(String hoTen, String soDienThoai, int namSinh, String diaChi,
			String maDichVu) {
		connect();
		// dau vao la array chua sua
		String sql = "update ungvien set HoTen = ?, NamSinh = ?, DiaChi = ?, MaDichVu = ? where  SoDienThoai = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, hoTen);
			ps.setString(2, soDienThoai);
			ps.setInt(3, namSinh);
			ps.setString(4, diaChi);
			ps.setString(5, maDichVu);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void xoaungvienTheoSoDienThoai(String soDienThoai) {
		connect();

		String sql = "delete from ungvien where maungvien = " + soDienThoai
				+ "delete from taikhoan where sodienthoai = " + soDienThoai
				+ "delete from dangkydichvu where maungvien = " + soDienThoai;
		PreparedStatement ps = null;
		try {

			
			ps = connection.prepareStatement(sql);
			ps.executeUpdate();

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
	}

	public static void main(String[] args) {
		UngVienDAO uv = new UngVienDAO();
		// ungvien nguoi= new ungvien();
		// nguoi.setSodienthoai(1234);
		// nguoi.setMatkhau("xxxx");
		// uv.themungvien(nguoi);
		// System.out.println(uv.layDanhSachungvienTheoDV("DV2"));
		// ungvien uvn = uv.layungvienTheoSoDienThoai("0976573743");
		// System.out.println(uvn.getTenDichVu());
		uv.xoaungvienTheoSoDienThoai("3333");
	}

	// public boolean kiemTraungvien(String soDienThoai) {
	// connect();
	// String sql = "select * from ungvien where SoDienThoai = ?";
	// try {
	// PreparedStatement ps = connection.prepareStatement(sql);
	// ps.setString(1, soDienThoai);
	// ResultSet rs = ps.executeQuery();
	// while(rs.next()) {
	// return true;
	// }
	//
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }finally {
	// try {
	// connection.close();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// return false;
	// }
}
