package com.duongminhtai.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.duongminhtai.model.bean.NguoiDung;
import com.duongminhtai.model.bean.Quyen;
import com.duongminhtai.util.DBConnection;

public class NguoiDungDAO {
	private Connection conn = null;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;

	public NguoiDung getNguoiDung(String username, String password) {
		conn = DBConnection.getConnection();
		NguoiDung nguoiDung = null;
		String sql = "SELECT nd.id, nd.fullname, nd.username, nd.password, nd.id_role, q.name AS roleName "
				+ "FROM nguoidung AS nd "
				+ "INNER JOIN quyen AS q "
				+ "ON nd.id_role = q.id "
				+ "WHERE nd.username = ? AND nd.password = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				nguoiDung = new NguoiDung(
						rs.getString("id"), 
						rs.getString("fullname"), 
						rs.getString("username"), 
						rs.getString("password"), new Quyen(
								rs.getInt("id_role"), 
								rs.getString("roleName")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nguoiDung;
	}
	
	public static void main(String[] args) {
		NguoiDungDAO dao = new NguoiDungDAO();
		System.out.println(dao.getNguoiDung("admin", "123456"));
	}
}
