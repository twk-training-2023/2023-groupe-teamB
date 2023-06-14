package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TypeSearchDAO;
import dto.SearchDTO;

@WebServlet("/TypeSearchServlet")
public class TypeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TypeSearchServlet() {
		super();
	}

	//Compare names→Get_name&Get_pass
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Connect DAO(check user)
		TypeSearchDAO tsdao = new TypeSearchDAO();
		SearchDTO sdto = tsdao.select();

		//Insert username session 
		request.setAttribute("sdto", sdto);

		//forward jsp result
		RequestDispatcher rd = request.getRequestDispatcher("/view/SearchView/TypeSearch.jsp");
		rd.forward(request, response);
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}