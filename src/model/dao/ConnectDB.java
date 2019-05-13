package model.dao;
/**
 * ConnectDB.java
 * 
 * Date: Aug 5, 2018
 * 
 * DATE               AUTHOR          DESCRIPTION				
 * -------------------------------------------------				
 * Aug 5, 2018        DanTT           Create				
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {

	static String url = "jdbc:sqlserver://localhost:1433;databaseName=osin";
	static String userName = "sa";
	static String password = "123456";
	
	public static Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			return DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static int sinhMa(String tenBang) {
		String sql = String.format("SELECT MAX(id) FROM %s",tenBang);
		Connection conn = ConnectDB.getConnection();
		int index = 0;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				index = rs.getInt(1)+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return index;
	}
	public static void main(String[] args) {
		System.out.println(sinhMa("dichvu"));
	}
}
