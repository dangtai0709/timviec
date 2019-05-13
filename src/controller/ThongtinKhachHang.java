package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.khachhang;
import model.bo.KhachHangBO;

/**
 * Servlet implementation class ThongtinKhachHang
 */
public class ThongtinKhachHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongtinKhachHang() {
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

			String tencongty = request.getParameter("tencongty");
			String Email = request.getParameter("Email");
			String phone = request.getParameter("phone");
			String diachi = request.getParameter("diachi");
			khachhang kh = new khachhang();
			KhachHangBO khbo= new KhachHangBO();
			kh.setDiachicty(diachi);
			kh.setSodienthoaicty(Integer.valueOf(phone));
			kh.setEmailcty(Email);
			kh.setTencongty(tencongty);
			khbo.themkhachhang(kh);
			response.sendRedirect("TrangChuNguoiDungServlet");
		}

}
