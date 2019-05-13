package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.dangkydichvu;
import model.bean.taikhoan;
import model.bo.DangkydichvuBO;

/**
 * Servlet implementation class NhanViecServlet
 */
public class NhanViecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NhanViecServlet() {
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
		HttpSession session = request.getSession();
		if (session.getAttribute("taikhoan") == null) {

			response.sendRedirect("StartServlet");
			return;
		}
		taikhoan tk = (taikhoan) session.getAttribute("taikhoan");
		response.setCharacterEncoding("UTF-8");
		// String maCTV = request.getParameter("maCTV"); // lấy mã Cộng tác viên
		String maDangKy = request.getParameter("macongviec");
		DangkydichvuBO dkBO = new DangkydichvuBO();
		dangkydichvu dk = new dangkydichvu();
		dk.setMacongviec(Integer.valueOf(maDangKy));
		dk.setMaungvien(tk.getSodienthoai());
		dk.setTrangthai(0);

		if (dkBO.themdangkydichvu(dk)) {
			System.out.println(dk);
			response.getWriter().write("Nhận việc thành công!");
		}

		else {
			response.setContentType("text/plain");
			response.getWriter().write("Bạn đã nộp hồ sơ cho công việc này");
		}

	}

}
