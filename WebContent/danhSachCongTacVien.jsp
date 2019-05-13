<%@page import="common.StringProcess"%>
<%@page import="model.bean.ungvien"%>
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
</head>

<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<%@include file="header.jsp"%>
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>Quản lý ứng viên</h1>
			</section>

			<!-- Main content -->
			<section class="content container-fluid">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">Danh sách ứng viên</h3>
							</div>
							<!-- /.box-header -->
							<div class="col-md-6">
								<form>
									<label>Chuyên môn</label>
									<div class="form-group">
										<select class="form-control select2" name="maDichVu"
											style="width: 80%; display: inline-block;">
											<option value="">-- Chọn chuyên môn --</option>
											<%
												ArrayList<dichvu> listDV = (ArrayList<dichvu>) request.getAttribute("listDV");
												for (dichvu dv : listDV) {
											%>
											<option value="<%=dv.getMadichvu()%>"><%=dv.getTendichvu()%></option>
											<%
												}
											%>
										</select>
										<button type="submit" class="btn btn-success btn-flat"
											style="margin-bottom: 3px;">Lọc</button>
									</div>
								</form>
							</div>
							<div class="box-body">
								<table id="example2" class="table table-bordered table-hover">
									<thead>
										<tr>
											<th>Số điện thoại</th>
											<th>Họ tên</th>
											<th>Giới tính</th>
											<th>Năm sinh</th>
											<th>Địa chỉ</th>
											<th>Chuyên môn</th>
											
											<th>Thao tác</th>
										</tr>
									</thead>
									<tbody>
										<%
											ArrayList<ungvien> listCTV = (ArrayList<ungvien>) request.getAttribute("listCTV");
											for (ungvien ctv : listCTV) {
										%>
										<tr class="data">
											<th scope="row"><%=ctv.getMaungvien()%>
											</th>
											<td><%=ctv.getHoten()%></td>
											<td><%=ctv.getGioitinh()%></td>
											<td><%=ctv.getNgaysinh()%></td>
											<td><%=ctv.getDiachi()%></td>
											<td><%=StringProcess.tendichvu(ctv.getMadichvu()) %></td>
											
											<td><a href="" title="Xóa" onclick="layDL('<%=ctv.getMaungvien()%>');" style="color: red"> <i
													class="fa fa-trash"></i>
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
	<script src="components/jQuery/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script src="components/bootstrap/js/bootstrap.min.js"></script>
	<!-- AdminLTE App -->
	<script src="dist/js/adminlte.js"></script>
	<script type="text/javascript" src="components/bootstrap-rating.js"></script>
	<script type="text/javascript" src="components/pagination.js"></script>
	<script type="text/javascript">
	function layDL(a, b) {
		//debugger;
		$
				.ajax({
					url : 'XoaUngVienKhachHang',
					data : {
						maungvien : a,
					},
					success : function(responseText) {
						//debugger;
						document.getElementById("thongbao").innerHTML = responseText;
						$('#xnPheDuyet').modal('show');
						load();
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