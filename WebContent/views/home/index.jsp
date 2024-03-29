<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Trang chủ</title>
    <link rel="shortcut icon" type="image/ico" href="<%=request.getContextPath() %>/templates/images/icon-180x180.png" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<%=request.getContextPath() %>/templates/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/templates/css/style1.css" rel="stylesheet">
  </head>
  <body>
	<%@ include file="/templates/include/header.jsp" %>
    <div class="page-content">
    	<div class="row">
		  <%@ include file="/templates/include/menu.jsp" %>
		  <div class="col-md-10">
				<div class="row">
		  		<div class="col-md-12 panel-warning">
		  			<div class="content-box-header panel-heading">
	  					<div class="panel-title ">Dashboard</div>
		  			</div>
		  			<div class="content-box-large box-with-header">
			  			<div class="row">
				            <div class="col-md-4 col-sm-4 col-xs-4">
				                <div class="panel panel-back noti-box">
				                    <span class="icon-box bg-color-green set-icon">
				                    <span class="glyphicon glyphicon-th-list"></span>
				                </span>
				                    <div class="text-box">
				                        <p class="main-text"><a class="fs-14" href="<%=request.getContextPath()%>/phongban/index" title="">Quản lý phòng ban</a></p>
				                    </div>
				                </div>
				            </div>
				            <div class="col-md-4 col-sm-4 col-xs-4">
				                <div class="panel panel-back noti-box">
				                    <span class="icon-box bg-color-blue set-icon">
				                    <span class="glyphicon glyphicon-book"></span>
				                </span>
				                    <div class="text-box">
				                        <p class="main-text"><a class="fs-14" href="<%=request.getContextPath()%>/nhanvien/index" title="">Quản lý nhân viên</a></p>
				                    </div>
				                </div>
				            </div>
				            <div class="col-md-4 col-sm-4 col-xs-4">
				            </div>
				        </div>
					</div>
		  		</div>
		  	</div>	

		  	<div class="row">
		  		<div class="col-md-6">
		  			<div class="content-box-large">
		  				<div class="panel-heading">
							<div class="panel-title">Chào mừng đến với trang quản trị</div>
							
							<div class="panel-options">
								<a href="#" data-rel="collapse"><i class="glyphicon glyphicon-refresh"></i></a>
								<a href="#" data-rel="reload"><i class="glyphicon glyphicon-cog"></i></a>
							</div>
						</div>
		  				<div class="panel-body">
		  					Ut tristique adipiscing mauris, sit amet suscipit metus porta quis. Donec dictum tincidunt erat, eu blandit ligula. Nam sit amet dolor sapien. Quisque velit erat, congue sed suscipit vel, feugiat sit amet enim. Suspendisse interdum enim at mi tempor commodo. Sed tincidunt sed tortor eu scelerisque. Donec luctus malesuada vulputate. Nunc vel auctor metus, vel adipiscing odio. Aliquam aliquet rhoncus libero, at varius nisi pulvinar nec. Aliquam erat volutpat. Donec ut neque mi. Praesent enim nisl, bibendum vitae ante et, placerat pharetra magna. Donec facilisis nisl turpis, eget facilisis turpis semper non. Maecenas luctus ligula tincidunt iasdsd vitae ante et, 
				  			<br /><br />
				  			Interdum et malesuada fames ac ante ipsum primis in faucibus. Quisque sed consectetur erat. Maecenas in elementum libero. Sed consequat pellentesque ultricies. Ut laoreet vehicula nisl sed placerat. Duis posuere lectus n, eros et hendrerit pellentesque, ante magna condimentum sapien, eget ultrices eros libero non orci. Etiam varius diam lectus.
							<br /><br />
		  				</div>
		  			</div>
		  		</div>

		  		<div class="col-md-6">
		  			<div class="row">
		  				<div class="col-md-12">
		  					<div class="content-box-header">
			  					<div class="panel-title">Hướng dẫn sử dụng</div>
								
				  			</div>
				  			<div class="content-box-large box-with-header">
				  				
					  			Pellentesque luctus quam quis consequat vulputate. Sed sit amet diam ipsum. Praesent in pellentesque diam, sit amet dignissim erat. Aliquam erat volutpat. Aenean laoreet metus leo, laoreet feugiat enim suscipit quis. Praesent mauris mauris, ornare vitae tincidunt sed, hendrerit eget augue. Nam nec vestibulum nisi, eu dignissim nulla.
								<br /><br />
							</div>
		  				</div>
		  			</div>
		  			<div class="row">
		  				<div class="col-md-12">
		  					<div class="content-box-header">
			  					<div class="panel-title">Nội quy</div>
				  			</div>
				  			<div class="content-box-large box-with-header">
				  				
					  			Pellentesque luctus quam quis consequat vulputate. Sed sit amet diam ipsum. Praesent in pellentesque diam, sit amet dignissim erat. Aliquam erat volutpat. Aenean laoreet metus leo, laoreet feugiat enim suscipit quis. Praesent mauris mauris, ornare vitae tincidunt sed, hendrerit eget augue. Nam nec vestibulum nisi, eu dignissim nulla.
								<br /><br />
							</div>
		  				</div>
		  			</div>
		  		</div>
		  	</div>
		  	
		  </div>
		</div>
    </div>
    <%@ include file="/templates/include/footer.jsp" %>
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="<%=request.getContextPath() %>/templates/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/templates/js/custom.js"></script>
  </body>
</html>
