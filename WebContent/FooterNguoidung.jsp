<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="DaNaLiKinh-contact">
	<div class="DaNaLiKinh-contact">
		<div class="container text-center">
			<h2 class="heading2 wow zoomIn"  data-wow-delay="0.01s">Liên hệ với chúng tôi</h2>
			<p>

				Nếu có thắc mắc hay khó khăn trong quá trình sử dụng ứng dụng, hãy
				liên hệ với chúng tôi.<br> Chúng tôi luôn sẵn sàng hỗ trợ bạn.<br>

			</p>
			<form>
				<div class="row">
					<div class="col-md-8">


						<div class="contact-form text-left">
							<input id="txtName" class="form-control" type="text"
								placeholder="Họ tên" aria-label="txtName"> <input
								id="txtEmail" class="form-control" type="email"
								placeholder="Email" aria-label="txtEmail">
							<textarea id="txtContent" rows="5" placeholder="Nội dung"
								aria-label="txtContent"></textarea>
							<div class="text-center-mobile">
								<button id="btnSubmitContact" type="button"
									class="btn btn btn-normal">Gửi</button>
							</div>
							<div id="lbResponseContact"></div>
							<input type="hidden" id="urlContact"
								value="https://cc.DaNaLiKinh.com/api/user/contact">
						</div>

					</div>
					<div class="col-md-4">
						<div class="contact-info text-center">
							<div class="contact-phone">
								<img src="./images/trangchu/ic_phone.svg" alt="">
								<p>
									Hotline - <a href="tel:1900636736" class="white-text">1900.636.736</a>
								</p>
								<p>

									Đăng việc - <a href="tel:02873038038" class="white-text">02873.038.038</a>
								</p>
							</div>
							<div class="contact-mail">
								<img src="./images/trangchu/ic_mail.svg" alt="">
								<p>
									<a href="mailto:support@DaNaLiKinh.com" class="white-text">support@DaNaLiKinh.com</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- DaNaLiKinh contact -->

<!-- Footer -->
<div class="is-after">
	<footer id="footer">
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<h2>DaNaLiKinh</h2>
					<div class="share-block">
						<a href="#" target="_blank" aria-label="linkFacebook"
							rel="noopener"> <img src="./images/trangchu/ic_facebook.svg"
							alt="">
						</a> <a href="#" target="_blank" aria-label="linkTwitter"
							rel="noopener"> <img src="./images/trangchu/ic_twitter.svg"
							alt="">
						</a> <a href="#" target="_blank" aria-label="linkYoutube"
							rel="noopener"> <img src="./images/trangchu/ic_youtube.svg"
							alt="">
						</a> <a href="#" target="_blank" aria-label="linkInstagram"
							rel="noopener"> <img src="./images/trangchu/ic_instagram.svg"
							alt="">
						</a>
					</div>
				</div>
				<div class="col-sm-9">
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<div class="row">
								<div class="col col-xs-6 col-sm-6 col-md-3 col-lg-3 footer-item"
									style="height: 161px;">
									<div class="footer-wrapper">
										<h4>Công ty</h4>
										<p>
											<a href="GioiThieuServlet">Giới thiệu</a>
										</p>
										<p>
											<a href="#" target="_blank" rel="noopener">Blog</a>
										</p>
										<p>
											<a href="#" id="displayReviews">Đánh giá</a>
										</p>
										<p>
											<a href="#">Tuyển dụng</a>
										</p>
									</div>
								</div>
								<div class="col col-xs-6 col-sm-6 col-md-3 col-lg-3 footer-item"
									style="height: 161px;">
									<div class="footer-wrapper">
										<h4>Các dịch vụ</h4>
										<p>
											<a href="DichVuGiupViecTheoGioServlet">Giúp việc nhà theo giờ</a>
										</p>
										<p>
											<a href="DichVuVeSinhMayLanhServlet">Vệ sinh máy lạnh</a>
										</p>
										<p>
											<a href="#">Giữ trẻ</a>
										</p>
									</div>
								</div>
								<div class="col col-xs-6 col-sm-6 col-md-3 col-lg-3 footer-item"
									style="height: 161px;">
									<div class="footer-wrapper">
										<h4>Liên hệ</h4>
										<p>
											<a href="tel:1900636736">1900.636.736</a>
										</p>
										<p>
											<a href="mailto:support@DaNaLiKinh.com">support@DaNaLiKinh.com</a>
										</p>
									</div>
								</div>
								<div class="col col-xs-6 col-sm-6 col-md-3 col-lg-3 footer-item"
									style="height: 161px;">
									<div class="footer-wrapper">
										<h4>Hỗ trợ</h4>
										<p>
											<a href="#">Trung tâm hỗ trợ</a>
										</p>
										<p>
											<a href="#">FAQs</a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="sub-footer">
				<div class="container">
					<div class="row">
						<div class="col-sm-6">
							<p>© 2017 DaNaLiKinh, Ltd.</p>
						</div>
						<div class="col-sm-6">
							<div class="footer-terms">
								<a href="#"> <span>Điều khoản sử dụng</span>
								</a> <span>|</span> <a href="#"> <span>Chính sách bảo mật</span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<input type="hidden" id="hdfLanguage" value="vn"> <input
			type="hidden" id="urlRegister" value="#">
	</footer>
</div>
</div>
</div>
</body>
<script>
	new WOW().init();
</script>
</html>
