package admin_servlet;						//正しきパッケージ名を
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StaffDAO;
import dto.StaffDTO;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();
	}

	//Compare names→Get_name&Get_pass
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Initialization
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		//DAOの接続
		StaffDAO stdao = new StaffDAO();
		StaffDTO stdto = stdao.allStaff();
		request.setAttribute("stdto", stdto);
		//正しきallStaff.jspのパスを
		RequestDispatcher rd = request.getRequestDispatcher("/view/AdminView/DeleteStaff.jsp");
		rd.forward(request, response);

	}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
}
}