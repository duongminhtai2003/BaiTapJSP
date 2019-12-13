<%@page import="com.duongminhtai.model.bean.NhanVien"%>
<%@page import="com.duongminhtai.model.bean.PhongBan"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Nhân viên</title>
<link rel="shortcut icon" type="image/ico"
	href="<%=request.getContextPath()%>/templates/images/icon-180x180.png" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="<%=request.getContextPath()%>/templates/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lobster"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/templates/css/style1.css"
	rel="stylesheet">
</head>
<body>
	<%@ include file="/templates/include/header.jsp"%>
	<%
		NhanVien nhanVien = (NhanVien)request.getAttribute("nhanVien");
	%>
	<div class="page-content">
		<div class="row">
			<%@ include file="/templates/include/menu.jsp"%>
			<div class="col-md-10">
				<div class="row">
					<div class="col-md-12 panel-info">
						<div class="content-box-header panel-heading">
							<div class="panel-title ">Sửa nhân viên</div>
						</div>
						<div class="content-box-large box-with-header">
							<div>
								<form action="<%=request.getContextPath()%>/nhanvien/edit"
									method="post">
									<div class="row mb-10"></div>
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<%-- <label for="id">ID</label> <input type="text"
													class="form-control" placeholder="Nhập id" name="id" value="<%=nhanVien.getId()%>"> --%>
											</div>
											<div class="form-group">
												<label for="name">Tên</label> <input type="text"
													class="form-control" placeholder="Nhập tên" name="name" value="<%=nhanVien.getName()%>">
											</div>
											<div class="form-group">
												<label>Phòng ban</label> <select class="form-control"
													name="id_role">
													<option value="<%=nhanVien.getPhongBan().getId()%>"><%=nhanVien.getPhongBan().getName()%></option>
													<%
														List<PhongBan> listPhongBan = (List) request.getAttribute("listPhongBan");
														if (listPhongBan != null) {
															for (PhongBan pb : listPhongBan) {
																if(!nhanVien.getPhongBan().getId().equals(pb.getId())){
													%>
													<option value="<%=pb.getId()%>"><%=pb.getName()%></option>
													<%
																}
														}
														}
													%>
												</select>
											</div>
											<div class="form-group">
												<label for="address">Địa chỉ</label> <input type="text"
													class="form-control" placeholder="Nhập địa chỉ"
													name="address" value="<%=nhanVien.getAddress()%>">
											</div>
											<div class="form-group">
												<label for="phone">Số điện thoại</label> <input type="text"
													class="form-control" placeholder="Nhập sđt" name="phone" value="<%=nhanVien.getPhone()%>">
											</div>
											<div class="form-group">
												<label for="birthday">Ngày sinh</label> <input type="date"
													class="form-control" placeholder="Chọn ngày sinh"
													name="birthday" value="<%=nhanVien.getBirthday()%>">
											</div>
										</div>
										<div class="col-sm-6"></div>
										<div class="col-sm-12">
											<div class="form-group">
												<label>Chi tiết</label>
												<textarea class="form-control" rows="7"></textarea>
											</div>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-12">
											<input type="submit" value="Thêm" class="btn btn-success" />
											<input type="reset" value="Nhập lại" class="btn btn-default" />
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/templates/include/footer.jsp"%>
	<script src="https://code.jquery.com/jquery.js"></script>
	<script
		src="<%=request.getContextPath()%>/templates/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/templates/js/custom.js"></script>
</body>
</html>