package admin_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MessageDAO;

/**
 * Servlet implementation class CmpContactServlet
 */
@WebServlet("/CmpContactServlet")
public class CmpContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    public CmpContactServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//セッションからログインした名前を取得
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("name");
		//入力された連絡文を取得
		String message = (request.getParameter("message"));
		String botton = "社員一覧ページ";
		String URL = "/view/GeneralView/MyPage.jsp";
		
		//利用するDAOのインスタンス生成
		MessageDAO dao = new MessageDAO();
		//引数を渡してメソッド実行
		dao.insertMessage(name,message);
		request.setAttribute("botton", botton);
		request.setAttribute("URL", URL);
		
		//送信完了画面に遷移
        RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Complete.jsp");
        rd.forward(request, response);		
	}
}