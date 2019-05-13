package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.congviec;
import model.bean.dichvu;
import model.bean.taikhoan;
import model.bo.CongViecBO;
import model.bo.DichVuBO;

/**
 * Servlet implementation class ThemMoiDichVuServlet
 */
public class ThemMoiDichVuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemMoiDichVuServlet() {
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
		DichVuBO dvbo= new DichVuBO();
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("ten") != null) {
			dichvu dv = new dichvu();
			
			String ma = "DV"+dvbo.sinhMa();
			dv.setMadichvu(ma);
			dv.setTendichvu(request.getParameter("ten"));
			dvbo.themdichvu(dv);
			response.sendRedirect("DanhSachDichVuServlet");
		}else {
			String ma = "DV"+dvbo.sinhMa() ;
			request.setAttribute("madichvu", ma);
			RequestDispatcher rd = request.getRequestDispatcher("themMoiDichVu.jsp");
			rd.forward(request, response);
			
		}
			
		
	}

}
