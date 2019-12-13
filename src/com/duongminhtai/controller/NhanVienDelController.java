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
import com.duongminhtai.service.NhanVienService;

@WebServlet("/nhanvien/del")
public class NhanVienDelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NhanVienService nhanVienService = new NhanVienService();

	public NhanVienDelController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		NguoiDung nguoiDung = (NguoiDung) session.getAttribute("nguoiDung");
		if (nguoiDung != null) {
			String id = request.getParameter("id");
			int check = nhanVienService.delNhanVien(id);
			if (check > 0) {
				response.sendRedirect(request.getContextPath() + "/nhanvien/index?message=delsuccess");
				return;
			} else {
				response.sendRedirect(request.getContextPath() + "/nhanvien/index?message=delfail");
				return;
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/auth/login.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
