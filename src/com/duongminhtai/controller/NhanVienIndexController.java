package com.duongminhtai.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.duongminhtai.model.bean.NguoiDung;
import com.duongminhtai.model.bean.NhanVien;
import com.duongminhtai.service.NhanVienService;

@WebServlet("/nhanvien/index")
public class NhanVienIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NhanVienService nhanVienService = new NhanVienService();

	public NhanVienIndexController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		NguoiDung nguoiDung = (NguoiDung) session.getAttribute("nguoiDung");
		if (nguoiDung != null) {
			String message = request.getParameter("message");
			List<NhanVien> listNhanVien = nhanVienService.getListNhanVien();
			request.setAttribute("message", message);
			request.setAttribute("listNhanVien", listNhanVien);
			RequestDispatcher rd = request.getRequestDispatcher("/views/nhanvien/index.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/auth/login.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
