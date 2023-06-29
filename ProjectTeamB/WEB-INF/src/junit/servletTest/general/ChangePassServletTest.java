package junit.servletTest.general;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import general_servlet.ChangePassServlet;

public class ChangePassServletTest {

	@Test
	@DisplayName("パスワード変更送信完了")
	public void ChngMyClear() throws ServletException, IOException {
		ChangePassServlet chngser = new ChangePassServlet();
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();

		HttpSession session = req.getSession();
		String name = "鈴木恵美";
		String password = "abc";
		session.setAttribute("name", name);
		req.setParameter("password", password);

		chngser.doPost(req, resp);

		assertThat("マイページへ", is(req.getAttribute("botton")));
		assertThat("/view/GeneralView/MyPage.jsp", is(req.getAttribute("URL")));
		assertThat("/view/VersView/Complete.jsp", is(resp.getForwardedUrl()));
	}

	@Test
	@DisplayName("パスワード変更送信失敗")
	public void ChngMyfaild() throws ServletException, IOException {
		ChangePassServlet chngser = new ChangePassServlet();
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();

		HttpSession session = req.getSession();
		String name = "鈴木";
		String password = "abc";
		session.setAttribute("name", name);
		req.setParameter("password", password);

		chngser.doPost(req, resp);

		assertThat("マイページへ", is(req.getAttribute("botton")));
		assertThat("/view/GeneralView/MyPage.jsp", is(req.getAttribute("URL")));
		assertThat("/view/VersView/Error.jsp", is(resp.getForwardedUrl()));
	}

	@Test
	@DisplayName("パスワード変更/セッションが期限切れ")
	public void ChngMysession() throws ServletException, IOException {
		ChangePassServlet chngser = new ChangePassServlet();
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();

		HttpSession session = req.getSession();
		String name = null;
		session.setAttribute("name", name);

		chngser.doPost(req, resp);

		assertThat("/view/VersView/Timeout.jsp", is(resp.getForwardedUrl()));
	}
}
