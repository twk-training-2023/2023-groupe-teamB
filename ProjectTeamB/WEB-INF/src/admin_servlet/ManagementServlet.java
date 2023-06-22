package admin_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SkillDAO;

@WebServlet("/ManagementServlet")
public class ManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManagementServlet() {
		super();
	}

	//Add new staff information
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Initialization
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String[] name = (String[]) request.getParameterValues("name");

		if (request.getParameter("ok") != null) {
			SkillDAO skdao = new SkillDAO();
			int check = skdao.StatusOK(name);
			if (check == name.length) {
				RequestDispatcher rd = request.getRequestDispatcher("/SkillServlet");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Error.jsp");
				rd.forward(request, response);
			}

		} else if (request.getParameter("out") != null) {
			SkillDAO skdao = new SkillDAO();
			int check = skdao.StatusOUT(name);
			if (check == name.length) {
				RequestDispatcher rd = request.getRequestDispatcher("/SkillServlet");
				rd.forward(request, response);
			} else {
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