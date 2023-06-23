package general_servlet;

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

/**
 * Servlet implementation class CheckListServlet
 */
@WebServlet("/SelfINFServlet")
public class SelfINFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelfINFServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//セッションからログインした名前を取得
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("name");
		//利用するDAOのインスタンス生成
		StaffDAO dao = new StaffDAO();
		//引数を渡してメソッド実行
		StaffDTO value = dao.selfINF(name);
		
        request.setAttribute("value", value);
        request.setAttribute("name", name);
		//送信完了画面に遷移
        RequestDispatcher rd = request.getRequestDispatcher("/view/GeneralView/SelfINF.jsp");
        rd.forward(request, response);		
	}
}