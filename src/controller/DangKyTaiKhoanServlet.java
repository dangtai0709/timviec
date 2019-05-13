package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.dichvu;
import model.bo.DichVuBO;

/**
 * Servlet implementation class DangKyTaiKhoanServlet
 */
public class DangKyTaiKhoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyTaiKhoanServlet() {
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
		DichVuBO dichVuBO = new DichVuBO();
		ArrayList<dichvu> listDV = dichVuBO.layDanhSachdichvu();
		HttpSession session = request.getSession();
		session.setAttribute("listDV", listDV);
		response.sendRedirect("dangkytaikhoan.jsp");
	}

}
