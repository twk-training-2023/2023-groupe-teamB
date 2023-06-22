package admin_servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StaffDAO;
import dto.StaffDTO;

@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManagerServlet() {
		super();
	}

	//Get  all staff information
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Initialization
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		//Connect DAO(return staff name)
		StaffDAO stdao = new StaffDAO();
		StaffDTO stdto = stdao.allStaff();
		
		
		request.setAttribute("stdto", stdto);
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/AdminView/Allstaff.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
}
}