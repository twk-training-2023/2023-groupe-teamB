package admin_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StaffDAO;

@WebServlet("/CmpAddServlet")
public class CmpAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CmpAddServlet() {
		super();
	}

	//Add new staff information
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Initialization
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		//Get typed user information
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		int lv = Integer.parseInt(request.getParameter("lv"));
		//Name botton
		String botton = "社員一覧ページへ";
		//Complete comment
		String URL =  "/view/AdminView/AllStaff.jsp";

		//Connect DAO
		StaffDAO stdao = new StaffDAO();
		int stdto = stdao.addStaff(name, email, pass, lv);
		
		//Check SQL proces
		if (stdto == 2) {
			
			//Return data
			request.setAttribute("botton", botton);
			request.setAttribute("URL", URL);
			//Forward jsp result
			RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Complete.jsp");
			rd.forward(request, response);
		
		}else{
			
			//Return data
			request.setAttribute("botton", botton);
			request.setAttribute("URL", URL);
			//Forward jsp result
			RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Error.jsp");
			rd.forward(request, response);
		
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}