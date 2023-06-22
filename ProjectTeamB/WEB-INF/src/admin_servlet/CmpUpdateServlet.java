package admin_servlet; //正しきパッケージ名を

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StaffDAO;

@WebServlet("/CmpUpdateServlet")
public class CmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CmpUpdateServlet() {
		super();
	}

	//Compare names→Get_name&Get_pass
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Initialization
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		int lv = Integer.parseInt(request.getParameter("lv"));
		String nema = request.getParameter("neme");
		
		String botton = "社員一覧ページ";
		String URL = "/ManagerServlet";
		
		StaffDAO stdao = new StaffDAO();
		int us = stdao.updateStaff(nema,lv);
		
		if(us==1) {
			request.setAttribute("botton",botton);
			request.setAttribute("URL",URL);
			RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Complete.jsp");
			rd.forward(request, response);
			
		}else {
			request.setAttribute("botton",botton);
			request.setAttribute("URL",URL);
			RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Error.jsp");
			rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}