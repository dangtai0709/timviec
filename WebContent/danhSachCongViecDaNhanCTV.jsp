<%@page import="model.bean.congviec"%>
<%@page import="common.StringProcess"%>
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
<div class="modal" id="xnPheDuyet" data-popup="popup-1">
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
					data-popup-open="rating-modal" data-popup-close="popup-1">Đánh
					giá</button>
			</div>
		</div>
	</div>
</div>

<div class="table-service-price section-space">
	<div class="container">
		<h2 class="heading2 text-center white-text">Danh sách công việc
			của bạn</h2>
		<div class="col-md-6"></div>
		<div class="col-md-6 themMoi" style="margin-left: 10px; margin-bottom:25px;">
			<a href="DanhSachCongViecCTVServlet" class="btn btn-primary"><i
				class="fa fa-plus"></i> Nhận việc mới</a>
		</div>
		<div class="">
			<%
				ArrayList<congviec> listCongViec = (ArrayList<congviec>) request.getAttribute("listCongViec");
				int i = 0;
				if (listCongViec.size() == 0) {
			%>
			<h3>Bạn chưa đăng ký công việc nào</h3>
			<%
				} else {
			%>
			<table class="table table-price table-price-maid"
				style="font-size: 16px; text-align: center">
				<thead>
					<tr>
						<th>#</th>
						<th>Tên công ty</th>
						<th>Liên hệ </th>
						<th>Địa điểm</th>
						<th>Ngày hết hạn</th>
						<th>Lương</th>
						<th>Số giờ làm</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (congviec dkdv : listCongViec) {
					%>
					<tr>
						<th><%=++i%></th>
						<td><%=dkdv.getTencongty()%></td>
						<td><%=dkdv.getEmail()%>-<%=dkdv.getSodienthoai()%></td>
						<td><%=dkdv.getDiadiem()%></td>
						<td><%=dkdv.getNgayhethan()%></td>
						<td><%=dkdv.getLuong()%></td>
						<td><%=dkdv.getSogio()%></td>
						<td><a href="" title="Hủy ĐK"
							onclick="layDL('<%=dkdv.getId() %>');">
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
		$.ajax({
			url : 'XacNhanHoanThanhCVServlet',
			data : {
				maDangKy : a,
				xoacongviec:"sdf"
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
