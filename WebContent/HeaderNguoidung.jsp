<%@page import="model.bean.taikhoan"%>
<%@page import="model.bean.dichvu"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" type="image/jpg"
	href="images/vector-icon/images.jpg">
<title>DaNaLiKinh</title>
<link rel="stylesheet" href="components/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" type="text/css"
	href="components/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="jquery/bxslider/jquery.bxslider.css">
<link rel="stylesheet" type="text/css"
	href="components/bootstrap-rating.css">
<link rel="stylesheet" type="text/css" href="animate/animate.min.css">
<link rel="stylesheet" type="text/css" href="css/Header.css">
<link rel="stylesheet" type="text/css" href="css/trangchu.css">
<link rel="stylesheet" type="text/css" href="css/cacdichvu.css">
<link rel="stylesheet" type="text/css" href="css/gioithieu.css">
<link rel="stylesheet" type="text/css" href="css/Footer.css">
<link rel="stylesheet" type="text/css" href="dist/css/skin-blue.css">

<script type="text/javascript" src="jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="jquery/jquery.validate.min.js"></script>
<script type="text/javascript" src='animate/wow.min.js'></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="jquery/bxslider/jquery.bxslider.min.js"></script>
<script type="text/javascript" src="components/pagination.js"></script>
<script type="text/javascript" src="js/danalikinh.js"></script>

<!-- <style type="text/css">
form{
	width: 80%;
	margin: 0 auto;
	margin-top: 25px;
}
</style> -->

</head>
<body id="body">
	<%
		HttpSession ss = request.getSession();
		taikhoan tk = (taikhoan) ss.getAttribute("taikhoan");
		if (tk == null) {
			tk = new taikhoan();
			tk.setQuyen(6);
		}
	%>
	<div class="wrapper">
		<header id="header"> <nav class="navbar navbar-default">
		<div class="container-fluid-daxoa">
			<div class="header-container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle plus collapsed"
						data-toggle="collapse" data-target="#navbar-collapse-plus"
						aria-label="button">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand logo" href="index.jsp">DaNaLiKinh</a>
				</div>
				<div class="collapse navbar-collapse header-menu"
					id="navbar-collapse-plus">
					<ul class="nav navbar-nav">
						<li><a href="TrangChuNguoiDungServlet">Trang chủ</a></li>
						<li class=""><a href="gioithieu.jsp">Giới thiệu</a></li>

						<li><a href="#" id="menu-lienhe-scoll">Liên hệ</a></li>

					</ul>
					<ul class="nav navbar-nav navbar-right">

						<%
							if (tk.getQuyen() == 1) {
						%>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Công việc <i
								class="fa fa-angle-down" aria-hidden="true"></i></a>
							<ul class="dropdown-menu button-menu menu-register">
								<li><a href="DanhSachCongViecCTVServlet">Danh sách công
										việc</a></li>
								<li class="divider"></li>
								<li><a href="CongViecDaNhanCTVServlet">Công việc đã
										nhận</a></li>
							</ul></li>
						<!-- <li><a  href="DanhSachCongViecCTVServlet">Danh sách công việc</a></li> -->
						<%
							} else if (tk.getQuyen() == 2) {
						%>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Công việc <i
								class="fa fa-angle-down" aria-hidden="true"></i></a>
							<ul class="dropdown-menu button-menu menu-register">
								<li><a href="DanhSachCongViecKhachHangServlet">Công
										việc đã đăng</a></li>
								<li class="divider"></li>
								<li><a href="Hosodanhan">Hồ sơ đã nhận</a></li>
							</ul></li>

						<%
							} else if (tk.getQuyen() == 3) {
						%>
						<li><a href="DashboardServlet">Quản trị</a></li>
						<%
							}

							if (tk.getGioitinh() == null) {
						%>
						<li><a href="StartServlet">Đăng nhập</a></li>
						<%
							} else {
						%>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#"> <img
								class="li-image-taikhoan" src="images/taikhoan/anony1.jpg">
								<%=tk.getHoten()%> <i class="fa fa-angle-down"
								aria-hidden="true"></i></a>
							<ul class="dropdown-menu button-menu">
								<div class="header-nguoidung">
									<img class="ul-li-image-taikhoan"
										src="images/taikhoan/anony1.jpg">
									<li><a class="" href=""
										style="float: left; padding: 10px 5px;">Thông tin</a></li>
									<li><a class="" href="DangXuatServlet"
										style="float: right; padding: 10px 5px;">Đăng xuất</a></li>
								</div>
							</ul></li>
						<%
							}
						%>
						<!-- 								<li><a href="" class="language-select">English</a></li> -->
					</ul>
				</div>
			</div>
		</div>
		</nav> </header>
		<div class="popup" data-popup="popup-1">
			<div class="popup-inner">
				<div class="popup-header">
					<h2>Thông tin đăng ký dịch vụ</h2>
				</div>
				<div class="popup-content">
					<form action="ThemDangKyDichVuServlet">
						<p>
							Chọn loại dịch vụ:<span id="gvtg-error-dichvu"></span>
						</p>
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
						<p>
							Nơi làm việc: <span id="gvtg-error-diachi"></span>
						</p>
						<input type="text" id="gvtg-themdiachi"
							class="check-input address" name="diadiem">

						<p>
							Ngày làm hết hạn đăng ký: <span id="gvtg-error-date"></span>
						</p>
						<input type="date" id="gvtg-ngaylam" name="ngayhethan" class="change-input date">
						<p>
							Số giờ làm: <span id="gvtg-error-time"></span>
						</p>
						<input type="number" id="gvtg-thoigian" name="sogio" class="check-input time">
						<p>
							Số người làm: <span id="gvtg-error-time"></span>
						</p>
						<input type="number" id="gvtg-thoigian" name="songuoi" class="check-input time">

						<p>
							Lương: <span id="gvtg-error-name"></span>
						</p>
						<input type="number" id="gvtg-themtenlienhe"
							class="check-input " name="luong">

						<p>
							Mô tả: <span id="gvtg-error-phone"></span>
						</p>
						<input type="text" id="gvtg-sodienthoai" name="mota" class="check-input phone">

						<p>
							<button type="submit" class="btn btn-success" name="submit"
								value="submit">Xác nhận</button>
							<button class="btn btn-danger" data-popup-close="popup-1">Hủy</button>
						</p>
					</form>
				</div>
			</div>
		</div>
		<%
			if (tk.getQuyen() == 2) {
		%>
		<a href="#" class="btn-normal button-dangkydichvu dangkydichvu-modal"
			data-popup-open="popup-1" id="dangkydichvu-modal"
			style="text-decoration: none;"><i class="fa fa-pencil"
			style="font-size: 17px;"></i> Đăng ký dịch vụ</a>
		<%
			}
			if (tk.getQuyen() != 2 && tk.getQuyen() != 1) {
		%>
		<a href="/timvieclam/login.jsp" class="btn-normal button-dangkydichvu"
			style="text-decoration: none;"> Đăng nhập để đăng ký</a>
		<%
			}
		%>
		
		<div id="main-page">