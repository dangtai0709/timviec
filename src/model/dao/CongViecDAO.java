package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.congviec;

public class CongViecDAO {
	Connection connection = null;;

	private void connect() {
		connection = ConnectDB.getConnection();
	}

	public ArrayList<congviec> layDanhSachcongviec(String madichvu) {
		connect();
		String sql;
		if (madichvu == "") {
			sql = "select congviec.*,tendichvu,tencongty,email from congviec join dichvu on congviec.madichvu=dichvu.madichvu\r\n" + 
					"join khachhang on khachhang.makhachhang= congviec.makhachhang  ";
		} else {
			sql = "select congviec.*,tendichvu,tencongty,email from congviec join dichvu on congviec.madichvu=dichvu.madichvu\r\n" + 
					"left join khachhang on khachhang.makhachhang= congviec.makhachhang where congviec.madichvu='"
					+ madichvu + "'";
		}
		ResultSet rs = null;
		try {
			Statement ps = connection.createStatement();
			rs = ps.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<congviec> list = new ArrayList<congviec>();
		congviec congviec;
		try {
			while (rs.next()) {
				congviec = new congviec();
				congviec.setId(rs.getInt(1));
				congviec.setMadichvu(rs.getString(2));
				congviec.setLuong(rs.getInt(3));
				congviec.setMota(rs.getString(4));
				congviec.setDiadiem(rs.getString(5));
				congviec.setNgayhethan(rs.getString(6));
				congviec.setSonguoi(rs.getInt(7));
				congviec.setSogio(rs.getInt(8));
				congviec.setMakhachhang(rs.getInt(9));
				congviec.setTendichvu(rs.getString(10));
				congviec.setTencongty(rs.getString(11));
				congviec.setEmail(rs.getString(12));
				congviec.setSonguoinhan(songuoinhan(rs.getInt(1)));
				list.add(congviec);
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

	public ArrayList<congviec> laycongviecTheoSoDienThoai(int soDienThoai) {
		connect();
		System.out.println(soDienThoai);
		congviec congviec = null;
		ArrayList<congviec> list = new ArrayList<congviec>();
		String sql = "select * from congviec\r\n" + 
				" where  congviec.makhachhang=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, soDienThoai);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				congviec = new congviec();
				congviec.setId(rs.getInt(1));
				congviec.setMadichvu(rs.getString(2));
				congviec.setLuong(rs.getInt(3));
				congviec.setMota(rs.getString(4));
				congviec.setDiadiem(rs.getString(5));
				congviec.setNgayhethan(rs.getString(6));
				congviec.setSonguoi(rs.getInt(7));
				congviec.setSogio(rs.getInt(8));
				congviec.setMakhachhang(rs.getInt(9));
				congviec.setSonguoinhan(songuoinhan(rs.getInt(1)));
				list.add(congviec);
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
		return list;
	}

	public int songuoinhan(int soDienThoai) {
		connect();

		String sql = "select count(*) as a from dangkydichvu where  macongviec=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, soDienThoai);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return rs.getInt(1);

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

	public void themcongviec(congviec req) {
		connect();
		// dau vao la array

		String sql = "insert into congviec values(?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
		//	ps.setInt(1, 1);
			ps.setString(1, req.getMadichvu());
			ps.setInt(2, req.getLuong());
			ps.setString(3, req.getMota());
			ps.setString(4, req.getDiadiem());
			ps.setString(5, req.getNgayhethan());
			ps.setInt(6, req.getSonguoi());
			ps.setInt(7, req.getSogio());
			ps.setInt(8, req.getMakhachhang());
			//
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

	public void suacongviecTheoSoDienThoai(String hoTen, String soDienThoai, int namSinh, String diaChi,
			String macongviec) {
		connect();
		// dau vao la array chua sua // sua luon taikhoan nha
		String sql = "update congviec set HoTen = ?, NamSinh = ?, DiaChi = ?, Macongviec = ? where  SoDienThoai = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, hoTen);
			ps.setString(2, soDienThoai);
			ps.setInt(3, namSinh);
			ps.setString(4, diaChi);
			ps.setString(5, macongviec);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void xoacongviecTheoSoDienThoai(int soDienThoai) {
		connect();
		String sql0 = "delete from congviec where id = ?";
System.out.println(soDienThoai);
		try {

			PreparedStatement ps = connection.prepareStatement(sql0);
			ps.setInt(1, soDienThoai);
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
		CongViecDAO cv = new CongViecDAO();
		//System.out.println(cv.songuoinhan(1));
		//System.out.println(cv.laycongviecTheoSoDienThoai(1234));
		 System.out.println(cv.layDanhSachcongviec("DV1"));
		// congviec nguoi = new congviec();
		// nguoi.setSodienthoai(1234);
		// nguoi.setMatkhau("xxxx");
		// uv.themcongviec(nguoi);
		// congviec uvn = uv.laycongviecTheoSoDienThoai("0976573743");
		// System.out.println(uvn.getTencongviec());
	}
}
