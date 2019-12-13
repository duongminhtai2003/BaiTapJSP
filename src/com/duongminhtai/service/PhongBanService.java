package com.duongminhtai.service;

import java.util.List;

import com.duongminhtai.model.bean.PhongBan;
import com.duongminhtai.model.dao.PhongBanDAO;

public class PhongBanService {
	private PhongBanDAO phongBanDAO = new PhongBanDAO();
	
	public List<PhongBan> getListPhongBan() {
		return phongBanDAO.getListPhongBan();
	}
	
	public PhongBan getPhongBan(String id) {
		return phongBanDAO.getPhongBan(id);
	}
	
	public int delPhongBan(String id) {
		return phongBanDAO.delPhongBan(id);
	}
	
	public int addPhongBan(PhongBan phongBan) {
		return phongBanDAO.addPhongBan(phongBan);
	}
	
	public int editPhongBan(PhongBan phongBan) {
		return phongBanDAO.editPhongBan(phongBan);
	}
	
}
