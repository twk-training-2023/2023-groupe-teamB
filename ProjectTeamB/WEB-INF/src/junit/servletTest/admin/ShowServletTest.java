package junit.servletTest.admin;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import admin_servlet.ShowServlet;
import bean.StaffBean;
import dto.StaffDTO;

class ShowServletTest {
	MockHttpServletRequest req = new MockHttpServletRequest();
	MockHttpServletResponse resp = new MockHttpServletResponse();

	@Test
	@DisplayName("個人の社員情報表示")
	void test1() throws ServletException, IOException {
		ShowServlet servlet = new ShowServlet();
		
		HttpSession session = req.getSession();
		session.setAttribute("name", "太郎");
		String name2 = "佐藤一郎";
		req.setParameter("name",name2);
		servlet.doGet(req, resp);
		StaffDTO dto = (StaffDTO) req.getAttribute("stdto");
		for (int i = 0; i < dto.size(); i++) {
		     StaffBean bean = dto.get(i);
		     assertEquals("0001",bean.getId());
		}
		String name = (String) req.getAttribute("nama");
		assertEquals("佐藤一郎",name);
		assertEquals("/view/AdminView/StaffINF.jsp",resp.getForwardedUrl());
	}

	@Test
	@DisplayName("個人の社員情報表示(エラー)")
	void test2() throws ServletException, IOException {
		ShowServlet servlet = new ShowServlet();

		HttpSession session = req.getSession();
		session.setAttribute("name", "太郎");

		servlet.doGet(req, resp);
		String URL = (String) req.getAttribute("URL");
		String botton = (String) req.getAttribute("botton");
		assertEquals("/ManagerServlet",URL);
		assertEquals("社員一覧ページ",botton);
		assertEquals("/view/VersView/Error.jsp", resp.getForwardedUrl());
	}

	@Test
	@DisplayName("個人の社員情報表示-セッション切れ")
	void test3() throws ServletException, IOException {
		ShowServlet servlet = new ShowServlet();
		String name2 = "佐藤一郎";
		req.setParameter("name", name2);

		servlet.doGet(req, resp);
		assertEquals("/view/VersView/Timeout.jsp", resp.getForwardedUrl());
	}
}
