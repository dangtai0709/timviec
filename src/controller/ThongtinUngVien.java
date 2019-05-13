package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ungvien;
import model.bo.UngVienBO;

/**
 * Servlet implementation class ThongtinUngVien
 */
public class ThongtinUngVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongtinUngVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
			String dichvu = request.getParameter("madichvu");
			String gioithieu = request.getParameter("gioithieu");
			String ungvien = request.getParameter("maungvien");
			ungvien uv = new ungvien();
			uv.setCmnd(Integer.valueOf(request.getParameter("cmnd")));
			uv.setGioithieubanthan(gioithieu);
			uv.setMadichvu(dichvu);
			uv.setMaungvien(Integer.valueOf(ungvien));
			UngVienBO uvbo= new UngVienBO();
			uvbo.themungvien(uv);
			response.sendRedirect("TrangChuNguoiDungServlet");
		}
		
	

}
