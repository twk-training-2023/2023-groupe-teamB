package general_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StaffDAO;

@WebServlet("/ChangePassServlet")
public class ChangePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangePassServlet() {
		super();
	}

	//update New Password
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Initialization
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		//Connect session
		HttpSession session = request.getSession();

		//Get requestdata and username
		String name = (String) session.getAttribute("name");
		if (name == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Timeout.jsp");
			rd.forward(request, response);
		} else {
			String pass = request.getParameter("password");
			//name botton
			String botton = "マイページへ";
			//Complete comment
			String URL = "/view/GeneralView/MyPage.jsp";

			//Connect DAO(return flg)
			StaffDAO stdao = new StaffDAO();
			int say = stdao.ChngPss(name, pass);

			//Check SQL process
			if (say == 1) {

				//Return data
				request.setAttribute("botton", botton);
				request.setAttribute("URL", URL);
				//forward jsp result
				RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Complete.jsp");
				rd.forward(request, response);

			} else {

				//Return data
				request.setAttribute("botton", botton);
				request.setAttribute("URL", URL);
				//forward jsp result
				RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Error.jsp");
				rd.forward(request, response);

			}
		}
	}

	protected void doget(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}