package com.duongminhtai.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.duongminhtai.model.bean.NguoiDung;
import com.duongminhtai.model.bean.NhanVien;
import com.duongminhtai.model.bean.PhongBan;
import com.duongminhtai.service.NhanVienService;

@WebServlet("/nhanvien/edit")
public class NhanVienEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NhanVienService nhanVienService = new NhanVienService();

	public NhanVienEditController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		NguoiDung nguoiDung = (NguoiDung) session.getAttribute("nguoiDung");
		if (nguoiDung != null) {
			String message = request.getParameter("message");
			String id = request.getParameter("id");
			NhanVien nhanVien = nhanVienService.getNhanVien(id);
			request.setAttribute("message", message);
			request.setAttribute("nhanVien", nhanVien);
			RequestDispatcher rd = request.getRequestDispatcher("/views/nhanvien/edit.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/auth/login.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String birthday = request.getParameter("birthday");
		String phone = request.getParameter("phone");
		String id_pb = request.getParameter("id_pb");
		NhanVien nhanVien = new NhanVien(id, name, address, birthday, phone, new PhongBan(id_pb, ""));
		int check = nhanVienService.editNhanVien(nhanVien);
		if (check > 0) {
			response.sendRedirect(request.getContextPath() + "/nhanvien/index?message=editsuccess");
			return;
		} else {
			response.sendRedirect(request.getContextPath() + "/nhanvien/edit?message=editfail&id=" + id);
			return;
		}
	}

}
