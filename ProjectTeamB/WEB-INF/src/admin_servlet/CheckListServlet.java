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
import dto.MessageDTO;

/**
 * Servlet implementation class CheckListServlet
 */
@WebServlet("/CheckListServlet")
public class CheckListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//セッションからログインした名前を取得
		//HttpSession session = request.getSession();
		//String name = (String)session.getAttribute("name");
		String name = "早瀬";
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		//利用するDAOのインスタンス生成
		MessageDAO dao = new MessageDAO();
		//引数を渡してメソッド実行
		MessageDTO value = dao.selectMessage();
		
        request.setAttribute("value", value);
        request.setAttribute("name", name);
		//送信完了画面に遷移
        RequestDispatcher rd = request.getRequestDispatcher("/view/AdminView/CheckList.jsp");
        rd.forward(request, response);		
	}
}