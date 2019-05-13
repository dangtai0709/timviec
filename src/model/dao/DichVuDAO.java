package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.dichvu;

public class DichVuDAO {
	Connection connection = null;;

	private void connect() {
		connection = ConnectDB.getConnection();
	}

	public ArrayList<dichvu> layDanhSachdichvu() {
		connect();
		String sql = "select * from dichvu   ";
		ResultSet rs = null;
		try {
			Statement ps = connection.createStatement();
			rs = ps.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<dichvu> list = new ArrayList<dichvu>();
		dichvu dichvu;
		try {
			while (rs.next()) {
				dichvu = new dichvu();
				dichvu.setMadichvu(rs.getString(1));
				dichvu.setTendichvu(rs.getString(2));
				list.add(dichvu);
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

	public dichvu laydichvuTheoSoDienThoai(String soDienThoai) {
		connect();
		dichvu dichvu = null;
		String sql = "select * from dichvu where  madichvu=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, soDienThoai);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dichvu = new dichvu();
				dichvu.setMadichvu(rs.getString(1));
				dichvu.setTendichvu(rs.getString(2));

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
		return dichvu;
	}

	public void themdichvu(dichvu req) {
		connect();
		// dau vao la array

		String sql = "insert into dichvu values(?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, req.getMadichvu());
			ps.setString(2, req.getTendichvu());
			
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

	public void suadichvuTheoSoDienThoai(dichvu req) {
		connect();
		// dau vao la array chua sua // sua luon taikhoan nha
		String sql = "update dichvu set tendichvu=? where madichvu=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, req.getTendichvu());
			ps.setString(2, req.getMadichvu());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void xoadichvuTheoSoDienThoai(String soDienThoai) {
		connect();
		String sql0 = "delete from dichvu where madichvu = ?";
		
		try {
			
				PreparedStatement ps = connection.prepareStatement(sql0);
				ps.setString(1, soDienThoai);
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
		DichVuDAO dvd= new DichVuDAO();
		dichvu dv = new dichvu();
		dv.setMadichvu("DV26");
		dv.setTendichvu("tesst");
		//dvd.themdichvu(dv);
		dvd.suadichvuTheoSoDienThoai(dv);
//		dichvuDAO uv = new dichvuDAO();
//		dichvu nguoi = new dichvu();
//		nguoi.setSodienthoai(1234);
//		nguoi.setMatkhau("xxxx");
//		uv.themdichvu(nguoi);
		// dichvu uvn = uv.laydichvuTheoSoDienThoai("0976573743");
		// System.out.println(uvn.getTenDichVu());
	}
}
