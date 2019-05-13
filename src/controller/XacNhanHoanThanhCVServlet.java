package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.taikhoan;
import model.bo.CongViecBO;
import model.bo.DangkydichvuBO;

/**
 * Servlet implementation class XacNhanHoanThanhCVServlet
 */
public class XacNhanHoanThanhCVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XacNhanHoanThanhCVServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("taikhoan") == null) {

			response.sendRedirect("StartServlet");
			return;
		} else {
			taikhoan tk = (taikhoan) session.getAttribute("taikhoan");
			// lay danh sach sinh vien
			DangkydichvuBO dkBO = new DangkydichvuBO();
			String maDangKy = request.getParameter("maDangKy");
			String xoacongviec= request.getParameter("xoacongviec");
			String ungvien= request.getParameter("ungvien");
			if(xoacongviec != null) {
				if(ungvien == null) {
					dkBO.xoadangkydichvuTheoSoDienThoai(Integer.valueOf(maDangKy) ,tk.getSodienthoai());
				}else {
					dkBO.xoadangkydichvuTheoSoDienThoai(Integer.valueOf(maDangKy) ,Integer.valueOf(ungvien));
				}
				
			}else {
				CongViecBO cv= new CongViecBO();
				cv.xoacongviecTheoSoDienThoai(Integer.valueOf(maDangKy));
			}
			
			response.setContentType("text/plain");
			response.getWriter().write("OK");

		}
	}

}
