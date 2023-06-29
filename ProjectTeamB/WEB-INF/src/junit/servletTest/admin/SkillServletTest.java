package junit.servletTest.admin;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import admin_servlet.SkillServlet;
import bean.SkillBean;
import dto.SkillDTO;

class SkillServletTest {
   MockHttpServletRequest req = new MockHttpServletRequest();
   MockHttpServletResponse resp = new MockHttpServletResponse();
   
	@Test
	@DisplayName("スキル表示")
	void test1() throws ServletException, IOException {
		SkillServlet servlet = new SkillServlet();
		HttpSession session = req.getSession();
		session.setAttribute("name", "太郎");
		
		servlet.doGet(req, resp);
		SkillDTO dto = (SkillDTO) req.getAttribute("skdto");
		SkillBean bean = dto.get(0);
		assertEquals("佐藤一郎", bean.getName());
		assertEquals("/view/AdminView/CheckSkill.jsp",resp.getForwardedUrl());
	}
	
	@Test
	@DisplayName("スキル表示（セッション切れ）")
	void test2() throws ServletException, IOException {
		SkillServlet servlet = new SkillServlet();
	
		
		servlet.doGet(req, resp);
		assertEquals("/view/VersView/Timeout.jsp",resp.getForwardedUrl());
	}

}
