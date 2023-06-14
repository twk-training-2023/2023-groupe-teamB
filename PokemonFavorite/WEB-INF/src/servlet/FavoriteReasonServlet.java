package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ReasonBean;
import dao.FavoriteReasonDAO;
import dao.ReasonCheckDAO;

@WebServlet("/FavoriteReasonServlet")
public class FavoriteReasonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FavoriteReasonServlet() {
		super();
	}

	//Compare names→Get_name&Get_pass
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Initialization
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		//Create Bean instance
		ReasonBean rbe = new ReasonBean();
		
		//Get requestdata
		rbe.setName(request.getParameter("username"));
		rbe.setPKMN(request.getParameter("name"));
		rbe.setReason(request.getParameter("reason"));
		
		//Connect DAO(check user)
		ReasonCheckDAO rcdao = new ReasonCheckDAO();
		boolean flg = rcdao.select(rbe);
		
		//Check account
		if(flg){
			
			//Error account
			String nouser = "ユーザー名" + rbe.getName() + "は既に登録されています。";
			
			//Return data
			request.setAttribute("nouser", nouser);

			//forward jsp result
			RequestDispatcher rd = request.getRequestDispatcher("/view/LoginView/Error.jsp");
			rd.forward(request, response);

		}else{
			//Connect DAO(check user)
			FavoriteReasonDAO rdao = new FavoriteReasonDAO();
			int num = rdao.select(rbe);
			
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