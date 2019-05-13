package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.khachhang;

public class KhachHangDAO {
	Connection connection = null;;

	private void connect() {
		connection = ConnectDB.getConnection();
	}

	public ArrayList<khachhang> layDanhSachkhachhang() {
		connect();
		String sql = "select * from khachhang   ";
		ResultSet rs = null;
		try {
			Statement ps = connection.createStatement();
			rs = ps.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<khachhang> list = new ArrayList<khachhang>();
		khachhang khachhang;
		try {
			while (rs.next()) {
				khachhang = new khachhang();
				khachhang.setMakhachhang(rs.getInt(1));
				khachhang.setTencongty(rs.getString(2));
				khachhang.setEmailcty(rs.getString(3));
				khachhang.setDiachicty(rs.getString(5));
				khachhang.setSodienthoaicty(rs.getInt(4));
				list.add(khachhang);
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

	public khachhang laykhachhangTheoSoDienThoai(String soDienThoai) {
		connect();
		khachhang khachhang = null;
		String sql = "select * from khachhang where  makhachhang=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, soDienThoai);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				khachhang = new khachhang();
				khachhang.setMakhachhang(rs.getInt(1));
				khachhang.setTencongty(rs.getString(2));
				khachhang.setEmailcty(rs.getString(3));
				khachhang.setDiachicty(rs.getString(5));
				khachhang.setSodienthoaicty(rs.getInt(4));

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
		return khachhang;
	}

	public void themkhachhang(khachhang req) {
		connect();
		// dau vao la array

		String sql = "insert into khachhang values(?,?,?,?,?)";
		// String sql1 = "insert into taikhoan values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, req.getMakhachhang());
			ps.setString(2, req.getTencongty());
			ps.setString(3, req.getEmailcty());
			ps.setInt(4, req.getSodienthoaicty());
			ps.setString(5, req.getDiachicty());
			ps.executeUpdate();
			// ps = connection.prepareStatement(sql1);
			// ps.setInt(1, req.getSodienthoai());
			// ps.setString(2, req.getMatkhau());
			// ps.setString(3, req.getDiachi());
			// ps.setInt(4, req.getQuyen());
			// ps.setString(5, req.getNgaysinh());
			// ps.setString(6, req.getGioitinh());
			// ps.setString(6, req.getHoten());
			// ps.executeUpdate();
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

	public void suakhachhangTheoSoDienThoai(String hoTen, String soDienThoai, int namSinh, String diaChi,
			String maDichVu) {
		connect();
		// dau vao la array chua sua // sua luon taikhoan nha
		String sql = "update khachhang set HoTen = ?, NamSinh = ?, DiaChi = ?, MaDichVu = ? where  SoDienThoai = ?";
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

	public void xoakhachhangTheoSoDienThoai(String soDienThoai) {
		connect();
		String sql = "delete from khachhang where makhachhang = "+soDienThoai + "delete from taikhoan where sodienthoai = "+soDienThoai
				+ "delete from congviec where makhachhang = "+soDienThoai
				+ "delete from dangkydichvu where macongviec in (select macongviec from congviec where makhachhang="+soDienThoai+")";
		try {
		
				PreparedStatement ps = connection.prepareStatement(sql);
				
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
		KhachHangDAO uv = new KhachHangDAO();
//		khachhang nguoi = new khachhang();
//		nguoi.setSodienthoai(1234);
//		nguoi.setMatkhau("xxxx");
//		uv.themkhachhang(nguoi);
		uv.xoakhachhangTheoSoDienThoai("9898");
		// khachhang uvn = uv.laykhachhangTheoSoDienThoai("0976573743");
		// System.out.println(uvn.getTenDichVu());
	}
}
