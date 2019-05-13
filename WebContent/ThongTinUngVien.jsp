<%@page import="model.bean.taikhoan"%>
<%@page import="model.bean.dichvu"%>
<%@page import="java.util.ArrayList"%>
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
<link rel="stylesheet" type="text/css"
	href="components/bootstrap-rating.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<style type="text/css">
form{
	width: 80%;
	margin: 0 auto;
	margin-top: 25px;
}
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		
		<div class="content-wrapper">
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<div class="box box-primary">
							<div class="box-header with-border">
								<h3 class="box-title">Thông tin ứng viên</h3>
							</div>
							<form  action="ThongtinUngVien" method="post">
								<!-- form start -->
								<!-- <div class="box-body"> -->
								
								<div class="form-group">
									<label for="phone">CMND</label> <input type="number"
										name="cmnd" class="form-control" 
										placeholder="Nhập CMND">
										<%taikhoan tk=(taikhoan) session.getAttribute("taikhoan"); %>
										 <input type="text"
										name="maungvien" class="hidden" 
										value="<%= tk.getSodienthoai()%>">
								</div>
								
								<label>Chuyên môn </label>
								<div class="form-group">
									<select class="select2" id="gvtg-themdichvu" name="madichvu"
							style="display: inline-block;">
							<%
								ArrayList<dichvu> listDV = (ArrayList<dichvu>) session.getAttribute("listDV");
								if (listDV == null) {
								} else {
									for (dichvu dv : listDV) {
							%>
							<option value="<%=dv.getMadichvu()%>">
								<%=dv.getTendichvu()%></option>
							<%
								}
								}
							%>
						</select>
								</div>
								
								<div class="form-group">
									<label for="address">Giới thiệu</label> <input type="text"
										name="gioithieu" class="form-control" 
										placeholder="Giới thiệu bản thân">
								</div>
								<div class="box-footer">
									<button class="btn btn-success" type="submit" value="submit" name="submit">Xác nhận</button>
                					<input class="btn btn-warning" type="reset" value="Nhập lại"  />
								</div>
							</form>
						</div>
					</div>
				</div>
			</section>
		</div>
		
	</div>
	<script src="components/jQuery/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script src="components/bootstrap/js/bootstrap.min.js"></script>
	<!-- AdminLTE App -->
	<script src="dist/js/adminlte.js"></script>
</body>
</html>