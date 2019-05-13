<%@page import="model.bean.dangkydichvu"%>
<%@page import="common.StringProcess"%>
<%@page import="model.bean.dangkydichvu"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="HeaderNguoidung.jsp"%>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div class="modal" id="xnPheDuyet" data-popup="popup-01">
	<div class="modal-dialog" id="myModal">
		<div class="modal-content">
			<div class="modal-header">
				<h4>Thông báo</h4>
			</div>
			<div class="modal-body">
				<span id="thongbao" style="color: #027bfb; font-size: 15px;"></span>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary" id="confirm-modal"
					data-popup-open="rating-modal" data-popup-close="popup-01">Đánh
					giá</button>
			</div>
		</div>
	</div>
</div>
<div class="modal" id="danhGia" data-popup="rating-modal">
	<div class="modal-dialog" id="myModal2" style="width: 22%">
		<div class="modal-content">
			<!-- <form action="DanhGiaCongTacVienServlet"> -->
			<div class="modal-body" style="height: 150px; text-align: center;">
				<input type="hidden" class="rating" id="xepHang" /> <br> <input
					type="hidden" name="maCTV" id="maCTV">
				<button type="button" value="submit" name="submit"
					onclick="danhGiaCTV();" class="btn btn-success hide1"
					 style="margin-top: 10px" data-popup-close="rating-modal">Xác nhận</button>
			</div>
			<div class="modal-footer"></div>
			<!-- </form> -->
		</div>
	</div>
</div>
<div class="table-service-price section-space">
	<div class="container">
		<h2 class="heading2 text-center white-text">Danh sách hồ sơ đã nhận</h2>
		<div class="">
			<%
				ArrayList<dangkydichvu> listdangkydichvu = (ArrayList<dangkydichvu>) request.getAttribute("listCongViec");
				int i = 0;
				if (listdangkydichvu.size() == 0) {
			%>
			<h3>Bạn chưa đăng ký dịch vụ nào</h3>
			<a href="javascript:;"
				class="btn-normal scroll-download dangkydichvu-modal"
				data-popup-open="popup-1" style="text-decoration: none;">Đăng ký
				dịch vụ</a>
			<%
				} else {
			%>
			<table class="table table-price table-price-maid"
				style="font-size: 16px;">
				<thead>
					<tr>
							<th>#</th>
						<th>Mã dịch vụ </th>
						<th>Số điện thoại</th>
						<th>Tên người đăng ký</th>
						
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<%
						for (dangkydichvu dkdv : listdangkydichvu) {
					%>
					<tr>
						<td><%=++i%></td>
						<td><%=StringProcess.tendichvu(dkdv.getMadichvu())%></td>
						<td><%=dkdv.getSodienthoai()%></td>
						<td><%=dkdv.getTencongty()%></td>
						
						<td><a href="" title="Hủy ĐK"
							onclick="layDL('<%=dkdv.getMacongviec() %>','<%=dkdv.getMaungvien() %>');">
								<i class="fa fa-trash-o"></i>
						</a></td>
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
<script type="text/javascript" src="components/bootstrap-rating.js"></script>
<script type="text/javascript" src="components/notify.min.js"></script>
<script type="text/javascript">
	
	
		function layDL(a,b) {
		//debugger;
		//alert(a+""+b);
		$.ajax({
			url : 'XacNhanHoanThanhCVServlet',
			data : {
				maDangKy : a,
				xoacongviec:"sadasd",
				ungvien:b
			},
			success : function(responseText) {
				alert("Xóa thành công");
				location.reload(true);
			},
			error : function(responseText) {
				//debugger;
				document.getElementById("thongbao").value = responseText;
			},
		});
	};
	
</script>
<%@include file="FooterNguoidung.jsp"%>
