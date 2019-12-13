package com.duongminhtai.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.duongminhtai.model.bean.PhongBan;
import com.duongminhtai.util.DBConnection;

public class PhongBanDAO {
	private Connection conn = null;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;

	public List<PhongBan> getListPhongBan() {
		conn = DBConnection.getConnection();
		List<PhongBan> listPhongBan = new ArrayList<PhongBan>();
		String sql = "SELECT id, name FROM phongban";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				PhongBan phongBan = new PhongBan(rs.getString("id"), rs.getString("name"));
				listPhongBan.add(phongBan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPhongBan;
	}

	public PhongBan getPhongBan(String id) {
		conn = DBConnection.getConnection();
		PhongBan phongBan = null;
		String sql = "SELECT id, name FROM phongban WHERE id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				phongBan = new PhongBan(rs.getString("id"), rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phongBan;
	}

	public int delPhongBan(String id) {
		conn = DBConnection.getConnection();
		int result = 0;
		String sql = "DELETE FROM phongban WHERE id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int addPhongBan(PhongBan phongban) {
		conn = DBConnection.getConnection();
		int result = 0;
		String sql = "INSERT INTO phongban(id, name) VALUES (?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, phongban.getId());
			ps.setString(2, phongban.getName());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int editPhongBan(PhongBan phongban) {
		conn = DBConnection.getConnection();
		int result = 0;
		String sql = "UPDATE phongban SET name=? WHERE id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, phongban.getName());
			ps.setString(2, phongban.getId());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
