package junit.servletTest.admin;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import admin_servlet.CheckListServlet;
import bean.MessageBean;
import dto.MessageDTO;

public class CheckListServletTest {
	
	MockHttpServletRequest req = new MockHttpServletRequest();
	MockHttpServletResponse resp = new MockHttpServletResponse();
	
	@Test
	@DisplayName("連絡確認")
	public void test1() throws ServletException, IOException {
		CheckListServlet a = new CheckListServlet();
		HttpSession session = req.getSession();
		session.setAttribute("name", "佐藤一郎");
		a.doGet(req,resp);
		
		MessageDTO dto = (MessageDTO) req.getAttribute("value");
		MessageBean bean = dto.get(0);
		
		String name = (String) req.getAttribute("name");
			
		assertEquals("佐藤一郎", name);
		assertEquals("今月で辞めます", bean.getMessage());
		assertEquals("/view/AdminView/CheckList.jsp", resp.getForwardedUrl());
	}
	

	@Test
	@DisplayName("連絡確認-セッション切れ")
	void test3() throws ServletException, IOException {
		CheckListServlet servlet = new CheckListServlet();
		HttpSession session = req.getSession();
		session.setAttribute("name", null);
		servlet.doGet(req, resp);
		assertEquals("/view/VersView/Timeout.jsp", resp.getForwardedUrl());
	}
}
