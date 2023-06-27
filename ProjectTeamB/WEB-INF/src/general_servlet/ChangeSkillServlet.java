package general_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SkillDAO;

@WebServlet("/ChangeSkillServlet")
public class ChangeSkillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangeSkillServlet() {
		super();
	}

	//Add a new skill information
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Initialization
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		//Connect session
		HttpSession session = request.getSession();
		//Get skilldata and username
		String name = (String) session.getAttribute("name");
		if (name == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Timeout.jsp");
			rd.forward(request, response);
		} else {
			String skill_name = request.getParameter("skill_name");
			Integer skill_lv = Integer.parseInt(request.getParameter("skill_lv"));
			String skill_appeal = request.getParameter("skill_appeal");

			//Connect DAO(return flg)
			SkillDAO skdao = new SkillDAO();
			int say = skdao.ChngMn(name, skill_name, skill_lv, skill_appeal);

			//Name botton
			String botton = "マイページへ";
			//Error comment
			String URL = "/view/GeneralView/MyPage.jsp";

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