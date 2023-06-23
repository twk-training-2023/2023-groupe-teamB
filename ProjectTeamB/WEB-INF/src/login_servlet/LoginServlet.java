package login_servlet;

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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	//Check eamil,pass→Get username
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Initialization
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		//Get requestdata
		String email = request.getParameter("email");
		String pass = request.getParameter("password");

		//Connect DAO(return name,staff_lv)
		StaffDAO stdao = new StaffDAO();
		StaffDTO stdto= stdao.select(email,pass);
		
		//Connect session
		HttpSession session = request.getSession();
		
		//Get username
		String username = stdto.get(0).getName();
		
		//Check account(false→up process,true→down process)
		if(username.equals("nouser")){
			
			//Error comment
			String nouser = "メールアドレス ： " + email + "またはパスワードでエラーが起きています。";
			String error =  "/view/LoginView/Login.jsp";
			
			//Return data
			request.setAttribute("nouser", nouser);
			request.setAttribute("error", error);

			//forward jsp result
			RequestDispatcher rd = request.getRequestDispatcher("/view/LoginView/LoginError.jsp");
			rd.forward(request, response);

		}else{
			//Insert username,staff_lv session 
			session.setAttribute("name",stdto.get(0).getName());
			session.setAttribute("staff_lv",stdto.get(0).getStaff_lv());

			//forward jsp result
			RequestDispatcher rd = request.getRequestDispatcher("/view/LoginView/Menu.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}