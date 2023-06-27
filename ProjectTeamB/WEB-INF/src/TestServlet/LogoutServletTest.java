package TestServlet;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import login_servlet.LogoutServlet;

public class LogoutServletTest {

	@Test
	@DisplayName("ログインアウト")
	public void ChngMn() throws ServletException, IOException {
		LogoutServlet logser = new LogoutServlet();
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();

		HttpSession session = req.getSession();
		String name = "鈴木恵美";
		String staff_lv = "1";
		session.setAttribute("name", name);
		session.setAttribute("staff_lv", staff_lv);
		logser.doPost(req, resp);

		assertThat("/view/LoginView/Login.jsp", is(resp.getForwardedUrl()));
	}

}
