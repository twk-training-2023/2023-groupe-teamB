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

import general_servlet.ChangeSkillServlet;

public class ChangeSkillServletTest {

	@Test
	@DisplayName("パスワード変更送信完了")
	public void ChngSkClear() throws ServletException, IOException {
		ChangeSkillServlet chngser = new ChangeSkillServlet();
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();

		HttpSession session = req.getSession();
		String name = "鈴木恵美";
		String skill_name = "java";
		String skill_lv = "9";
		String skill_appeal = "Javaプログラミング能力認定試験1級、Oracle認定Javaプログラマ:ゴールド";

		session.setAttribute("name", name);
		req.setParameter("skill_name", skill_name);
		req.setParameter("skill_lv", skill_lv);
		req.setParameter("skill_appeal", skill_appeal);

		chngser.doPost(req, resp);

		assertThat("マイページへ", is(req.getAttribute("botton")));
		assertThat("/view/GeneralView/MyPage.jsp", is(req.getAttribute("URL")));
		assertThat("/view/VersView/Complete.jsp", is(resp.getForwardedUrl()));
	}

	@Test
	@DisplayName("パスワード変更送信失敗")
	public void ChngSkfaild() throws ServletException, IOException {
		ChangeSkillServlet chngser = new ChangeSkillServlet();
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();

		HttpSession session = req.getSession();
		String name = "鈴木";
		String skill_name = "java";
		String skill_lv = "8";
		String skill_appeal = "前職は総理大臣です。対戦ありがとうございました。";

		session.setAttribute("name", name);
		req.setParameter("skill_name", skill_name);
		req.setParameter("skill_lv", skill_lv);
		req.setParameter("skill_appeal", skill_appeal);

		chngser.doPost(req, resp);

		assertThat("マイページへ", is(req.getAttribute("botton")));
		assertThat("/view/GeneralView/MyPage.jsp", is(req.getAttribute("URL")));
		assertThat("/view/VersView/Error.jsp", is(resp.getForwardedUrl()));
	}

	@Test
	@DisplayName("パスワード変更/セッションが期限切れ")
	public void ChngSksession() throws ServletException, IOException {
		ChangeSkillServlet chngser = new ChangeSkillServlet();
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();

		HttpSession session = req.getSession();
		String name = null;
		session.setAttribute("name", name);

		chngser.doPost(req, resp);

		assertThat("/view/VersView/Timeout.jsp", is(resp.getForwardedUrl()));
	}
}
