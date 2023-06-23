package general_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MessageDAO;

/**
 * Servlet implementation class CmpContactServlet
 */
@WebServlet("/CmpContactServlet")
public class CmpContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CmpContactServlet() {
		super();
	}

	//Add a new message from staff
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Initialization
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		//Connect session
		HttpSession session = request.getSession();

		//Get typed message and username
		String name = (String) session.getAttribute("name");
		String message = (request.getParameter("message"));
		if (name == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Timeout.jsp");
			rd.forward(request, response);
		} else {
			//Name botton
			String botton = "マイページへ";
			//Error comment
			String URL = "/view/GeneralView/MyPage.jsp";

			//Connect DAO(return flg)
			MessageDAO medao = new MessageDAO();
			int say = medao.insertMessage(name, message);

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

}
