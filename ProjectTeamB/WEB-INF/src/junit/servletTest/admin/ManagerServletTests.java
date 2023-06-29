package junit.servletTest.admin;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import admin_servlet.ManagerServlet;
import bean.StaffBean;
import dto.StaffDTO;

class ManagerServletTests {
	MockHttpServletRequest req = new MockHttpServletRequest();
	MockHttpServletResponse resp = new MockHttpServletResponse();
	
	@Test
	@DisplayName("社員一覧表示")
	void test1() throws ServletException, IOException {
       ManagerServlet servlet = new ManagerServlet();
       
       HttpSession session = req.getSession();
		session.setAttribute("name", "太郎");
		servlet.doGet(req, resp);
		StaffDTO dto = (StaffDTO)req.getAttribute("stdto");
		StaffBean bean = dto.get(0);
		assertEquals("砂糖", bean.getName());
		assertEquals("/view/AdminView/Allstaff.jsp",resp.getForwardedUrl());
	}
	
	@Test
	@DisplayName("スキル表示（セッション切れ）")
	void test2() throws ServletException, IOException {
		ManagerServlet servlet = new ManagerServlet();
	
		
		servlet.doGet(req, resp);
		assertEquals("/view/VersView/Timeout.jsp",resp.getForwardedUrl());
	}

}
