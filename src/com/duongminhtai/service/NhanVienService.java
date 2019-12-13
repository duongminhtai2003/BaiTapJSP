package com.duongminhtai.service;

import java.util.List;

import com.duongminhtai.model.bean.NhanVien;
import com.duongminhtai.model.dao.NhanVienDAO;

public class NhanVienService {
	private NhanVienDAO nhanVienDAO = new NhanVienDAO();
	
	public List<NhanVien> getListNhanVien() {
		return nhanVienDAO.getListNhanVien();
	}
	
	public NhanVien getNhanVien(String id) {
		return nhanVienDAO.getNhanVien(id);
	}
	
	public int delNhanVien(String id) {
		return nhanVienDAO.delNhanVien(id);
	}
	
	public int addNhanVien(NhanVien nhanVien) {
		return nhanVienDAO.addNhanVien(nhanVien);
	}
	
	public int editNhanVien(NhanVien nhanVien) {
		return nhanVienDAO.editNhanVien(nhanVien);
	}
	
}
