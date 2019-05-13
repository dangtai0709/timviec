package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.congviec;
import model.bean.taikhoan;
import model.bo.CongViecBO;

/**
 * Servlet implementation class ThemDangKyDichVuServlet
 */
public class ThemDangKyDichVuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemDangKyDichVuServlet() {
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
		HttpSession session = request.getSession();
		if (session.getAttribute("taikhoan") == null) {
			response.sendRedirect("StartServlet");
			return;
		} else {
			taikhoan tk = (taikhoan) session.getAttribute("taikhoan");
			CongViecBO cvBO= new CongViecBO();
			congviec req= new congviec();
			req.setMadichvu(request.getParameter("madichvu"));
			req.setDiadiem( request.getParameter("diadiem"));
			req.setNgayhethan( request.getParameter("ngayhethan"));
			req.setSogio(Integer.valueOf( request.getParameter("sogio")));
			req.setLuong(Integer.valueOf( request.getParameter("luong")));
			req.setSonguoi(Integer.valueOf( request.getParameter("songuoi")));
			req.setMota( request.getParameter("mota"));
			req.setMakhachhang(tk.getSodienthoai());
			cvBO.themcongviec(req);
			response.sendRedirect("TrangChuNguoiDungServlet");
		}
		
			
		
	}

}
