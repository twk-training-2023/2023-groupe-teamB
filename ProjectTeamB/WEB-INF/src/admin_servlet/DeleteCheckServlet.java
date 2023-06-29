package admin_servlet; //正しきパッケージ名を

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DeleteCheckServlet")
public class DeleteCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteCheckServlet() {
		super();
	}

	//Compare names→Get_name&Get_pass
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Initialization
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
			String[] nam = request.getParameterValues("name");
			HttpSession session = request.getSession();
			String name = (String) session.getAttribute("name");
			if (name == null) {
				RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Timeout.jsp");
				rd.forward(request, response);
			} else {
			session.setAttribute("delname", nam);
			//System.out.println(name[0]);

			RequestDispatcher rd = request.getRequestDispatcher("/view/AdminView/CheckDelete.jsp");
			rd.forward(request, response);
		}
	}
}