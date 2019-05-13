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
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="components/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <!-- <link rel="stylesheet" href="components/Ionicons/css/ionicons.min.css"> -->
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/AdminLTE.css">

    <link rel="stylesheet" href="dist/css/skin-blue.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>

<body class="hold-transition skin-blue sidebar-mini">

	
    <div class="wrapper">
    	<%@include file="header.jsp"%>
    	 <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
          Quản lý dịch vụ
        </h1>
      </section>

      <!-- Main content -->
      <section class="content container-fluid">
        <div class="row">
          <div class="col-xs-12">
            <div class="box">
              <div class="box-header">
                <h3 class="box-title">Danh sáchh dịch vụ</h3>
              </div>
              <!-- /.box-header -->
              <div class="col-md-6"></div>
                            <div class="col-md-6 themMoi" style="margin-bottom: 25px">
								<a href="ThemMoiDichVuServlet" class="btn btn-primary"><i class="fa fa-plus"></i> Thêm mới</a>
							</div>
              <div class="box-body">
                <table id="example2" class="table table-bordered table-hover">
                  <thead>
                    <tr>
                      <th>Mã dịch vụ</th>
                      <th>Tên dịch vụ</th>
                     
                      <th>Thao tác</th>
                    </tr>
                  </thead>
                  <tbody>
                  	<% 
						ArrayList<dichvu>listDichVu = (ArrayList<dichvu>)request.getAttribute("listDichVu");
						for(dichvu dv:listDichVu){
					%>
	
                    <tr class="data">
                      <td><%=dv.getMadichvu() %></td>
                      <td><%=dv.getTendichvu() %></td>
                     
                      <td>
                        <a href="SuaDichVuServlet?maDichVu=<%=dv.getMadichvu()%>" title="Sửa">
                          <span class="fa fa-edit"></span>
                        </a>
                        &nbsp|&nbsp
                        <a href="XoaDichVuServlet?maDichVu=<%=dv.getMadichvu()%>" title="Xóa" style="color: red">
                          <i class="fa fa-trash"></i>
                        </a>
                      </td>
                    </tr>
                    <%} %>
                  </tbody>
                </table>
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
</body>

</html>