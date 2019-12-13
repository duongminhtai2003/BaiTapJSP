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
import com.duongminhtai.model.bean.PhongBan;
import com.duongminhtai.service.PhongBanService;

@WebServlet("/phongban/index")
public class PhongBanIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhongBanService phongBanService = new PhongBanService();

	public PhongBanIndexController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		NguoiDung nguoiDung = (NguoiDung) session.getAttribute("nguoiDung");
		if (nguoiDung != null) {
			String message = request.getParameter("message");
			List<PhongBan> listPhongBan = phongBanService.getListPhongBan();
			request.setAttribute("message", message);
			request.setAttribute("listPhongBan", listPhongBan);
			RequestDispatcher rd = request.getRequestDispatcher("/views/phongban/index.jsp");
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
