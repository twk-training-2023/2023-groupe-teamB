package junit.servletTest.admin;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import admin_servlet.CmpDelServlet;

public class CmpDelServletTest {

	MockHttpServletRequest req = new MockHttpServletRequest();
	MockHttpServletResponse resp = new MockHttpServletResponse();
	
	@Test
	@DisplayName("社員削除(削除成功)")
	public void test1() throws ServletException, IOException {
		
		CmpDelServlet a = new CmpDelServlet();
		HttpSession session = req.getSession();
		session.setAttribute("name", "太郎");
		
		String[]name = new String[1];
		String str = "小鳥遊ホシノ";
		name [0] = str;
		
		
		session.setAttribute("delname", name);
		
		a.doGet(req,resp);

		assertEquals("社員一覧ページ", req.getAttribute("botton"));
		assertEquals("/ManagerServlet", req.getAttribute("URL"));
		assertEquals("/view/VersView/Complete.jsp", resp.getForwardedUrl());
	}
	@Test
	@DisplayName("社員削除(削除失敗)")
	public void test2() throws ServletException, IOException {
		
		CmpDelServlet a = new CmpDelServlet();
		
		String[]name = new String[1];
		String str = "";
		name [0] = str;
		
		HttpSession session = req.getSession();
		session.setAttribute("name", "太郎");
		session.setAttribute("delname", name);
		
		a.doGet(req,resp);

		assertEquals("社員一覧ページ", req.getAttribute("botton"));
		assertEquals("/ManagerServlet", req.getAttribute("URL"));
		assertEquals("/view/VersView/Error.jsp", resp.getForwardedUrl());
	}
	
	@Test
	@DisplayName("個人の社員情報表示-セッション切れ")
	void test3() throws ServletException, IOException {
		CmpDelServlet servlet = new CmpDelServlet();
		HttpSession session = req.getSession();
		session.setAttribute("name", null);
		servlet.doGet(req, resp);
		assertEquals("/view/VersView/Timeout.jsp", resp.getForwardedUrl());
	}
}
