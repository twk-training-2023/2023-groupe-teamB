package junit.servletTest.general;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import general_servlet.CmpContactServlet;

class CmpContactServletTest {

	MockHttpServletRequest req = new MockHttpServletRequest();
	MockHttpServletResponse resp = new MockHttpServletResponse();
	
	@Test
	@DisplayName("連絡のデータを登録できた場合の分岐")
	public void test1() throws ServletException, IOException {
		CmpContactServlet a = new CmpContactServlet();
		HttpSession session = req.getSession();
		session.setAttribute("name", "鈴木恵美");
		req.setAttribute("message", "こんにちは");
		a.doPost(req,resp);
		
		assertEquals("マイページへ", req.getAttribute("botton"));
		assertEquals("/view/GeneralView/MyPage.jsp", req.getAttribute("URL"));
		assertEquals("/view/VersView/Complete.jsp", resp.getForwardedUrl());
	}
	@Test
	@DisplayName("連絡のデータを登録できなかった場合の分岐")
	public void test2() throws ServletException, IOException {
		CmpContactServlet a = new CmpContactServlet();
		HttpSession session = req.getSession();
		session.setAttribute("name", "ぁぁｘ");
		req.setAttribute("message", "こんにちは");
		a.doPost(req,resp);	
		
		assertEquals("マイページへ", req.getAttribute("botton"));
		assertEquals("/view/GeneralView/MyPage.jsp", req.getAttribute("URL"));
		assertEquals("/view/VersView/Error.jsp", resp.getForwardedUrl());
	}
	
	@Test
	@DisplayName("削除確認-セッション切れ")
	void test6() throws ServletException, IOException {
		CmpContactServlet servlet = new CmpContactServlet();
		HttpSession session = req.getSession();
		session.setAttribute("name", null);
		servlet.doPost(req, resp);
		assertEquals("/view/VersView/Timeout.jsp", resp.getForwardedUrl());
	}
}
