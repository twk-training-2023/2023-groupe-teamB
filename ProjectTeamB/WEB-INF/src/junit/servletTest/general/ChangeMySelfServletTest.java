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

import bean.StaffBean;
import dto.StaffDTO;
import general_servlet.ChangeMySelfServlet;

public class ChangeMySelfServletTest {

	@Test
	@DisplayName("個人情報更新")
	public void ChngMn() throws ServletException, IOException {
		ChangeMySelfServlet chngser = new ChangeMySelfServlet();
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();

		HttpSession session = req.getSession();
		String name = "鈴木恵美";
		session.setAttribute("name", name);

		chngser.doGet(req, resp);

		StaffDTO stdto = (StaffDTO) req.getAttribute("stdto");
		for (int a = 0; a < stdto.size(); a++) {
			StaffBean stbe = stdto.get(a);
			assertThat("", is(stbe.getMyself()));
			assertThat("java", is(stbe.getSkill_name()));
			assertThat(9, is(stbe.getSkill_lv()));
			assertThat("Javaプログラミング能力認定試験1級、Oracle認定Javaプログラマ:ゴールド", is(stbe.getSkill_appeal()));
			assertThat("/view/GeneralView/ChangeMySelf.jsp", is(resp.getForwardedUrl()));
		}

	}

	@Test
	@DisplayName("個人情報更新/セッションが期限切れ")
	public void ChngM() throws ServletException, IOException {
		ChangeMySelfServlet chngser = new ChangeMySelfServlet();
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();

		HttpSession session = req.getSession();
		String name = null;
		session.setAttribute("name", name);

		chngser.doGet(req, resp);

		assertThat("/view/VersView/Timeout.jsp", is(resp.getForwardedUrl()));
	}
}
