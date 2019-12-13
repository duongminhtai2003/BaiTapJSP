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
import com.duongminhtai.model.bean.PhongBan;
import com.duongminhtai.service.NhanVienService;
import com.duongminhtai.service.PhongBanService;

@WebServlet("/nhanvien/add")
public class NhanVienAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NhanVienService nhanVienService = new NhanVienService();
	private PhongBanService phongBanService = new PhongBanService();
	public NhanVienAddController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		NguoiDung nguoiDung = (NguoiDung) session.getAttribute("nguoiDung");
		if(nguoiDung != null) {
			List<PhongBan> listPhongBan = phongBanService.getListPhongBan();
			String message = request.getParameter("message");
			request.setAttribute("message", message);
			request.setAttribute("listPhongBan", listPhongBan);
			RequestDispatcher rd = request.getRequestDispatcher("/views/nhanvien/add.jsp");
			rd.forward(request, response);
		}else {
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
		int check = nhanVienService.addNhanVien(nhanVien);
		if (check > 0) {
			response.sendRedirect(request.getContextPath() + "/nhanvien/index?message=addsuccess");
			return;
		} else {
			response.sendRedirect(request.getContextPath() + "/nhanvien/add?message=addfail");
			return;
		}
	}

}
