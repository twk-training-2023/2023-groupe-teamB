package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserSearchBean;
import dao.NewRecordDAO;
import dao.UserSearchDAO;

@WebServlet("/NewRecordServlet")
public class NewRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewRecordServlet() {
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
		
		//Check account
		if(flg){
			
			//Error account
			String nouser = "ユーザー名" + usbe.getUser() + "は既に登録されています。";
			
			//Return data
			request.setAttribute("nouser", nouser);

			//forward jsp result
			RequestDispatcher rd = request.getRequestDispatcher("/view/LoginView/Error.jsp");
			rd.forward(request, response);

		}else{
			//ConnectDAO(add user)
			NewRecordDAO nrda = new NewRecordDAO();
			int num = nrda.select(usbe);
			
			//Check insert username & password
			if(num==1){
				//Return data
				request.setAttribute("answer","完了済み");
				//forward jsp result
				RequestDispatcher rd = request.getRequestDispatcher("/view/LoginView/Login.jsp");
				rd.forward(request, response);
			}else{
				//forward jsp result
				RequestDispatcher rd = request.getRequestDispatcher("/view/LoginView/Error.jsp");
				rd.forward(request, response);	
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}