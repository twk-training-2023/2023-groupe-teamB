package admin_servlet; //正しきパッケージ名を

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StaffDAO;

@WebServlet("/CmpAddServlet")
public class CmpAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CmpAddServlet() {
		super();
	}

	//Compare names→Get_name&Get_pass
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Initialization
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		int lv = Integer.parseInt(request.getParameter("lv"));
		String botton = "社員一覧ページ";
		String URL = "/ManagerServlet";

		//DAOの接続
		StaffDAO stdao = new StaffDAO();
		int stdto = stdao.addStaff(name, email, pass, lv);

		if (stdto == 3) {
			request.setAttribute("botton", botton);
			request.setAttribute("URL", URL);
			RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Complete.jsp");
			rd.forward(request, response);

		} else {
			request.setAttribute("botton", botton);
			request.setAttribute("URL", URL);
			RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Error.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String csv = request.getParameter("fpass");
		String name, email, pass;
		int lv;
		String botton = "社員一覧ページ";
		String URL = "/ManagerServlet";
		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br = null;
		try {
			fi = new FileInputStream(csv);
			is = new InputStreamReader(fi);
			br = new BufferedReader(is);
			String line;
			while ((line = br.readLine()) != null) {
				//String[] data = line.split(",");
				name = line.split(",")[0];
				email = line.split(",")[1];
				pass = line.split(",")[2];
				lv = Integer.parseInt(line.split(",")[3]);
				StaffDAO stdao = new StaffDAO();
				int stdto = stdao.addStaff(name, email, pass, lv);
				if (stdto == 3) {
					request.setAttribute("botton", botton);
					request.setAttribute("URL", URL);
					RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Complete.jsp");
					rd.forward(request, response);

				} else {
					request.setAttribute("botton", botton);
					request.setAttribute("URL", URL);
					RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Error.jsp");
					rd.forward(request, response);
				}
			}
		} catch (Exception e) {
			request.setAttribute("botton", botton);
			request.setAttribute("URL", URL);
			RequestDispatcher rd = request.getRequestDispatcher("/view/VersView/Error.jsp");
			rd.forward(request, response);
		}
	}
}