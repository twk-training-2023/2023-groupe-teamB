package junit.servletTest.admin;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import admin_servlet.UpdateServlet;
import bean.StaffBean;
import dto.StaffDTO;

class UpdateServletTest {
	MockHttpServletRequest req = new MockHttpServletRequest();
	MockHttpServletResponse resp = new MockHttpServletResponse();

	@Test
	@DisplayName("社員の権限レベルの取得")
	void test1() throws ServletException, IOException {
		UpdateServlet servlet = new UpdateServlet();

		HttpSession session = req.getSession();
		session.setAttribute("name", "太郎");
		String name2 = "佐藤一郎";
		req.setParameter("neme", name2);
		servlet.doGet(req, resp);

		StaffDTO dto = (StaffDTO) req.getAttribute("stdto");
		for (int i = 0; i < dto.size(); i++) {
			StaffBean bean = dto.get(i);
			assertEquals(1, bean.getStaff_lv());
			assertEquals("/view/AdminView/UpdateStaff.jsp", resp.getForwardedUrl());
			assertEquals(name2, req.getAttribute("nema"));
		}
	}

	@Test
	@DisplayName("社員の権限レベルの取得-セッション切れ")
	void test2() throws ServletException, IOException {
		UpdateServlet servlet = new UpdateServlet();
		String name2 = "佐藤一郎";
		req.setParameter("name", name2);

		servlet.doGet(req, resp);
		assertEquals("/view/VersView/Timeout.jsp", resp.getForwardedUrl());
	}
}
