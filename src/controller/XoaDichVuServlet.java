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
 * Servlet implementation class XoaDichVuServlet
 */
public class XoaDichVuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaDichVuServlet() {
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
  		
  		dvbo.xoadichvuTheoSoDienThoai(ma);
  			response.sendRedirect("DanhSachDichVuServlet");
  		
  			
  		
  	}

}
