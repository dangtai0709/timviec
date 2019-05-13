<%@page import="model.bean.taikhoan"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header class="main-header">
	<a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button"> 
		<a href="dashboard.jsp" class="logo"> 
			<span class="logo-lg"
			style="left: 40px; position: absolute; font-size: 17px;">DANH
				MỤC CHÍNH</span>
		</a>
	</a>
	<!-- Header Navbar -->
	<nav class="navbar navbar-static-top" role="navigation">
		<!-- Sidebar toggle button-->
		<img style="width: 37px; padding-top: 7px;" src="dist/img/logo.png">
		<span id="header-text"> DaNaLiKinh - Chuyên giới thiệu giúp
			việc uy tín </span>
		<!-- Navbar Right Menu -->
		<!-- Menu toggle button -->
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<!-- Messages: style can be found in dropdown.less-->
				<li class="dropdown messages-menu">
					<!-- Menu toggle button --> <a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <i class="fa fa-envelope-o"></i> <span
						class="label label-success">4</span>
				</a>
					<ul class="dropdown-menu">
						<li class="header">You have 4 messages</li>
						<li>
							<!-- inner menu: contains the messages -->
							<ul class="menu">
								<li>
									<!-- start message --> <a href="#">
										<div class="pull-left">
											<!-- User Image -->
											<img src="dist/img/user2-160x160.jpg" class="img-circle"
												alt="User Image">
										</div> <!-- Message title and timestamp -->
										<h4>
											Support Team <small> <i class="fa fa-clock-o"></i> 5
												mins
											</small>
										</h4> <!-- The message -->
										<p>Why not buy a new awesome theme?</p>
								</a>
								</li>
								<!-- end message -->
							</ul> <!-- /.menu -->
						</li>
						<li class="footer"><a href="#">See All Messages</a></li>
					</ul>
				</li>
				<!-- /.messages-menu -->

				<!-- Notifications Menu -->
				<li class="dropdown notifications-menu">
					<!-- Menu toggle button --> <a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <i class="fa fa-bell-o"></i> <span
						class="label label-warning">10</span>
				</a>
					<ul class="dropdown-menu">
						<li class="header">You have 10 notifications</li>
						<li>
							<!-- Inner Menu: contains the notifications -->
							<ul class="menu">
								<li>
									<!-- start notification --> <a href="#"> <i
										class="fa fa-users text-aqua"></i> 5 new members joined today
								</a>
								</li>
								<!-- end notification -->
							</ul>
						</li>
						<li class="footer"><a href="#">View all</a></li>
					</ul>
				</li>
				<!-- User Account Menu -->
				<li class="dropdown user user-menu">
					<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <!-- The user image in the navbar--> <img
						src="dist/img/user2-160x160.jpg" class="user-image"
						alt="User Image"> <!-- hidden-xs hides the username on small devices so only the image appears. -->
						<span class="hidden-xs">
							<%-- <% NguoiDung nguoiDung  =  (NguoiDung)(session.getAttribute("nguoiDung"));%> --%>
							<%--  ${sessionScope.tenTaiKhoan} --%>
							<%	HttpSession ss = request.getSession();
						 taikhoan tk=(taikhoan)	ss.getAttribute("taikhoan");
							 %>
							 <%= tk.getHoten() %>
						</span>
					</a>
					<ul class="dropdown-menu">
						<!-- The user image in the menu -->
						<li class="user-header"><img src="dist/img/user2-160x160.jpg"
							class="img-circle" alt="User Image">
							<p><%= tk.getHoten() %> -Admin</p></li>
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="#" class="btn btn-default btn-flat">Sửa thông tin</a>
							</div>
							<div class="pull-right">
								<a href="DangXuatServlet" class="btn btn-default btn-flat">Đăng xuất</a>
							</div>
						</li>
					</ul>
				</li>
				<li></li>
			</ul>
		</div>
	</nav>
</header>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">

	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar Menu -->
		<ul class="sidebar-menu" data-widget="tree">
			<!-- Optionally, you can add icons to the links -->
			<li class="active"><a href="TrangChuNguoiDungServlet"> <i class="fa fa-home"></i> <span>Trang
						chủ</span>
			</a></li>
			<li class=""><a href="DashboardServlet"> <i class="fa fa-tachometer"></i> <span>Dashboard</span>
			</a></li>
			<li><a href="DashboardServlet"> <i class="fa fa-user-plus"></i> <span>Quản
						lý ứng viên</span>
			</a></li>
			<li><a href="DanhSachNguoiDungServlet"> <i class="fa fa-user"></i> <span>Quản
						lý khách hàng</span>
			</a></li>
			<li class="treeview"><a href="#"> <i class="fa fa-link"></i>
					<span>Quản lý dịch vụ</span> <span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a href="ThemMoiDichVuServlet"> <i class="fa fa-plus"></i> Thêm dịch vụ
					</a></li>
					<li><a href="DanhSachDichVuServlet"> <i class="fa fa-list"></i> Danh sách dịch
							vụ
					</a></li>
				</ul></li>
			
		</ul>
		<!-- /.sidebar-menu -->
	</section>
	<!-- /.sidebar -->
</aside>