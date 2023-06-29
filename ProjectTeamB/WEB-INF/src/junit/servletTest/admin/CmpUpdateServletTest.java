package junit.servletTest.admin;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import admin_servlet.CmpUpdateServlet;

class CmpUpdateServletTest {
	MockHttpServletRequest req = new MockHttpServletRequest();
	MockHttpServletResponse resp = new MockHttpServletResponse();
	
	@Test
	@DisplayName("権限レベルの更新")
	void test1() throws ServletException, IOException {
		CmpUpdateServlet servlet = new CmpUpdateServlet();
		
		HttpSession session = req.getSession();
		session.setAttribute("name", "太郎");
		String name2 = "佐藤一郎";
		req.setParameter("neme",name2);
		String lv = "1";
	    req.setParameter("lv",lv);
		servlet.doGet(req, resp);
		String URL = (String) req.getAttribute("URL");
		String botton = (String) req.getAttribute("botton");
		assertEquals("/ManagerServlet",URL);
		assertEquals("社員一覧ページ",botton);
		assertEquals("/view/VersView/Complete.jsp",resp.getForwardedUrl());
	}

	@Test
	@DisplayName("権限レベルの更新-エラー")
	void test2() throws ServletException, IOException {
		CmpUpdateServlet servlet = new CmpUpdateServlet();
		
		String name2 = "";
		req.setParameter("neme",name2);
		String lv = "1";
	    req.setParameter("lv",lv);
		HttpSession session = req.getSession();
		session.setAttribute("name", "太郎");
		servlet.doGet(req, resp);
		String URL = (String) req.getAttribute("URL");
		String botton = (String) req.getAttribute("botton");
		assertEquals("/ManagerServlet",URL);
		assertEquals("社員一覧ページ",botton);
		assertEquals("/view/VersView/Error.jsp",resp.getForwardedUrl());
	}
	
	@Test
	@DisplayName("権限レベルの更新-セッション切れ")
	void test3() throws ServletException, IOException {
		CmpUpdateServlet servlet = new CmpUpdateServlet();
		String name2 = "佐藤一郎";
		req.setParameter("name", name2);
		String lv = "1";
	    req.setParameter("lv",lv);
		servlet.doGet(req, resp);
		assertEquals("/view/VersView/Timeout.jsp", resp.getForwardedUrl());
	}
}
