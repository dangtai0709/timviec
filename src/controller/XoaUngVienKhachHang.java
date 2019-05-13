package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.taikhoan;
import model.bo.KhachHangBO;
import model.bo.UngVienBO;

/**
 * Servlet implementation class XoaUngVienKhachHang
 */
public class XoaUngVienKhachHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaUngVienKhachHang() {
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
		response.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("taikhoan") == null) {

			response.sendRedirect("StartServlet");
			return;
		} else {
			taikhoan tk = (taikhoan) session.getAttribute("taikhoan");
			UngVienBO uvbo= new UngVienBO();
			KhachHangBO khbo= new KhachHangBO();
			String maungvien = request.getParameter("maungvien");
			String khachhang = request.getParameter("makhachhang");
			if(maungvien != null) {
				uvbo.xoaUngVienTheoSoDienThoai(maungvien);
			}
			if(khachhang != null) {
				khbo.xoakhachhangTheoSoDienThoai(khachhang);
			}

			
			response.setContentType("text/plain");
			response.getWriter().write("OK");

		}
	}


}
