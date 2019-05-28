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
		String sql = "select macongviec,dangkydichvu.maungvien,sodienthoai,hoten,congviec.madichvu,trangthai,mota,ngayhethan,id from dangkydichvu\r\n" + 
				"join congviec on congviec.id=dangkydichvu.macongviec\r\n" + 
				"join taikhoan on taikhoan.sodienthoai=dangkydichvu.maungvien join ungvien on dangkydichvu.maungvien=ungvien.maungvien \r\n" + 
				"where makhachhang=? and trangthai <> 2";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, soDienThoai);
			ResultSet rs = ps.executeQuery();
			UngVienDAO uvdao=  new UngVienDAO();
			while (rs.next()) {
				dangkydichvu = new dangkydichvu();
				dangkydichvu.setMacongviec(rs.getInt(1));
				dangkydichvu.setMaungvien(rs.getInt(2));
				dangkydichvu.setSodienthoai(rs.getString(3));
				dangkydichvu.setTencongty(rs.getString(4));
				dangkydichvu.setMadichvu(rs.getString(5));
				dangkydichvu.setTrangthai(rs.getInt(6));
				dangkydichvu.setMota(rs.getString(7));
				dangkydichvu.setNgayhethan(rs.getString(8));
				dangkydichvu.setId(rs.getInt(9));
				dangkydichvu.setUngvien(uvdao.layungvienTheoSoDienThoai(String.valueOf( rs.getInt(2))));
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

	public void suadangkydichvuTheoSoDienThoai(int macongviec, int maungvien) {
		connect();
		// dau vao la array chua sua // sua luon taikhoan nha
		String sql = "update dangkydichvu set trangthai=1 where  macongviec =? and maungvien=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, macongviec);
			ps.setInt(2, maungvien);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void suadangkydichvu(int macongviec, int maungvien) {
		connect();
		// dau vao la array chua sua // sua luon taikhoan nha
		String sql = "update dangkydichvu set trangthai=2 where  macongviec =? and maungvien=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, macongviec);
			ps.setInt(2, maungvien);
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
		
		System.out.println(dkBO.laydsdangky(1234));
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
