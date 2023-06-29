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
import dto.StaffDTO;

@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowServlet() {
		super();
	}

	//Compare names→Get_name&Get_pass
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Initialization
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String nama = request.getParameter("name");
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		if (name == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Timeout.jsp");
			rd.forward(request, response);
		} else {
			String botton = "社員一覧ページ";
			String URL = "/ManagerServlet";

			//DAOの接続
			StaffDAO stdao = new StaffDAO();
			StaffDTO stdto = stdao.checkStaff(nama);
			if (stdto.size() == 0) {
				request.setAttribute("botton", botton);
				request.setAttribute("URL", URL);
				RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Error.jsp");
				rd.forward(request, response);

			} else {
				request.setAttribute("stdto", stdto);
				request.setAttribute("nama", nama);

				RequestDispatcher rd = request.getRequestDispatcher("/view/AdminView/StaffINF.jsp");
				rd.forward(request, response);
			}
		}
	}

}