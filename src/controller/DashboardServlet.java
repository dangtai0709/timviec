package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import model.bean.dichvu;
import model.bean.ungvien;
import model.bo.DichVuBO;
import model.bo.UngVienBO;

/**
 * Servlet implementation class DashboardServlet
 */
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
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
		HttpSession session = request.getSession();
		if (session.getAttribute("taikhoan") == null) {
			response.sendRedirect("StartServlet");
			return;
		} 
			DichVuBO dvbo = new DichVuBO();
			ArrayList<dichvu> listDV = dvbo.layDanhSachdichvu();
			request.setAttribute("listDV", listDV);

			// lay danh sach sinh vien
			ArrayList<ungvien> listCTV;
			UngVienBO uvbo = new UngVienBO();
			String maDichVu = request.getParameter("maDichVu");
			if (maDichVu == null || maDichVu.length() == 0) {
				listCTV = uvbo.layDanhSachUngVien();
			} else {
				listCTV = uvbo.layDanhSachUngVienTheoDV(maDichVu);
			}
			request.setAttribute("listCTV", listCTV);
			RequestDispatcher rd = request.getRequestDispatcher("danhSachCongTacVien.jsp");
			rd.forward(request, response);
		
	}

}
