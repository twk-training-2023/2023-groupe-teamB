package junit.servletTest.admin;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import admin_servlet.ManagementServlet;

public class ManagementServletTest {
	
	MockHttpServletRequest req = new MockHttpServletRequest();
	MockHttpServletResponse resp = new MockHttpServletResponse();
	
	@Test
	@DisplayName("申請承認(承認成功)")
	public void test1() throws ServletException, IOException {
		
		ManagementServlet a = new ManagementServlet();
		HttpSession session = req.getSession();
		session.setAttribute("name", "太郎");
		
		String[]name = new String[1];
		name [0] = "鈴木恵美"; 
		
		req.setParameter("name", name);
		req.setParameter("ok","ok");
		a.doGet(req,resp);
		
		assertEquals("/SkillServlet", resp.getForwardedUrl());
	}
	@Test
	@DisplayName("申請承認(承認失敗)")
	public void test2() throws ServletException, IOException {
		
		ManagementServlet a = new ManagementServlet();
		HttpSession session = req.getSession();
		session.setAttribute("name", "太郎");
		
		String[]name = new String[1];
		
		req.setParameter("name", name);
		req.setParameter("ok","ok");
		a.doGet(req,resp);
		
		assertEquals("/view/VersView/Error.jsp", resp.getForwardedUrl());
	}
	@Test
	@DisplayName("申請否認(否認成功)")
	public void test3() throws ServletException, IOException {
		
		ManagementServlet a = new ManagementServlet();
		HttpSession session = req.getSession();
		session.setAttribute("name", "太郎");
		
		String[]name = new String[1];
		name [0] = "鈴木恵美"; 
		
		req.setParameter("name", name);
		req.setParameter("out","out");
		a.doGet(req,resp);
		
		assertEquals("/SkillServlet", resp.getForwardedUrl());
	}
	@Test
	@DisplayName("申請否認(否認失敗)")
	public void test4() throws ServletException, IOException {
		
		ManagementServlet a = new ManagementServlet();
		HttpSession session = req.getSession();
		session.setAttribute("name", "太郎");
		
		String[]name = new String[1];
		
		req.setParameter("name", name);
		req.setParameter("out","out");
		a.doGet(req,resp);
		
		assertEquals("/view/VersView/Error.jsp", resp.getForwardedUrl());
	}
	@Test
	@DisplayName("否認でも承認でもない場合")
	public void test5() throws ServletException, IOException {
		
		ManagementServlet a = new ManagementServlet();
		HttpSession session = req.getSession();
		session.setAttribute("name", "太郎");
		
		String[]name = new String[1];
		
		req.setParameter("name", name);
		a.doGet(req,resp);
	}
	
	@Test
	@DisplayName("削除確認-セッション切れ")
	void test6() throws ServletException, IOException {
		ManagementServlet servlet = new ManagementServlet();
		HttpSession session = req.getSession();
		session.setAttribute("name", null);
		servlet.doGet(req, resp);
		assertEquals("/view/VersView/Timeout.jsp", resp.getForwardedUrl());
	}
}
