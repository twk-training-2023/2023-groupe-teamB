package general_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MyselfDAO;

@WebServlet("/ChangeMineServlet")
public class ChangeMineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangeMineServlet() {
		super();
	}

	//Update new myself
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Initialization
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		//Get username
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
		//Get requestdata
		String myself = request.getParameter("myself");

		//Connect DAO(update password)
		MyselfDAO mydao = new MyselfDAO();
		int say = mydao.ChngMn(name,myself);
		
		//Name botton
		String botton = "マイページへ";
		//Complete comment
		String URL =  "/view/GeneralView/MyPage.jsp";
		
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

	protected void doget(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}