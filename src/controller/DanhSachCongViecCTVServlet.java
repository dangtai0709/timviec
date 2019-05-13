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
import model.bean.dichvu;
import model.bean.taikhoan;
import model.bean.ungvien;
import model.bo.CongViecBO;
import model.bo.DichVuBO;
import model.bo.UngVienBO;

/**
 * Servlet implementation class DanhSachCongViecCTVServlet1
 */
public class DanhSachCongViecCTVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachCongViecCTVServlet() {
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
//			DichVuBO dichVuBO = new DichVuBO();
//			ArrayList<dichvu> listDV = dichVuBO.layDanhSachdichvu();
//			request.setAttribute("listDV2", listDV);
			
			ArrayList<congviec> listCongViec;
			CongViecBO cv = new CongViecBO();
			UngVienBO uv= new UngVienBO();
			ungvien uv1= uv.layUngVienTheoSoDienThoai(String.valueOf(tk.getSodienthoai()));
			listCongViec = cv.layDanhSachcongviec(uv1.getMadichvu());
			request.setAttribute("listCongViec", listCongViec);
			RequestDispatcher rd = request.getRequestDispatcher("danhSachCongViecCTV2.jsp");
			rd.forward(request, response);
		}
	}

}
