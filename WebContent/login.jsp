<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 2 | Starter</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet" href="components/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<!-- <link rel="stylesheet" href="components/Ionicons/css/ionicons.min.css"> -->
<!-- Theme style -->
<link rel="stylesheet" href="dist/css/AdminLTE.css">

<link rel="stylesheet" href="dist/css/skin-blue.css">

</head>

<body class="hold-transition skin-blue sidebar-mini sidebar-collapse">
	<div class="wrapper">
		<%@include file="header2.jsp"%>
		<div class="content-wrapper">
		<div class="container">
			<div class="wapper-taikhoan col-lg-8 col-lg-offset-2">
				<h3>Đăng nhập hệ thống</h3>
				<br>
				<form action="LoginServlet" method="post" id="form-dangnhap">
					<div class="row form-group">
						<label class="col-lg-3 col-lg-offset-1">Tên đăng nhập</label>
						<div class="col-lg-6">
							<input type="text" class=" form-control" name="tenDangNhap" />
						</div>
					</div>
					<div class="row form-group">
						<label class="col-lg-3 col-lg-offset-1">Mật khẩu</label>
						<div class="col-lg-6">
							<input type="password" class="form-control" name="matKhau" />
						</div>
					</div>
					<div class="row form-group">
						<div class="col-lg-6 col-lg-offset-4">
							<p style="color: red;"><%=(String)request.getAttribute("thongBao") == null ? "" : (String)request.getAttribute("thongBao")%></p>
						</div>
					</div>
					<div class="row form-group">
						<div class="col-lg-6 col-lg-offset-4">
							<button class="btn btn-primary" type="submit" value="submit" name="submit">Đăng nhập</button>
							<button class="btn btn-primary" type="reset" value="submit" name="submit">Hủy</button>
						</div>
					</div>
					<div class="col-lg-6 col-lg-offset-4 text-dang-ky-tk"><a href="DangKyTaiKhoanServlet">Đăng ký tài khoản mới</a></div>
				</form>
			</div>
		</div>
		</div>
	<%@include file="footer.jsp"%>
	</div>
	<script src="components/jQuery/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script src="components/bootstrap/js/bootstrap.min.js"></script>
	<!-- AdminLTE App -->
	<script src="dist/js/adminlte.js"></script>
</body>
</html>