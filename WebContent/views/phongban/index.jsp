<%@page import="com.duongminhtai.model.bean.PhongBan"%>
<%@page import="com.duongminhtai.model.bean.NhanVien"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Phòng ban</title>
	<link rel="shortcut icon" type="image/ico" href="<%=request.getContextPath()%>/templates/images/icon-180x180.png" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="<%=request.getContextPath()%>/templates/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/templates/css/style1.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/templates/include/header.jsp"%>
	<div class="page-content">
		<div class="row">
			<%@ include file="/templates/include/menu.jsp"%>
			<div class="col-md-10">

				<div class="content-box-large">
					<div class="row">
						<div class="panel-heading">
							<div class="panel-title ">Quản lý phòng ban</div>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-md-8">
							<a href="<%=request.getContextPath()%>/phongban/add"
								class="btn btn-success"><span
								class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>
						</div>
						<div class="col-md-4">
							<div class="input-group form">
								<input type="text" class="form-control" placeholder="Search...">
								<span class="input-group-btn">
									<button class="btn btn-primary" type="button">Search</button>
								</span>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="panel-body">
							<table cellpadding="0" cellspacing="0" border="0"
								class="table table-striped table-bordered" id="example">
								<thead>
									<tr>
										<th>ID</th>
										<th>Tên</th>
										<th>Chức năng</th>
									</tr>
								</thead>
								<tbody>
									<%
										List<PhongBan> listPhongBan = (List) request.getAttribute("listPhongBan");
										if (listPhongBan != null) {
											for (PhongBan pb : listPhongBan) {
												String urlDel = request.getContextPath()+"/phongban/del?id="+pb.getId();
												String urlEdit = request.getContextPath()+"/phongban/edit?id="+pb.getId();
									%>
									<tr class="odd gradeX">
										<td><%=pb.getId() %></td>
										<td><%=pb.getName() %></td>
										<td class="center text-center">
											<a href="<%=urlEdit %>" title="" class="btn btn-primary">
											<span class="glyphicon glyphicon-pencil "></span> Sửa</a> 
											<a href="<%=urlDel %>" title="" class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa không ?')">
											<span class="glyphicon glyphicon-trash"></span> Xóa</a>
										</td>
									</tr>
									<%
										}
										}
									%>

								</tbody>
							</table>
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
