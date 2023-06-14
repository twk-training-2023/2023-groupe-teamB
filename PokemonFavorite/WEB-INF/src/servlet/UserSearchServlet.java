package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserSearchBean;
import dao.UserSearchDAO;

@WebServlet("/UserSearchServlet")
public class UserSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserSearchServlet() {
		super();
	}

	//Compare names→Get_name&Get_pass
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Initialization
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		//Create Bean instance
		UserSearchBean usbe = new UserSearchBean();
		
		//Get requestdata
		usbe.setUser(request.getParameter("username"));
		usbe.setPass(request.getParameter("password"));

		//Connect DAO(check user)
		UserSearchDAO usda = new UserSearchDAO();
		boolean flg = usda.select(usbe);
		
		//Connect session
		HttpSession session = request.getSession();
		
		//Check account(false→up process,true→down process)
		if(!flg){
			
			//Error comment
			String nouser = "ユーザー名" + usbe.getUser() + "またはパスワードでエラーが起きています。";
			
			//Return data
			request.setAttribute("nouser", nouser);

			//forward jsp result
			RequestDispatcher rd = request.getRequestDispatcher("/view/LoginView/Error.jsp");
			rd.forward(request, response);

		}else{
			//Insert username session 
			session.setAttribute("username",usbe.getUser());
			
			//Insert password Bean
			usbe.setPass("");

			//forward jsp result
			RequestDispatcher rd = request.getRequestDispatcher("/view/LoginView/PlatformDB.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}