package junit.servletTest.admin;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import admin_servlet.DeleteCheckServlet;

public class DeleteCheckServletTest {

	MockHttpServletRequest req = new MockHttpServletRequest();
	MockHttpServletResponse resp = new MockHttpServletResponse();
	
	@Test
	@DisplayName("削除確認")
	public void test1() throws ServletException, IOException {
		
		DeleteCheckServlet a = new DeleteCheckServlet();
		HttpSession session = req.getSession();
		session.setAttribute("name", "佐藤一郎");
		
		String[]name = new String[1];
		String str = "小鳥遊ホシノ";
		name [0] = str; 
		
		req.setParameter("name", name);
		
		a.doGet(req,resp);

		
		String[] name2 = (String[]) session.getAttribute("delname");
		
		assertEquals(str, name2[0]);
		assertEquals("/view/AdminView/CheckDelete.jsp", resp.getForwardedUrl());
	}
	
	@Test
	@DisplayName("削除確認-セッション切れ")
	void test3() throws ServletException, IOException {
		DeleteCheckServlet servlet = new DeleteCheckServlet();
		HttpSession session = req.getSession();
		session.setAttribute("name", null);
		servlet.doGet(req, resp);
		assertEquals("/view/VersView/Timeout.jsp", resp.getForwardedUrl());
	}
}
