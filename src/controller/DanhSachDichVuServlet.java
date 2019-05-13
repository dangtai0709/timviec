package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.dichvu;
import model.bo.DichVuBO;

/**
 * Servlet implementation class DanhSachDichVuServlet
 */
public class DanhSachDichVuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachDichVuServlet() {
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
		ArrayList<dichvu> listDichVu = dichVuBO.layDanhSachdichvu();
		request.setAttribute("listDichVu", listDichVu);

		RequestDispatcher rd = request.getRequestDispatcher("danhSachDichVu.jsp");
		rd.forward(request, response);
	}

}
