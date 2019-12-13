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
import com.duongminhtai.model.bean.PhongBan;
import com.duongminhtai.service.PhongBanService;

@WebServlet("/phongban/add")
public class PhongBanAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhongBanService phongBanService = new PhongBanService();

	public PhongBanAddController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		NguoiDung nguoiDung = (NguoiDung) session.getAttribute("nguoiDung");
		if (nguoiDung != null) {
			String message = request.getParameter("message");
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("/views/phongban/add.jsp");
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
		PhongBan phongBan = new PhongBan(id, name);
		int check = phongBanService.addPhongBan(phongBan);
		if (check > 0) {
			response.sendRedirect(request.getContextPath() + "/phongban/index?message=addsuccess");
			return;
		} else {
			response.sendRedirect(request.getContextPath() + "/phongban/add?message=addfail");
			return;
		}
	}

}
