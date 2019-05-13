package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.dangkydichvu;
import model.bean.taikhoan;
import model.bo.DangkydichvuBO;

/**
 * Servlet implementation class CongViecDaNhanCTVServlet
 */
public class CongViecDaNhanCTVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CongViecDaNhanCTVServlet() {
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
		} else  {
			taikhoan tk= (taikhoan) session.getAttribute("taikhoan");
			// lay danh sach cong viec
			ArrayList<dangkydichvu>  listCongViec;
			DangkydichvuBO dangKyDichVuBO = new DangkydichvuBO();
			listCongViec = dangKyDichVuBO.laydsdangkydichvuTheoSoDienThoai(tk.getSodienthoai());
			request.setAttribute("listCongViec", listCongViec);
			RequestDispatcher rd = request.getRequestDispatcher("danhSachCongViecDaNhanCTV.jsp");
			rd.forward(request, response);
		} 
	}

}
