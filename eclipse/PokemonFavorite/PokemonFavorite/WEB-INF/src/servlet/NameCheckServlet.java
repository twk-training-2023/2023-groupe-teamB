package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NameCheckDAO;
import dto.SearchDTO;

@WebServlet("/NameCheckServlet")
public class NameCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NameCheckServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 		//パラメータの取得
 		request.setCharacterEncoding("UTF-8");
 		String thisname = request.getParameter("thisname");
 		
 		//DAOの接続
 		NameCheckDAO ncdao = new NameCheckDAO();
 		SearchDTO sdto = ncdao.select(thisname);
 		
 		//返還作業
 		request.setAttribute("sdto", sdto);
	    //JSPへのフォワード処理
	    RequestDispatcher rd = request.getRequestDispatcher("/view/SearchView/ReasonAdd.jsp");
	    rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}