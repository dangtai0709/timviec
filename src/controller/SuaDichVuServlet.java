package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.dichvu;
import model.bo.DichVuBO;

/**
 * Servlet implementation class SuaDichVuServlet
 */
public class SuaDichVuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaDichVuServlet() {
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
  		response.setCharacterEncoding("utf-8");
  		request.setCharacterEncoding("utf-8");
  		DichVuBO dvbo= new DichVuBO();
  		String ma = request.getParameter("maDichVu") ;
  		if(request.getParameter("ten") != null) {
  			dichvu dv = new dichvu();
  			dv.setMadichvu(request.getParameter("madichvu"));
  			
  			dv.setTendichvu(request.getParameter("ten"));
  			System.out.println(request.getParameter("madichvu"));
  			dvbo.suadichvuTheoSoDienThoai(dv);
  			response.sendRedirect("DanhSachDichVuServlet");
  		}else {
  			//String ma = request.getParameter("maDichVu") ;
  			request.setAttribute("madichvu", ma);
  			request.setAttribute("tendichvu", dvbo.laydichvuTheoSoDienThoai(ma).getTendichvu());
  			RequestDispatcher rd = request.getRequestDispatcher("themMoiDichVu.jsp");
  			rd.forward(request, response);
  			
  		}
  			
  		
  	}

}
