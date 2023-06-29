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
import dto.StaffDTO;

@WebServlet("/ChangeMySelfServlet")
public class ChangeMySelfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangeMySelfServlet() {
		super();
	}

	//Get user information
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Initialization
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		//Connect session
		HttpSession session = request.getSession();String name = (String) session.getAttribute("name");if(name == null) {RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Timeout.jsp");rd.forward(request, response);}else {

		//Connect DAO(check user)
		StaffDAO stdao = new StaffDAO();
		StaffDTO stdto = stdao.ChngMySlf(name);

		//Return data
		request.setAttribute("stdto", stdto);

		//Forward jsp result
		RequestDispatcher rd = request.getRequestDispatcher("/view/GeneralView/ChangeMySelf.jsp");
		rd.forward(request, response);
		}

	}

}