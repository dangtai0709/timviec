package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.congviec;
import model.bean.dangkydichvu;
import model.bean.taikhoan;
import model.bo.CongViecBO;
import model.bo.DangkydichvuBO;

/**
 * Servlet implementation class Hosodanhan
 */
public class Hosodanhan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hosodanhan() {
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
		} else {
			taikhoan tk = (taikhoan) session.getAttribute("taikhoan");
			ArrayList<dangkydichvu>  listCongViec;
			DangkydichvuBO dvbo = new DangkydichvuBO();
			listCongViec = dvbo.laydsdangky(tk.getSodienthoai());
			request.setAttribute("listCongViec", listCongViec);
			RequestDispatcher rd = request.getRequestDispatcher("hosodanhan.jsp");
			rd.forward(request, response);
		} 
	}

}
