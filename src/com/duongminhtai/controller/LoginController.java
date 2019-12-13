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
import com.duongminhtai.service.NguoiDungService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NguoiDungService nguoiDungService = new NguoiDungService();

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = request.getParameter("message");
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("/views/auth/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		NguoiDung nguoiDung = nguoiDungService.getNguoiDung(username, password);
		if (nguoiDung != null) {
			session.setAttribute("nguoiDung", nguoiDung);
			response.sendRedirect(request.getContextPath() + "/home");
			return;
		} else {
			response.sendRedirect(request.getContextPath() + "/login?message=loginfail");
			return;
		}
	}

}
