package junit.servletTest.admin;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import admin_servlet.DeleteServlet;
import bean.StaffBean;
import dto.StaffDTO;

public class DeleteServletTest {

	MockHttpServletRequest req = new MockHttpServletRequest();
	MockHttpServletResponse resp = new MockHttpServletResponse();
	
	@Test
	@DisplayName("社員削除画面")
	public void test1() throws ServletException, IOException {
		
		DeleteServlet a = new DeleteServlet();
		HttpSession session = req.getSession();
		session.setAttribute("name", "太郎");
		
		a.doGet(req,resp);
		
		StaffDTO dto = (StaffDTO) req.getAttribute("stdto");
		int num = dto.size();
		num = num -1;
		StaffBean bean = dto.get(num);
		
		assertEquals("小野崎響著", bean.getName());
		assertEquals("/view/AdminView/DeleteStaff.jsp", resp.getForwardedUrl());
		
	}
	@Test
	@DisplayName("削除確認-セッション切れ")
	void test3() throws ServletException, IOException {
		DeleteServlet servlet = new DeleteServlet();
		HttpSession session = req.getSession();
		session.setAttribute("name", null);
		servlet.doGet(req, resp);
		assertEquals("/view/VersView/Timeout.jsp", resp.getForwardedUrl());
	}
}
