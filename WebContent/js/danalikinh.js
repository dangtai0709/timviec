$(document).ready(function(){
//		slide
		  $('.blider').bxSlider(
		  	{
		  		//pager:false,
		  		touchEnabled:true,
		  		auto:true,
		  		controls: true,
			  });
		  
//			hien popup-dangky
			 //----- OPEN
		    $('[data-popup-open]').on('click', function(e)  {
//		    	$("body").addClass('popup-body');
		    	var targeted_popup_class = $(this).attr('data-popup-open');
		    	$('[data-popup="' + targeted_popup_class + '"]').show();
		    	e.preventDefault();
		    });

		    //----- CLOSE
		    $('[data-popup-close]').on('click', function(e)  {
		    	var targeted_popup_class = $(this).attr('data-popup-close');
		    	$('[data-popup="' + targeted_popup_class + '"]').hide();
//		    	$("body").removeClass('popup-body');
		    	e.preventDefault();
		    });
		    
////		  load du lieu popup dang ky
//		  $(".dangkydichvu-modal").on('click',function(){
//			  	$(".validate").prop( "disabled", true );
//				$("#gvtg-themdiachi").val('');
//				$("#gvtg-ngaylam").val('');
//				$("#gvtg-giolam").val('');
//				$("#gvtg-thoigian").val('');
//				$("#gvtg-themtenlienhe").val('');
//				$("#gvtg-sodienthoai").val('');
//			});
//
//			$("#xacnhandichvu-modal").on('click',function(){
//				$("#gvtg-xndichvu").val($("#gvtg-themdichvu").val());
//				$("#gvtg-xndiachi").val($("#gvtg-themdiachi").val());
//				$("#gvtg-xnngaylam").val($("#gvtg-ngaylam").val());
//				$("#gvtg-xngiolam").val($("#gvtg-giolam").val());
//				$("#gvtg-xnthoigian").val($("#gvtg-thoigian").val());
//				$("#gvtg-xntenlienhe").val($("#gvtg-themtenlienhe").val());
//				$("#gvtg-xnsodienthoai").val($("#gvtg-sodienthoai").val());
//				
//				$("#gvtg-xndichvu1").html($("#gvtg-themdichvu option:selected").text());
//				$("#gvtg-xndiachi1").html($("#gvtg-themdiachi").val());
//				$("#gvtg-xnngaylam1").html($("#gvtg-ngaylam").val());
//				$("#gvtg-xngiolam1").html($("#gvtg-giolam").val());
//				$("#gvtg-xnthoigian1").html($("#gvtg-thoigian").val());
//				$("#gvtg-xntenlienhe1").html($("#gvtg-themtenlienhe").val());
//				$("#gvtg-xnsodienthoai1").html($("#gvtg-sodienthoai").val());
//			});
//			
////			VALIDATE====================
//			$(".dangkydichvu-modal").on('click',function(){
//				$(".validate").prop( "disabled", true );
//				$("#gvtg-error-diachi").html("Trường bắt buộc.");
//				$("#gvtg-error-date").html("Trường bắt buộc.");
//				$("#gvtg-error-time1").html("Trường bắt buộc.");
//				$("#gvtg-error-time").html("Trường bắt buộc.");
//				$("#gvtg-error-name").html("Trường bắt buộc.");
//				$("#gvtg-error-phone").html("Trường bắt buộc.");
//			});
//			function checkvalidate() {
//
//				var a, b, c, d, e, f, g  = 0;
//				if(($("#gvtg-themdiachi").val().trim()!='')&&($("#gvtg-themdiachi").val().trim().length >= 5)) a=1;	
//				else a=0;
//				
//				if($("#gvtg-ngaylam").val().trim()!='') b=1;
//				else b=0;
//				
//				if($("#gvtg-giolam").val().trim()!='') g=1;
//				else g=0;
//				
//				if(($("#gvtg-thoigian").val().trim()!='') && ($("#gvtg-thoigian").val().trim().match(/^[0-9]+$/)))c=1;
//				else c=0;
//				
//				if(($("#gvtg-themtenlienhe").val().trim()!='')
//						&&($("#gvtg-themtenlienhe").val().trim().match(/^[a-zA-Z_ ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+$/))
//						&&($("#gvtg-themtenlienhe").val().trim().length >= 2)) d=1;
//				else d=0;
//				
//				if(($("#gvtg-sodienthoai").val().trim()!='')&&($("#gvtg-sodienthoai").val().trim().match(/^\+?\d{1,4}?[- .]?\(?(?:\d{2,3})\)?[- .]?\d\d\d[- .]?\d\d\d\d$/))) e=1;
//				else e=0;
//				
//				
//				if(a==0 || b==0 || c==0 || d==0 || e==0 || g==0) return false;
//				else return true;
//			}
//			$(".check-input ").keyup(function() {
//				if(checkvalidate() == true){	
//					$(".validate").prop( "disabled", false );
//				}
//				else $(".validate").prop( "disabled", true );
//			});
//			$(".change-input ").change(function() {
//				if(checkvalidate() == true){
//					$(".validate").prop( "disabled", false );
//				}
//				else $(".validate").prop( "disabled", true );
//			});
//			
//			//phan loai error
//			$("#gvtg-themdiachi").keyup(function() {
//				if($("#gvtg-themdiachi").val().trim()==''){
//					$("#gvtg-error-diachi").html("Địa chỉ không được để trống!");
//					return;
//				}
//				else
//					if($("#gvtg-themdiachi").val().trim().length < 5){
//						$("#gvtg-error-diachi").html("Địa chỉ quá ngắn!");
//						return;
//					}
//					else $("#gvtg-error-diachi").html("");
//			});
//			$("#gvtg-ngaylam").change(function() {
//				if($("#gvtg-ngaylam").val().trim()==''){
//					$("#gvtg-error-date").html("Ngày làm không hợp lệ!");
//					return;
//				}
//				else
//					$("#gvtg-error-date").html("");
//			});
//			$("#gvtg-giolam").change(function() {
//				if($("#gvtg-giolam").val().trim()==''){
//					$("#gvtg-error-time1").html("Giờ làm không hợp lệ!");
//					return;
//				}
//				else
//					$("#gvtg-error-time1").html("");
//			});
//			$("#gvtg-thoigian").keyup(function() {
//				if($("#gvtg-thoigian").val().trim()==''){
//					$("#gvtg-error-time").html("Thời gian không được để trống!");
//					return;
//				}
//				else
//					if($("#gvtg-thoigian").val().trim().match(/^[0-9]+$/)){
//						$("#gvtg-error-time").html("");
//						return;
//					}
//					else $("#gvtg-error-time").html("Thời gian không hợp lệ!");
//			});
//			$("#gvtg-themtenlienhe").keyup(function() {
//				if($("#gvtg-themtenlienhe").val().trim()==''){
//					$("#gvtg-error-name").html("Tên không được để trống!");
//					return;
//				}
//				else
//					if($("#gvtg-themtenlienhe").val().trim().length < 2){
//						$("#gvtg-error-name").html("Tên quá ngắn!");
//						return;
//					}
//					else
//						if($("#gvtg-themtenlienhe").val().trim().match(/^[a-zA-Z_ ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+$/))
//							{$("#gvtg-error-name").html("");return}	
//						else $("#gvtg-error-name").html("Tên không hợp lệ!");
//			});
//			$("#gvtg-sodienthoai").keyup(function() {
//				if($("#gvtg-sodienthoai").val().trim()==''){
//					$("#gvtg-error-phone").html("Số điện thoại không được để trống!");
//					return;
//				}
//				else
//					if($("#gvtg-sodienthoai").val().trim().match(/^\+?\d{1,4}?[- .]?\(?(?:\d{2,3})\)?[- .]?\d\d\d[- .]?\d\d\d\d$/)){
//						$("#gvtg-error-phone").html("");
//						return;
//					}
//					else $("#gvtg-error-phone").html("Số điện thoại không hợp lệ!");
//			});
//			========================Danh sach cong viec
			$('#loc-chuyenmon-cv').change(function() {
				$.ajax({
					url:'DanhSachCongViecServlet',
					data:{
						AjaxLimit:"true",
						maDichVu:$('#loc-chuyenmon-cv').val().trim(),
						trangThai:$('#loc-trangthai-cv').val().trim(),
					},
					success: function(responseText){
						if(responseText !="")
							$('.table-ajax-cv').html(responseText);
						else
							$('.table-ajax-cv').html("<div style=\"font-size:25px;\">Không có công việc nào! </div>");
					}
				});
			});
			$('#loc-trangthai-cv').change(function() {
				$.ajax({
					url:'DanhSachCongViecServlet',
					data:{
						AjaxLimit:"true",
						maDichVu:$('#loc-chuyenmon-cv').val().trim(),
						trangThai:$('#loc-trangthai-cv').val().trim(),
					},
					success: function(responseText){
						if(responseText !="")
							$('.table-ajax-cv').html(responseText);
						else
							$('.table-ajax-cv').html("<div style=\"font-size:25px;\">Không có công việc nào! </div>");
					}
				});
			});
			$('#input-timkiem-cv').keyup(function() {
				$.ajax({
					url:'TimKiemTrongDanhSachCongViecServlet',
					data:{
						chuoitimkiem:$('#input-timkiem-cv').val(),
					},
					success: function(responseText){
						if(responseText !="")
							$('.table-ajax-cv').html(responseText);
						else
							$('.table-ajax-cv').html("<div style=\"font-size:25px;\">Không tìm thấy! </div>");
					}
				});
			});
//			$(".button-nhanviec-getindex").click(function(){
//				$(this).attr('class',function(){
//					return 'button-nhanviec-backgroud';
//				});
//				$(this).attr('html','Hủy');
//				
//			});
//			============Scoll
			$('#menu-lienhe-scoll').click(function(event){
			var offset = $('#DaNaLiKinh-contact').offset().top;
			//console.log(offset);
			$('html,body').animate({scrollTop: offset }, 500);
			});
});