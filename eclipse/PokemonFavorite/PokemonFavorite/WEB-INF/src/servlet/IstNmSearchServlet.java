package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IstNmSearchDAO;
import dto.SearchDTO;

@WebServlet("/IstNmSearchServlet")
public class IstNmSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public IstNmSearchServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 		//パラメータの取得
 		request.setCharacterEncoding("UTF-8");
 		String typename = request.getParameter("typename");
 		
 		//DAOの接続
 		IstNmSearchDAO insdto = new IstNmSearchDAO();
 		SearchDTO sdto = insdto.select(typename);
 		
 		//初期設定
 		String result = "";
 		
 		//結果の格納
 		for (int j = 0; j < sdto.size(); j++) {
			result += "<a href = \"/PokemonFavorite/LikeNmSearchServlet?typename="
					+typename + "&firstname="+ sdto.get(j).getName() +"\">" + sdto.get(j).getName() +"</a><br/>";
		}
 		
 		//返還作業
 		request.setAttribute("typename", typename);
 		request.setAttribute("result", result);
	    //JSPへのフォワード処理
	    RequestDispatcher rd = request.getRequestDispatcher("/view/SearchView/IstNmSearch.jsp");
	    rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
