package com.duongminhtai.service;

import com.duongminhtai.model.bean.NguoiDung;
import com.duongminhtai.model.dao.NguoiDungDAO;

public class NguoiDungService {
	private NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();

	public NguoiDung getNguoiDung(String username, String password) {
		return nguoiDungDAO.getNguoiDung(username, password);
	}
}
