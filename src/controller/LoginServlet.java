package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.dichvu;
import model.bean.taikhoan;
import model.bo.DichVuBO;
import model.bo.TaikhoanBO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		// String thoat = request.getParameter("thoat");
		DichVuBO dichVuBO = new DichVuBO();
		ArrayList<dichvu> listDV = dichVuBO.layDanhSachdichvu();
		//
		TaikhoanBO tkBO = new TaikhoanBO();
		int kt = tkBO.checkLogin(tenDangNhap, matKhau);
		if (kt != 0) {
			// neu ma quyen == 1 chuyen toi trang Admin()
			taikhoan tk = tkBO.laytaikhoanTheoMataikhoan(tenDangNhap);
			HttpSession session = request.getSession();
			session.setAttribute("taikhoan", tk);
			if (tk.getQuyen() == 3){
				
				//session.setAttribute("nhomQuyen", nguoiDung.getMaQuyen()+"");
				//session.setAttribute("maCTV", nguoiDung.getMaCongTacVien());
				response.sendRedirect("DashboardServlet");
			}
			else if (tk.getQuyen()  == 1) {
				
				response.sendRedirect("TrangChuNguoiDungServlet");
			}
			else {
				
				session.setAttribute("listDV", listDV);
				response.sendRedirect("TrangChuNguoiDungServlet");
			}
			
		} else {
			String thongBao = "Sai tên đăng nhập hoặc mật khẩu";
			request.setAttribute("thongBao", thongBao);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
