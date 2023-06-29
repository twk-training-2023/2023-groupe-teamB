package junit.servletTest.login;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import login_servlet.LoginServlet;

public class LoginServletTest {

	@Test
	@DisplayName("ログイン")
	public void ChngMn() throws ServletException, IOException {
		LoginServlet logser = new LoginServlet();
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();

		String email = "a";
		String password = "abc";
		req.setParameter("email", email);
		req.setParameter("password", password);
		logser.doGet(req, resp);

		HttpSession session = req.getSession();
		assertThat(1, is(session.getAttribute("staff_lv")));
		assertThat("鈴木恵美", is(session.getAttribute("name")));
		assertThat("/view/LoginView/Menu.jsp", is(resp.getForwardedUrl()));
	}

	@Test
	@DisplayName("ログイン失敗")
	public void NoChngMn() throws ServletException, IOException {
		LoginServlet logser = new LoginServlet();
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();

		String email = "あ";
		String password = "bbc";
		req.setParameter("email", email);
		req.setParameter("password", password);
		logser.doGet(req, resp);

		assertThat("/view/LoginView/Login.jsp", is(req.getAttribute("error")));
		assertThat("メールアドレス ： あまたはパスワードでエラーが起きています。", is(req.getAttribute("nouser")));
		assertThat("/view/LoginView/LoginError.jsp", is(resp.getForwardedUrl()));

	}
}
