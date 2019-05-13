<%@page import="model.bean.khachhang"%>
<%@page import="common.StringProcess"%>
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
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<%@include file="header.jsp"%>
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>Quản lý tài khoản</h1>
			</section>

			<!-- Main content -->
			<section class="content container-fluid">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">Danh sách khách hàng</h3>
							</div>
							<!-- /.box-header -->
							<div class="col-md-6"></div>
							<div class="col-md-6 themMoi" style="margin-bottom: 25px">
								<a href="ThemMoiNguoiDungServlet" class="btn btn-primary"><i
									class="fa fa-plus"></i> Thêm mới</a>
							</div>
							<div class="box-body">
								<table id="example2" class="table table-bordered table-hover">
									<thead>
										<tr>

											<th>Số điện thoại công ty</th>
											<th>Tên công ty</th>
											<th>Địa chỉ</th>
											<th>Email công ty</th>
											<th>Số điện thoại quản lý</th>
											<th>Thao tác</th>
										</tr>
									</thead>
									<tbody>
										<%
											ArrayList<khachhang> listND = (ArrayList<khachhang>) request.getAttribute("listND");
											for (khachhang nguoiDung : listND) {
										%>
										<tr class="data">

											<td><%=nguoiDung.getSodienthoaicty()%></td>
											<td><%=nguoiDung.getTencongty()%></td>
											<td><%=nguoiDung.getDiachicty()%></td>
											<td><%=nguoiDung.getEmailcty()%></td>
											<td><%=nguoiDung.getMakhachhang()%></td>
											<td> <a href=""
												onclick="layDL('<%=nguoiDung.getMakhachhang()%>');"
												title="Xóa" style="color: red"> <i class="fa fa-trash"></i>
											</a></td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>
								<div class="paging-container" id="tablePaging"></div>
							</div>
							<!-- /.box-body -->
						</div>
					</div>
				</div>
			</section>
			<!-- /.content -->
		</div>
		<%@include file="footer.jsp"%>
	</div>
	<!-- Bootstrap 3.3.7 -->
	<script src="components/jQuery/jquery.min.js"></script>
	<script src="components/bootstrap/js/bootstrap.min.js"></script>
	<!-- AdminLTE App -->
	<script type="text/javascript" src="dist/js/adminlte.js"></script>
	<script type="text/javascript" src="components/pagination.js"></script>
	<script>
		$(document).ready(
				function() {
					load = function() {
						window.tp = new Pagination('#tablePaging', {
							itemsCount : $("#example2 tr.data").length,
							onPageSizeChange : function(ps) {
								console.log('changed to ' + ps);
							},
							onPageChange : function(paging) {
								//custom paging logic here
								console.log(paging);
								var start = paging.pageSize
										* (paging.currentPage - 1), end = start
										+ paging.pageSize, $rows = $(
										'#example2').find('.data');

								$rows.hide();

								for (var i = start; i < end; i++) {
									$rows.eq(i).show();
								}
							}
						});
					}

					load();
				});
	</script>
	<script type="text/javascript">
	function layDL(a, b) {
		//debugger;
		$
				.ajax({
					url : 'XoaUngVienKhachHang',
					data : {
						makhachhang : a,
					},
					success : function(responseText) {
						//debugger;
						document.getElementById("thongbao").innerHTML = responseText;
						$('#xnPheDuyet').modal('show');
					},
					error : function(responseText) {
						//debugger;
						document.getElementById("thongbao").value = responseText;

					},
				});
	};
	</script>
</body>

</html>