package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.taikhoan;
import model.bean.ungvien;
import model.bo.TaikhoanBO;
import model.bo.UngVienBO;

/**
 * Servlet implementation class ThemMoiNguoiDungServlet
 */
public class ThemMoiNguoiDungServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemMoiNguoiDungServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		
		String tenTaiKhoan = request.getParameter("hovaten");
		String soDienThoai = request.getParameter("sodienthoai");
		String matKhau = request.getParameter("matkhau");
		String diachi = request.getParameter("diachi");
		String ngaysinh = request.getParameter("ngaysinh");
		String gioitinh = request.getParameter("gioitinh");
		String quyen = request.getParameter("quyen");

		//
		// CongTacVienBO congTacVienBo = new CongTacVienBO();
		// String maCongTacVien = "CTV" +
		// String.format("%05d",congTacVienBo.sinhMa()+1);
		//
		// NguoiDungBO nguoiDungBO = new NguoiDungBO();
		// String maNguoiDung = "ND" + String.format("%05d",nguoiDungBO.sinhMa()+1);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		TaikhoanBO tkbo = new TaikhoanBO();
		if ("submit".equals(request.getParameter("submit"))) {
			taikhoan tk = new taikhoan();
			tk.setDiachi(diachi);
			tk.setGioitinh(gioitinh);
			tk.setHoten(tenTaiKhoan);
			tk.setMatkhau(matKhau);
			tk.setNgaysinh(ngaysinh);
			tk.setQuyen(Integer.valueOf(quyen));
			tk.setSodienthoai(Integer.valueOf(soDienThoai));
			if (tkbo.themtaikhoan(tk)) {
				HttpSession	session = request.getSession();
				session.setAttribute("taikhoan", tk);
				if(Integer.valueOf(quyen)==1) {
					RequestDispatcher rd = request.getRequestDispatcher("ThongTinUngVien.jsp");
					rd.forward(request, response);
				}else {
					RequestDispatcher rd = request.getRequestDispatcher("ThongTinKhachHang.jsp");
					rd.forward(request, response);
				}
				
				
				//response.getWriter().write("OK xong");
			} else {
				
				response.getWriter().write("Số điện thoại này đã có !");
			}

		}
	}

}
