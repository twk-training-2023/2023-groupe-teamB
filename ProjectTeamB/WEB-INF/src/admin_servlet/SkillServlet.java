package admin_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SkillDAO;
import dto.SkillDTO;

@WebServlet("/SkillServlet")
public class SkillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SkillServlet() {
		super();
	}

	//Add new staff information
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Initialization
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");


		//Connect DAO
		SkillDAO skdao = new SkillDAO();
		SkillDTO skdto = skdao.AllSkill();
		
	
		request.setAttribute("skdto", skdto);
		RequestDispatcher rd = request.getRequestDispatcher("/view/AdminView/CheckSkill.jsp");
		rd.forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}