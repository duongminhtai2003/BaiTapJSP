<%@page import="com.duongminhtai.model.bean.NguoiDung"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	NguoiDung nguoiDung = (NguoiDung)session.getAttribute("nguoiDung");
    %>
  	<div class="header">
	     <div class="container">
	        <div class="row">
	           <div class="col-md-5">
	              <!-- Logo -->
	              <div class="logo">
	                 <h1>
						<a href="<%=request.getContextPath()%>/home">Admin</a>
					</h1>
	              </div>
	           </div>
	           <div class="col-md-2">
	              <div class="row">
	                <div class="col-lg-12"></div>
	              </div>
	           </div>
	           <div class="col-md-5">
	              <div class="navbar navbar-inverse" role="banner">
	                  <nav class="collapse navbar-collapse bs-navbar-collapse navbar-right" role="navigation">
	                    <ul class="nav navbar-nav">
	                      <li class="dropdown">
	                        <a href="#">Xin chào: <%=nguoiDung.getFullname()%></a>
	                      </li>
	                      <li class="dropdown">
	                        <a href="<%=request.getContextPath()%>/logout">Đăng xuất</a>
	                      </li>
	                    </ul>
	                  </nav>
	              </div>
	           </div>
	        </div>
	     </div>
	</div>