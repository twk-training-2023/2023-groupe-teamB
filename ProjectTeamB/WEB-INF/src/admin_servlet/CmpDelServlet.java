package admin_servlet; //正しきパッケージ名を

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StaffDAO;

@WebServlet("/CmpDelServlet")
public class CmpDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CmpDelServlet() {
		super();
	}

	//Compare names→Get_name&Get_pass
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Initialization
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		if (name == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Timeout.jsp");
			rd.forward(request, response);
		} else {
			String[] delname = (String[]) session.getAttribute("delname");
			String botton = "社員一覧ページ";
			String URL = "/ManagerServlet";

			StaffDAO stdao = new StaffDAO();
			int del = stdao.deleteStaff(delname);

			if (del == delname.length) {
				request.setAttribute("botton", botton);
				request.setAttribute("URL", URL);
				RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Complete.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("botton", botton);
				request.setAttribute("URL", URL);
				RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Error.jsp");
				rd.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}