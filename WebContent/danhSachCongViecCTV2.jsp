
<%@page import="model.bean.congviec"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="HeaderNguoidung.jsp"%>
<div class="ds-cv-wapper">
	<div class="ds-cv-mainpage">
		<div class="container">
			<div class="row ds-cv-mainpage-header">
				<!-- Modal -->
				<div class="modal" id="xnPheDuyet">
					<div class="modal-dialog" id="myModal">
						<div class="modal-content">
							<div class="modal-body">
								<span id="thongbao" style="color: #027bfb; font-size: 15px;"></span>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Ok</button>
							</div>
						</div>
					</div>
				</div>
				<!--  -->
				<div class="box-header">
					<h3 class="box-title">Danh sách công việc</h3>
				</div>

				<div class="row ds-cv-mainpage-content">
					<div class="ds-cv-mainpage-text">
						<table class="col-md-10 col-md-offset-2 table-ajax-cv"
							id="example2">
							<%
								ArrayList<congviec> listCongViec = (ArrayList<congviec>) request.getAttribute("listCongViec");
								for (congviec cv : listCongViec) {
							%>
							<tr class="data">
								<td class="ds-cv-mainpage-text-left col-md-4 col-md-offset-1 ">
									<h4><%=cv.getTendichvu()%>
										- Công ty:
										<%=cv.getTencongty()%></h4>
									<div class="row">
										<p class="col-md-5">Địa điểm &nbsp :</p>
										<span class="col-md-5"><%=cv.getDiadiem()%></span>
									</div>
									<div class="row">
										<p class="col-md-5">Mô tả &nbsp :</p>
										<span class="col-md-5"><%=cv.getMota()%></span>
									</div>
									<div class="row">
										<p class="col-md-5">Lương &nbsp :</p>
										<span class="col-md-5"><%=cv.getLuong()%> VNĐ</span>
									</div>
									<div class="row">
										<p class="col-md-5">Điện thoại - Email :</p>
										<span class="col-md-5"><%=cv.getMakhachhang()%>-<%=cv.getEmail()%></span>
									</div>
									<div class="row">
										<p class="col-md-5">Ngày hết hạn đăng ký:</p>
										<span class="col-md-5"><%=cv.getNgayhethan()%> </span>
									</div>
									<div class="row">
										<p class="col-md-5">Số giờ làm &nbsp :</p>
										<span class="col-md-5"><%=cv.getSogio()%></span>
									</div>

									<div class="row">
										<p class="col-md-5">Trạng thái &nbsp :</p>
										<span class="col-md-5 trang-thai" style="color: #26b532;">Đã
											có <%=cv.getSonguoinhan()%>người nạp hồ sơ. Chúng tôi cần <%=cv.getSonguoi()%> hồ sơ 
										</span>
									</div>


								</td>
								<td class="ds-cv-mainpage-text-right col-md-4">

									<button onclick="layDL('<%=cv.getId()%>');"
										class="button-nhanviec-getindex">
										<i class="fa fa-paper-plane"></i> Nhận việc
									</button>
								</td>
							</tr>

							
							<%
								}
							%>
						</table>
						
								<div class="paging-container "  id="tablePaging" style="padding-left:30%"></div>
							
					</div>
				</div>
			</div>
		</div>
	</div>
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
		function layDL(b) {
					$.ajax({
						url : 'NhanViecServlet',
						data : {
							macongviec : b
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
		$(document).ready(function() {
			$('.button-nhanviec-getindex').click(function() {
				$(this).parent().parent().addClass('row-nhan-viec');
			});
		});
	</script>
	<%@include file="FooterNguoidung.jsp"%>