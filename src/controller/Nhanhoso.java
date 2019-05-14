package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.taikhoan;
import model.bo.CongViecBO;
import model.bo.DangkydichvuBO;

/**
 * Servlet implementation class Nhanhoso
 */
public class Nhanhoso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Nhanhoso() {
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
		response.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("taikhoan") == null) {

			response.sendRedirect("StartServlet");
			return;
		} else {
			DangkydichvuBO dkbo = new DangkydichvuBO();
			dkbo.suadangkydichvuTheoSoDienThoai(Integer.valueOf(request.getParameter("macongviec")),
					Integer.valueOf(request.getParameter("maungvien")));
			response.setContentType("text/plain");
			response.getWriter().write("OK");

		}
	}

}
