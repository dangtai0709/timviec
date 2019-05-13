//===check dang ky tai khoan==
	$(document).ready(function() {
		$.validator.addMethod("check",function(value, element,regex) {
            //return this.optional(element) || regex.test(value);
            //or
            return regex.test(value);
			});
		
			$(".submit").click(function(){
				$(".submit-dk-taikhoan").submit();
			});
			
//			check confim pass
			

//			check so dien thoai
			$('.sodienthoai').change(function() {
				$.ajax({
					url:'ThemMoiNguoiDungServlet',
					data:{
						sodienthoai:$('.sodienthoai').val().trim(),
					},
					success: function(responseText){
						if(responseText != ""){
							$('.sodienthoai').val(responseText);
						}
					}
				});
				
			});
			
	});
			
