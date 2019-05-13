<%@page import="model.bo.DichVuBO"%>
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
form {
	width: 80%;
	margin: 0 auto;
	margin-top: 25px;
}
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<%@include file="header.jsp"%>
		<div class="content-wrapper">
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<div class="box box-primary">
							<div class="box-header with-border">
								<h3 class="box-title">Thêm mới dịch vụ</h3>
							</div>
							<%
								if (request.getAttribute("tendichvu") == null) {
							%>
							<form role="form" method="post" action="ThemMoiDichVuServlet">
								<%
									} else {
								%>
								<form role="form" method="post" action="SuaDichVuServlet">
									<%
										}
									%>
									<!-- form start -->
									<!-- <div class="box-body"> -->
									<div class="form-group">
										<label for="exampleInputEmail1">Mã dịch vụ</label> <input
											type="text" class="form-control" disabled
											value="<%=request.getAttribute("madichvu")%>">
									</div>
									<div class="form-group">
										<label for="exampleInputEmail1">Tên dịch vụ</label> 
										<input type="text" name="madichvu"  class="hidden"
											 value="<%=request.getAttribute("madichvu")%>">
										<input
											type="text" class="form-control" name="ten"
											placeholder="Tên dịch vụ"
											<%if (request.getAttribute("tendichvu") != null) {%>
											value="<%=request.getAttribute("tendichvu")%>" <%}%>>
									</div>
									<div class="box-footer">
										<button type="submit" class="btn btn-primary">Submit</button>
									</div>
								</form>
						</div>
					</div>
				</div>
			</section>
		</div>
		<%@include file="footer.jsp"%>
	</div>
	<script src="components/jQuery/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script src="components/bootstrap/js/bootstrap.min.js"></script>
	<!-- AdminLTE App -->
	<script src="dist/js/adminlte.js"></script>
	<script src="components/ckeditor/ckeditor.js"></script>

</body>

</html>