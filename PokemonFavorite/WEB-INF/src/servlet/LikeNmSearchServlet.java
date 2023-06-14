package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LikeNmSearchDAO;
import dto.SearchDTO;

@WebServlet("/LikeNmSearchServlet")
public class LikeNmSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LikeNmSearchServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 		//パラメータの取得
 		request.setCharacterEncoding("UTF-8");
 		String typename = request.getParameter("typename");
 		String firstname = request.getParameter("firstname");
 		
 		
 		//DAOの接続
 		LikeNmSearchDAO lnsdao = new LikeNmSearchDAO();
 		SearchDTO sdto = lnsdao.select(typename,firstname);
 		
 		//返還作業
 		request.setAttribute("typename", typename);
 		request.setAttribute("sdto", sdto);
	    //JSPへのフォワード処理
	    RequestDispatcher rd = request.getRequestDispatcher("/view/SearchView/LikeNmSearch.jsp");
	    rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}