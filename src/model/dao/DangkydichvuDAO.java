package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.dangkydichvu;
import model.bo.DangkydichvuBO;

public class DangkydichvuDAO {
	Connection connection = null;;

	private void connect() {
		connection = ConnectDB.getConnection();
	}

	public ArrayList<dangkydichvu> layDanhSachdangkydichvu() {
		connect();
		String sql = "select * from dangkydichvu   ";
		ResultSet rs = null;
		try {
			Statement ps = connection.createStatement();
			rs = ps.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<dangkydichvu> list = new ArrayList<dangkydichvu>();
		dangkydichvu dangkydichvu;
		try {
			while (rs.next()) {
				dangkydichvu = new dangkydichvu();
				dangkydichvu.setMacongviec(rs.getInt(1));
				dangkydichvu.setMaungvien(rs.getInt(2));
				dangkydichvu.setTrangthai(rs.getInt(3));
				list.add(dangkydichvu);
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

	public ArrayList<dangkydichvu> laydsdangkydichvuTheoSoDienThoai(int soDienThoai) {
		connect();
		dangkydichvu dangkydichvu = null;
		
		ArrayList<dangkydichvu> list = new ArrayList<dangkydichvu>();
		String sql = "select * from dangkydichvu\r\n" + 
				"join congviec on congviec.id=dangkydichvu.macongviec\r\n" + 
				"join khachhang on khachhang.makhachhang=congviec.makhachhang where   macongviec=? or maungvien=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, soDienThoai);
			ps.setInt(2, soDienThoai);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				dangkydichvu = new dangkydichvu();
				dangkydichvu.setMacongviec(rs.getInt(1));
				dangkydichvu.setMaungvien(rs.getInt(2));
				dangkydichvu.setTrangthai(rs.getInt(3));
				dangkydichvu.setId(rs.getInt(4));
				dangkydichvu.setMadichvu(rs.getString(5));
				dangkydichvu.setLuong(rs.getInt(6));
				dangkydichvu.setMota(rs.getString(7));
				dangkydichvu.setDiadiem(rs.getString(8));
				dangkydichvu.setNgayhethan(rs.getString(9));
				dangkydichvu.setSonguoi(rs.getInt(10));
				dangkydichvu.setSogio(rs.getInt(11));
				dangkydichvu.setMakhachhang(rs.getInt(12));
				dangkydichvu.setTencongty(rs.getString(14));
				dangkydichvu.setEmail(rs.getString(15));
				dangkydichvu.setSodienthoai(rs.getString(16));
				list.add(dangkydichvu);
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
	public ArrayList<dangkydichvu> laydsdangky(int soDienThoai) {
		connect();
		dangkydichvu dangkydichvu = null;
		
		ArrayList<dangkydichvu> list = new ArrayList<dangkydichvu>();
		String sql = "select macongviec,maungvien,sodienthoai,hoten,madichvu from dangkydichvu\r\n" + 
				"join congviec on congviec.id=dangkydichvu.macongviec\r\n" + 
				"join taikhoan on taikhoan.sodienthoai=dangkydichvu.maungvien \r\n" + 
				"where makhachhang=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, soDienThoai);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				dangkydichvu = new dangkydichvu();
				dangkydichvu.setMacongviec(rs.getInt(1));
				dangkydichvu.setMaungvien(rs.getInt(2));
				dangkydichvu.setSodienthoai(rs.getString(3));
				dangkydichvu.setTencongty(rs.getString(4));
				dangkydichvu.setMadichvu(rs.getString(5));
				list.add(dangkydichvu);
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

	public boolean themdangkydichvu(dangkydichvu req) {
		connect();
		// dau vao la array

		String sql = "insert into dangkydichvu values(?,?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, req.getMacongviec());
			ps.setInt(2, req.getMaungvien());
			ps.setInt(3, req.getTrangthai());
			ps.executeUpdate();
				return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
				return false;
				
			}
		}
		
	}

	public void suadangkydichvuTheoSoDienThoai(String hoTen, String soDienThoai, int namSinh, String diaChi,
			String madangkydichvu) {
		connect();
		// dau vao la array chua sua // sua luon taikhoan nha
		String sql = "update dangkydichvu set HoTen = ?, NamSinh = ?, DiaChi = ?, Madangkydichvu = ? where  SoDienThoai = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, hoTen);
			ps.setString(2, soDienThoai);
			ps.setInt(3, namSinh);
			ps.setString(4, diaChi);
			ps.setString(5, madangkydichvu);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void xoadangkydichvuTheoSoDienThoai(int soDienThoai,int maungvien) {
		connect();
		String sql0 = "delete from dangkydichvu where macongviec = ? and maungvien=?";
		
		try {
			//
				PreparedStatement ps = connection.prepareStatement(sql0);
				ps.setInt(1, soDienThoai);
				ps.setInt(2, maungvien);
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
		DangkydichvuBO dkBO = new DangkydichvuBO();
//		dangkydichvu dk= new dangkydichvu();
//		
//		dk.setMacongviec(121234234);
//		dk.setMaungvien(123);
//		dk.setTrangthai(0);
		//System.out.println(dkBO.laydangkydichvuTheoSoDienThoai(123));
//		dangkydichvuDAO uv = new dangkydichvuDAO();
//		dangkydichvu nguoi = new dangkydichvu();
//		nguoi.setSodienthoai(1234);
//		nguoi.setMatkhau("xxxx");
//		uv.themdangkydichvu(nguoi);
		// dangkydichvu uvn = uv.laydangkydichvuTheoSoDienThoai("0976573743");
		// System.out.println(uvn.getTendangkydichvu());
	}
}