package com.duongminhtai.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.duongminhtai.model.bean.NhanVien;
import com.duongminhtai.model.bean.PhongBan;
import com.duongminhtai.util.DBConnection;

public class NhanVienDAO {
	private Connection conn = null;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public List<NhanVien> getListNhanVien(){
		conn = DBConnection.getConnection();
		List<NhanVien> listNhanVien = new ArrayList<NhanVien>();
		String sql = "SELECT nv.id, nv.name AS nvName, nv.address, nv.birthday, nv.id_pb, nv.phone, pb.name AS pbName "
				+ "FROM nhanvien AS nv "
				+ "INNER JOIN phongban AS pb "
				+ "ON nv.id_pb = pb.id";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				NhanVien nhanVien = new NhanVien(
						rs.getString("id"), 
						rs.getString("nvName"), 
						rs.getString("address"), 
						rs.getString("birthday"), 
						rs.getString("phone"), 
						new PhongBan(
								rs.getString("id_pb"), 
								rs.getString("pbName")));
				listNhanVien.add(nhanVien);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listNhanVien;
	}
	
	public NhanVien getNhanVien(String id) {
		conn = DBConnection.getConnection();
		NhanVien nhanVien = null;
		String sql = "SELECT nv.id, nv.name AS nvName, nv.address, nv.birthday, nv.id_pb, nv.phone, pb.name AS pbName "
				+ "FROM nhanvien AS nv "
				+ "INNER JOIN phongban AS pb "
				+ "ON nv.id_pb = pb.id "
				+ "WHERE nv.id = ?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				nhanVien = new NhanVien(
						rs.getString("id"), 
						rs.getString("nvName"), 
						rs.getString("address"), 
						rs.getString("birthday"), 
						rs.getString("phone"), 
						new PhongBan(
								rs.getString("id_pb"), 
								rs.getString("pbName")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nhanVien;
	}
	
	public int delNhanVien(String id) {
		conn = DBConnection.getConnection();
		int result = 0;
		String sql = "DELETE FROM nhanvien WHERE id = ?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int addNhanVien(NhanVien nhanVien) {
		conn = DBConnection.getConnection();
		int result = 0;
		String sql = "INSERT INTO nhanvien(id, name, address, birthday, id_pb, phone) VALUES (?,?,?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, nhanVien.getId());
			ps.setString(2, nhanVien.getName());
			ps.setString(3, nhanVien.getAddress());
			ps.setString(4, nhanVien.getBirthday());
			ps.setString(5, nhanVien.getPhongBan().getId());
			ps.setString(6, nhanVien.getPhone());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int editNhanVien(NhanVien nhanVien) {
		conn = DBConnection.getConnection();
		int result = 0;
		String sql = "UPDATE nhanvien SET name=?, address=?, birthday=?, id_pb=?, phone=? WHERE id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, nhanVien.getName());
			ps.setString(2, nhanVien.getAddress());
			ps.setString(3, nhanVien.getBirthday());
			ps.setString(4, nhanVien.getPhongBan().getId());
			ps.setString(5, nhanVien.getPhone());
			ps.setString(6, nhanVien.getId());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
